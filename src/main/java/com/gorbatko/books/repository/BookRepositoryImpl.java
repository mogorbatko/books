package com.gorbatko.books.repository;

import com.gorbatko.books.config.ConfigReader;
import com.gorbatko.books.model.BookModel;
import com.gorbatko.books.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final List<BookModel> bookRepo;

    @Autowired
    public BookRepositoryImpl(CSVService csvService,
                              ConfigReader configReader) {
        String path = configReader.getDatasetPath();
        this.bookRepo = csvService.loadDataset(path);
    }

    @Override
    public List<BookModel> getAll() {
        return bookRepo;
    }

}
