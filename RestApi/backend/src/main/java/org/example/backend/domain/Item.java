package org.example.backend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 500, nullable = true)
    private String content;

    @Builder
    public Item(String name, String content) {
        this.name=name;
        this.content=content;
    }

    public void update(String name, String content) {
        this.name=name;
        this.content=content;
    }
}
