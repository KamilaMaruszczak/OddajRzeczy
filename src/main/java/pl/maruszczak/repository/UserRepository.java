package pl.maruszczak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.maruszczak.model.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    @Query("select u.email from User u")
    List<String> queryFindAllEmails();


}
