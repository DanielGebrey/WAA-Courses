package Lab1.Lab1.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Lab1.Lab1.entities.User;
import Lab1.Lab1.entities.dto.respond.UserDTO;
import Lab1.Lab1.repo.UserRepo;
import Lab1.Lab1.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserDTO findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDTO.class);
    }

    @Override
    public void create(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepo.save(user);
    }

    @Override
    public UserDTO update(long id, UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setId(id);
        userRepo.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

}
