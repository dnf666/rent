package com.dinner.controller;

import com.dinner.model.Cuisine;
import com.dinner.service.CuisineService;
import com.dinner.util.Pager;
import com.dinner.util.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * created on 2019-03-04
 *
 * @author dailinfu
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("cuisine")
public class CuisineController {
    @Resource
    private CuisineService cuisineService;
    @PostMapping("/filter")
    public ResponseEntity memberFilter(@RequestBody Cuisine cuisine,
                                       int page,
                                       int size
    ) {
        Pager<Cuisine> pager = new Pager<>();
        pager.setCurrentPage(page);
        pager.setPageSize(size);
        try {
            List<Cuisine> list = cuisineService.filter(pager, cuisine);
            for (Cuisine cuisine1:list){
                String url = "http://localhost:8082/dinner"+cuisine1.getUrl();
                cuisine1.setUrl(url);
            }
            pager.setData(list);
            return new ResponseEntity(1, "find cuisine success", pager);
        } catch (Exception e) {
            return new ResponseEntity(0,e.getMessage(), pager);
        }
    }
    @PostMapping("file")
    public ResponseEntity updatePhoto(Cuisine cuisine, @RequestParam("file") MultipartFile file,
                                      HttpServletRequest request) throws IOException {
        cuisineService.updatePhoto(cuisine, file, request);
        return new ResponseEntity<>(1, "添加成功", "");
    }
    @PostMapping("delCuisine")
    public ResponseEntity deleteCuisineInfoByCuisineName(@RequestBody Cuisine cuisine) {
        if (cuisine.getName() == null || cuisine.getName().length() == 0) {
            return new ResponseEntity<>(0, "菜名为空", "");
        }
        int result = cuisineService.deleteByPrimaryKey(cuisine);
        return new ResponseEntity<>(1, "删除成功", result);
    }


}
