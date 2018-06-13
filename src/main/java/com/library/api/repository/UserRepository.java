package com.library.api.repository;

import com.library.api.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(nativeQuery = true)
    List<User> retrieveUsersWithOverdueLoans();

    @Query
    List<User> retrieveUsersWithNameContaining(@Param("STRING") String name);

    @Override
    List<User> findAll();

    User getUserByUserId(Long userId);

    void deleteById(Long userId);

    User save(User user);

}
