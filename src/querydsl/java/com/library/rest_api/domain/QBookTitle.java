package com.library.rest_api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBookTitle is a Querydsl query type for BookTitle
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBookTitle extends EntityPathBase<BookTitle> {

    private static final long serialVersionUID = 182108260L;

    public static final QBookTitle bookTitle = new QBookTitle("bookTitle");

    public final StringPath author = createString("author");

    public final NumberPath<Long> bookTitleId = createNumber("bookTitleId", Long.class);

    public final ListPath<BookCopy, QBookCopy> listOfCopies = this.<BookCopy, QBookCopy>createList("listOfCopies", BookCopy.class, QBookCopy.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final NumberPath<Integer> yearOfPublishing = createNumber("yearOfPublishing", Integer.class);

    public QBookTitle(String variable) {
        super(BookTitle.class, forVariable(variable));
    }

    public QBookTitle(Path<? extends BookTitle> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBookTitle(PathMetadata metadata) {
        super(BookTitle.class, metadata);
    }

}

