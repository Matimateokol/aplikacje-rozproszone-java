package com.example.SpringCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;
    @GetMapping("/")
    public List<Post> getAll(){
        return postRepository.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable("id") int id) {
        return postRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Post> posts) {
        return postRepository.save(posts);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Post updatedPost) {
        Post post = postRepository.getById(id);

        if (post != null) {
            post.setInsides(updatedPost.getInsides());
            postRepository.update(post);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Post updatedPost) {
        Post post = postRepository.getById(id);

        if (post != null) {
            if (updatedPost.getInsides() != null) post.setInsides(updatedPost.getInsides());

            postRepository.update(post);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return postRepository.delete(id);
    }
}
