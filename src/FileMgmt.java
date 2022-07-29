package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FileMgmt {
    // File management functions and global constants

    final static double VERSION = 0.01; // global version variable
    final static String FILEPATH = "passfile.txt"; // variable to be edited according to what the user wants the password database file to be 
    final static String ENCRYPTEDFILEPATH = "ENCRYTPEDpassfile.txt";
    final static String CREDENTIALS = ""; // credentials variable that will be used later by newCredentialsEntry()
    final static String USERNAME = ""; // username variable that will be used by newUsernameEntry()
    final static String PASSWORD = ""; // password variable that will be used by newPasswordEntry()
    final static String KEYSETFILENAME = "aead-keyset.json"; // variable will be used by aeadCrypto()
    final static String SETTINGSFILENAME = "settings.json"; // variable will be used by settings()
    final static String LOGOIMAGEPATH_FULL = "src/images/256_icon_rounded.png"; // file path for full icon/logo image
    final static String LOGOIMAGEPATH_FULL_48PX = "src/images/256_icon_rounded_48px.png";
    final static String LOGOIMAGEPATH_MINIMAL = "src/images/256_icon_rounded_minimal.png"; // file path for minimal icon/logo image
    final static String ICON_FILECHECKMARK = "src/images/filecheckmark.png";

    /**
     * Checks for the file specified. If the file type is "passfile", the user must input the file path for the passfile and encrypted passfile.
     * @param filetype - The type of file to be checked. "passfile" checks for both passfile and encpassfile, therefore the encfilepath must be provided as well.
     * @param filepath - The path to the file to be checked. Passfile or settingsfile.
     * @param encfilepath - The path to the encrypted passfile. If checking for settingsfile, leave blank.
     * @return {@code true} if file exists , {@code false} if file doesn't exist
     * @author Ahmed Osman
     */
    public static boolean fileCheck(String filetype, String filepath, String encfilepath) { // function to check if passfile exists

        if (filetype == "passfile") { // Checks if PASSFILE or ENCRYPTEDPASSFILE exists, returns true if one of the two exist.
            File passfile = new File(filepath);
            File encryptedpassfile = new File(encfilepath);

            if (passfile.exists() || encryptedpassfile.exists()) { // read file name and set variable "filename" to it
                return(true);
            }
            else if (passfile.exists() == false || encryptedpassfile.exists() == false) {
                return(false);
            }
            else {
                return(false);
            }
        }
        else if (filetype == "encryptedpassfile") { // Checks if only ENCRYTPEDPASSFILE exists, returns true if it does.
            File encryptedpassfile = new File(encfilepath);

            if (encryptedpassfile.exists()) {
                return(true);
            }
            else if (encryptedpassfile.exists() == false) {
                return(false);
            }
            else {
                return(false);
            }
        }
        else if (filetype == "settingsfile") { // checks if settings file exists, returns true if it does
            File settingsfile = new File(filepath);

            if (settingsfile.exists()) {
                return(true);
            }
            else if (settingsfile.exists() == false) {
                return(false);
            }
            else {
                return(false);
            }
        }
        else {
            return(false);
        }
    }
    
    /**
     * Creates a password/settings file in the specified filepath.
     * @param filetype - The type of file to create, "passfile" or "settingsfile"
     * @param filepath - The path of the file to read from, e.g. "myFile.txt"
     * @return {@code true} if file was successfully created, {@code false} if the file was not created.
     * @author Ahmed Osman
     */
    public static boolean createFile(String filetype, String filepath) { // function to create files (passfile, settingsfile)
        if (filetype == "passfile") { // create passfile
            File passfile = new File(filepath);

            try {
                if (passfile.createNewFile()) { // checks if passfile can be created, result would be true if it can
                    FileWriter fileWrite = new FileWriter(filepath);
                    //fileWrite.write("Password Manager v" + g_version + " by Ahmed Osman\n" + "Usernames/Passwords:\n");
                    fileWrite.close();

                    System.out.println("Password database file successfully created! " + "(\"" + filepath + "\")");
                    
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return(passfile.createNewFile());
                }
                else {
                    System.out.println("File already exists or cannot be created."); // redundant since there is a function dedicated to this check anyway
                    return(false);
                }
            }
            catch (IOException e) { // catches any exceptions if something goes wrong with this part of the program
                System.out.println("Something went wrong, please restart the program. (An error occured. Error Code: 1FC)\n");
                e.printStackTrace();
            }
        }
        else if (filetype == "settingsfile") { // create settingsfile
            File settingsfile = new File(filepath);

            try {
                if (settingsfile.createNewFile()) { // checks if settingsfile can be created, result would be true if it can
                    FileWriter fileWrite = new FileWriter(filepath);
                    //fileWrite.write("Password Manager v" + g_version + " by Ahmed Osman\n" + "Usernames/Passwords:\n");
                    //fileWrite.close();

                    System.out.println("Settings database file successfully created! " + "(\"" + filepath + "\")" + "\n");
                    
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return(settingsfile.createNewFile());
                }
                else {
                    System.out.println("File already exists."); // redundant since there is a function dedicated to this check anyway
                    return(false);
                }
            }
            catch (IOException e) { // catches any exceptions if something goes wrong with this part of the program
                System.out.println("Something went wrong, please restart the program. (An error occured. Error Code: 2FC)\n");
                e.printStackTrace();
            }
        }
        return(false);
    }
    /*public static void writeToFile(String[] args) { // function to append credentials to passfile
        try {
            FileWriter fileWrite = new FileWriter(filename, true);

            fileWrite.write("\n" + credentials);
            fileWrite.close();

            clearScreen();
            System.out.println("\nPassword Manager: New Credentials Entry\n");
            System.out.println("Username/Password Combo: \n" + credentials);
            System.out.println("\nSuccessfully saved credentials in " + filename + "!");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            System.out.println("Something went wrong, please restart the program. (An error occured.)\n");
            e.printStackTrace();
        }
    }*/
    
    /**
     * Reads from specified file.
     * @param filepath - The file to read from, e.g. "myFile.txt"
     * @author Ahmed Osman
     */
    public static void readFromFile(String filepath) { // function to read from passfile and output contents
        File specifiedFile = new File(filepath);

        try {
            Scanner fileReader = new Scanner(specifiedFile);
            System.out.println("\nPassword Manager: View Credentials\n\n");

            while (fileReader.hasNextLine()) {
                String output = fileReader.nextLine();
                System.out.println(output);
            }
            
            System.out.println("\n");
            fileReader.close();
            //pressEnterToContinue();
        }
        catch (FileNotFoundException e) {
            System.out.println("Something went wrong, please restart the program. (An error occured.)\n");
            e.printStackTrace();
        }
    }

    /**
     * Sleeps for {@code int x} seconds.
     * @param unit - The unit of time measure. (m,s,ms)
     * @param time - The amount of time to sleep for.
     * @author Ahmed Osman
     */
    public static void timeSleep(String unit, int time) {
        if (unit == "m") { // Minutes
            try {
                TimeUnit.MINUTES.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (unit == "s") { // Seconds
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (unit == "ms") { // Miliseconds
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}