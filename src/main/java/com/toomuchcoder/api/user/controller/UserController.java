package com.toomuchcoder.api.user.controller;

import com.toomuchcoder.api.auth.domain.Messenger;
import com.toomuchcoder.api.user.domain.User;
import com.toomuchcoder.api.user.domain.UserDTO;
import com.toomuchcoder.api.user.repositorie.UserRepository;
import com.toomuchcoder.api.user.service.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName: com.toomuchcoder.api.user.controller
 * fileName        : UserController.java
 * author          : solyikwon
 * date            : 2022-06-01
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-06-01         solyikwon      최초 생성
 **/
@CrossOrigin(origins = "*",allowedHeaders = "*")//나중에 아마존에서 발급하면 체인지함
@Api(tags = "users")
@RequestMapping("/users")
@RestController
@RequiredArgsConstructor

public class UserController {
    private final UserService service;
    private final UserRepository repository;
    private final ModelMapper modelMapper;// 맵 1:1,필터 ??,리듀서 1:다

    @PostMapping("/login")
    @ApiOperation(value = "${UserController.login}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something Wrong"),
            @ApiResponse(code = 422, message = "유효하지 않은 아이디/비밀번호")
    })
    public ResponseEntity<UserDTO> login(@ApiParam("Login User") @RequestBody UserDTO user) {
        return ResponseEntity.ok(service.login(user));
    }

    @PostMapping("/logout")
    public ResponseEntity<Messenger> logout() {
        return ResponseEntity.ok(service.logout());
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findAll/sort")
    public ResponseEntity<List<User>> findAll(Sort sort) {

        return ResponseEntity.ok(service.findAll(sort));
    }

    @GetMapping("/findAll/pageable")
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {

        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/count")
    public ResponseEntity<Messenger> count() {
        return ResponseEntity.ok(service.count());
    }


    @PatchMapping(value = "/update") @ResponseBody
    public ResponseEntity<Messenger> update(@RequestBody UserDTO user){
        return ResponseEntity.ok(service.update(user));
    }
/**
    @DeleteMapping(value = "/delete") @ResponseBody
    public ResponseEntity<Messenger> delete(@RequestBody UserDTO user){
        return ResponseEntity.ok(service.delete(user));
    }
 */



    @DeleteMapping("/deleteAll")
    public ResponseEntity<Messenger> deleteAll() {
        return ResponseEntity.ok(service.deleteAll());
    }

    @PostMapping("/join")
    @ApiOperation(value = "${UserController.join}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something Wrong"),
            @ApiResponse(code = 403, message = "승인거절"),
            @ApiResponse(code = 422, message = "중복된 ID")
    })
    public ResponseEntity<Messenger> save(@ApiParam("Join user")@RequestBody UserDTO user) {
        System.out.println("회원가입정보:"+user.toString());//확인하고 지우기.
        return ResponseEntity.ok(service.save(user));
    }

    @GetMapping("/existsById/{userid}")
    public ResponseEntity<Messenger> existsById(@PathVariable String userid) {
        return ResponseEntity.ok(service.existsById(userid));
    }

    @PostMapping("/existsByUsername") @ResponseBody
    public ResponseEntity<Boolean> existsByUsername(@RequestBody UserDTO user) {
        return ResponseEntity.ok(repository.existsByUsername(user.getUsername()));
    }

    @PostMapping("/existsByPhone") @ResponseBody
    public ResponseEntity<Boolean> existsByPhone(@RequestBody UserDTO user) {
        return ResponseEntity.ok(repository.existsByPhone(user.getPhone()));
    }

    @PostMapping("/existsByEmail") @ResponseBody
    public ResponseEntity<Boolean> existsByEmail(@RequestBody UserDTO user) {
        return ResponseEntity.ok(repository.existsByEmail(user.getEmail()));
    }

    @PostMapping("/existsByNickname") @ResponseBody
    public ResponseEntity<Boolean> existsByNickname(@RequestBody UserDTO user) {
        return ResponseEntity.ok(repository.existsByNickname(user.getNickname()));
    }

    @PostMapping("/existsByGender") @ResponseBody
    public ResponseEntity<Boolean> existsByGender(@RequestBody UserDTO user) {
        return ResponseEntity.ok(repository.existsByNickname(user.getGender()));

    }@PostMapping("/existsByWeight") @ResponseBody
    public ResponseEntity<Boolean> existsByWeight(@RequestBody UserDTO user) {

        return ResponseEntity.ok(repository.existsByNickname(user.getWeight()));
    }
    @PostMapping("/existsByHeight") @ResponseBody
    public ResponseEntity<Boolean> existsByHeight(@RequestBody UserDTO user) {
        return ResponseEntity.ok(repository.existsByNickname(user.getHeight()));
    }
/**
    @DeleteMapping(value = "/delete") @ResponseBody
    public void delete(@RequestBody UserDTO user) throws Exception{
        System.out.println(user);
        service.delete(user);
    }
 */
    @DeleteMapping( "/delete") @ResponseBody
    public void delete(@RequestBody UserDTO user) throws Exception{
        service.delete(user);
    }








}
