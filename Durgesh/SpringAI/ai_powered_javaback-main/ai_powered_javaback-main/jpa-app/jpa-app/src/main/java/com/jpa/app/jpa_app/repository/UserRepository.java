package com.jpa.app.jpa_app.repository;

import com.jpa.app.jpa_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Integer>
{

}
