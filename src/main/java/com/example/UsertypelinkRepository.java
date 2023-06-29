package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsertypelinkRepository extends JpaRepository<Usertypelink, String> {
        @Query(value = "select * from usertyperlink u where u.username=?1", nativeQuery = true)
        List<Usertypelink> findbyUsername (String username);
}