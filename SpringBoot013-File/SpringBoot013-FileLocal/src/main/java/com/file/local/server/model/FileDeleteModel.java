package com.file.local.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 */
@ApiModel(value = "文件删除请求")
public class FileDeleteModel {

    @ApiModelProperty(value = "删除标示,0:本文件,1:整个文件目录")
    private int flag;

    @ApiModelProperty(value = "文件服务器存放路径")
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
