package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.service.UploadFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadFileController {
    private UploadFileService uploadFileService;

    public UploadFileController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @RequestMapping("file/upload")
    public ResponseEntity<String>  uploadFileTest(@RequestParam MultipartFile uploadFile) {
        return  ResponseEntity.status(HttpStatus.OK).body(uploadFileService.uploadFile(uploadFile));
    }

}
