package cn.yxyz.vaccines.service.impl;

import cn.yxyz.vaccines.service.UploadFileService;
import cn.yxyz.vaccines.utils.MultipartFileToFile;
import cn.yxyz.vaccines.utils.TencentUploadUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

@Service
public class UploadFileServiceImp implements UploadFileService {

    private TencentUploadUtil tencentUploadUtil;

    public UploadFileServiceImp(TencentUploadUtil tencentUploadUtil) {
        this.tencentUploadUtil = tencentUploadUtil;
    }

    @Override
    public String uploadFile(MultipartFile zipFile) {
        String url = null;
        File file=null;
        try {
            file = MultipartFileToFile.multipartFileToFile(zipFile);
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");
            String originalFilename = zipFile.getOriginalFilename();
            String fileExtraName = Objects.requireNonNull(originalFilename).substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
            url = tencentUploadUtil.uploadFile("vaccines/" + fileName + "."+fileExtraName, file);
            MultipartFileToFile.deleteTempFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MultipartFileToFile.deleteTempFile(file);
        }
        return url;
    }
}



