package com.example.bootjar_comment.service;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.repository.CommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CommentQueryService {

    private final CommandRepository commandRepository;

    public Flux<CommentCommand> getCommentList(Long todoId) {
        return commandRepository.findByTodoId(todoId);
    }
}