package com.example.myjpa.controller;

import com.example.myjpa.moel.User;
import com.example.myjpa.respository.UserPagingAndSortingRepository;
import com.example.myjpa.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

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

    @GetMapping("/getbypage")
    public Page<User> getUserByPage(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize, @RequestParam("sortMethod") String sortMethod) {
        pageNumber = pageNumber > 0 ? pageNumber : 1;
        pageSize = pageSize > 0 && pageSize < 20 ? pageSize : 10;

        Sort.Direction sortForPage;
        switch (Sort.Direction.valueOf(sortMethod.toUpperCase())) {
            case DESC:
                sortForPage = DESC;
                break;
            case ASC:
                sortForPage = ASC;
                break;
            default:
                sortForPage = DESC;
                break;
        }

        Page<User> userList = this.userPagingAndSortingRepository.findAll(
                PageRequest.of(pageNumber, pageSize, Sort.by(sortForPage, "id"))
        );
        return userList;
    }

    @GetMapping("/getbynameorid")
    public List<User> getPageByNameOrId(@RequestParam("name") String name, @RequestParam("id") Long id) {
        return this.userRepository.findByNameOrId(name.trim(), id);
    }

    @GetMapping("/getbynameandid")
    public List<User> getPageByNameAndId(@RequestParam("name") String name, @RequestParam("id") Long id) {
        return this.userRepository.findByNameAndId(name.trim(), id);
    }
}
