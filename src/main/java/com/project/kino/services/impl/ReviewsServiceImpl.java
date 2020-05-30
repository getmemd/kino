package com.project.kino.services.impl;

import com.project.kino.entities.Reviews;
import com.project.kino.repositories.ReviewsRepository;
import com.project.kino.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    public List<Reviews> getAllReviewsByUser(String email) {
        return reviewsRepository.findByDeletedAtNullAndAuthor_Email(email);
    }

    public Reviews getReviewById(Long id) {
        return reviewsRepository.getOne(id);
    }

    public void saveReview(Reviews review) {
        reviewsRepository.save(review);
    }

    public void deleteReview(Reviews review) {
        reviewsRepository.delete(review);
    }
}
