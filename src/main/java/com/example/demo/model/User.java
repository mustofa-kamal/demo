package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

    @Id
    private String id;

    @NotNull(message = "Must be filled")
    @Size(min=2, max=30, message = "Must be min 2 and max 30 size")
    private String name;

    @NotNull(message = "Must be filled")
    @Email(message = "Must be a valid email address")
    private String email;

    private LocalDateTime registrationDate;


}
