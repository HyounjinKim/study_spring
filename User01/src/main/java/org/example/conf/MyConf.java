package org.example.conf;

import org.example.member.MemberDao;
import org.example.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConf {
    @Bean
    public MemberDao memberDao(){
        MemberDao md = new MemberDao();
        return md;
    }

    @Bean
    public MemberService memberService(){
        MemberService ms = new MemberService();
        ms.setMemberDao(memberDao());
        return ms;
    }
}
