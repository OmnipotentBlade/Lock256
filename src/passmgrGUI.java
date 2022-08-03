package src;

public class passmgrGUI {

    static StartupFrame sFrame;
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
                FileMgmt.setTaskbarIcon(mFrame, FileMgmt.LOGOIMAGEPATH_MINIMAL);
            } else {
                MainFrame mFrame = new MainFrame(false);
                FileMgmt.setTaskbarIcon(mFrame, FileMgmt.LOGOIMAGEPATH_MINIMAL);
            }
        }
        else if (passFileExists == false) {
            sFrame = new StartupFrame();
            iterationCount += 1;

            FileMgmt.setTaskbarIcon(sFrame, FileMgmt.LOGOIMAGEPATH_MINIMAL); // works on Mac + Windows
        }
    }
}