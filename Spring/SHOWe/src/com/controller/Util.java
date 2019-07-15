package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void saveFile(MultipartFile mf) {
		byte [] data;
		String imgname = mf.getOriginalFilename();
		String dir="C:\\Users\\student\\KH\\TIL\\Spring\\smvc3\\web\\img\\";
		try {
			data = mf.getBytes();
			FileOutputStream fout = new FileOutputStream(dir+imgname);
			fout.write(data);
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
