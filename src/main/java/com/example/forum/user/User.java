package com.example.forum.user;

import com.example.forum.posts.Post;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    private String name, password;
    private List<Post> favorites;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.favorites = new ArrayList<>();
    }
}
