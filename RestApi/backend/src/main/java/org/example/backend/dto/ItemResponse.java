package org.example.backend.dto;

import lombok.Getter;
import org.example.backend.domain.Item;

@Getter
public class ItemResponse {
    private final String name;
    private final String content;

    public ItemResponse(Item item) {
        this.name=item.getName();
        this.content=item.getContent();
    }
}
