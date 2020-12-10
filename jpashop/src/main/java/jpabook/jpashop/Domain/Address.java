package jpabook.jpashop.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable //어디서나 내장될 수 있다.
@Getter @Setter
public class Address {
    private String city;
    private String street;
    private String zipCode;
}
