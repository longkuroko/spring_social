package social.Network.projectsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import social.Network.projectsocial.model.User;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
    Optional<User> findUserByUserCode(String userCode);

    Boolean existsByEmail(String email);


    @Transactional
    @Modifying
    @Query(
            "UPDATE User a " + "SET a.isEnable = TRUE WHERE a.email = ?1")
    int enableUser(String email);
}
