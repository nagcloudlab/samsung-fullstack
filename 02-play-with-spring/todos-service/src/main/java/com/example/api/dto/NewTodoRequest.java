package com.example.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewTodoRequest {
    private String title;
    private boolean completed;
}
