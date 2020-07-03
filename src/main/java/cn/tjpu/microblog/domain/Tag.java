package cn.tjpu.microblog.domain;

import lombok.Data;
import lombok.NonNull;

/**
 * 微博标签封装类
 *
 * @author Trey
 * @since 2020/6/30
 */

@Data
public class Tag {

    private String tagId;

    private String tagName;

    private String tagDescription;
}
