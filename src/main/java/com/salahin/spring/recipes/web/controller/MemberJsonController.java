package com.salahin.spring.recipes.web.controller;

import com.salahin.spring.recipes.domain.Members;
import com.salahin.spring.recipes.service.recipeimplementation.MemberServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tuli on 11/12/2016.
 */
@Controller
public class MemberJsonController {

    @Autowired
    private MemberServiceImple memberServiceImple;

    @RequestMapping(value = {"/members*"}, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Members> getMembers() {
        Members members = new Members();
        members.addMembers(memberServiceImple.findAll());
        return new ResponseEntity<Members>(members, HttpStatus.OK);
    }
}
