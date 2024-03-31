package com.codingapple.shop.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;


    @GetMapping("/register")
    String register(){
        return "register.html";
    }

    @PostMapping("/addUser")
    String addUser(String username, String password, String displayName){
        memberService.saveUser(username, password, displayName);
        return "redirect:/list";
    }
}
