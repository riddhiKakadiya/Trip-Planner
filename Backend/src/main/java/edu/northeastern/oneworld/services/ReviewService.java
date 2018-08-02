package edu.northeastern.oneworld.services;

import com.google.gson.Gson;
import edu.northeastern.oneworld.models.*;
import edu.northeastern.oneworld.repositories.DestinationRepository;
import edu.northeastern.oneworld.repositories.ReviewRepository;
import edu.northeastern.oneworld.repositories.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    DestinationRepository destinationRepository;

    /**
     * Method to create a new review
     * @param json review object
     * @return owner
     */
    @PostMapping("/api/review")
    public Review createReview(@RequestBody String json) {
        Gson gson = new Gson();
        Review review = gson.fromJson(json, Review.class);
        return reviewRepository.save(review);
    }

    /**
     * @param id
     * @param newreview
     * @return
     */
    @PutMapping("/api/review/{rId}")
    public Review updateReview(@PathVariable("rId") int id, @RequestBody Review newreview) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            return reviewRepository.save(review);
        } else
            return null;
    }

    @GetMapping("/api/review/{rId}/like")
    public int getAllLikesForReview(@PathVariable("rId") int id){
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            return review.getNumberOfLikes().size();
        } else
            return 0;
    }

    @DeleteMapping("api/review/{rId}")
    public void deleteReview(@PathVariable("rId") int id){
        reviewRepository.deleteById(id);
    }
}
