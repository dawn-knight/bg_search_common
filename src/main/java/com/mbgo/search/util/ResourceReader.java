package com.mbgo.search.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceReader {
	private String _filePath;
	private String _charSet;
	private InputStream _inputStream = null;
	private InputStreamReader _inputStreamReader = null;
	private BufferedReader _bufferedReader = null;
	private String current = null;
	
	private File _file = null;
	
	public ResourceReader(String file) {
		_filePath = file;
		_charSet = "utf-8";
	}
	
	public ResourceReader(String file, String cs) {
		_filePath = file;
		_charSet = cs;
	}

	public ResourceReader(File file, String cs) {
		_file = file;
		_charSet = cs;
	}
	public ResourceReader(File file) {
		_file = file;
		_charSet = "utf-8";
	}
	
	public void load() throws NullPathException, IOException {
		close();
		if(_file == null) {
			_inputStream = new FileInputStream(new File(_filePath));
		} else {
			_inputStream = new FileInputStream(_file);
		}
		_inputStreamReader = new InputStreamReader(_inputStream, _charSet);
		_bufferedReader = new BufferedReader(_inputStreamReader, 512);
	}
	
	public String readLine() throws IOException {
		return current == null ? _bufferedReader.readLine() : current;
	}
	
	public void close() throws IOException {
		if(_inputStream != null) {
			_inputStream.close();
		}
		if(_inputStreamReader != null) {
			_inputStreamReader.close();
		}
		if(_bufferedReader != null) {
			_bufferedReader.close();
		}
	}

	public boolean isEnd() throws IOException {
		current = _bufferedReader.readLine();
		if(current == null) {
			return true;
		}
		return false;
	}
}
