package com.sgtesting.logfile;

import org.apache.log4j.Logger;

public class LogFileDemo 
{
		public static Logger log=Logger.getLogger("Loop Output");
		
		public static void main(String[] args) 
		{
			log.info("For Loop output starts here ...");
			for(int i=20;i<=40;i++)
			{
				if(i%2==0)
				{
					log.info("The Even Number :"+i);
				}
			}
			log.info("For Loop output ends here ...");
		}

}
