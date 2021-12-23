package com.example.forum.posts;

import com.example.forum.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostService {

    @Autowired
   PostRepository postRepository;

    public int createPost(Post post) {
        Post existing = postRepository.get(post.getName());
        if (existing != null)
            return 1;

        postRepository.save(post);

        return 0;
    }

    public Collection<Post> getPosts() {
        return postRepository.getPosts();
    }

    public int addFavorite(User user, String postName) {
        Post post = postRepository.get(postName);
        if (post == null)
            return 1;

        user.getFavorites().add(post);
        return 0;
    }

    //public Post editpost(int id, )

    public boolean deletePost(String PostName) {

        Post post = postRepository.get(PostName);
        if (post == null)
            return false;

        postRepository.remove(post);
        return true;
    }
}