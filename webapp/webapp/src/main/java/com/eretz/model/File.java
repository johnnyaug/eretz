package com.eretz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "FILE_REPOSITORY")
public class File {
	private Long fileId;
	private String relativePath;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long id) {
		this.fileId = id;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String path) {
		this.relativePath = path;
	}
}
