package cn.tjpu.microblog.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Blog表封装类
 *
 * @author Trey
 * @since 2020/6/30
 */

@Data
public class Blog {

    //blogId
    private Integer blogId;

    //标题
    private String title;

    //正文
    private String content;

    //authorId
    private Integer authorId;

    //tagId
    private Integer tagId;

    //点赞数
    private Integer likes;

    //浏览量
    private Integer pageviews;

    //发表时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    //评论数
    private Integer commentCount;

    //blogPhotoId
    private String blogPhoto;

}
