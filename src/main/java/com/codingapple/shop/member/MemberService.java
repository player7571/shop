package com.codingapple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(String username, String password, String displayName){
        if(username.length()<4||password.length()<4){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "아이디나 비밀번호가 너무 짧습니다"
            );
        }
        Member member = new Member();
        String result = passwordEncoder.encode(password);
        member.setUsername(username);
        member.setPassword(result);
        member.setDisplayName(displayName);
        memberRepository.save(member);
    }

}
