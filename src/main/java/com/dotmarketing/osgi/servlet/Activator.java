package com.dotmarketing.osgi.servlet;



import org.osgi.framework.BundleContext;
import com.dotmarketing.osgi.GenericBundleActivator;

public class Activator extends GenericBundleActivator {


  final static String FILTER_NAME = "helloWorldFilter";
  final static String SERVLET_NAME = "helloWorldServlet";

  @SuppressWarnings("unchecked")
  public void start(BundleContext bundleContext) throws Exception {


    new TomcatServletFilterUtil().addServlet(SERVLET_NAME, new HelloWorldServlet(), "/helloWorld");

    new TomcatServletFilterUtil().addFilter(FILTER_NAME, new HelloWorldFilter(), FilterOrder.FIRST, "*", "/helloWorld");


  }



  public void stop(BundleContext context) {
    new TomcatServletFilterUtil().removeServlet(SERVLET_NAME);
    new TomcatServletFilterUtil().removeFilter(FILTER_NAME);

  }


}


