package com.gorbatko.books.service;

import com.gorbatko.books.model.BookModel;

import java.util.List;

public interface CSVService {
    List<BookModel> loadDataset(String path);
}
