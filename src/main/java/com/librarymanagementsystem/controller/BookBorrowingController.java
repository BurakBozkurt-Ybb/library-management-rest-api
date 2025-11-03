package com.librarymanagementsystem.controller;

import com.librarymanagementsystem.model.BookBorrowing;
import com.librarymanagementsystem.service.BookBorrowingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowings")
public class BookBorrowingController {

    private final BookBorrowingService borrowingService;

    public BookBorrowingController(BookBorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping
    public List<BookBorrowing> getAllBorrowings() {
        return borrowingService.getAllBorrowings();
    }

    @GetMapping("/{id}")
    public BookBorrowing getBorrowingById(@PathVariable Long id) {
        return borrowingService.getBorrowingById(id);
    }

    @PostMapping
    public BookBorrowing createBorrowing(@RequestBody BookBorrowing borrowing) {
        return borrowingService.createBorrowing(borrowing);
    }

    @PutMapping("/{id}/return")
    public BookBorrowing returnBook(@PathVariable Long id) {
        return borrowingService.returnBook(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBorrowing(@PathVariable Long id) {
        borrowingService.deleteBorrowing(id);
    }
}