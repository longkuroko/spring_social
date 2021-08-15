package social.Network.projectsocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import social.Network.projectsocial.model.Comment;
import social.Network.projectsocial.repository.CommentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentService{

    @Autowired
    private CommentRepository commentRepository;

    //get all comment
    public List<Comment> getAllComment(){
        return commentRepository.findAll();
    }

    // create comment
    public Comment createComment (Comment comment){
        return commentRepository.save(comment);
    }


    //update comment
    public Comment updateComment(Comment comment){
        return commentRepository.save(comment);
    }


    //delete comment
    public void deleteCommentById(long id){
        commentRepository.deleteById(id);
    }
}
