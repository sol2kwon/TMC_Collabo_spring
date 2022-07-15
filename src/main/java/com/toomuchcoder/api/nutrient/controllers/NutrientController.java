package com.toomuchcoder.api.nutrient.controllers;

import com.toomuchcoder.api.auth.domain.Messenger;
import com.toomuchcoder.api.nutrient.domains.Nutrient;
import com.toomuchcoder.api.nutrient.domains.NutrientDTO;
import com.toomuchcoder.api.nutrient.services.NutrientService;
import com.toomuchcoder.api.user.domains.User;
import com.toomuchcoder.api.user.domains.UserDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName: com.toomuchcoder.api.addmeal.controllers
 * fileName        : addmealController.java
 * author          : solyikwon
 * date            : 2022-06-01
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-06-01         solyikwon      최초 생성
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/nutrients")

public class NutrientController {
    private final NutrientService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Nutrient>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findAll/sort")
    public ResponseEntity<List<Nutrient>> findAll(Sort sort) {

        return ResponseEntity.ok(service.findAll(sort));
    }


    @GetMapping("/count")
    public ResponseEntity<Messenger> count() {
        return ResponseEntity.ok(service.count());
    }


    @PatchMapping(value = "/update") @ResponseBody
    public ResponseEntity<Messenger> update(@RequestBody NutrientDTO nutrientDTO){
        return ResponseEntity.ok(service.update(nutrientDTO));
    }

    @DeleteMapping(value = "/delete") @ResponseBody
    public ResponseEntity<Messenger> delete(@RequestBody NutrientDTO nutrientDTO){
        return ResponseEntity.ok(service.delete(nutrientDTO));
    }



    @DeleteMapping("/deleteAll")
    public ResponseEntity<Messenger> deleteAll() {
        return ResponseEntity.ok(service.deleteAll());
    }

    @PostMapping("/nutrient")
    public ResponseEntity<Messenger> save(@ApiParam("nutrient user")@RequestBody NutrientDTO nutrientDTO) {
        System.out.println("nutrient 정보:"+nutrientDTO.toString());//확인하고 지우기.
        return ResponseEntity.ok(service.save(nutrientDTO));
    }

    @GetMapping("/existsById/{nutrientid}")
    public ResponseEntity<Messenger> existsById(@PathVariable String nutrientid) {
        return ResponseEntity.ok(service.existsById(nutrientid));

    }
}