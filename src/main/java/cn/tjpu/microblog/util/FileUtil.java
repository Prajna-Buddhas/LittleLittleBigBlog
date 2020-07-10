package cn.tjpu.microblog.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * 上传文件工具类
 *
 * @author Trey
 * @since 2020/7/8
 */


public class FileUtil {
    public static final String AVATAR = "E:/Practice/avatar/";
    public static final String BLOGIMG = "E:/Practice/blogImg/";

    public static String saveImg(MultipartFile file, String path) throws IOException {
        if (file == null) {
            return "fail";
        }
        File filePath = new File(path);
        if (!filePath.exists()){
            filePath.mkdirs();
        }

        UUID fileUuid = UUID.randomUUID();
        String originFileName = fileUuid.toString() + Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().indexOf("."));
        File fileName = new File(path,originFileName);
        file.transferTo(fileName);

        return originFileName;
    }

}
