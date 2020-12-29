package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private String name;
    @Embedded //embedable 과 둘중 하나만 있으면 됨
    private Address address;
    @OneToMany(mappedBy = "member") //1: 다 //매핑되는 갹체이다
    private List<Order> orders = new ArrayList<>();

}
