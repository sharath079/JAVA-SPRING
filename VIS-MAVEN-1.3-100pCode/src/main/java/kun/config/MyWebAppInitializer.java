package kun.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		
		AnnotationConfigWebApplicationContext parentCtx=null;
		AnnotationConfigWebApplicationContext childCtx=null;
		ContextLoaderListener listener=null;
		
		DispatcherServlet ds=null;
		ServletRegistration.Dynamic dynamic=null;
		
		//parent container
		parentCtx=new AnnotationConfigWebApplicationContext();
		parentCtx.register(AppConfig.class);
		
		//create listener
		
		listener= new ContextLoaderListener(parentCtx);
		//Register Servlet Listener with Servlet Container
		sc.addListener(listener);
		
		//child Container
		
		childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(DispatcherServletAppConfig.class);
		
		//create dispatcher Servlet obj
		
		ds=new DispatcherServlet(childCtx);
		
		//Register dispatcher Servlet
		//Register ServletRegistration.Dynamic with ServletContext
		dynamic=sc.addServlet("dynamic",ds);
		dynamic.setLoadOnStartup(2);
		dynamic.addMapping("*.htm");
		
	}

}
