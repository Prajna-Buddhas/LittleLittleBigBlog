package cn.tjpu.microblog.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 评论封装类
 *
 * @author Trey
 * @since 2020/6/30
 */

@Data
public class Comment {

    private Integer commentId;

    @NonNull
    private Integer userId;

    @NonNull
    private String commentContent;

    private Integer commentLikes;

    private String parentCommentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date commentDate;

    @NonNull
    private Integer blogId;

}
