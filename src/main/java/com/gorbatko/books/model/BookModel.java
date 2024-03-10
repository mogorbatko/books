package com.gorbatko.books.model;

import com.gorbatko.books.converter.DateConverter;
import com.gorbatko.books.converter.IntegerConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookModel {
    @CsvBindByName
    private String isbn;
    @CsvBindByName
    private String title;
    @CsvBindByName(column = "series_title")
    private String seriesTitle;
    @CsvBindByName(column = "series_release_number")
    private String seriesReleaseNumber;
    @CsvBindByName
    private String authors;
    @CsvBindByName
    private String publisher;
    @CsvBindByName
    private String language;
    @CsvBindByName
    private String description;
    @CsvCustomBindByName(column = "num_pages", converter = IntegerConverter.class)
    private int numPages;
    @CsvBindByName
    private String format;
    @CsvBindByName
    private String[] genres;
    @CsvCustomBindByName(column = "publication_date", converter = DateConverter.class)
    private LocalDate publicationDate;
    @CsvBindByName(column = "rating_score")
    private double ratingScore;
    @CsvBindByName(column = "num_ratings")
    private double numRatings;
    @CsvBindByName(column = "num_reviews")
    private double numReviews;
    @CsvBindByName(column = "current_readers")
    private double currentReaders;
    @CsvBindByName(column = "want_to_read")
    private double wantToRead;
    @CsvBindByName
    private double price;
    @CsvBindByName
    private String url;
}