package com.dinner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Cost {
    private Integer id;

    private String name;

    private Date date;

    private Double price;


}
