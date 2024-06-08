package com.example.service;
 
import com.example.model.Users;
import com.example.repository.UsersRepository;
import com.example.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class UsersService {
 
    @Autowired
    private UsersRepository usersRepository;
 
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
 
    public Users getUsersById(long id) throws ResourceNotFoundException {
        return usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for the ID: " + id));
    }
 
    public Users addUsers(Users users) {
        return usersRepository.save(users);
    }
    
    
    public void updateUsers(long id, Users newUsers) throws ResourceNotFoundException {
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for the ID: " + id));
 
        if (newUsers.getUser_email() != null) {
            users.setUser_email(newUsers.getUser_email());
        }
 
        if (newUsers.getUser_phone() != null) {
            users.setUser_phone(newUsers.getUser_phone());
        }
 
        if (newUsers.getBalance() != 0) {
            users.setBalance(newUsers.getBalance());
        }
        
        if (newUsers.getUser_address() != null) {
            users.setUser_address(newUsers.getUser_address());
        }
 
        usersRepository.save(users);
    }
 
    public void deleteUsers(long id) throws ResourceNotFoundException {
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for the ID: " + id));
        usersRepository.delete(users);
    }
    
}