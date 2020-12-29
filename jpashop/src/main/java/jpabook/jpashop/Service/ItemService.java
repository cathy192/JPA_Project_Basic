package jpabook.jpashop.Service;

import jpabook.jpashop.Domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    
    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    //머지와 완전 동일한 동작방식 코드
    @Transactional
    public void updateItem(Long itemId, String name,int price ,int stock){
        Item finditem = itemRepository.findOne(itemId);
        //finditem.setPrice(bookParam.getPrice());
        finditem.setName(name);
        finditem.setPrice(price);
        finditem.setStockQuantity(stock);

    //commit 되면 plush흫 날림. 변경되면 update
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }
    public  Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
