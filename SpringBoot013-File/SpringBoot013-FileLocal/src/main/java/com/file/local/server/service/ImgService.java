package com.file.local.server.service;

import org.springframework.web.multipart.MultipartFile;

import com.file.local.server.model.FileServerModel;
/**
 * create by lorne on 2017/12/27
 */
public interface ImgService {

    FileServerModel uploadImage(MultipartFile file, String cutSize);

    boolean cutImage(String filePath, String cutSize);
}
