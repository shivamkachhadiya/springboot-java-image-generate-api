package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/my")
public class myapi {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/image")
    public String getImageUrl() {
        String apiUrl = "https://dog.ceo/api/breeds/image/random";

        DogImageResponse response = restTemplate.getForObject(apiUrl, DogImageResponse.class);

        if (response != null && "success".equals(response.getStatus())) {
            return "<img src=\"" + response.getMessage() + "\" alt=\"Dog Image\" />";
        } else {
            return "Failed to get image.";
        }
    }

    // Other endpoints (api1 to api4)
}
