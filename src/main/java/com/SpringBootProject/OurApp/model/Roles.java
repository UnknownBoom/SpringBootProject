package com.SpringBootProject.OurApp.model;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    Manager,Master,Customer,Director,Deputy_director;

    @Override
    public String getAuthority() {
        return name();
    }
}
