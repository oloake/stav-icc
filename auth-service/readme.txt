All configuration is placed in this "conf" folder and is referenced in the app by 
the "conf.dir" system property which needs to be set. The reason
is that I like keeping the configuration separate from the application. Unfortunately the log4j configuration 
needs to be packaged with the app if we want to use any special appenders or logging patterns. 
See:
http://www.mulesoft.org/documentation/display/MULE3USER/Logging+With+Mule+ESB+3.x

The following line needs to be added to "$MULE_HOME/conf/wrapper.conf":
wrapper.java.additional.4=-Dconf.dir=%MULE_HOME%/conf

When running from an IDE it can be set like this:
-Dconf.dir=conf 

And then we also need to point to the Mule installation so that the log file can be written
to the correct place according to the log4j configuration:
-Dmule.home=$MULE_HOME

The app also needs a "keystore.jks" and "truststore.jks" installed in "$MULE_HOME/conf". 

All configuration modifications to the Mule installation are in ../mule-esb. 