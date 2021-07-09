package com.sungmin.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello spring!!");
        return "hello"; // cotroller의 동작과정: return에서 hello는 /resource/templates 안의 hello.html은 찾는거임
    }

    // MVC와 템플릿 엔진을 이용한 방법
    @GetMapping("hello-mvc")
    // @RequestParm =  HttpServletRequest 객체와 같은 역할,  메소드의 파라미터값을 넣어줌
    // @RequestParam("가져올 데이터의 이름") [데이터타입] [가져온데이터를 담을 변수]
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name); //  Model 객체를 이용해서, 뷰로 값을 넘겨준다
        return "hello-template";
    }

    //api 방식: 데이터를 그대로 내리는 방식
    @GetMapping("hello-string")
    @ResponseBody // http에서 헤더와 바디가 있는데, 바디부에 내가 데이터를 직접 넣겠다는 의미이다.
    public String helloString(@RequestParam("name") String name){
        return "hello "+ name;
    }

    // 이게 진정한 api 방식임. -> json으로 반환하는 방법을 이용함
    // json = key, value로 이루어져 인간이 읽을 수 있는 텍스트를 사용하는 개방형 표준 포맷
    @GetMapping("hello-api")
    @ResponseBody // http에서 헤더와 바디가 있는데, 바디부에 내가 데이터를 직접 넣겠다는 의미이다.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();  // 객체면 JsonConverter()가 json형식으로 바꿔준다, 문자열 변수면 StringConverter()가 호출
        hello.setName(name);
        return hello;
    }


    static class Hello{
        private  String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
