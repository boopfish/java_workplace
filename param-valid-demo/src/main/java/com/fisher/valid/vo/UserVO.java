package com.fisher.valid.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author fisher
 * @Date 2021-02-22 16:06
 */
@Data
public class UserVO {
	@NotBlank(message = "用户名不能为空", groups = {Register.class, Login.class})
	String username;
	@NotBlank(message = "密码不能为空", groups = {Register.class, Login.class})
	String password;
	@NotNull(message = "性别不能为空", groups = {Register.class})
	@Range(min = 0, max = 1, message = "性别不合法",groups = {Register.class})
	Integer sex;
	@Range(min = 18, message = "年龄不能小于18", groups = Register.class)
	@NotNull(message = "年龄不能为空", groups = {Register.class})
	Integer age;

	public interface Register {}

	public interface Login {}

}
