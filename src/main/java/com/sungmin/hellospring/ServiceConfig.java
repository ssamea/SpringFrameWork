package com.sungmin.hellospring;

import com.sungmin.hellospring.repository.MemberRepository;
import com.sungmin.hellospring.repository.MemoryMemberRepository;
import com.sungmin.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean  // 스프링빈에 직접 등록하는 방법
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
