package be.ucll.david.Tasks.repository;

import be.ucll.david.Tasks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
