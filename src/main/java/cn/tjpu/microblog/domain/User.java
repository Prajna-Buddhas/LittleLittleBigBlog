package cn.tjpu.microblog.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * 用户表实体类
 *
 * @author Trey
 * @since 2020/6/30
 */

@Data
public class User {

    private Integer userId;

    private String username;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String nickname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;

    private String avatarId;

    private String email;

}
