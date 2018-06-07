package com.library.rest_api.service;

import com.library.rest_api.domain.QUser;
import com.library.rest_api.domain.User;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    private JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
    private QUser user = QUser.user;
    private JPAQuery<?> query = new JPAQuery<Void>(entityManager);


    public List<User> fetchAllUsersWithGivenFirstName(String param) {
        return queryFactory.selectFrom(user)
                .where(user.userFirstName.eq(param))
                .fetch();
    }
}


