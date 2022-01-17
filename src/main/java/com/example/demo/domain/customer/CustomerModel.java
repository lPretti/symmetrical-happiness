package com.example.demo.domain.customer;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private Long id;
    private String mail;
    private String phone;
    private String name;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;
}
