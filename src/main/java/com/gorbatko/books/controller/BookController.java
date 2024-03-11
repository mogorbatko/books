package com.gorbatko.books.controller;

import com.gorbatko.books.exception.ValidationRuntimeException;
import com.gorbatko.books.model.BookModel;
import com.gorbatko.books.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get top 10 books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    @GetMapping("/top10")
    public ResponseEntity<List<BookModel>> getTop10(@Valid
                                                    @RequestParam(required = false)
                                                    @Min(value = 1000, message = "Year must be a 4-digit number")
                                                    @Max(value = 9999, message = "Year must be a 4-digit number")
                                                    Integer year,
                                                    @RequestParam String column,
                                                    @RequestParam String sort) throws ValidationRuntimeException {
        return ResponseEntity.status(200).body(bookService.getTop10(year, column, sort));
    }
}
