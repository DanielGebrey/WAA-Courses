package Lab1.Lab1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Lab1.Lab1.entities.User;
import Lab1.Lab1.entities.dto.respond.UserDTO;
import Lab1.Lab1.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO updatedUser) {
        return userService.update(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        userService.deleteById(id);
    }
}
