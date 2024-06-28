package com.example.bootjar_comment.controller;

import com.example.bootjar_comment.dto.TodoDto;
import com.example.bootjar_comment.dto.UserDto;
import com.example.bootjar_comment.global.CreateCommandHandler;
import com.example.bootjar_comment.global.DeleteCommandHandler;
import com.example.bootjar_comment.global.UpdateCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos/comments")
public class ReceiveController {

    private final CreateCommandHandler createCommandHandler;
    private final UpdateCommandHandler updateCommandHandler;
    private final DeleteCommandHandler deleteCommandHandler;

    // user-insert
    @PostMapping("/user-signup")
    public Mono<Void> signUp(@RequestBody UserDto userDto) {
        return createCommandHandler.processUserSignup(userDto).then();
    }

    // user-update
    @PutMapping("/user-update ")
    public Mono<Void> userUpdate(@RequestBody UserDto userDto) {
        return updateCommandHandler.processUserUpdate(userDto).then();
    }

    // user-delete
    @DeleteMapping("/user-delete/{userId}")
    public Mono<Void> userDelete(@PathVariable("userId") Long userId) {
        return deleteCommandHandler.processUserDelete(userId);
    }

    // todo-insert
    @PostMapping("/todo-add")
    public Mono<Void> todoInsert(@RequestBody TodoDto todoDto) {
        return createCommandHandler.processTodoInsert(todoDto.getId());
    }

    // todo-delete
    @DeleteMapping("/todo-delete/{todoId}")
    public Mono<Void> todoDelete(@PathVariable("todoId") Long todoId) {
        return deleteCommandHandler.processTodoDelete(todoId);
    }
}
