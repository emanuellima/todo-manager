package pt.ulht.es.todomanager.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import pt.ist.fenixframework.FenixFramework;

public class Bootstrap implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		FenixFramework.initialize(PropertiesManager.getFenixFrameworkConfig());
	}

}