package com.codingapple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveUser(String username, String password, String displayName){
        Member member = new Member();
        String result = new BCryptPasswordEncoder().encode(password);
        member.setUsername(username);
        member.setPassword(result);
        member.setDisplayName(displayName);
        memberRepository.save(member);
    }

}
