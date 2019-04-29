package com.shopping.service;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.shopping.common.enums.ExceptionEnums;
import com.shopping.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UploadService {


    @Autowired
    private FastFileStorageClient storageClient;

    public static final List<String> ALLOW_TYPES= Arrays.asList("image/jpeg","image/png","image/bmp");
    public String uploadImage(MultipartFile file) {
        //保存文件
        try {

            String contentType = file.getContentType();

            if (!ALLOW_TYPES.contains(contentType)){
                throw new LyException(ExceptionEnums.UPLOAD_FILE_TYPE_ERROR);
            }

            BufferedImage read = ImageIO.read(file.getInputStream());
            if (read==null){
                throw new LyException(ExceptionEnums.UPLOAD_FILE_TYPE_NOT_ERROR);
            }
            /*File desc=new File("F:\\BaiduYunDownload\\shopping\\upload",file.getOriginalFilename());
            file.transferTo(desc);*/
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);

            return "http://image.leyou.com/"+storePath.getFullPath();
        } catch (IOException e) {
            log.error("上传文件失败!",e);
            throw new LyException(ExceptionEnums.UPLOAD_FILE_ERROR);
        }
        //返回地址
    }
}
