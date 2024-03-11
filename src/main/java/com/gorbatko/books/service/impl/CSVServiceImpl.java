package com.gorbatko.books.service.impl;

import com.gorbatko.books.exception.CSVServiceRuntimeException;
import com.gorbatko.books.model.BookModel;
import com.gorbatko.books.service.CSVService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
public class CSVServiceImpl implements CSVService {
    @Override
    public List<BookModel> loadDataset(String path) {
        try (FileReader reader = new FileReader(path)) {
            return new CsvToBeanBuilder<BookModel>(reader)
                    .withType(BookModel.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            throw new CSVServiceRuntimeException("Can not load dataset!");
        }
    }


}
