package com.file.local.server.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.file.local.server.model.FileServerModel;

public interface FileService {
	File download(String filePath);
	
	boolean removeFile(String fileName, int flag);
	
	FileServerModel uploadFile(MultipartFile file);
}
