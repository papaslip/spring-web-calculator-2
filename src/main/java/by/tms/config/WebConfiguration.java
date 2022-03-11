package by.tms.config;

import by.tms.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("by.tms")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private TestInterceptor testInterceptor;

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".jsp");
		viewResolver.setPrefix("/pages/");
		return viewResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor)
				.addPathPatterns("/calc/**");
//				.excludePathPatterns("/user/reg");
	}
}
