package com.library.rest_api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLoan is a Querydsl query type for Loan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLoan extends EntityPathBase<Loan> {

    private static final long serialVersionUID = 1848496219L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLoan loan = new QLoan("loan");

    public final ListPath<BookCopy, QBookCopy> copiesLoaned = this.<BookCopy, QBookCopy>createList("copiesLoaned", BookCopy.class, QBookCopy.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> dateOfLoan = createDate("dateOfLoan", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> dateOfReturn = createDate("dateOfReturn", java.time.LocalDate.class);

    public final NumberPath<Long> loanId = createNumber("loanId", Long.class);

    public final QUser user;

    public QLoan(String variable) {
        this(Loan.class, forVariable(variable), INITS);
    }

    public QLoan(Path<? extends Loan> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLoan(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLoan(PathMetadata metadata, PathInits inits) {
        this(Loan.class, metadata, inits);
    }

    public QLoan(Class<? extends Loan> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

