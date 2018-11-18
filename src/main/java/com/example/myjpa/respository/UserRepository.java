package com.example.myjpa.respository;

import com.example.myjpa.moel.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByNameAndId(String name, Long id);

    List<User> findByNameOrId(String name, Long id);
}
