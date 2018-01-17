package com.takata.system.file.dao;

import com.takata.common.dao.BaseDao;
import com.takata.system.file.domain.FileUpload;
import org.springframework.stereotype.Repository;

/**
 * @author lzf
 **/
@Repository
public class FileUploadDao extends BaseDao {

    /**
     * 插入一个FileUpload文件
     * @param fileUpload 文件数据
     * @return 1成功，0不成功
     */
    public Integer insertSelective(FileUpload fileUpload){
        return this.writerSqlSession.insert("FileUploadMapper.insertSelective", fileUpload);
    }

    /**
     * 根据文件Id查询文件实体
     * @param fileUpload 文件ID
     * @return 返回结果
     */
    public FileUpload selectByPrimaryKey(FileUpload fileUpload){
        return this.readSqlSession.selectOne("FileUploadMapper.selectByPrimaryKey", fileUpload);
    }

}
