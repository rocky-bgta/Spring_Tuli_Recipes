package com.salahin.spring.recipes.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Tuli on 11/12/2016.
 * This class created for test purpose to check rest xml service.
 */
@XmlRootElement
public class Member {
    private String name;
    private String phone;
    private String email;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
