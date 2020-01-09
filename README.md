## com.dotcms.servlet.filter.tomcat

This is an OSGI plugin that can dynaicamlly load and unload servlets and filters from a dotCMS TOMCAT installation.  Filters can be mapped to the ROOT, e.g. `/*` and be run first or last in the filter chain.

This is not warrented and has not been tested under load or in any production environment and there could be issues with classloaders, memory leaks etc.  I wanted to share this as someone might find it useful.
