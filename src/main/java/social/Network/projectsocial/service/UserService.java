package social.Network.projectsocial.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import social.Network.projectsocial.exception.UserNotFoundException;
import social.Network.projectsocial.model.User;
import social.Network.projectsocial.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public User createUser(User user){
        user.setUserCode(UUID.randomUUID().toString());
        Date createTime = new Date();
        user.setCreate_At(createTime);
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User by id" + id + "Not found"));
    }

    public void deleteUserById(long id){
        userRepository.deleteById(id);
    }


}
