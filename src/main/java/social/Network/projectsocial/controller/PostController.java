package social.Network.projectsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import social.Network.projectsocial.model.Post;
import social.Network.projectsocial.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost(){
        List<Post> posts = postService.getAllPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody  Post post){
        Post newPost = postService.createPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable("id") long id){
        Post post = postService.getPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        Post updatePost = postService.updatePost(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Post> deletePostById(@PathVariable("id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
