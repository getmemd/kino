package com.project.kino.services;

import com.project.kino.entities.Reviews;
import com.project.kino.entities.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewsService {
    List<Reviews> getAllReviewsByUser(String email);
}
