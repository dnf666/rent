package com.dinner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Finance {
    private Integer id;
    private Date date;
    private String phone;
    private String location;
    private String name;

}
