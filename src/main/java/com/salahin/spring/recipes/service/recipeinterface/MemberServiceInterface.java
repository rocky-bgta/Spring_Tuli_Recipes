package com.salahin.spring.recipes.service.recipeinterface;

import com.salahin.spring.recipes.domain.Member;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

/**
 * Created by marten on 16-06-14.
 */
public interface MemberServiceInterface {

    Collection<Member> findAll();
    Member find(int id);
}
