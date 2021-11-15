package com.example.forum.posts;

import com.example.forum.user.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@CrossOrigin
@RestController
@Data
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public Collection<Post> getPosts(@RequestHeader("token") String token, HttpServletResponse response) {
        if (userService.validate(token) == null) {
            response.setStatus(401);
            return null;
        }

        return postService.getPosts();
    }

    @PutMapping("/create")
    public String createPost(@RequestHeader("token") String token, @RequestBody Post post, HttpServletResponse response) {
        if (userService.validate(token) == null) {
            response.setStatus(401);
            return null;
        }

        int result = postService.createPost(post);
        switch (result) {
            case 1:
                response.setStatus(409);
                return "There is already a post with that name";
            case 0:
                return "Post has been created";
            default:
                response.setStatus(500);
                return "Something went wrong.";
        }
    }

    @DeleteMapping("/post/delete/{PostName}")
    public String deletePost(@PathVariable("PostName") String PostName, HttpServletResponse response) {
        if (!postService.deletePost(PostName)) {
            response.setStatus(404);
            return "There is no post named '" + PostName + "'";
        }

        return "You have deleted '" + PostName + "'";
    }

   // private String name, description;
}
