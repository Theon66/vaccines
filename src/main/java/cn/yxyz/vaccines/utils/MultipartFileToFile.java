package cn.yxyz.vaccines.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;

public class MultipartFileToFile {

    public static File multipartFileToFile(MultipartFile file) throws IOException {
        if (file == null || file.getSize() <= 0) {
            return null;
        }

        InputStream ins = file.getInputStream();
        File toFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        inputStreamToFile(ins, toFile);
        ins.close();
        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     */
    public static boolean deleteTempFile(File file) {
        boolean res = true;
        if (file != null) {
            res = file.delete();
        }
        return res;
    }
}
