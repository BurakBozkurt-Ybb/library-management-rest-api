package com.librarymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "publishers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Benzersiz yayınevi kimliği

    @Column(nullable = false)
    private String name; // Yayınevi adı

    private int establishmentYear; // Kuruluş yılı

    private String address; // Yayınevi adresi

    // Bir yayınevinin birden fazla kitabı olabilir (One-to-Many)
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Book> books;
}