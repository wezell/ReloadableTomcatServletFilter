
README
------

This bundle plugin is an example of how to use services provide by other bundles and
 how to register servlets and filters.

How to build this example
-------------------------

Note: As you can see, this plugin depends on com.dotcms.service example.
It will use com.dotmarketing.osgi.service.HelloWorld.

In order to compile this plugin without error you need to run first under com.dotcms.service example:
./gradlew jar

As you can see the build.gradle will use the jar compiled under that example.

Then to compile this plugin all you need to do is to do:
./gradlew jar
This will build a jar in the build/libs directory

1. To install this bundle:

Copy the bundle jar file inside the Felix OSGI container (dotCMS/felix/load).
        OR
Upload the bundle jar file using the dotCMS UI (CMS Admin->Dynamic Plugins->Upload Plugin).

2. To uninstall this bundle:

Remove the bundle jar file from the Felix OSGI container (dotCMS/felix/load).
        OR
Undeploy the bundle using the dotCMS UI (CMS Admin->Dynamic Plugins->Undeploy).

How to create a bundle plugin using services and registering servlets and filters
-------------------------------------------

--
In order to create this OSGI plugin, you must create a META-INF/MANIFEST to be inserted into OSGI jar.
This file is being created for you by Gradle. If you need you can alter our config for this but in general our out of the box config should work.
The Gradle plugin uses BND to generate the Manifest. The main reason you need to alter the config is when you need to exclude a package you are including on your Bundle-ClassPath

If you are building the MANIFEST on your own or desire more info on it below is a description of what is required
in this MANIFEST you must specify (see template plugin):

Bundle-Name: The name of your bundle

Bundle-SymbolicName: A short an unique name for the bundle

Bundle-Activator: Package and name of your Activator class (example: com.dotmarketing.osgi.servlet.Activator)

DynamicImport-Package: *
    Dynamically add required imports the plugin may need without add them explicitly

Import-Package: This is a comma separated list of package's name.
                In this list there must be the packages that you are using inside
                the bundle plugin and that are exported by the dotCMS runtime.

Beware!!!
---------

In order to work inside the Apache Felix OSGI runtime, the import
and export directive must be bidirectional.

The DotCMS must declare the set of packages that will be available to
the OSGI plugins by changing the file: dotCMS/WEB-INF/felix/osgi-extra.conf.
This is possible also using the dotCMS UI (CMS Admin->Dynamic Plugins->Exported Packages).

Only after that exported packages are defined in this list,
a plugin can Import the packages to use them inside the OSGI blundle.

--
--
--
com.dotmarketing.osgi.servlet.HelloWorldServlet
-----------------------------------------------

Simple and standard implementation of a HttpServlet that will use
the HelloWorld service provide by the com.dotcms.service bundle plugin (Please refer to INSTALL.txt (!)).

--
com.dotmarketing.osgi.servlet.TestFilter
----------------------------------------

Simple and standard implementation of a Filter

--
Activator
---------

This bundle activator extends from com.dotmarketing.osgi.GenericBundleActivator and implements BundleActivator.start().
Gets a reference for the HelloWorldService via HelloWorld interface (com.dotcms.service bundle plugin - Please refer to INSTALL.txt (!)) and register
our HelloWorldServlet servlet and the TestFilter filter.

--
--
--
Testing
-------

The HelloWorldServlet is registered under the url pattern "/helloworld" can be test it running and assuming your dotcms url is localhost:8080:
    http://localhost:8080/app/helloworld

The TestFilter filter is registered for the url pattern "/helloworld/.*" can be test it running and assuming your dotcms url is localhost:8080:
    http://localhost:8080/app/helloworld/
    http://localhost:8080/app/helloworld/testing.dot
