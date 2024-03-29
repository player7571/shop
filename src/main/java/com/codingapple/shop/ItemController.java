package com.codingapple.shop;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
//    @Autowired //Lombok 없이 등록하는 방법
//    public ItemController(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        var a = new Item();
        System.out.println(a.toString());
        return "list.html";
    }
    //상품추가 기능
    //1. 상품 이름, 가격 작성 가능한 페이지와 폼
    //2. 전송버튼 누르면 서버에 보냄
    //3. 서버는 검사하고 문제없으면 DB에 저장(바로 넣으면 위험하니 서버 거치는게 좋다)
    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String title, Integer price){
        var val = new Item();
        val.setTitle(title);
        val.setPrice(price);
        itemRepository.save(val);
        //new Item() 해서 아이템의 오브젝트 넣어야함
        //ItemRepository.save(???);로 db에 저장
        //Item 변수들 private로 변경하고 해보기
        return "redirect:/list";
    }

//    @PostMapping("/add")
//    String addPost(@RequestParam Map formData){
//        System.out.println(formData);
//        return "redirect:/list";
//    }

}
