package src;

import src.FileMgmt;

import java.net.URL;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.io.File;

public class passmgrGUI {

    static int iterationCount = 0;

    public static void main(String[] args) {
        boolean passFileExists = FileMgmt.fileCheck("passfile", FileMgmt.FILEPATH, FileMgmt.ENCRYPTEDFILEPATH);
        
        if (passFileExists == true) {
            /*
            File passfile = new File(FileMgmt.FILEPATH);
            try {
                passfile.delete();                          // UNCOMMENT IF DEBUGGING STARTUPFRAME
            } catch (Exception e) {}
            main(args);
            */
            if (iterationCount > 0) {  
                MainFrame mFrame = new MainFrame(true);
                setTaskbarIcon(FileMgmt.LOGOIMAGEPATH_MINIMAL);
            } else {
                MainFrame mFrame = new MainFrame(false);
                setTaskbarIcon(FileMgmt.LOGOIMAGEPATH_MINIMAL);
            }
        }
        else if (passFileExists == false) {
            StartupFrame sFrame = new StartupFrame();
            iterationCount += 1;

            setTaskbarIcon(FileMgmt.LOGOIMAGEPATH_MINIMAL); // works on Mac
            ImageIcon iconImage = new ImageIcon(FileMgmt.LOGOIMAGEPATH_MINIMAL);   //Old method of setting taskbar icon (only works on Windows)
            sFrame.setIconImage(iconImage.getImage());
        }
    }

    // Supplemental functions:
    public static void setTaskbarIcon(String imageFile) {
        // CREDITS: flohall on StackOverflow https://stackoverflow.com/a/56924202

        //loading an image from a file
        final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        final URL imageResource = passmgrGUI.class.getClassLoader().getResource(imageFile); // added custom .png
        final Image image = defaultToolkit.getImage(imageResource);

        //this is new since JDK 9
        final Taskbar taskbar = Taskbar.getTaskbar();

        try {
            //set icon for mac os (and other systems which do support this method)
            taskbar.setIconImage(image);
        } catch (final UnsupportedOperationException e) {
            System.out.println(System.getProperty("os.name") + " does not support 'taskbar.setIconImage'");
        } catch (final SecurityException e) {
            System.out.println("There was a security exception for: 'taskbar.setIconImage'");
        }

        //set icon for windows os (and other systems which do support this method)
        //mFrame.setIconImage(image); //Doesn't work, cannot make a static reference to setIconImage() because it is non-static
    }
}