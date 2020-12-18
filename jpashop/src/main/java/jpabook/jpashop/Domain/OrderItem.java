package jpabook.jpashop.Domain;

import jpabook.jpashop.Domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    private int orderPrice; //주문 가격
    private int count; //주문 수량

    //생성 메서드
    public static OrderItem creatOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem= new OrderItem();
        orderItem.setItems(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        item.removeStock(count);
        return orderItem;
    }

    //비지니스 로직
    public void cancel(){//재고 수량 원복
        getItems().addStock(count);
    }

    //조회 로직==//
    public int getTotalPrice(){
        return getOrderPrice() * getCount();
    }
}
