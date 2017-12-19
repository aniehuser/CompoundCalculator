package chem;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Prog {
	public static String projDir;
	public static Logger log;
	public static Scanner reader;
	public static final String empty = "DNE";
	public static final String splitCompound = "(?<=\\))|(?=[A-Z][a-z]?\\d*|\\)|\\()";
	public static Hashtable<String, Element> elements; 

	public static void main(String[] args) {
		setProjectVariables();
		getLogger();
		
		
		///////////////////////////////
		////////////TESTING////////////
		 String EXAMPLE_TEST = "(Aa)5)";//"(HaHHa1H1(O2)10Ha10H10)12H";

	    
	        System.out.println(EXAMPLE_TEST.matches(".*\\(\\).*|.*\\)$|.*\\)\\D.*"));
	        System.out.println(EXAMPLE_TEST.matches(".*\\)"));
	        String[] splitString = (EXAMPLE_TEST.split(".*\\(\\).*|.*\\)$|.*\\)\\D.*"));//[a-z]|(\\D{2}))
	        System.out.println(splitString.length);// should be 14
	        for (String string : splitString) {
	            System.out.println(string);
	        }
	        // replace all whitespace with tabs
	        System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
		 while(true){
	        StringContainer compound = new StringContainer();
	        if(InputHandler.getCompound(compound))
	        	System.out.println(new Compound(compound.get()));
		 }
		
		
		///////////////////////////////
		///////////////////////////////

	}
	
	private static void setProjectVariables(){
		projDir = System.getProperty("user.dir");
		reader = new Scanner(System.in);
		elements = FileLoader.LoadElements();
	}
	
	private static void getLogger(){
		log = Logger.getLogger("test");
		Logger rootLogger = Logger.getLogger("");
	    Handler[] handlers = rootLogger.getHandlers();
	    if (handlers[0] instanceof ConsoleHandler) {
	        rootLogger.removeHandler(handlers[0]);
	    }
	        
	    try { //Open the log file and add the simple text formatter
	    	FileHandler file = new FileHandler("debug.log");
	      	file.setFormatter(new SimpleFormatter());
			log.addHandler(file);
		} catch (IOException e) {
			log.severe("Log file error: " + e.toString());
			System.out.println("Couldn't get logger!");
		}         
	}

}
