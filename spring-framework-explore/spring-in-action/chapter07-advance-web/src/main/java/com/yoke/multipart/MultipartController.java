package com.yoke.multipart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("multi")
public class MultipartController {

    @PostMapping
    @ResponseBody
    public String uploadFile(@RequestPart MultipartFile file){

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());

        return "OK";
    }
}
