package com.file.local.server.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import com.file.local.server.config.LocalFileProperties;
import com.file.local.server.exception.FileServerException;
import com.file.local.server.model.FileServerModel;
import com.file.local.server.service.FileService;
import com.file.local.server.service.FileValidateService;
import com.file.local.server.utils.FileServerUtils;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private LocalFileProperties fileProperties;

	@Autowired
	private FileValidateService fileValidateService;

	@Override
	public File download(String filePath) {
		try {
			File file = new File(fileProperties.getFileServerPath() + "/" + filePath);
			if (file == null || !file.exists()) {
				return null;
			} else {
				return file;
			}
		} catch (Exception e) {
			throw new FileServerException(e);
		}
	}

	@Override
	public boolean removeFile(String filePath, int flag) {
		if (StringUtils.isEmpty(filePath)) {
			throw new FileServerException("filePath is null");
		}
		String serverPath = fileProperties.getFileServerPath();
		File file = new File(serverPath + "/" + filePath);
		if (!file.exists()) {
			throw new FileServerException("file not exists");
		}
		boolean isCutFile = FileServerUtils.isCutImgName(file.getName());
		String baseName = FilenameUtils.getBaseName(file.getName());
		if (isCutFile) {
			baseName = baseName.substring(0, baseName.lastIndexOf("_"));
		}
		if (!file.getParent().endsWith(DigestUtils.md5DigestAsHex(baseName.getBytes()))) {
			throw new FileServerException("file md5 val error");
		}
		if (flag == 1) {
			try {
				FileUtils.deleteDirectory(file.getParentFile());
			} catch (IOException e) {
				throw new FileServerException("delete fileName group error.");
			}
		} else {
			file.delete();
			int listLength = file.getParentFile().list().length;
			if (listLength == 0) {
				try {
					FileUtils.deleteDirectory(file.getParentFile());
				} catch (IOException e) {
					throw new FileServerException("delete fileName group error.");
				}
			}
		}
		return true;
	}

	@Override
	public FileServerModel uploadFile(MultipartFile file) {
		if (file.getSize() <= 0) {
			throw new FileServerException("file is null.");
		}
		fileValidateService.validateFile(file);
		try {
			String fileName = file.getOriginalFilename();
			String ext = FilenameUtils.getExtension(fileName);
			String baseName = FilenameUtils.getBaseName(fileName);
			String serverPath = fileProperties.getFileServerPath();
			String fileNamePath = DigestUtils.md5DigestAsHex(baseName.getBytes());
			String filePath = "/" + fileNamePath + "/" + baseName + "." + ext;
			File uploadFile = new File(serverPath + filePath);
			FileUtils.copyInputStreamToFile(file.getInputStream(), uploadFile);
			FileServerModel fileServerModel = new FileServerModel();
			fileServerModel.setPath(filePath);
			fileServerModel.setUrl(fileProperties.getFileDownloadUrl() + filePath);
			return fileServerModel;
		} catch (Exception e) {
			throw new FileServerException(e);
		}
	}
}
