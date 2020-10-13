//import java.io.*;
//import java.util.ArrayList;
//
//public class TestAdministrator {
//    private static final Option help = new Option("h", "help", "List a summary of all options and their arguments.");
//    private static final Option verbose = new Option("v", "verbose", "Enable verbose output.");
//    private static final Option banner =  new Option("b" , "banner", "Print the application's banner.");
//
//    public static void main(String args[]) throws IOException {
//        // Creating the banner...
//        IBanner testBanner = new Banner("Test Admin","1.2","2003-2020","Michel de Champlain");
//
//        // Creating the option table and adding all the valid options...
//        IOptionTable optionTable = new OptionTable();
//        optionTable.add(help);
//        optionTable.add(verbose);
//        optionTable.add(banner);
//
//        // Creating the administrator...
//        IAdministrator admin = new Administrator(args,"TestAdministrator [ -h | -b | -v ]", optionTable);
//
//        // Parsing options and arguments...
//        admin.administer();
//
//        IOptionTable options = admin.getOptions();
//
//        // Checking valid options have been enabled...
//        if (options.get("help").isEnabled()) {
//            admin.usage();
//        } else if (options.get("banner").isEnabled()) {
//            System.out.println(testBanner);
//        }
//
//        // Executing... and print five stars (*****) if the verbose option is enabled.
//        ArrayList<String>  arguments = admin.getArguments();
//        for (String argName : arguments) {
//            doSomethingOn(argName);
//            if (options.get("verbose").isEnabled()) {
//                System.out.println("*****");
//            }
//        }
//    }
//    public static void doSomethingOn(String filename) {
//        System.out.println("Do an action on this file '" + filename + "'...");
//    }
//}