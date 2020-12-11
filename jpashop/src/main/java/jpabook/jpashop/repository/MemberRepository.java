package jpabook.jpashop.repository;

import jpabook.jpashop.Domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //자동으로 스프링빈으로 등록(component scan대상)
@RequiredArgsConstructor
public class MemberRepository {
   // @PersistenceContext //이 어노테이션으로 엔티티 매니저 자동 샹성

    private final EntityManager em; //엔티티 매니저 인잭션 주입

    public void save(Member member){
        em.persist(member);
    }
    public Member findOne(Long id){
        return em.find(Member.class,id);
    }
    public List<Member>findAll(){
        return  em.createQuery("select m from Member m", Member.class)
                .getResultList();
        //처음 인자가 Jpql,두번째 인자가 반환타입
        //sql은 테이블 대상, jpql은 엔티티 대상으로 쿼리
    }
    public  List<Member> findByName(String name){
    return em.createQuery("select m from Member m where m.name =:name",Member.class)
            .setParameter("name",name)
            .getResultList();
    }
}
