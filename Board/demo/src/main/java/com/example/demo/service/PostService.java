package com.example.demo.service;

import com.example.demo.dto.AddPostingRequest;
import com.example.demo.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Posting;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostingRepository postingRepository;

    public Posting save(AddPostingRequest request) {
        return postingRepository.save(request.toEntity());
    }

    public void delete(int id) {
        postingRepository.deleteById(id);
    }
}
