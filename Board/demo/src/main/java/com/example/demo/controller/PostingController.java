package com.example.demo.controller;

import com.example.demo.dto.AddPostingRequest;
import com.example.demo.dto.PostingResponse;
import com.example.demo.entity.Posting;
import com.example.demo.repository.PostingRepository;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostingController {
    private final PostService postService;
    @Autowired
    PostingRepository postingRepository;
    @GetMapping("/api/postings")
    public List<Posting> getPostings() {
        List<Posting> postings = postingRepository.findAll();
        return postings;
    }

    @PostMapping("/api/postings")
    public ResponseEntity<Posting> addPosting(@RequestBody AddPostingRequest request) {
        Posting savedPosting = postService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPosting);
    }

    @DeleteMapping("/api/postings/{id}")
    public ResponseEntity<Void> deletePosting(@PathVariable int id) {
        postService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @GetMapping("/api/postings/{id}")
    public ResponseEntity<PostingResponse> findPosting(@PathVariable int id) {
        Posting posting = postService.findById(id);

        return ResponseEntity.ok()
                .body(new PostingResponse(posting));
    }

}
