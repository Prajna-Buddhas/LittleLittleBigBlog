package cn.tjpu.microblog.service;

import cn.tjpu.microblog.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Trey
 * @since 2020/7/8
 */

@Service
public class PublishBlogService {

    public String saveBlogImg(MultipartFile file) throws IOException {
        return FileUtil.saveImg(file,FileUtil.BLOGIMG);
    }
}
