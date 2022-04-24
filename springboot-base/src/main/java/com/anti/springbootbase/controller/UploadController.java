package com.anti.springbootbase.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Controller
public class UploadController {

    @Value("${file.upload.path}")
    private String path;

    @GetMapping("/")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload1")
    @ResponseBody
    public String create(@RequestPart MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String filePath = path + fileName;

            File dest = new File(filePath);
            file.transferTo(dest.toPath());//不用copy防止重复上传
            return "Upload file success : " + dest.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "系统异常";
        }
    }

    @PostMapping("/upload2")
    @ResponseBody
    public String create(@RequestPart MultipartFile[] files) throws IOException {
        StringBuilder message = new StringBuilder();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            String filePath = path + fileName;

            File dest = new File(filePath);
            file.transferTo(dest.toPath());
            message.append("Upload file success : ").append(dest.getAbsolutePath()).append("<br>");
        }
        return message.toString();
    }
}
