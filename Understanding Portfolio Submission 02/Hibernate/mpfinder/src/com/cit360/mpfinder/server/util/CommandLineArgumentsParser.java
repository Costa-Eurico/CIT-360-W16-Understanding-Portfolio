package com.cit360.mpfinder.server.util;

/**
 *
 * @author eucosta
 */
public class CommandLineArgumentsParser {

    public boolean Verbose = false;
    public int portNumber = 0;

    //TODO: Complete this class to parse input parameters

    public CommandLineArgumentsParser(){}

    public boolean parseCommandLineArguments(String[] args){
        int i = 0;
        String arg;
        boolean _bSuccess = false;

        while (i < args.length && args[i].startsWith("-")) {
            arg = args[i++];

            // use this type of check for "wordy" arguments
            if (arg.equals("-verbose")) {
                Verbose = true;
            }

            // use this type of check for arguments that require arguments
            else if (arg.equals("-p")) {
                if (i < args.length) {
                    portNumber = Integer.parseInt(args[i++]);
                }
                else {
                    System.err.println("-p requires the port number the server will be listening to.");
                }
            }
        }
        if (i != args.length) {
            System.err.println("Usage: MissingPersonFinderServer [-verbose] -p a port number the server will be listening to");
        }
        else {
            _bSuccess = true;
        }

        return _bSuccess;
    }
}
