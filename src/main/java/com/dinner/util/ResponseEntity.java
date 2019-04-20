package com.dinner.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * created on 2019-03-03
 *

 */
@Data
@AllArgsConstructor
public class ResponseEntity<T>{
    private int status;
    private String message;
    private T object;
}

