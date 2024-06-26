package com.example.bootjar_comment.repository;

import com.example.bootjar_comment.domain.Comment;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CommandRepository extends R2dbcRepository<Comment, Long> {
}
