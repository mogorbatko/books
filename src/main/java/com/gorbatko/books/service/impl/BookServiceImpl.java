package com.gorbatko.books.service.impl;

import com.gorbatko.books.condition.Column;
import com.gorbatko.books.condition.Sort;
import com.gorbatko.books.exception.checked.ValidationException;
import com.gorbatko.books.model.BookModel;
import com.gorbatko.books.repository.BookRepository;
import com.gorbatko.books.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gorbatko.books.condition.Column.AUTHORS;
import static com.gorbatko.books.condition.Column.NUM_PAGES;
import static com.gorbatko.books.condition.Column.NUM_RATING;
import static com.gorbatko.books.condition.Column.PUBLICATION_DATE;
import static com.gorbatko.books.condition.Column.RATING_SCORE;
import static com.gorbatko.books.condition.Column.TITLE;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookModel> getTop10(Integer year, String column, String sort) throws ValidationException {
        if (!Column.isExist(column)) {
            throw new ValidationException(String.format("Invalid column value! Column can take following values: %s, %s, %s, %s, %s, %s",
                    TITLE.getName(), AUTHORS.getName(), NUM_PAGES.getName(), PUBLICATION_DATE.getName(),
                    RATING_SCORE.getName(), NUM_RATING.getName()));
        }
        if (!Sort.isExist(sort)) {
            throw new ValidationException("Invalid sort value! Parameter sort should contains only ASC or DESC value");
        }
        List<BookModel> models = bookRepository.getAll();
        return models.stream()
                .filter(b -> b.getPublicationDate() != null)
                .filter(b -> year == null || b.getPublicationDate().getYear() == year)
                .filter(Column.isValid(column))
                .sorted(Column.apply(column, sort))
                .limit(10)
                .toList();
    }
}
