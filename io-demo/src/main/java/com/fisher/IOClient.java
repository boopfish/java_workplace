package com.fisher;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @Description BIO客户端
 * @Author fisher
 * @Date 2021-02-21 14:11
 */

public class IOClient {
	public static void main(String[] args) throws IOException {

		Socket socket = null;
		try {
			socket = new Socket("localhost", 9999);
			socket.getOutputStream().write((new Date() + ":" + "hello world").getBytes());
			InputStream inputStream = socket.getInputStream();

				int length = -1;
				byte[] data = new byte[1024];
				while ((length = inputStream.read(data)) != -1) {
					System.out.println(new java.lang.String(data, 0, length));
				}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socket.close();

		}
	}
}
