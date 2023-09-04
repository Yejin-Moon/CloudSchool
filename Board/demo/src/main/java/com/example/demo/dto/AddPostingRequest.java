package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.demo.entity.Posting;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddPostingRequest {
    private String name;
    private String title;
    private String content;
    private int view_cnt;

    public Posting toEntity() {
        return Posting.builder()
                .name(name)
                .title(title)
                .content(content)
                .view_cnt(view_cnt)
                .build();
    }
}
