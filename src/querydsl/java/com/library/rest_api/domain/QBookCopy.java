package com.library.rest_api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBookCopy is a Querydsl query type for BookCopy
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBookCopy extends EntityPathBase<BookCopy> {

    private static final long serialVersionUID = 282468329L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBookCopy bookCopy = new QBookCopy("bookCopy");

    public final NumberPath<Long> bookCopyId = createNumber("bookCopyId", Long.class);

    public final QBookTitle bookTitle;

    public final BooleanPath isAvailable = createBoolean("isAvailable");

    public final QLoan loan;

    public QBookCopy(String variable) {
        this(BookCopy.class, forVariable(variable), INITS);
    }

    public QBookCopy(Path<? extends BookCopy> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBookCopy(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBookCopy(PathMetadata metadata, PathInits inits) {
        this(BookCopy.class, metadata, inits);
    }

    public QBookCopy(Class<? extends BookCopy> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.bookTitle = inits.isInitialized("bookTitle") ? new QBookTitle(forProperty("bookTitle")) : null;
        this.loan = inits.isInitialized("loan") ? new QLoan(forProperty("loan"), inits.get("loan")) : null;
    }

}

