package com.fisher;

import com.alibaba.fastjson.JSONObject;
import com.fisher.service.MessageService;
import okhttp3.*;
import okhttp3.Request.Builder;

import java.io.IOException;


/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws IOException {
		OkHttpClient okHttpClient = new OkHttpClient();
		System.out.println(MediaType.get("application/json;charset=utf-8"));
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("autoDoorIp", "test");
		jsonObject.put("autoDoorSn", 123);
		jsonObject.put("classroomId", "test");
		jsonObject.put("controlPanelIp", "test");
		jsonObject.put("mac", "test");

		RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jsonObject.toJSONString());

		Request request = new Request.Builder()
				.url("http://192.168.0.39:7005/cp/toServer/autoRegister")
				.post(body)
				.build();
		Call call = okHttpClient.newCall(request);
		Response re = call.execute();

	}
}
