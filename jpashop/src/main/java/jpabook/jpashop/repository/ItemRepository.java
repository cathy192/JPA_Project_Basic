package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
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
        else {
            //merge는 병합이 되서 영속적으로 관리하는애이고
            //em.merge(item)은 영속적이지 않음
            Item merge = em.merge(item); //이미 등록된걸 update와 비슷
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class,id);
    }
    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
        .getResultList();
    }
}
