package com.codingapple.shop;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model){
        if(itemService.findByIdItem(id, model)){ //Optional 안에 값이 있는지 체크하는게 좋음
            return "detail.html";
        } else{
            return "redirect:/list";
        }

    }

}
