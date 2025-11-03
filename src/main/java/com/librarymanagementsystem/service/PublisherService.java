package com.librarymanagementsystem.service;

import com.librarymanagementsystem.exception.ResourceNotFoundException;
import com.librarymanagementsystem.model.Publisher;
import com.librarymanagementsystem.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with id: " + id));
    }

    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(Long id, Publisher updatedPublisher) {
        Publisher publisher = getPublisherById(id);
        publisher.setName(updatedPublisher.getName());
        publisher.setAddress(updatedPublisher.getAddress());
        publisher.setEstablishmentYear(updatedPublisher.getEstablishmentYear());
        return publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id) {
        Publisher publisher = getPublisherById(id);
        publisherRepository.delete(publisher);
    }
}