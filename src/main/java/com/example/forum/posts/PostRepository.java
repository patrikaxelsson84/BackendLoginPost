package com.example.forum.posts;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository {

    private Map<String, Post> posts = new HashMap<>();

    public Post get(String name) {
        return posts.get(name.toLowerCase());
    }

    public void save(Post post) {
        posts.put(post.getName().toLowerCase(), post);
    }

    public void remove(Post post){
        posts.remove(post.getName().toLowerCase());
    }

    public Collection<Post> getPosts() {
        return posts.values();
    }

}