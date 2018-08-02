package edu.northeastern.oneworld.services;

import java.util.Optional;

import com.google.gson.Gson;
import edu.northeastern.oneworld.models.*;
import edu.northeastern.oneworld.repositories.UserLikeRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.northeastern.oneworld.repositories.AdminRepository;
import edu.northeastern.oneworld.repositories.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})
public class AdminService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    AdminRepository adminRespository;

    @Autowired
    UserLikeRepository userLikeRepository;
    /**
     * Method to create a new user
     *
     * @param json user object
     * @return user
     */
    @PostMapping("/api/admin")
    public Admin createAdmin(@RequestBody String json) {
        Gson gson = new Gson();
        Admin admin = gson.fromJson(json, Admin.class);
        return adminRespository.save(admin);
    }

}
