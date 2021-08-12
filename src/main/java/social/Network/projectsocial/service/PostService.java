package social.Network.projectsocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import social.Network.projectsocial.exception.UserNotFoundException;
import social.Network.projectsocial.model.Post;
import social.Network.projectsocial.model.User;
import social.Network.projectsocial.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;



    public List<Post> getAllPost(){
        return postRepository.findAll();

    }
    public Post createPost(Post post){
        return postRepository.save(post);
    }

    public Post getPostById(Long id){
        return postRepository.findById(id).orElseThrow(()-> new UserNotFoundException("This post not found"));
    }

    public Post updatePost(Post post){
        return postRepository.save(post);
    }

    public void deletePostById(long id){
        postRepository.deleteById(id);
    }
}
