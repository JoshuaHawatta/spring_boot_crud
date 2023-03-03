package com.joshua.spring_aula.repositories;

import com.joshua.spring_aula.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT U FROM Users U WHERE LOWER(U.name) LIKE %?1%")
    List<Users> getByName(String name);
}
