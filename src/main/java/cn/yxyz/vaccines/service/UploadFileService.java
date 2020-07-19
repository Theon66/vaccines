package cn.yxyz.vaccines.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    String uploadFile(MultipartFile zipFile);
}
