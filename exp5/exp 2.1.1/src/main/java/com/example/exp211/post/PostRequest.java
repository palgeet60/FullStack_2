package com.example.exp211.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 120, message = "Title must be at most 120 characters")
        String title,

        @NotBlank(message = "Content is required")
        @Size(max = 5000, message = "Content must be at most 5000 characters")
        String content,

        @NotBlank(message = "Author is required")
        @Size(max = 80, message = "Author must be at most 80 characters")
        String author
) {
}
