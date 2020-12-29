package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery" ,fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)//ORDINERY는 1,2,3,4,숫자로 들어감
    //무조건 STRING 타입으로!
    private DeliveryStatus status;//READY, COMP
}
