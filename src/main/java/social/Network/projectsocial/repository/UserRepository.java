package social.Network.projectsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import social.Network.projectsocial.model.User;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User , Long> {
}
