package com.salahin.spring.recipes.web;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by marten on 06-06-14.
 */
@Order(2)
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}
