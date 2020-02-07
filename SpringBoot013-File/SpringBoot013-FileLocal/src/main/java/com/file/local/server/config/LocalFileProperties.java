package com.file.local.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * chenkw
 */
@Component
@PropertySource("classpath:/config/local_file.properties")
public class LocalFileProperties {
	
    @Value("${file.config.server.path}")
    private String fileServerPath;

    @Value("${file.config.download.url}")
    private String fileDownloadUrl;

    @Value("${file.config.default.cutSize}")
    private String fileDefaultCutSize;

    @Value("${file.config.validate.type}")
    private String fileValidateType;

	public String getFileServerPath() {
		return fileServerPath;
	}

	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}

	public String getFileDownloadUrl() {
		return fileDownloadUrl;
	}

	public void setFileDownloadUrl(String fileDownloadUrl) {
		this.fileDownloadUrl = fileDownloadUrl;
	}

	public String getFileDefaultCutSize() {
		return fileDefaultCutSize;
	}

	public void setFileDefaultCutSize(String fileDefaultCutSize) {
		this.fileDefaultCutSize = fileDefaultCutSize;
	}

	public String getFileValidateType() {
		return fileValidateType;
	}

	public void setFileValidateType(String fileValidateType) {
		this.fileValidateType = fileValidateType;
	}

}
