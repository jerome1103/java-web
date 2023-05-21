package tw.jerome.infra.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BaseListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("web應用啟動...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("web應用銷毀...");	
	}
	
}
