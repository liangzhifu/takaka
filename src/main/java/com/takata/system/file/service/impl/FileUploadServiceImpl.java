package com.takata.system.file.service.impl;

import com.takata.common.shiro.Principal;
import com.takata.common.shiro.PrincipalUtils;
import com.takata.system.file.dao.FileUploadDao;
import com.takata.system.file.domain.FileUpload;
import com.takata.system.file.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * @author lzf
 **/
@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

    @Resource(name = "fileUploadDao")
    private FileUploadDao fileUploadDao;

    @Override
    public FileUpload getFileUpload(FileUpload fileUpload) throws Exception {
        return this.fileUploadDao.selectByPrimaryKey(fileUpload);
    }

    @Override
    public void addFileUpload(FileUpload fileUpload) throws Exception {
        Principal principal = PrincipalUtils.getPrincipal();
        fileUpload.setCreateBy(principal != null ? principal.getId() : null);
        fileUpload.setCreateDate(new Date());
        Integer num = this.fileUploadDao.insertSelective(fileUpload);
        if(num != 1){
            throw new Exception("新增上传文件失败！");
        }
    }

    @Override
    public FileUpload addFile(MultipartFile file, String path) throws Exception {
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        int index = fileName.lastIndexOf(".");
        String fileSuffix = fileName.substring(index);
        String fileAlias = UUID.randomUUID().toString() + fileSuffix;
        String filePath = path + "fileupload/" + fileAlias;
        file.transferTo(new File(filePath));

        FileUpload fileUpload = new FileUpload();
        fileUpload.setFileName(fileName);
        fileUpload.setFileAlias(fileAlias);
        fileUpload.setFileType(fileType);
        this.addFileUpload(fileUpload);
        return fileUpload;
    }

}
