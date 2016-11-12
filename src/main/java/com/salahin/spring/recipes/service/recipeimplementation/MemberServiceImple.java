package com.salahin.spring.recipes.service.recipeimplementation;


import com.salahin.spring.recipes.domain.Member;
import com.salahin.spring.recipes.service.recipeinterface.MemberServiceInterface;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marten on 16-06-14.
 */
public class MemberServiceImple implements MemberServiceInterface {

    private final Map<Integer, Member> members = new HashMap<>();

    @PostConstruct
    public void init() {
        Member m1 = new Member();
        m1.setName("Marten Deinum");
        m1.setEmail("marten@deinum.biz");
        m1.setPhone("00-31-1234567890");

        Member m2 = new Member();
        m2.setName("John Doe");
        m2.setPhone("1-800-800-800");
        m2.setEmail("john@doe.com");

        Member m3 = new Member();
        m3.setName("Jane Doe");
        m3.setPhone("1-801-802-803");
        m3.setEmail("jane@doe.com");

        members.put(1, m1);
        members.put(2, m2);
        members.put(3, m3);
    }


    @Override
    public java.util.Collection<Member> findAll() {
        return members.values();
    }

    @Override
    public Member find(int id) {
        Member member;
        member = members.get(id);
        return member;
    }
}
