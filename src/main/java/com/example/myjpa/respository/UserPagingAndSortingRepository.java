package com.example.myjpa.respository;

import com.example.myjpa.moel.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByName(String name);
}
