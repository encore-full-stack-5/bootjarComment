package com.example.bootjar_comment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/todos")
public class VersionController {

    @GetMapping("/todos/comments/version")
    public String version() {
        return "v1.0.0";
    }
}
