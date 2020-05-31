package be.ucll.david.Tasks.service;

import be.ucll.david.Tasks.dto.CreateUserDTO;
import be.ucll.david.Tasks.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO createUser(CreateUserDTO userDTO);
}
