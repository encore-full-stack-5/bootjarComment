package com.example.bootjar_comment.service;

import com.example.bootjar_comment.dto.CommentDto;
import com.example.bootjar_comment.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CommentQueryServiceImpl implements CommentQueryService {
    private final QueryRepository queryRepository;

    public Flux<CommentDto> getCommentList(Long todoId) {
        return queryRepository.findByTodoId(todoId);
    }
}
