package org.example.components;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements InitializingBean, DisposableBean {
    @Autowired
    private MemberRepository memberRepository;

    private String str;

    @Override
    public void afterPropertiesSet() throws Exception {
        str = "sdasd";
        System.out.println("IOC 컨테이너에 들어갈때");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("IOC 컨테이너 없어질때");
    }

    public void regist() {
        memberRepository.insert();
    }
}
