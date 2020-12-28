package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
@Getter @Setter
public class MemberForm {
    //이름 값이 없으면 오류
    @NotEmpty(message = "회원 이름은 필수입니다.")
    private  String name;

    private String city;
    private String street;
    private String zipcode;
}
