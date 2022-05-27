package com.dotmarketing.osgi.servlet;



import org.osgi.framework.BundleContext;
import com.dotmarketing.osgi.GenericBundleActivator;

public class Activator extends GenericBundleActivator {


  final static String FILTER_NAME = "helloWorldFilter";
  final static String SERVLET_NAME = "helloWorldServlet";

  @SuppressWarnings("unchecked")
  public void start(BundleContext bundleContext) throws Exception {


    new TomcatServletFilterUtil().addServlet(SERVLET_NAME, new HelloWorldServlet(), "/helloWorld");

    //Restarting the filter chain can cause issues with existing filters
    //new TomcatServletFilterUtil().addFilter(FILTER_NAME, new HelloWorldFilter(), FilterOrder.FIRST, "*", "/helloWorld");


  }



  public void stop(BundleContext context) {
    new TomcatServletFilterUtil().removeServlet(SERVLET_NAME);
    
    //Restarting the filter chain can cause issues with existing filters
    //new TomcatServletFilterUtil().removeFilter(FILTER_NAME);

  }


}


