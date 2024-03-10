package com.gorbatko.books.repository;

import com.gorbatko.books.model.BookModel;

import java.util.List;

public interface BookRepository {
    List<BookModel> getAll();
}
