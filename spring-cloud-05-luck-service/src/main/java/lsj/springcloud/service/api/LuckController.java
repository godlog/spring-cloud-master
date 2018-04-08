package lsj.springcloud.service.api;


import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author TF016519
 * @description:
 * @date 2018-3-29 15:44
 * @version:1.0.0
 */
@RestController
public class LuckController {

    @RequestMapping(value = "luck", method = RequestMethod.GET)
    public String luck() {
        return "luck";
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            FileUtils.writeByteArrayToFile(new File("d://test" + file.getOriginalFilename()), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }


}
