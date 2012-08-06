All configuration is placed in this "conf" folder and is referenced in the app by 
the "conf.dir" system property which needs to be set. Also log4j configuration is placed here. The reason
is that I like keeping the configuration separate from the application.

The following line needs to be added to "$MULE_HOME/conf/wrapper.conf":
wrapper.java.additional.4=-Dconf.dir=%MULE_HOME%/conf

When running from an IDE it can be set like this:
-Dconf.dir=conf 

And then we also need to point to the log4j configuration:
-Dlog4j.configuration=file:conf/log4j.properties

The app also needs a "keystore.jks" and "truststore.jks" installed in "$MULE_HOME/conf". 

All configuration modifications to the Mule installation are in ../mule-esb. 