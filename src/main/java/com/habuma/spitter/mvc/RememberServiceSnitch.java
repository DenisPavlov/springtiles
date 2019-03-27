package com.habuma.spitter.mvc;

import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;

public class RememberServiceSnitch {

    public void tellMe() {
        System.out.println("************   KEY: " + rememberService.getKey());
    }

    public void setRememberService(AbstractRememberMeServices rememberService) {
        this.rememberService = rememberService;
    }

    public AbstractRememberMeServices getRememberService() {
        return rememberService;
    }

    private AbstractRememberMeServices rememberService;
}
