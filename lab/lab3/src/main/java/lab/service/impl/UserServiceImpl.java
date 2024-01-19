package lab.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.entities.Users;
import lab.repo.UserRepo;
import lab.service.UserService;
import lab.entities.dto.respond.UserDTO;

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

    @Override
    public List<Users> findUsersWithMoreThanNPosts(int n) {
        return userRepo.findUsersWithMoreThanNPosts(n);
    }

}
