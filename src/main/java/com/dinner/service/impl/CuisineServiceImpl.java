package com.dinner.service.impl;

import com.dinner.dao.CuisineMapper;
import com.dinner.model.Cuisine;
import com.dinner.service.CuisineService;
import com.dinner.util.Pager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * created on 2019-03-04
 *
 * @author dailinfu
 */

@Service
public class CuisineServiceImpl implements CuisineService {
    @Resource
    private CuisineMapper cuisineMapper;
    @Override
    public int deleteByPrimaryKey(Cuisine key) {
        Cuisine cuisine = cuisineMapper.selectByPrimaryKey(key.getName());
        String url = cuisine.getUrl();

        return cuisineMapper.deleteByPrimaryKey(key.getName());
    }

    @Override
    public int insert(Cuisine record) {
        return 0;
    }

    @Override
    public Cuisine selectByPrimaryKey(Cuisine key) throws Exception {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Cuisine record) {
        return 0;
    }

    @Override
    public List<Cuisine> filter(Pager<Cuisine> pager, Cuisine cuisine) throws Exception {
        Integer total = cuisineMapper.countCuisinesByKeys(cuisine);
        pager.setRecordSize(total);
        if (cuisine != null) {
            return cuisineMapper.filter(pager, cuisine);
        } else {
            throw new Exception("未填写过滤条件");
        }
    }

    @Override
    public void updatePhoto(Cuisine cuisine, MultipartFile file, HttpServletRequest request)throws IOException {
        String originalFilename = file.getOriginalFilename();
        Objects.requireNonNull(originalFilename);
        String suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String fileName = System.currentTimeMillis() + suffix;

        savePhoto(file, request, fileName);

        cuisine.setUrl("/photo/" + fileName);
        cuisineMapper.insert(cuisine);
    }

    @Override
    public List<Cuisine> selectAll() {
        return cuisineMapper.selectAll();
    }

    @Override
    public void updateCuisine(Cuisine cuisine, MultipartFile file, HttpServletRequest request) throws IOException {
        String originalFilename = file.getOriginalFilename();
        Objects.requireNonNull(originalFilename);
        String suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String fileName = System.currentTimeMillis() + suffix;
        deleteOldPhoto(cuisine,request);
        savePhoto(file,request,fileName);
        cuisine.setUrl("/photo/" + fileName);
        cuisineMapper.updateByPrimaryKeySelective(cuisine);
    }

    @Override
    public int deletePhotoAndCuisine(Cuisine cuisine, HttpServletRequest request) throws IOException {
        deleteOldPhoto(cuisine,request);
        return cuisineMapper.deleteByPrimaryKey(cuisine.getName());
    }

    private void deleteOldPhoto(Cuisine cuisine,HttpServletRequest request) throws IOException {
        Cuisine cuisine1 = cuisineMapper.selectByPrimaryKey(cuisine.getName());
        String url = cuisine1.getUrl();
        String filePath = request.getSession().getServletContext().getRealPath(url);
        Path path = Paths.get(filePath);
        Files.deleteIfExists(path);
    }

    private void savePhoto(MultipartFile file, HttpServletRequest request, String fileName) throws IOException {
        String filePath = request.getSession().getServletContext().getRealPath("/photo/" + fileName);
        checkFileExist(filePath);
        File saveFile = new File(filePath);
        try {
            file.transferTo(saveFile);
        }catch (IOException e){
            throw new IOException("文件上传失败");
        }
    }
    private void checkFileExist(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)){
            Files.createFile(path);
        }
    }
}
