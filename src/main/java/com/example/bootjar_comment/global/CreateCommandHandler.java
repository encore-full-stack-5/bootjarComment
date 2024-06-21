package com.example.bootjar_comment.global;

import com.example.bootjar_comment.dto.CreateCommentDto;
import com.example.bootjar_comment.service.CommentCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateCommandHandler {
    private final CommentCommandService commentCommandService;

    public Mono<Void> createHandle(CreateCommentDto createCommentDto){
        return commentCommandService.createComment(createCommentDto);
    }

}
