package org.example.backend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.backend.domain.Item;
import org.example.backend.dto.AddItemRequest;
import org.example.backend.dto.UpdateItemRequest;
import org.example.backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    public Item save(AddItemRequest request) {
        return itemRepository.save(request.toEntity());
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(int id) {
        return itemRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found : "+id));
    }

    public void delete(int id) {
        itemRepository.deleteById(id);
    }

    @Transactional
    public Item update(int id, UpdateItemRequest request) {
        Item item = itemRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found : "+id));
        item.update(request.getName(), request.getContent());
        return item;
    }
}
