package com.sungmin.hellospring.service;

import com.sungmin.hellospring.domain.Member;
import com.sungmin.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    // Dependeny Injection (DI)
    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach  // @AfterEach: 어떤 메서드가 끝날때 마다 실행하는 문장
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }


    @Test
    void join() {
        //give
        Member member = new Member();
        member.setName("Jin Sung Min");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    public void 중복_회원_예외(){
        //give
        Member member1 = new Member();
        member1.setName("Jin Sung Min");

        Member member2 = new Member();
        member2.setName("Jin Sung Min");

        //when
        memberService.join(member1);
        IllegalStateException e =  assertThrows(IllegalStateException.class,()->memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*
        try {
            memberService.join(member2);
            fail("테스트 예외가 발생해야합니다.");
        }catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.1213");
        }

         */

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}