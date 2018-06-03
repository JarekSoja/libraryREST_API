package com.library.rest_api.repository;

import com.library.rest_api.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByUserLastName(String userLastName);

    void deleteById(Long userId);

}
