package vip.xjdai.file;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
public class Base64Img {
    private static SimpleDateFormat df = new SimpleDateFormat("yyyyMM");

    private static String getUploadPath() {
        return "File/image/upload/" + df.format(new Date()) + "/";
    }

    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();


    /**
     * Base64 转换成图片
     *
     * @param base64Str
     * @throws Exception
     */
    public static void saveBase64(String base64Str) throws Exception {
        StringBuilder fileName = new StringBuilder();
        fileName.append(new Date().getTime());
        if (base64Str.contains("data:image/png;")) {
            base64Str = base64Str.replace("data:image/png;base64,", "");
            fileName.append(".png");
        } else if (base64Str.contains("data:image/jpeg;")) {
            base64Str = base64Str.replace("data:image/jpeg;base64,", "");
            fileName.append(".jpeg");
        } else {
            log.error("文件解析错误,faile = [{}]", base64Str);
        }
        try {
            // 将base64编码的字符串解码成字节数组
            byte[] bytes = decoder.decodeBuffer(base64Str);
            // 创建一个将bytes作为其缓冲区的ByteArrayInputStream对象
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            Path directory = Paths.get(Base64Img.getUploadPath());
            long copy = Files.copy(bais, directory.resolve(fileName.toString()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File---Size：" + copy);
            System.out.println("File---Url：" + Base64Img.getUploadPath() + fileName.toString());

        } catch (IOException e) {
            log.error("文件上传失败,faile = [{}]", base64Str);

        }
    }
}
