package jpabook.jpashop.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="member_id") //pk의미
    private Member member;

    @OneToMany
    @JoinColumn(name="order")
    private List<Orderitmes> orderItmes  = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "delivery_id")
    private  Delivery delivery ;

    private LocalDateTime orderDate; //주문 시간(자바가 알아서 날짜 지원해줌)
    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문 상태 [ORDER, CANCEL]

}
