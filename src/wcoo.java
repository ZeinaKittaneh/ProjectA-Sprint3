// wc.java - Count characters, lines, and words

import java.io.*;
import java.util.*;

public class wcoo {
	public static final String USAGE = "The wc program is used to count charcters, words and lines in source file"
			+ "\nUsage: wc <option> <src file> {src file}";
	public static final Banner BANNER = new Banner("wc", "1.5", "2020-2021", "Zeina Kittaneh");

	public static void main(String args[]) throws IOException {
		
		//Take an object of class Administrator and pass command line arguments, usages, banners of counters to  it
		Administrator admin = new Administrator(args, USAGE, BANNER); 
		
		if(admin.parseOptionsArgs(args)) { //If arguments are valid
			if(admin.help.isEnaled())
				System.out.println(USAGE);
			else if(admin.banner.isEnaled())
				System.out.println(BANNER);
			else if(Option.verboseEnabled && admin.getFilesList().length == 0) { //if user didn't specify an option or a file
				System.out.println("Please specify a source file!");
				return;
			}
			CounterFactory cf = new CounterFactory(); //Create the counter using counter factory
			if(admin.getFilesList().length != 0) { //If user has entered at least one file name, continue
					new WCcomposite().countingAll(admin.getFilesList(), cf); //Call the composed class for WC counter 
	
			}
		}
	}
}
