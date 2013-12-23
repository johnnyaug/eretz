package com.eretz.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.eretz.dao.FilePathDao;
import com.eretz.util.PropertiesUtil;

public class FilePathServiceImpl implements FilePathService {
	@Autowired
	private FilePathDao filePathDao;

	@Override
	public InputStream getStream(Long fileId) throws FileNotFoundException {
		return new FileInputStream(PropertiesUtil.getProperty("fileRepositoryBaseDir") + filePathDao.getRelativePath(fileId));
	}
}
