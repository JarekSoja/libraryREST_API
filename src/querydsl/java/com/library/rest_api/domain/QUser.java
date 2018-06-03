package com.library.rest_api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1848768310L;

    public static final QUser user = new QUser("user");

    public final DatePath<java.time.LocalDate> dateOfCreation = createDate("dateOfCreation", java.time.LocalDate.class);

    public final ListPath<Loan, QLoan> listOfLoans = this.<Loan, QLoan>createList("listOfLoans", Loan.class, QLoan.class, PathInits.DIRECT2);

    public final StringPath userFirstName = createString("userFirstName");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userLastName = createString("userLastName");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

