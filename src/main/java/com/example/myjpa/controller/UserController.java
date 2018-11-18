package com.example.myjpa.controller;

import com.example.myjpa.moel.User;
import com.example.myjpa.respository.UserPagingAndSortingRepository;
import com.example.myjpa.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    @PostMapping("/add")
    public void addUser(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        this.userRepository.save(user);
    }

    @GetMapping("/getall")
    public Iterable<User> getAllUser() {
        return this.userRepository.findAll();
    }


    @GetMapping("/getbyid")
    public Optional<User> getUserById(@RequestParam("id") Long id) {
        return this.userRepository.findById(id);
    }

    @GetMapping("/deletebyid")
    public void deleteById(@RequestParam("id") Long id) {
        this.userRepository.deleteById(id);
    }

    @PostMapping("/updatebyid")
    public void updateById(@RequestParam("id") Long id, @RequestParam("name") String name) {
        Optional<User> userOptional = this.userRepository.findById(id);
        User user = userOptional.get();
        user.setName(name);
        this.userRepository.save(user);
    }

    @GetMapping("getbypage")
    public Page<User> getUserByPage() {
        Page<User> userList = this.userPagingAndSortingRepository.findAll(
                PageRequest.of(1, 5, Sort.by(Sort.Direction.DESC, "id"))
        );
        return userList;
    }
}
