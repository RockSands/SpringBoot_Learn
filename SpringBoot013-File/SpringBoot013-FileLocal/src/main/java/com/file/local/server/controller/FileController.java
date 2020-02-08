package com.file.local.server.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
		OutputStream outputStream = null;
		try {
			String encodedFileName = URLEncoder.encode(file.getName(), "utf-8").replaceAll("\\+", "%20");
			response.setHeader("Content-Disposition", "attachment;filename=" + encodedFileName);
			outputStream = response.getOutputStream();
			IOUtils.copy(new FileInputStream(file), outputStream);
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileServerException("文件下载失败!");
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	@ApiOperation(value = "展现", notes = "展现文件", produces = "application/octet-stream")
	@GetMapping("/show")
	public void show(HttpServletResponse response, @RequestParam("filePath") String filePath) {
		File file = fileService.download(filePath);
		if (file == null) {
			throw new FileServerException("文件不存在!");
		}
		OutputStream outputStream = null;
		try {
			String encodedFileName = URLEncoder.encode(file.getName(), "utf-8").replaceAll("\\+", "%20");
			response.setHeader("Content-Disposition", "filename=" + encodedFileName);
			outputStream = response.getOutputStream();
			IOUtils.copy(new FileInputStream(file), outputStream);
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileServerException("文件下载失败!");
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
				}
			}
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
