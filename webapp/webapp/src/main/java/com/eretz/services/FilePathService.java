package com.eretz.services;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface FilePathService {
	public InputStream getStream(Long fileId) throws FileNotFoundException;
}
