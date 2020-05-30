package com.project.kino.services;

import com.project.kino.entities.Reviews;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewsService {
    List<Reviews> getAllReviewsByUser(String email);

    Reviews getReviewById(Long id);

    void saveReview(Reviews review);

    void deleteReview(Reviews review);
}
