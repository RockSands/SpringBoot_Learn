package com.file.local.server.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.local.server.config.LocalFileProperties;
import com.file.local.server.exception.FileServerException;
import com.file.local.server.model.FileServerModel;
import com.file.local.server.model.ImageWH;
import com.file.local.server.service.FileService;
import com.file.local.server.service.ImgService;
import com.file.local.server.utils.FileServerUtils;

import net.coobird.thumbnailator.Thumbnails;

/**
 * create by lorne on 2017/12/27
 */
@Service
public class ImgServiceImpl implements ImgService {

	@Autowired
	private FileService fileService;

	@Autowired
	private LocalFileProperties fileProperties;

	@Override
	public FileServerModel uploadImage(MultipartFile file, String cutSize) {
		if (file.getSize() <= 0) {
			throw new FileServerException("file is null.");
		}
		if (cutSize == null) {
			cutSize = fileProperties.getFileDefaultCutSize();
		}
		FileServerModel fileServerModel = fileService.uploadFile(file);
		List<ImageWH> whs = FileServerUtils.loadCutSize(cutSize);
		try {
			File uploadFile = new File(fileProperties.getFileServerPath() + "/" + fileServerModel.getPath());
			uploadCutImages(whs, uploadFile);
			return fileServerModel;
		} catch (Exception e) {
			throw new FileServerException(e);
		}

	}

	private void uploadCutImages(List<ImageWH> whs, File sourceFile) {
		// 上传裁剪的图片
		try {
			for (ImageWH wh : whs) {
				String fileName = sourceFile.getName();
				String baseName = FilenameUtils.getBaseName(fileName);
				String ext = FilenameUtils.getExtension(fileName);
				String newFileName = baseName + "_" + wh.getW() + "x" + wh.getH() + "." + ext;
				File imgFile = new File(sourceFile.getParent() + "/" + newFileName);
				Thumbnails.of(sourceFile).size(wh.getW(), wh.getH()).toFile(imgFile);
			}
		} catch (Exception e) {
			throw new FileServerException(e);
		}
	}

	@Override
	public boolean cutImage(String filePath, String cutSize) {
		if (StringUtils.isEmpty(filePath)) {
			throw new FileServerException("filePath is null");
		}
		List<ImageWH> whs = FileServerUtils.loadCutSize(cutSize);
		String serverPath = fileProperties.getFileServerPath();
		File uploadFile = new File(serverPath + "/" + filePath);
		if (!uploadFile.exists()) {
			throw new FileServerException("file not exist");
		}
		uploadCutImages(whs, uploadFile);
		return true;
	}

}
