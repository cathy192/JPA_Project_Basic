package jpabook.jpashop.Domain.item;

import jpabook.jpashop.Domain.Category;
import jpabook.jpashop.exception.NotEnoughStockExcetion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //상속관계 중 singletable 전략
@Getter@Setter
@DiscriminatorColumn(name="dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category>categories = new ArrayList<>();
    //응집력을 위해 직접 비지니스로직을 안에 넣음
    //비지니스 로직
    /*
    재고 증가
    * */
    public void addStock(int quantity){
        this.stockQuantity+= quantity;

    }
    public void removeStock(int quantity){
       int restStock= this.stockQuantity-quantity;
       if(restStock<0){
           throw new NotEnoughStockExcetion("Need more stock");

       }
       this.stockQuantity=restStock;

    }

}
