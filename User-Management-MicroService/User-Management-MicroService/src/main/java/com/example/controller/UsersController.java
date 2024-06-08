package com.example.controller;
 
import com.example.model.Users;
import com.example.service.UsersService;
import com.example.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@CrossOrigin(origins = "*")
@RequestMapping("/users")
@RestController
public class UsersController {
 
    @Autowired
    private UsersService usersService;
 
    @GetMapping("/read")
    public List<Users> read() {
        return usersService.getAllUsers();
    }
 
    @GetMapping("/readOne/{id}")
    public Users readOne(@PathVariable long id) throws ResourceNotFoundException {
        return usersService.getUsersById(id);
    }
 
    @PostMapping("/add")
    public Users add(@RequestBody Users users) {
        return usersService.addUsers(users);
    }
 
    @PutMapping("/update/{id}")
    public void update(@RequestBody Users users, @PathVariable long id) throws ResourceNotFoundException {
    	usersService.updateUsers(id, users);
    }
 
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) throws ResourceNotFoundException {
    	usersService.deleteUsers(id);
    }
}
