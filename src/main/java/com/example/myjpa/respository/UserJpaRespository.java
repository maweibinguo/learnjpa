package com.example.myjpa.respository;

import com.example.myjpa.moel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRespository extends JpaRepository<User, Long> {
}
