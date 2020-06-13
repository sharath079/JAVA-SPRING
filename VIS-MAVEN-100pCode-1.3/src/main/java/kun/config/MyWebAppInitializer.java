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
		
		// create listener and register "parent conatiner"
		listener=new ContextLoaderListener(parentCtx);
		// register listener with Servlet Context
		sc.addListener(listener);
		
		// child container
		
		childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(DispatcherServletAppConfig.class);
		
		// create dispatcher servlet obj
		ds=new DispatcherServlet(childCtx);
		
		//register dispatcher servlet
		//Register ServletRegistartion.Dynamic with ServletContext
		
		dynamic=sc.addServlet("dynamic", ds);
		dynamic.setLoadOnStartup(2);
		dynamic.addMapping("*.htm");

	}

}
