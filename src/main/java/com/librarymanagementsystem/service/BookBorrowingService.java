package com.librarymanagementsystem.service;

import com.librarymanagementsystem.exception.ResourceNotFoundException;
import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.model.BookBorrowing;
import com.librarymanagementsystem.repository.BookBorrowingRepository;
import com.librarymanagementsystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookBorrowingService {
    private final BookBorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;

    public BookBorrowingService(BookBorrowingRepository borrowingRepository, BookRepository bookRepository) {
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
    }

    public List<BookBorrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public BookBorrowing getBorrowingById(Long id) {
        return borrowingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing record not found with id: " + id));
    }

    public BookBorrowing createBorrowing(BookBorrowing borrowing) {
        Long bookId = borrowing.getBook().getId();
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        borrowing.setBook(book);
        return borrowingRepository.save(borrowing);
    }

    public BookBorrowing returnBook(Long id) {
        BookBorrowing borrowing = getBorrowingById(id);
        borrowing.setReturnDate(LocalDate.now());
        return borrowingRepository.save(borrowing);
    }

    public void deleteBorrowing(Long id) {
        BookBorrowing borrowing = getBorrowingById(id);
        borrowingRepository.delete(borrowing);
    }
}