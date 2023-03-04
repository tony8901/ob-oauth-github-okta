package com.oboauthgithubokta.oboauthgithubokta.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //controlador MVC
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/page1")
    public String page1(Model model){
        model.addAttribute("message","Hello from page1");

        return "page1";
    }

    @GetMapping("/page2")
    public String page2(Model model,
                        @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
                        @AuthenticationPrincipal OAuth2User user){
        model.addAttribute("userName", user.getName());
        model.addAttribute("clientName", client.getPrincipalName());

        return "page2";
    }

}
