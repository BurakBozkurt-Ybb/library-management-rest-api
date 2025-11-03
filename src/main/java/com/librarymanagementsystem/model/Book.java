package com.librarymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Benzersiz kitap kimliği (Primary Key)

    @Column(nullable = false)
    private String name; // Kitap adı

    private int publicationYear; // Yayın yılı

    private int stock; // Kütüphanedeki mevcut miktar

    // ---------- İLİŞKİLER ----------

    // Bir kitap bir yazara aittir → Author (EAGER olarak değiştirildi)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    // Bir kitap bir yayınevine aittir → Publisher (EAGER olarak değiştirildi)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    // Bir kitap birden fazla kategoriye ait olabilir (Many-to-Many)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonIgnore
    private List<Category> categories;

    // Bir kitap birden fazla ödünç alma işlemine sahip olabilir (One-to-Many)
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BookBorrowing> borrowings;
}