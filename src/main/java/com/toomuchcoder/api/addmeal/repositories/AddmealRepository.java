package com.toomuchcoder.api.addmeal.repositories;

import com.toomuchcoder.api.addmeal.domains.Addmeal;
import com.toomuchcoder.api.comment.domains.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName: com.toomuchcoder.api.addmeal.repositories
 * fileName        : AddmealRepositories.java
 * author          : solyikwon
 * date            : 2022-06-01
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-06-01         solyikwon      최초 생성
 **/
public interface AddmealRepository extends JpaRepository<Addmeal, Long> {
}
