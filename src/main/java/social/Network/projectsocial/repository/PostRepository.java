package social.Network.projectsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import social.Network.projectsocial.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post , Long> {
}
