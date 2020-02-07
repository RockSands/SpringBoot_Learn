package com.file.local.server.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * create by lorne on 2017/9/28
 */
public interface FileValidateService {

    void validateFile(MultipartFile file) ;

}
