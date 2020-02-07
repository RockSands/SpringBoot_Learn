package com.file.local.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.local.server.model.FileServerModel;
import com.file.local.server.service.ImgService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * chenkw
 */
@RestController
@RequestMapping("/img")
@Api(value = "图片文件服务接口")
public class ImgController {

	@Autowired
	private ImgService imgService;

	@ApiOperation(value = "上传图片", notes = "上传并裁剪图片")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public FileServerModel uploadImage(@ApiParam(value = "文件流,name=file") @RequestParam("file") MultipartFile file) {
		return imgService.uploadImage(file, null);
	}

	@ApiOperation(value = "上传并裁剪图片", notes = "上传并裁剪图片")
	@RequestMapping(value = "/uploadCutImg", method = RequestMethod.POST)
	public FileServerModel uploadImage(@ApiParam(value = "文件流,name=file") @RequestParam("file") MultipartFile file,
			@ApiParam(value = "裁剪尺寸（数组类型）如:20x20,30x30,100x100") @RequestParam("cutSize") String cutSize) {
		return imgService.uploadImage(file, cutSize);
	}

	@ApiOperation(value = "裁剪图片", notes = "裁剪图片")
	@RequestMapping(value = "/cut", method = RequestMethod.POST)
	public boolean cutImage(@ApiParam(value = "文件服务器存放路径") @RequestParam("filePath") String filePath,
			@ApiParam(value = "裁剪尺寸（数组类型）如:20x20,30x30,100x100") @RequestParam("cutSize") String cutSize) {
		return imgService.cutImage(filePath, cutSize);
	}

}
