package com.fisher.springbootdemo.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 读取application.yml里面的配置然后加载到容器里面，使用的时候直接注入这个类就可以直接使用了
 * @Author fisher
 * @Date 2021-02-24 15:35
 */
@Component
@ConfigurationProperties(prefix = "library")
@Data
public class ReadConfigProperties {
	String location;
	List<Books> books;

	@Data
	static class Books {
		String name;
		String description;
	}
}
