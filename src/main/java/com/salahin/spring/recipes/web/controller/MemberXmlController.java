package com.salahin.spring.recipes.web.controller;

import com.salahin.spring.recipes.domain.Member;
import com.salahin.spring.recipes.domain.Members;
import com.salahin.spring.recipes.service.recipeinterface.MemberServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Tuli on 11/12/2016.
 */
@Controller
@PropertySource({"classpath:/application.properties","classpath:/message.properties"})
public class MemberXmlController {

    @Autowired
    private final MemberServiceInterface memberServiceInterface;

    @Autowired
    private Environment environment;

    public MemberXmlController(MemberServiceInterface memberServiceInterface) {
        this.memberServiceInterface = memberServiceInterface;
    }

    @RequestMapping("/member/{memberId}")
    @ResponseBody
    public ResponseEntity<Member> getMember(@PathVariable("memberId") int memberId){
        Member member = memberServiceInterface.find(memberId);
        if(member!=null) {
            return new ResponseEntity<Member>(member, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = {"/members*"} ,produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ResponseEntity<Members> getMembers() {
        // example of how read property file through environment variable
        String property = environment.getProperty("hello");
        Members members = new Members();
        members.addMembers(memberServiceInterface.findAll());
        return new ResponseEntity<Members>(members, HttpStatus.OK);
    }
}
