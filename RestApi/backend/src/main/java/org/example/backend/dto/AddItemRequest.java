package org.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.backend.domain.Item;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddItemRequest {

    private String name;
    private String content;

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .content(content)
                .build();
    }
}
