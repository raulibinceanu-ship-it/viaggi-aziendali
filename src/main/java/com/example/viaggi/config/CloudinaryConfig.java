package com.example.viaggi.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(Map.of(
                "cloud_name", "dle8bfqsl",
                "api_key", "527629648784384",
                "api_secret", "jyLG2fFlfjxOJk_DivXNFMaorCA"
        ));
    }
}
