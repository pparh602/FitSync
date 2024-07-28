package com.fitsync.FitSync.controllers;

import com.fitsync.FitSync.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/media")
public class MediaController {

    @Autowired private ImageService imageService;

    @PostMapping("/image")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        return imageService.upload(multipartFile);
    }
}
