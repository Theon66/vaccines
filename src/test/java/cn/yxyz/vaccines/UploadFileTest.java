package cn.yxyz.vaccines;

import cn.yxyz.vaccines.utils.TencentUploadUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UploadFileTest {
    @Autowired
    private TencentUploadUtil tencentUploadUtil;

    @Test
    public void testUpload() {
        //1.创建文件
        File file = new File("D:\\pic\\0.jpg");
        //2.调用方法，传入要在服务器上保存的目录及文件名    和  文件
//        System.out.println(tencentUploadUtil.uploadFile("vaccines/0.jpg",file));
       // UUID.randomUUID().toString().replaceAll("-","");
        System.out.println("11111111111111111111"+UUID.randomUUID().toString().replaceAll("-",""));
    }
}
