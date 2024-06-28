package com.example.bootjar_comment.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String nickname;
    private String image;
}
