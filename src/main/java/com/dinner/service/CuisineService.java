package com.dinner.service;

import com.dinner.model.Cuisine;
import com.dinner.util.Pager;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * created on 2019-03-04
 *

 */


public interface CuisineService extends BaseService<Cuisine>{
    List<Cuisine> filter(Pager<Cuisine> pager, Cuisine cuisine) throws Exception;

    void updatePhoto(Cuisine cuisine, MultipartFile file, HttpServletRequest request) throws IOException;

    List<Cuisine> selectAll();

    void updateCuisine(Cuisine cuisine, MultipartFile file, HttpServletRequest request) throws IOException;

    int deletePhotoAndCuisine(Cuisine cuisine, HttpServletRequest request) throws IOException;
}
