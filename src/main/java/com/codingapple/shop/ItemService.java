package com.codingapple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }

    public void findAllItem(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
    }

    public boolean findByIdItem(Long id, Model model){
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()){ //Optional 안에 값이 있는지 체크하는게 좋음
            model.addAttribute("data", result.get());
            return true;
        }
        return false;
    }
}
