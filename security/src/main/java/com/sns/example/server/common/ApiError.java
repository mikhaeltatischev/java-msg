package com.sns.example.server.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {

    private String message;
    private String reason;
    private String statusCode;
    private String timestamp;

}