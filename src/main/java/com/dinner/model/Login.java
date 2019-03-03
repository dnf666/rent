package com.dinner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Login {
    private String phone;

    private String name;

    private String sex;

    private Date birthday;

    private String address;

    private String password;

}