package com.librarymanagementsystem.exception;

// Aranan kaynak bulunamadığında fırlatılacak özel hata
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}