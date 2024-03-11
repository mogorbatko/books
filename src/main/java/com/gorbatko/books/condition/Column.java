package com.gorbatko.books.condition;

import com.gorbatko.books.model.BookModel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.gorbatko.books.condition.Sort.DESC;

public enum Column {
    BOOK("book", Comparator.comparing(BookModel::getBook), book -> book.getBook() != null),
    AUTHOR("author", Comparator.comparing(BookModel::getAuthor), book -> book.getAuthor() != null),
    NUM_PAGES("numPages", Comparator.comparing(BookModel::getNumPages), book -> book.getNumPages() != null),
    PUBLICATION_DATE("publicationDate", Comparator.comparing(BookModel::getPublicationDate), book -> book.getPublicationDate() != null),
    RATING("rating", Comparator.comparing(BookModel::getRating), book -> true),
    NUM_OF_VOTERS("numberOfVoters", Comparator.comparing(BookModel::getNumOfVoters), book -> true);

    private static final Set<String> NAMES = Arrays.stream(values())
            .map(Column::getName)
            .collect(Collectors.toSet());

    private static final Map<String, Comparator<BookModel>> COMPARATOR_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(Column::getName, Column::getComparator));

    private static final Map<String, Predicate<BookModel>> PREDICATE_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(Column::getName, Column::getPredicate));

    public static Comparator<BookModel> of(String column, String sort) {
        if (DESC.name().equals(sort)) {
            return COMPARATOR_MAP.get(column).reversed();
        } else {
            return COMPARATOR_MAP.get(column);
        }
    }

    public static Predicate<BookModel> isValid(String column) {
        return PREDICATE_MAP.getOrDefault(column, b -> true);
    }

    public static boolean isExist(String column) {
        return NAMES.contains(column);
    }

    private final String name;

    private final Comparator<BookModel> comparator;

    private final Predicate<BookModel> predicate;

    Column(String column, Comparator<BookModel> comparator, Predicate<BookModel> predicate) {
        this.name = column;
        this.comparator = comparator;
        this.predicate = predicate;
    }

    public String getName() {
        return this.name;
    }

    private Comparator<BookModel> getComparator() {
        return this.comparator;
    }

    private Predicate<BookModel> getPredicate() {
        return this.predicate;
    }
}
