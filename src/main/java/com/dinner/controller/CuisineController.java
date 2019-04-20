package com.dinner.controller;

import com.dinner.model.Cuisine;
import com.dinner.service.CuisineService;
import com.dinner.util.Pager;
import com.dinner.util.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("cuisine")
public class CuisineController {
    @Resource
    private CuisineService cuisineService;

    /**
     *房源管理的过滤
     * @param cuisine
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/filter")
    public ResponseEntity cuisineFilter(@RequestBody Cuisine cuisine,
                                        Integer page,
                                        Integer size
    ) {
        Pager<Cuisine> pager = new Pager<>();
        pager.setCurrentPage(page);
        pager.setPageSize(size);
        try {
            List<Cuisine> list = cuisineService.filter(pager, cuisine);
            for (Cuisine cuisine1 : list) {
                String url = cuisine1.getUrl();
                cuisine1.setUrl("/rent/"+url);
            }
            pager.setData(list);
            return new ResponseEntity(1, "find cuisine success", pager);
        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage(), pager);
        }
    }

    /**
     * 点菜时显示菜单
     * @return
     */
    @GetMapping("filter")
    public ResponseEntity selectAll() {
        List<Cuisine> list = cuisineService.selectAll();
        for (Cuisine cuisine1 : list) {
            String url = cuisine1.getUrl();
            cuisine1.setUrl("/rent/"+url);
        }
        Pager<Cuisine> pager = new Pager<>();
        pager.setRecordSize(list.size());
        pager.setData(list);
        return new ResponseEntity(1, "success", pager);

    }

    @PostMapping("file")
    public ResponseEntity updatePhoto(Cuisine cuisine, @RequestParam("file") MultipartFile file,
                                      HttpServletRequest request) throws IOException {
        cuisineService.updatePhoto(cuisine, file, request);
        return new ResponseEntity<>(1, "添加成功", "");
    }

    @PostMapping("updateCuisine")
    public ResponseEntity updateCuisine(Cuisine cuisine, @RequestParam("file") MultipartFile file,
                                        HttpServletRequest request) throws IOException {
        cuisineService.updateCuisine(cuisine, file, request);
        return new ResponseEntity<>(1, "更改成功", "");

    }

    @PostMapping("delCuisine")
    public ResponseEntity deleteCuisineInfoByCuisineName(@RequestBody Cuisine cuisine, HttpServletRequest request) throws IOException {
        if (cuisine.getLocation() == null || cuisine.getLocation().length() == 0) {
            return new ResponseEntity<>(0, "位置为空", "");
        }
        int result = cuisineService.deletePhotoAndCuisine(cuisine,request);
        return new ResponseEntity<>(1, "删除成功", result);
    }

}
