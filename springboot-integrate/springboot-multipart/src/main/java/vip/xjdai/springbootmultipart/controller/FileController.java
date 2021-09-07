package vip.xjdai.springbootmultipart.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("FileController")
public class FileController {

    @PostMapping("/upload")
    public String upload(UserP user, MultipartFile pictureFile) {
        System.out.println(user);
        //原始文件名称
        return pictureFile.getOriginalFilename();
    }

    @Data
    public static class UserP {
        private String name;

    }
}
