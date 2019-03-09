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
    private Long orderId;

    private String userId;

    private Date date;

    private Double price;
    private String name;


}
