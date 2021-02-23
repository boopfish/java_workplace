package com.fisher.valid.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @Description 对controller的单个参数进行校验时的配置
 * @Author fisher
 * @Date 2021-02-22 17:24
 */
@Configuration
public class ValidConfig {

	/**
	 *
	 * @return
	 */
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();/**设置validator模式为快速失败返回*/
		postProcessor.setValidator(validator());
		return postProcessor;
	}

	/**
	 * 该配置设置验证失败快速返回 有一处校验失败就立马返回，只会显示一处错误
	 * @return
	 */
	@Bean
	public Validator validator() {
		ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
				.configure()
				.addProperty("hibernate.validator.fail_fast", "true")
				.buildValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		return validator;
	}
}
