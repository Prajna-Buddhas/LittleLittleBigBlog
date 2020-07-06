package cn.tjpu.microblog.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 评论封装类
 *
 * @author Trey
 * @since 2020/6/30
 */

@Data
public class Comment {

    private Integer commentId;

    private Integer userId;

    private String commentContent;

    private Integer commentLikes;

    private Integer parentCommentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date commentDate;

    private Integer blogId;

    private List<Comment> subComments;
}
