package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.AddItemRequest;
import org.example.backend.dto.ItemResponse;
import org.example.backend.dto.UpdateItemRequest;
import org.example.backend.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.backend.domain.Item;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemApiController {

    private final ItemService itemService;

    @PostMapping("/api/items")
    public ResponseEntity<Item> addItem(@RequestBody AddItemRequest request) {
        Item savedItem = itemService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedItem);
    }

    @GetMapping("/api/items")
    public ResponseEntity<List<ItemResponse>> findAllItems() {
        List<ItemResponse> items = itemService.findAll()
                .stream()
                .map(ItemResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(items);
    }

    @GetMapping("/api/items/{id}")
    public ResponseEntity<ItemResponse> findItem(@PathVariable int id) {
        Item item = itemService.findById(id);

        return ResponseEntity.ok()
                .body(new ItemResponse(item));
    }

    @DeleteMapping("/api/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id) {
        itemService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable int id,
                                           @RequestBody UpdateItemRequest request) {
        Item updatedItem = itemService.update(id,request);

        return ResponseEntity.ok()
                .body(updatedItem);
    }
}
