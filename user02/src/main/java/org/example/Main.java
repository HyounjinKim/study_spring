package org.example;

// 알트+1 project 이동
// alt + insert 새로생성

import org.example.conf.MyConf;
import org.example.member.Member;
import org.example.member.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

// esc 누르면 다시 코드로
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConf.class);

//        Member member1 = new Member(null,"aaa@naver.com","김","1234",LocalDateTime.now());
//        Member member2 = new Member(null,"bbb@naver.com","이","1111",LocalDateTime.now());

        Member member1 = Member.builder()
                .email("aaa@naver.com")
                .name("김")
                .password("1234")
                .wdate(LocalDateTime.now())
                .build();

        Member member2 = Member.builder()
                .email("bbb@naver.com")
                .name("박")
                .password("1111")
                .wdate(LocalDateTime.now())
                .build();

        MemberService memberService = context.getBean(MemberService.class);
        memberService.resist(member1);
        memberService.resist(member2);

        memberService.list();
        // Member 두개

        String[] str = context.getBeanDefinitionNames();
        Arrays.stream(str).forEach(System.out::println);
//
//
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일 hh:mm:ss");
//
//        System.out.println(formatter.format(now));

        context.close();
    }
}