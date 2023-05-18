package com.backendserver.food.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendserver.food.entity.Post;
import com.backendserver.food.repository.PostRepository;
import com.social.socialfoodbackend.modal.User;

@Service
public class PostService {
 
    @Autowired
    private PostRepository postRepository;
 
    public Post save(Post post) {
        return postRepository.save(post);
    }
 
    public List<Post> getAll() {
        return postRepository.findAll();
    }
 
    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }
 
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
 
   
    
   
}


