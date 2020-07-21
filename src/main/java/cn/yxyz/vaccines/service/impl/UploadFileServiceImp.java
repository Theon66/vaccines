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
        try {
            //将传输文件转成File格式
            File file = MultipartFileToFile.multipartFileToFile(zipFile);
            //随机获得一个用户名
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");
            //得到上传文件名
            String originalFilename = zipFile.getOriginalFilename();
            //分割文件名获得文件后缀名
            String fileExtraName = Objects.requireNonNull(originalFilename).substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
            url = tencentUploadUtil.uploadFile("vaccines/" + fileName + "."+fileExtraName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
}



