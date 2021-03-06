package com.toomuchcoder.api.food.repositorie;

import com.toomuchcoder.api.food.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface  FoodCustomeReposittory{
    /**
     @Query(value="update Comment c set c.comment = :comment  where c.commentid = :postid",
     nativeQuery = true)
     //만약 댓글이 수정된다면 수정 date 자동등록 어떻게 할지?
     // 테이블 그대로 불러오면 안되는거 아님??
     int update(@Param("comment") String comment);
     */
}
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
     Optional<Food> findByFoodname(String foodname);
}
