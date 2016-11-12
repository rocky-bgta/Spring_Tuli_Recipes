package com.salahin.spring.recipes;

import com.salahin.spring.recipes.domain.Member;
import com.salahin.spring.recipes.domain.Members;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by Tuli on 11/12/2016.
 */
public class ConsumeRestService {

    public static void  main(String arg[]){
        String url= "http://localhost:8080/members.json";
        ConsumeRestService.getMembersFromXml(url,null);
    }

    public static Members getMembersFromXml(String url, Map parameters) {
        Members members;
        RestTemplate restTemplate = new RestTemplate();
        if(parameters!=null)
            members = restTemplate.getForObject(url,Members.class,parameters);
        else
            members = restTemplate.getForObject(url,Members.class);
        return members;
    }
}
