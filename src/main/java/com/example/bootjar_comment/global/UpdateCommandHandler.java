package com.example.bootjar_comment.global;


import com.example.bootjar_comment.dto.UserDto;
import com.example.bootjar_comment.service.CommentCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UpdateCommandHandler {
    private final CommentCommandService commentCommandService;

    public Mono<Void> updateHandle(Long commentId, String content){
        return commentCommandService.updateComment(commentId, content);
    }

    // user-update
    public Mono<Void> processUserUpdate(UserDto userDto) {
        return commentCommandService.processUserUpdate(userDto);
    }
}