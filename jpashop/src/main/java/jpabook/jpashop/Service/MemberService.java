package jpabook.jpashop.Service;

import jpabook.jpashop.Domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(readOnly = true) //transaction을 통해 데이터 변경이 이뤄질때 항상 명시해줘야함
//@AllArgsConstructor //롬복을 통해 생성자 만들어줌
@RequiredArgsConstructor //final 필드만 가지고 생성자를 만들어줌
public class MemberService {


    private final MemberRepository memberRepository; //변경 못하게
    //회원 가입
    @Transactional
    public Long join(Member member){
        validateDuplicationMember(member);//중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicationMember(Member member) {
         //EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //회원 한명 조회
    public Member findOne(Long memberId){
        return memberRepository.find(memberId);
    }

}
