package com.librarymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Benzersiz kategori kimliği

    @Column(nullable = false, unique = true)
    private String name; // Kategori adı (örnek: Roman, Tarih, Bilim)

    private String description; // Kategorinin tanımı

    // Bir kategori birden fazla kitaba ait olabilir (Many-to-Many)
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Book> books;
}