package com.toomuchcoder.api.image.services;

import com.toomuchcoder.api.auth.domain.Messenger;
import com.toomuchcoder.api.image.domains.Image;

/**
 * packageName: com.toomuchcoder.api.comment.services
 * fileName        : CommentService.java
 * author          : solyikwon
 * date            : 2022-06-01
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-06-01         solyikwon      최초 생성
 **/
public interface ImageService {
     Messenger count() ;


      Messenger update(Image image);


     Messenger delete(Image image);


     Messenger save(Image image);

}