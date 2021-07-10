package com.sungmin.hellospring.controller;

import com.sungmin.hellospring.domain.Member;
import com.sungmin.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  // 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다
    // Spring IoC 컨테이너가 관리하는 자바 객체를 빈(Bean)이라는 용어로 부른다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);   //  Model 객체를 이용해서, 뷰로 값을 넘겨준다
        return "members/memberList";
    }
}
