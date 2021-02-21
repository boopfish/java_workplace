package com.fisher;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Description BIO 服务端
 * @Author fisher
 * @Date 2021-02-21 14:15
 */

public class IOServer {
	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(9999);
			//
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("等待客户端连接");
			while (true) {
				Socket accept = null;
				try {
					accept = serverSocket.accept();
					System.out.println(accept.getInetAddress() + ":客户端连接成功");
					System.out.println(Thread.currentThread().getName());
					Socket finalAccept = accept;

						System.out.println(Thread.currentThread().getName());
						InputStream inputStream = null;
						try {
							inputStream = accept.getInputStream();
							int length = -1;
							byte[] data = new byte[1024];
							while ((length = inputStream.read(data)) != -1) {
								System.out.println(new java.lang.String(data, 0, length));
							}
							accept.getOutputStream().write((new Date() + ":" + "hello world").getBytes());
						} catch (IOException e) {
							e.printStackTrace();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}


			}
		}).start();

	}
}
