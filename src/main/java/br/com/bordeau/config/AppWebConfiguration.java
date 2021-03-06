package br.com.bordeau.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.bordeau.DAOS.AuthenticationDAO;
import br.com.bordeau.DAOS.EpisodioDAO;
import br.com.bordeau.DAOS.IndexDAO;
import br.com.bordeau.DAOS.PodcastDAO;
import br.com.bordeau.DAOS.RoleDAO;
import br.com.bordeau.DAOS.UsuarioDAO;
import br.com.bordeau.controllers.IndexController;
import br.com.bordeau.infra.FileSaver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = { IndexController.class, FileSaver.class, EpisodioDAO.class, IndexDAO.class,
		PodcastDAO.class, AuthenticationDAO.class, UsuarioDAO.class, RoleDAO.class })
public class AppWebConfiguration implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		return messageSource;
	}

	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar register = new DateFormatterRegistrar();
		register.setFormatter(new DateFormatter("dd/MM/yyyy"));
		register.registerFormatters(conversionService);
		return conversionService;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

}
