package com.example.bootjar_comment.controller;

import com.example.bootjar_comment.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos/comments")
public class UserController {

    private final RestTemplate restTemplate;

    @GetMapping("/user-signup")
    public String fetchExternalData() {
        String apiUrl = "http://34.121.86.244/todos/comments/user-signup";
        String responseData = restTemplate.getForObject(apiUrl, String.class);
        System.out.println(responseData);
        return responseData;
    }

}
