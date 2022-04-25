package com.springboot.repository;

import com.springboot.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select  u from  User u WHERE u.email = ?1")
    Optional<User> findByUserEmail(
            @Param(value = "email") String email
    );

    @Query("select u from User u where u.name like ?1% ")
    List<User> findAndSort(
            @Param(value = "name") String name,
            @Param(value = "sort")Sort sort
    );
}
