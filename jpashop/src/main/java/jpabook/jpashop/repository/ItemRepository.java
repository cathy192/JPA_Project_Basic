package jpabook.jpashop.repository;

import jpabook.jpashop.Domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em ;

    public void save(Item item){
        if(item.getId() ==null)//새로 생상한 객체이다
             em.persist(item); //신규 등록
        else
            em.merge(item); //이미 등록된걸 update와 비슷

    }

    public Item findOne(Long id){
        return em.find(Item.class,id);
    }
    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
        .getResultList();
    }
}
