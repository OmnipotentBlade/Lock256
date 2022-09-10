import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBCSideBar extends GridBagConstraints {
    // GridBagConstraints for each button in SideBarPanel

    GridBagConstraints userGbc = new GridBagConstraints(); GridBagConstraints usernameGbc = new GridBagConstraints();
    GridBagConstraints favoritesGbc = new GridBagConstraints(); GridBagConstraints favoritesTextGbc = new GridBagConstraints();
    GridBagConstraints loginsGbc = new GridBagConstraints();
    GridBagConstraints recentsGbc = new GridBagConstraints();
    GridBagConstraints passwordsGbc = new GridBagConstraints();
    GridBagConstraints reportGbc = new GridBagConstraints();
    GridBagConstraints settingsGbc = new GridBagConstraints();
    
    GBCSideBar() {
        userGbc.gridx = 0;
        userGbc.gridy = 0;
        userGbc.gridheight = 1;
        userGbc.gridwidth = 1;
        userGbc.weightx = 0;
        userGbc.weighty = 0.1;
        userGbc.ipadx = 20;
        userGbc.ipady = 15;
        userGbc.insets = new Insets(0,0,35,0);
        userGbc.anchor = GridBagConstraints.FIRST_LINE_START;
        userGbc.fill = GridBagConstraints.HORIZONTAL;
        
        usernameGbc.gridx = 1;
        usernameGbc.gridy = 0;
        usernameGbc.gridheight = 1;
        usernameGbc.gridwidth = 0;
        usernameGbc.weightx = 1;
        usernameGbc.weighty = 0;
        usernameGbc.ipadx = 0;
        usernameGbc.ipady = 31;
        usernameGbc.anchor = GridBagConstraints.PAGE_START;
        usernameGbc.fill = GridBagConstraints.HORIZONTAL;

        favoritesGbc.gridx = 0;
        favoritesGbc.gridy = GridBagConstraints.RELATIVE;
        favoritesGbc.gridheight = 1;
        favoritesGbc.gridwidth = 1;
        favoritesGbc.weightx = 0;
        favoritesGbc.weighty = 0.1;
        favoritesGbc.ipadx = 0;
        favoritesGbc.ipady = 0;
        favoritesGbc.insets = new Insets(0,0,10,0);
        favoritesGbc.anchor = GridBagConstraints.LINE_START;
        favoritesGbc.fill = GridBagConstraints.HORIZONTAL;

        favoritesTextGbc.gridx = 1;
        favoritesTextGbc.gridy = GridBagConstraints.RELATIVE;
        favoritesTextGbc.gridheight = 1;
        favoritesTextGbc.gridwidth = 0;
        favoritesTextGbc.weightx = 1;
        favoritesTextGbc.weighty = 0.1;
        favoritesTextGbc.ipadx = 0;
        favoritesTextGbc.ipady = 0;
        favoritesTextGbc.anchor = GridBagConstraints.PAGE_START;
        favoritesTextGbc.fill = GridBagConstraints.HORIZONTAL;

        recentsGbc.gridx = 0;
        recentsGbc.gridy = GridBagConstraints.RELATIVE;
        recentsGbc.gridheight = 1;
        recentsGbc.gridwidth = 1;
        recentsGbc.weightx = 0;
        recentsGbc.weighty = 0.1;
        recentsGbc.ipadx = 0;
        recentsGbc.ipady = 0;
        recentsGbc.insets = new Insets(0,0,10,0);
        recentsGbc.anchor = GridBagConstraints.LINE_START;
        recentsGbc.fill = GridBagConstraints.HORIZONTAL;

        loginsGbc.gridx = 0;
        loginsGbc.gridy = GridBagConstraints.RELATIVE;
        loginsGbc.gridheight = 1;
        loginsGbc.gridwidth = 1;
        loginsGbc.weightx = 0;
        loginsGbc.weighty = 0.1;
        loginsGbc.ipadx = 0;
        loginsGbc.ipady = 0;
        loginsGbc.insets = new Insets(0,0,10,0);
        loginsGbc.anchor = GridBagConstraints.LINE_START;
        loginsGbc.fill = GridBagConstraints.HORIZONTAL;

        passwordsGbc.gridx = 0;
        passwordsGbc.gridy = GridBagConstraints.RELATIVE;
        passwordsGbc.gridheight = 1;
        passwordsGbc.gridwidth = 1;
        passwordsGbc.weightx = 0;
        passwordsGbc.weighty = 0.1;
        passwordsGbc.ipadx = 0;
        passwordsGbc.ipady = 0;
        passwordsGbc.anchor = GridBagConstraints.LINE_START;
        passwordsGbc.fill = GridBagConstraints.HORIZONTAL;

        reportGbc.gridx = 0;
        reportGbc.gridy = GridBagConstraints.RELATIVE;
        reportGbc.gridheight = 1;
        reportGbc.gridwidth = 1;
        reportGbc.weightx = 0;
        reportGbc.weighty = 0;
        reportGbc.ipadx = 0;
        reportGbc.ipady = 0;
        reportGbc.insets = new Insets(50,0,10,0);
        reportGbc.anchor = GridBagConstraints.LINE_START;
        reportGbc.fill = GridBagConstraints.HORIZONTAL;
        
        settingsGbc.gridx = 0;
        settingsGbc.gridy = GridBagConstraints.RELATIVE;
        settingsGbc.gridheight = 1;
        settingsGbc.gridwidth = 1;
        settingsGbc.weightx = 0;
        settingsGbc.weighty = 0;
        settingsGbc.ipadx = 0;
        settingsGbc.ipady = 0;
        settingsGbc.insets = new Insets(15,0,10,0);
        settingsGbc.anchor = GridBagConstraints.LINE_START;
        settingsGbc.fill = GridBagConstraints.HORIZONTAL;
    }
    
    /**
     * Gets the user-specified {@code GridBagConstraints} object.
     * @param gbc
     * @return Selected {@code GridBagConstraints} object.
     */
    public GridBagConstraints getGbc(String gbc) {
        switch(gbc) {
            case "user": return userGbc;
            case "username": return usernameGbc;
            case "favorites": return favoritesGbc;
            case "favoritesText": return favoritesTextGbc;
            case "logins": return loginsGbc;
            case "recents": return recentsGbc;
            case "passwords": return passwordsGbc;
            case "report": return reportGbc;
            case "settings": return settingsGbc;
            default: return null;
        }
    }
}
