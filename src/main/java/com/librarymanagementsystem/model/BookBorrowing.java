package com.librarymanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "book_borrowings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Benzersiz kimlik (Primary Key)

    @Column(nullable = false)
    private String borrowerName; // Kitabı ödünç alan kişinin adı-soyadı

    @Column(nullable = false)
    private LocalDate borrowingDate; // Ödünç alma tarihi

    private LocalDate returnDate; // Teslim tarihi (başta null olabilir)

    // Her ödünç alma işlemi bir kitaba ait olur (Many-to-One)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}