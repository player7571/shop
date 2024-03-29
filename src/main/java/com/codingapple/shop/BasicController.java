package com.codingapple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BasicController {
    @GetMapping("/")
//    @ResponseBody 문자 그대로 보내달라는 어뮤테이션 뺴야 파일 전송?가능
    String hello(){
        return "index.html";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "마이페이지임";
    }

    @GetMapping("/date")
    @ResponseBody
    String date(){
        SimpleDateFormat date = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm");
        return date.format(new Date());
    }
}
