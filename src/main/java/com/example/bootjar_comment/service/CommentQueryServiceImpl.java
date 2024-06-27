package com.example.bootjar_comment.service;

import com.example.bootjar_comment.command.CommentCommand;
import com.example.bootjar_comment.domain.Comment;
import com.example.bootjar_comment.domain.User;
import com.example.bootjar_comment.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CommentQueryServiceImpl implements CommentQueryService {
    private final QueryRepository queryRepository;

    public Flux<CommentCommand> getCommentList(Long todoId) {
        return queryRepository.findByTodoId(todoId)
                .switchIfEmpty(Flux.error(new IllegalArgumentException("존재하지 않은 투두입니다.")));
    }
}
