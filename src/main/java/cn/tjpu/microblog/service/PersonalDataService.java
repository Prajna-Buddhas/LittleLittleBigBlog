package cn.tjpu.microblog.service;

import cn.tjpu.microblog.dao.PersonalDataMapper;
import cn.tjpu.microblog.domain.User;
import cn.tjpu.microblog.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 陈沿儒
 * @date 2020/7/10 - 18:21
 */

@Slf4j
@Service
public class PersonalDataService {
    @Resource
    private PersonalDataMapper personalDataMapper;
    @Resource
    HttpSession session;

    public void updateData(User user, MultipartFile file) throws IOException {
        if (!"".equals(file.getOriginalFilename()) && file.getOriginalFilename() != null) {
            String avatarId = FileUtil.saveImg(file, FileUtil.AVATAR);
            user.setAvatarId(avatarId);
        }
        personalDataMapper.updateByUserId(user);
        List<User> users = personalDataMapper.getUser(user);
        session.removeAttribute("userInfo");
        User newUser = users.get(0);
        session.setAttribute("userInfo", newUser);
    }
}
