package com.gorbatko.books.service;

import com.gorbatko.books.exception.checked.ValidationException;
import com.gorbatko.books.model.BookModel;

import java.util.List;

public interface BookService {
    List<BookModel> getTop10(Integer year, String column, String sort) throws ValidationException;
}
