package com.gorbatko.books.service;

import com.gorbatko.books.exception.ValidationRuntimeException;
import com.gorbatko.books.model.BookModel;

import java.util.List;

public interface BookService {
    /**
     * @throws ValidationRuntimeException
     */
    List<BookModel> getTop10(Integer year, String column, String sort);
}
