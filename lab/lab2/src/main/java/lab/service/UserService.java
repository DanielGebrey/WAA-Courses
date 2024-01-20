package lab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lab.entities.Users;
import lab.entities.dto.respond.UserDTO;

@Service
public interface UserService {

    List<Users> findAll();

    UserDTO findById(long id);

    void create(UserDTO userDTO);

    UserDTO update(long id, UserDTO userDTO);

    void deleteById(long id);
}
