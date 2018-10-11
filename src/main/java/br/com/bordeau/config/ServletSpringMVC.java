package br.com.bordeau.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
//		return new Class [] {JPAConfiguration.class,AppWebConfiguration.class};
		return new Class [] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
//		return new Class [] {};
		return new Class [] {AppWebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String [] {"/"};
	}
	
//	@Override
//	protected Filter[] getServletFilters() {
//		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//		encodingFilter.setEncoding("UTF-8");
//		return new Filter[] {encodingFilter, new OpenEntityManagerInViewFilter()};
//	}

}
