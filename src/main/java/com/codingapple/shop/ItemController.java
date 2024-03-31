package com.codingapple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model){
        itemService.findAllItem(model);
        return "list.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String title, Integer price){
        itemService.saveItem(title, price);
        return "redirect:/list";
    }


    @GetMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model){
        itemService.findByIdItem(id, model);
        return "edit.html";
    }

    @PostMapping("/edit")
    String editItem(Long id, String title, Integer price){
        itemService.modifyItem(id, title, price);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model){
        if(itemService.findByIdItem(id, model)){ //Optional 안에 값이 있는지 체크하는게 좋음
            return "detail.html";
        } else{
            return "redirect:/list";
        }

    }

}
