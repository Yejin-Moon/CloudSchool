package com.example.demo.service;

import com.example.demo.dto.AddPostingRequest;
import com.example.demo.dto.UpdatePostingRequest;
import com.example.demo.repository.PostingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Posting;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostingRepository postingRepository;

    public Posting save(AddPostingRequest request) {
        return postingRepository.save(request.toEntity());
    }

    public Posting findById(int id) {
        return postingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id를 찾을 수 없습니다."));
    }

    public void delete(int id) {
        postingRepository.deleteById(id);
    }

    @Transactional
    public Posting update(int id, UpdatePostingRequest request) {
        Posting posting = postingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id를 찾을 수 없습니다."));
        posting.update(request.getName(), request.getContent(), request.getTitle(), request.getView_cnt());
        return posting;
    }

    @Transactional
    public Posting getPost(int id) throws Exception {
        Optional<Posting> post = postingRepository.findById(id);

        if(post.isPresent()) {
            Posting postings = post.get();
            postings.increaseCnt();
            return postings;
        } else {
            throw new Exception("Id Not Found");
        }
    }
}
