package cn.yxyz.vaccines.controller;

import cn.yxyz.vaccines.pojo.Vaccines;
import cn.yxyz.vaccines.service.UploadFileService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadFileController {
    private UploadFileService uploadFileService;

    public UploadFileController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }
    @PostMapping(value = "file/upload", consumes = "multipart/*", headers = "content-type=multipart/form-data")

    @ApiOperation(value="上传文件", httpMethod = "POST",response = String.class,notes="上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uploadFile", value = "传入文件格式", required = true, dataType = "file", paramType = "form")

    })
 public ResponseEntity<String>  uploadFileTest(@RequestPart MultipartFile uploadFile) {
        return  ResponseEntity.status(HttpStatus.OK).body(uploadFileService.uploadFile(uploadFile));
    }

}
