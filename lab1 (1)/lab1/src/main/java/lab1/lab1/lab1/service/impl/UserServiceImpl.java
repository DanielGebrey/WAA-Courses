package lab1.lab1.lab1.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab1.lab1.lab1.entities.Users;
import lab1.lab1.lab1.entities.dto.respond.UserDTO;
import lab1.lab1.lab1.repo.UserRepo;
import lab1.lab1.lab1.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Users> findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserDTO findById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDTO.class);
    }

    @Override
    public void create(UserDTO userDTO) {
        Users user = modelMapper.map(userDTO, Users.class);
        userRepo.save(user);
    }

    @Override
    public UserDTO update(long id, UserDTO userDTO) {
        Users user = modelMapper.map(userDTO, Users.class);
        user.setId(id);
        userRepo.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

}
