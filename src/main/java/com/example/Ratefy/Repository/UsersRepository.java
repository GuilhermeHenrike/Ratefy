package com.example.Ratefy.Repository;

import com.example.Ratefy.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    public Users findByUsername(String username);
    public boolean existsByUsername(String username);

}
