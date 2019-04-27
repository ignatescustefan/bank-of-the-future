package com.logging;

import org.apache.log4j.Logger;

public class Log4J{

   /* Get actual class name to be printed on */
   static Logger log = Logger.getLogger(Log4J.class.getName());
   
   public static Logger getLogger() {
	   return log;
   }
}
