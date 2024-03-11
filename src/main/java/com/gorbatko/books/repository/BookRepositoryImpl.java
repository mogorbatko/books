package com.gorbatko.books.repository;

import com.gorbatko.books.config.ConfigReader;
import com.gorbatko.books.model.BookModel;
import com.gorbatko.books.service.CSVService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRepositoryImpl implements BookRepository {
    private List<BookModel> bookRepo;
    private final CSVService csvService;
    private final ConfigReader configReader;

    @Autowired
    public BookRepositoryImpl(CSVService csvService,
                              ConfigReader configReader) {
        this.csvService = csvService;
        this.configReader = configReader;
    }

    @PostConstruct
    private void init() {
        String path = configReader.getDatasetPath();
        this.bookRepo = csvService.loadDataset(path);
    }

    @Override
    public List<BookModel> getAll() {
        return bookRepo;
    }

}
