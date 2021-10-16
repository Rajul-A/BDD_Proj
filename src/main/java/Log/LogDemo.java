package Log;
import org.apache.log4j.LogManager;

import java.io.IOException;

import org.apache.log4j.*;  
  
  
public class LogDemo{  
  
   /* Get the class name to be printed on */  
   private static Logger logger = LogManager.getLogger(LogDemo.class.getName());  
     
   public static void main(String[] args)throws IOException{  
	  logger.debug("Hello this is a debug message");  
	  logger.info("Hello this is an info message");  
 
      logger.error("This is an error");
      logger.fatal("Thhis is a fatal");
      System.out.println("Done");
   } 
} 