package com.example.bootjar_comment.controller;

import com.example.bootjar_comment.global.CreateCommandHandler;
import com.example.bootjar_comment.global.QueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class CommentController {

    private final CreateCommandHandler commandHandler;
    private final QueryHandler queryHandler;



}
