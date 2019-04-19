package com.dinner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cuisine {
    private String location;

    private String url;

    private Double price;
    private Integer num = 0;
    private String roomOwner;
    private String phone;
    private String others;

}
