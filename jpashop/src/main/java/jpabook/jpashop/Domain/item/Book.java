package jpabook.jpashop.Domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("B")//single table이니깐 디비에서 구분하랴고 넣음
@Setter
public class Book extends Item{

    private String author;
    private String isbn;
}
