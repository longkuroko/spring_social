package social.Network.projectsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import social.Network.projectsocial.model.Comment;
import social.Network.projectsocial.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComment(){
        List<Comment> comments = commentService.getAllComment();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(Comment comment){
        Comment comment1 = commentService.createComment(comment);
        return new ResponseEntity<>(comment1, HttpStatus.OK);
    }

}
