package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "postings")
public class Posting {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 11)
    private int view_cnt;

    @Builder
    public Posting(String name, String content, String title, int view_cnt) {
        this.name=name;
        this.content=content;
        this.title=title;
        this.view_cnt=view_cnt;
    }

    public void update(String name, String content, String title, int view_cnt) {
        this.name=name;
        this.content=content;
        this.title=title;
        this.view_cnt=view_cnt;
    }

    public void increaseCnt() {
        this.view_cnt++;
    }
}
