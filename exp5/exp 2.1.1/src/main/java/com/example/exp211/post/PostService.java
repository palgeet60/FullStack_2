package com.example.exp211.post;

import com.example.exp211.common.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional(readOnly = true)
    public List<PostResponse> findAll() {
        return postRepository.findAll().stream().map(PostResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public PostResponse findById(Long id) {
        return PostResponse.from(getPost(id));
    }

    public PostResponse create(PostRequest request) {
        Post post = new Post();
        apply(request, post);
        return PostResponse.from(postRepository.save(post));
    }

    public PostResponse update(Long id, PostRequest request) {
        Post post = getPost(id);
        apply(request, post);
        post.updateTimestamps();
        return PostResponse.from(postRepository.save(post));
    }

    public void delete(Long id) {
        Post post = getPost(id);
        postRepository.delete(post);
    }

    private Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found: " + id));
    }

    private void apply(PostRequest request, Post post) {
        post.setTitle(request.title());
        post.setContent(request.content());
        post.setAuthor(request.author());
    }
}
