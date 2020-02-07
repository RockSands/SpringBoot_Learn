package com.file.local.server.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.local.server.config.LocalFileProperties;
import com.file.local.server.exception.FileServerException;
import com.file.local.server.service.FileValidateService;

/**
 */
@Service
public class FileValidateServiceImpl implements FileValidateService {

	@Autowired
	private LocalFileProperties fileProperties;
	
	private List<String> types;

	@PostConstruct
	private void init() {
		types = Arrays.asList(fileProperties.getFileValidateType().split(","));
	}

	@Override
	public void validateFile(MultipartFile file) {
		init();
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		if (!types.contains(ext)) {
			throw new FileServerException("file type error.");
		}
	}
}
