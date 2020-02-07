package com.file.local.server.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.local.server.exception.FileServerException;
import com.file.local.server.model.FileServerModel;
import com.file.local.server.service.FileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/file")
@Api(value = "文件服务接口")
public class FileController {
	@Autowired
	private FileService fileService;

	@ApiOperation(value = "下载", notes = "下载文件", produces = "application/octet-stream")
	@GetMapping("/download")
	public void file(HttpServletResponse response, @RequestParam("filePath") String filePath) {
		File file = fileService.download(filePath);
		if (file == null) {
			throw new FileServerException("文件不存在!");
		}
		try {
			// response.setContentType("application/octet-stream");
			String encodedFileName =  URLEncoder.encode(file.getName(),"utf-8").replaceAll("\\+", "%20");;
			response.setHeader("Content-Disposition", "attachment;filename=" + encodedFileName);
			if (file.getName().endsWith(".xlsx")) {
				response.setContentType(
						"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
			} else if (file.getName().endsWith(".doc")) {
				response.setContentType("application/msword;charset=utf-8");
			} else if (file.getName().endsWith(".ppt")) {
				response.setContentType("application/vnd.ms-powerpoint;charset=utf-8");
			} else if (file.getName().endsWith(".docx")) {
				response.setContentType(
						"application/vnd.openxmlformats-officedocument.wordprocessingml.document;charset=utf-8");
			} else if (file.getName().endsWith(".pptx")) {
				response.setContentType(
						"application/vnd.openxmlformats-officedocument.presentationml.presentation;charset=utf-8");
			} else if (file.getName().endsWith(".xls")) {
				response.setContentType("application/vnd.ms-excel;charset=utf-8");
			}
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			OutputStream outputStream = response.getOutputStream();
			response.setContentLength((int) file.length());
			FileCopyUtils.copy(new FileInputStream(file), outputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileServerException("文件下载失败!");
		}
	}

	@ApiOperation(value = "删除文件", notes = "删除文件")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public boolean removeFile(@ApiParam(value = "文件服务器存放路径") @RequestParam("filePath") String filePath,
			@ApiParam(value = "删除标示,0:本文件,1:整个文件目录") @RequestParam("flag") int flag) {
		return fileService.removeFile(filePath, flag);
	}

	@ApiOperation(value = "上传文件", notes = "上传文件")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public FileServerModel uploadFile(@ApiParam(value = "文件流,name=file") @RequestParam("file") MultipartFile file) {
		return fileService.uploadFile(file);
	}
}
