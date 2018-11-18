package com.example.myjpa.respository;

import com.example.myjpa.moel.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Long> {

}
