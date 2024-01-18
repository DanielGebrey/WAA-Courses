package Lab1.Lab1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Lab1.Lab1.entities.User;
import Lab1.Lab1.entities.dto.respond.UserDTO;

@Service
public interface UserService {

    List<User> findAll();

    UserDTO findById(long id);

    void create(UserDTO userDTO);

    UserDTO update(long id, UserDTO userDTO);

    void deleteById(long id);
}
