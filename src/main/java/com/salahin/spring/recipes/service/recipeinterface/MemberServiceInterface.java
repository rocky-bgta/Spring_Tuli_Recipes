package com.salahin.spring.recipes.service.recipeinterface;

import com.salahin.spring.recipes.domain.Member;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Collection;

/**
 * Created by marten on 16-06-14.
 */
public interface MemberServiceInterface {

    // Implement method level security
    @PreAuthorize("hasRole('USER')")
    Collection<Member> findAll();

    Member find(int id);
}
