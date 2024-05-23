package org.example.member;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor
public class MemberService {
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void regist(MemberDto md) {

        Member member = new Member(
                0,
                md.getEmail(),
                md.getName(),
                md.getPassword(),
                md.getConfirmPassword(),
                LocalDate.now());

        memberDao.insert(member);

    }

    public void list() {
        Collection<Member> collection = memberDao.select();
        collection.stream().forEach(System.out::println);

    }
}
