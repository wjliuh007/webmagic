package cn.wj.magic;

import java.io.File;
import java.io.IOException;

public class OcrTest {

	public static void main(String[] args) {
		String path = "F:\\\\18001380051.png";
		System.out.println("ORC Test Begin......");
		try {
			String valCode = new OCR().recognizeText(new File(path), "png");
			System.out.println(valCode);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ORC Test End......");
	}

}
