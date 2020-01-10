package com.yoke.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personInfo")
public class PersonnelBatchImportController {

    @PostMapping("/batch-import")
    public Object batchImport(@RequestParam("libId") String libId, @RequestParam("userId") String userId){

        return null;
    }
}
