package com.example.bootjar_comment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("/api/version")
    String version() {
        return "v1.0.0";
    }
}
