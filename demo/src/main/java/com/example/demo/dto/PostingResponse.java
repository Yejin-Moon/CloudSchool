package com.example.demo.dto;

import lombok.Getter;
import com.example.demo.entity.Posting;
@Getter
public class PostingResponse {
    private final String name;
    private final String title;
    private final String content;

    public PostingResponse(Posting posting) {
        this.name=posting.getName();
        this.title=posting.getTitle();
        this.content= posting.getContent();
    }
}
