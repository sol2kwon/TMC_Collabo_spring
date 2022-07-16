package com.toomuchcoder.api.food.controller;

import com.sun.istack.logging.Logger;
import com.toomuchcoder.api.auth.domain.Messenger;
import com.toomuchcoder.api.food.domain.Food;
import com.toomuchcoder.api.food.domain.FoodDTO;
import com.toomuchcoder.api.food.service.FoodService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodController {
    private final FoodService service;



    @GetMapping("/findAll")
    public ResponseEntity<List<Food>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findAll/sort")
    public ResponseEntity<List<Food>> findAll(Sort sort) {

        return ResponseEntity.ok(service.findAll(sort));
    }


    @GetMapping("/count")
    public ResponseEntity<Messenger> count() {
        return ResponseEntity.ok(service.count());
    }


    @PatchMapping(value = "/update") @ResponseBody
    public ResponseEntity<Messenger> update(@RequestBody FoodDTO foodDTO){
        return ResponseEntity.ok(service.update(foodDTO));
    }

    @DeleteMapping(value = "/delete") @ResponseBody
    public ResponseEntity<Messenger> delete(@RequestBody FoodDTO foodDTO){
        return ResponseEntity.ok(service.delete(foodDTO));
    }


    @DeleteMapping("/deleteAll")
    public ResponseEntity<Messenger> deleteAll() {
        return ResponseEntity.ok(service.deleteAll());
    }

    @PostMapping("/food")
    public ResponseEntity<Messenger> save(@ApiParam("food save")@RequestBody FoodDTO foodDTO) {
        System.out.println("food save:"+foodDTO.toString());//확인하고 지우기.
        return ResponseEntity.ok(service.save(foodDTO));
    }

    @GetMapping("/existsById/{foodid}")
    public ResponseEntity<Messenger> existsById(@PathVariable String foodid) {
        return ResponseEntity.ok(service.existsById(foodid));
    }
   @PostMapping("/upload")
    public ResponseEntity upload(@RequestPart MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        File destination = new File("C:/Users/amorf/test/" + originalFileName);//경로확인하기..
        try {
            file.transferTo(destination);
        } catch (IOException e) {
            e.printStackTrace();//에러확인
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(originalFileName);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(originalFileName);
    }

    @PostMapping(value ="/test/multipart")
    public ResponseEntity testMultipart(MultipartFile file) throws Exception {
        if (file == null) {
            throw new Exception();
        }
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        while ((line = br.readLine()) != null) {
        }

        return ResponseEntity.ok().build();
    }
}
