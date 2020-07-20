package com.crud.redis2.controller;

import com.crud.redis2.model.User;
import com.crud.redis2.repository.userRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/redis/crud")
public class userController {

    private userRepository userRepo;

    public userController(userRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User u1) {
        userRepo.save(u1);
        return "Added User!";
    }

    @PostMapping("/addBulkUsers")
    public String addBulkUsers(@RequestBody List<User> userList){
        int count = 0;
        for (User u1 : userList) {
            userRepo.save(u1);
            count++;
        }
        return "No. of Users added: " + count;
    }

    @GetMapping("/findAllUsers")
    public Map<String, User> getUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/findUser/{id}")
    public User getUser(@PathVariable String id){
        return userRepo.findById(id);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User u1){
        userRepo.update(u1);
        return "Updated User!";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        userRepo.delete(id);
        return "Deleted user with id: " + id;
    }

}
