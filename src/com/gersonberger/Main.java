package com.gersonberger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class Main extends Application {

    private static final long startuptime = System.currentTimeMillis();

    static final String PROGRAMNAME = "IIDX-FX";
    static final String PROGRAMVERSION = ProgramVersion.MAJOR_1_MINOR_4_REVISION_2;
    static final String PROGRAMDATE = "2017-05-23";

    static String LOCALDIR;
    static String SEPARATOR;

    static final String FILENAMEMUSICFILE = "music.json";
    static final String FILENAMECHARTSFILE = "charts.json";
    static final String FILENAMESCOREFILE = "scores.json";
    static final String FILENAMERIVALIDS = "rivalids.json";
    private static final String FILENAMESCOREFILEOLD = "scores.txt";
    private static final String FILENAMEPROPERTYFILE = "set.properties";

    static final String FILENAMETHEMELIGHT = "modena-adjust.css";
    static final String FILENAMETHEMEDARK = "dark.css";
    static final String FILENAMETHEMENANAHIRA = "nanahira.css";
    static final String FILENAMESTATUSCOLORS = "status.css";

    private static final String PROPERTYNAMEVERSION = "version";

    private static final String PROPERTYNAMETHEME = "theme";
    private static final String PROPERTYNAMESTATUSCOLORS = "show_statuscolors";
    private static final String PROPERTYNAMETITLESUGGESTIONS = "show_titlesuggestions";
    private static final String PROPERTYNAMEARTISTSUGGESTIONS = "show_artistsuggestions";
    private static final String PROPERTYNAMEPLAYERSIDE = "playerside";
    private static final String PROPERTYNAMEHIGHSPEED = "highspeed";
    private static final String PROPERTYNAMEBATTLE = "battle";
    private static final String PROPERTYNAMESLIM = "slim";
    private static final String PROPERTYNAMEBLACKWHITE = "blackwhite";
    private static final String PROPERTYNAMESONGLIST = "songlist";

    private static final String PROPERTYNAMEDJNAME = "dj_name";
    private static final String PROPERTYNAMEPLAYERID = "iidx_id";

    static final String PROPERTYNAMECOLORDER = "colorder";

    static final String PROPERTYNAMESTYLECOL = "stylecolumn_visible";
    static final String PROPERTYNAMETITLECOL = "titlecolumn_visible";
    static final String PROPERTYNAMEARTISTCOL = "artistcolumn_visible";
    static final String PROPERTYNAMEGENRECOL = "genrecolumn_visible";
    static final String PROPERTYNAMEDIFFICULTYCOL = "difficultycolumn_visible";
    static final String PROPERTYNAMELEVELCOL = "levelcolumn_visible";
    static final String PROPERTYNAMERATINGNCOL = "rncolumn_visible";
    static final String PROPERTYNAMERATINGHCOL = "rhcolumn_visible";
    static final String PROPERTYNAMEBPMCOL = "bpmcolumn_visible";
    static final String PROPERTYNAMELENGTHCOL = "lengthcolumn_visible";
    static final String PROPERTYNAMENOTESCOL = "notescolumn_visible";
    static final String PROPERTYNAMESTATUSCOL = "statuscolumn_visible";
    static final String PROPERTYNAMEGRADECOL = "gradecolumn_visible";
    static final String PROPERTYNAMEEXCOL = "excolumn_visible";
    static final String PROPERTYNAMEMISS_COUNTCOL = "misscolumn_visible";
    static final String PROPERTYNAMESCRATCHCOL = "scratchcolumn_visible";
    static final String PROPERTYNAMESTATSCLEARRATENOPLAY = "stats_clearrate_noplay";
    static final String PROPERTYNAMESTATSCOMPLETIONSTYLEDETAILS = "stats_stylecompletion_details";
    static final String PROPERTYNAMESTATSCOMPLETIONLEVELDETAILS = "stats_levelcompletion_details";

    private static String version;

    private static int os;
    static final int WINDOWS = 1;
    private static final int LINUX = 2;
    private static final int MAC = 3;
    private static final int UNKNOWN = -1;

    static String programTheme;

    private static File scoreFile;
    private static File propFile = null;
    static final String THEMELIGHT = "light";
    static final String THEMEDARK = "dark";
    static final String THEMENANAHIRA = "nanahira";

    static boolean statusColor;
    static boolean showTitleSuggestions;
    static boolean showArtistSuggestions;
    static String playerside;
    static String highspeed;
    static boolean battle;
    static boolean slim;
    static boolean blackwhite;
    static String songlist;
    static String djname;
    static String playerid;
    static String colorder;

    static boolean statsClearrateNoplay;
    static boolean statsStyleCompletionDetails;
    static boolean statsLevelCompletionDetails;

    @Override
    public void start(Stage primaryStage) throws IOException {

        log(Module.INITIALIZE, "OS:  " + System.getProperty("os.name"));
        log(Module.INITIALIZE, "VER: " + System.getProperty("os.version"));
        log(Module.INITIALIZE, "ARC: " + System.getProperty("os.arch"));
        log(Module.INITIALIZE, "USR: " + System.getProperty("user.name"));
        log(Module.INITIALIZE, "HOM: " + System.getProperty("user.home"));
        log(Module.INITIALIZE, "SEP: " + System.getProperty("file.separator"));
        log(Module.INITIALIZE, "JAV: " + System.getProperty("java.version") + "\n");

        os = determineOS(System.getProperty("os.name"));
        initDir();
        initProperties();
        findScoreFile();

        //maybe localization?
        Locale.setDefault(Locale.ENGLISH);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        primaryStage.getIcons().add(new Image(getClass().getResource("/img/icon32.png").toString()));
        primaryStage.getIcons().add(new Image(getClass().getResource("/img/icon256.png").toString()));
        primaryStage.setTitle(PROGRAMNAME + " " + PROGRAMVERSION);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(1400);
        primaryStage.setHeight(846);
        primaryStage.show();
        Main.log(Module.INITIALIZE,"done initializing (loading time: " + (System.currentTimeMillis() - Main.startuptime) + "ms)\n");
    }

    public static void main(String[] args) {
        launch(args);
    }

    static void log(String module, String msg) {
        Date date = new Date(System.currentTimeMillis());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
        System.out.println(formatter.format(date) + " [" + module.substring(0,4) + "] " + msg);
    }

    private int determineOS(String osName) {
        if (osName.toLowerCase().contains("win")) return WINDOWS;
        if (osName.toLowerCase().contains("nux") || osName.toLowerCase().contains("nix")) return LINUX;
        if (osName.toLowerCase().contains("mac")) return MAC;
        return UNKNOWN;
    }

    private void initDir(){
        switch (os) {
            case WINDOWS:
                LOCALDIR = System.getProperty("user.home") + "\\AppData\\Roaming\\" + PROGRAMNAME;
                SEPARATOR = "\\";
                break;
            case LINUX:
                LOCALDIR = System.getProperty("user.home") + "/." + PROGRAMNAME;
                SEPARATOR = "/";
                break;
            case MAC:
                LOCALDIR = System.getProperty("user.home") + "/Library/" + PROGRAMNAME;
                SEPARATOR = "/";
                break;
            default:
                System.err.println("UNKNOWN OPERATING SYSTEM");
                System.exit(-1);
        }

        File folder = new File(LOCALDIR);
        if (!folder.exists()) {
            if (!folder.mkdir()) {
                log(Module.INITIALIZE, "ERROR could not create folder " + folder.getPath());
                System.exit(-1);
            }
        }
    }

    static void findScoreFile() {
        File ScoreFile = new File(LOCALDIR + SEPARATOR + FILENAMESCOREFILE);
        if (!ScoreFile.exists()) scoreFile = null;
        else scoreFile = ScoreFile;
    }

    private void initProperties() throws IOException {
        propFile = new File(LOCALDIR + SEPARATOR + FILENAMEPROPERTYFILE);
        if (!propFile.exists()) {
            FileOutputStream fileOutputStream = new FileOutputStream(propFile.getPath());
            Properties properties = new Properties();
            properties.setProperty(PROPERTYNAMEVERSION, PROGRAMVERSION);
            properties.setProperty(PROPERTYNAMETHEME, THEMELIGHT);
            properties.setProperty(PROPERTYNAMESTATUSCOLORS, String.valueOf(false));
            properties.setProperty(PROPERTYNAMETITLESUGGESTIONS, String.valueOf(false));
            properties.setProperty(PROPERTYNAMEARTISTSUGGESTIONS, String.valueOf(true));
            properties.setProperty(PROPERTYNAMEPLAYERSIDE, "1");
            properties.setProperty(PROPERTYNAMEBATTLE, String.valueOf(false));
            properties.setProperty(PROPERTYNAMESLIM, String.valueOf(false));
            properties.setProperty(PROPERTYNAMEBLACKWHITE, String.valueOf(false));
            properties.setProperty(PROPERTYNAMEHIGHSPEED, String.valueOf("1"));
            properties.setProperty(PROPERTYNAMEDJNAME, String.valueOf(""));
            properties.setProperty(PROPERTYNAMEPLAYERID, String.valueOf(""));
            properties.setProperty(PROPERTYNAMESONGLIST, Style.OMNIMIX);
            properties.setProperty(PROPERTYNAMECOLORDER, "0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15");
            properties.setProperty(PROPERTYNAMESTATSCLEARRATENOPLAY, String.valueOf(true));
            properties.setProperty(PROPERTYNAMESTATSCOMPLETIONSTYLEDETAILS, String.valueOf(false));
            properties.setProperty(PROPERTYNAMESTATSCOMPLETIONLEVELDETAILS, String.valueOf(false));

            properties.store(fileOutputStream, null);
            fileOutputStream.close();
            setProperties_Default();

        } else {
            FileInputStream fileInputStream = new FileInputStream(propFile.getPath());
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

            //handle different property versions
            version = properties.getProperty(PROPERTYNAMEVERSION, ProgramVersion.OLDVERSION);

            //version 1.4
            if (version.equals(ProgramVersion.MAJOR_1_MINOR_4)) {
                programTheme = properties.getProperty(PROPERTYNAMETHEME, THEMELIGHT);
                statusColor = Boolean.valueOf(properties.getProperty(PROPERTYNAMESTATUSCOLORS, "false"));
                showTitleSuggestions = Boolean.valueOf(properties.getProperty(PROPERTYNAMETITLESUGGESTIONS, "false"));
                showArtistSuggestions = Boolean.valueOf(properties.getProperty(PROPERTYNAMEARTISTSUGGESTIONS, "true"));
                playerside = properties.getProperty(PROPERTYNAMEPLAYERSIDE, "1");
                battle = Boolean.valueOf(properties.getProperty(PROPERTYNAMEBATTLE, "false"));
                slim = Boolean.valueOf(properties.getProperty(PROPERTYNAMESLIM, "false"));
                blackwhite = Boolean.valueOf(properties.getProperty(PROPERTYNAMEBLACKWHITE, "false"));
                highspeed = properties.getProperty(PROPERTYNAMEHIGHSPEED, "1");
                djname = properties.getProperty(PROPERTYNAMEDJNAME, "");
                playerid = properties.getProperty(PROPERTYNAMEPLAYERID, "");
                songlist = properties.getProperty(PROPERTYNAMESONGLIST, Style.OMNIMIX);
                colorder = "0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
                statsClearrateNoplay = true;
                statsStyleCompletionDetails = false;
                statsLevelCompletionDetails = false;
                version = PROGRAMVERSION;

                log(Module.INITIALIZE, "updated settings from " + ProgramVersion.MAJOR_1_MINOR_4 + " to " + PROGRAMVERSION);
            }

            //version 1.4.1
            else if (version.equals(ProgramVersion.MAJOR_1_MINOR_4_REVISION_1)) {
                programTheme = properties.getProperty(PROPERTYNAMETHEME, THEMELIGHT);
                statusColor = Boolean.valueOf(properties.getProperty(PROPERTYNAMESTATUSCOLORS, "false"));
                showTitleSuggestions = Boolean.valueOf(properties.getProperty(PROPERTYNAMETITLESUGGESTIONS, "false"));
                showArtistSuggestions = Boolean.valueOf(properties.getProperty(PROPERTYNAMEARTISTSUGGESTIONS, "true"));
                playerside = properties.getProperty(PROPERTYNAMEPLAYERSIDE, "1");
                battle = Boolean.valueOf(properties.getProperty(PROPERTYNAMEBATTLE, "false"));
                slim = Boolean.valueOf(properties.getProperty(PROPERTYNAMESLIM, "false"));
                blackwhite = Boolean.valueOf(properties.getProperty(PROPERTYNAMEBLACKWHITE, "false"));
                highspeed = properties.getProperty(PROPERTYNAMEHIGHSPEED, "1");
                djname = properties.getProperty(PROPERTYNAMEDJNAME, "");
                playerid = properties.getProperty(PROPERTYNAMEPLAYERID, "");
                songlist = properties.getProperty(PROPERTYNAMESONGLIST, Style.OMNIMIX);
                colorder = properties.getProperty(PROPERTYNAMECOLORDER, "0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15");
                statsClearrateNoplay = Boolean.valueOf(properties.getProperty(PROPERTYNAMESTATSCLEARRATENOPLAY, "true"));
                statsStyleCompletionDetails = Boolean.valueOf(properties.getProperty(PROPERTYNAMESTATSCOMPLETIONSTYLEDETAILS, "false"));
                statsLevelCompletionDetails = Boolean.valueOf(properties.getProperty(PROPERTYNAMESTATSCOMPLETIONLEVELDETAILS, "false"));
                version = PROGRAMVERSION;

                log(Module.INITIALIZE, "updated settings from " + ProgramVersion.MAJOR_1_MINOR_4_REVISION_1 + " to " + PROGRAMVERSION);
            }

            //version 1.4.2
            else if (version.equals(ProgramVersion.MAJOR_1_MINOR_4_REVISION_2)) {
                programTheme = properties.getProperty(PROPERTYNAMETHEME, THEMELIGHT);
                statusColor = Boolean.valueOf(properties.getProperty(PROPERTYNAMESTATUSCOLORS, "false"));
                showTitleSuggestions = Boolean.valueOf(properties.getProperty(PROPERTYNAMETITLESUGGESTIONS, "false"));
                showArtistSuggestions = Boolean.valueOf(properties.getProperty(PROPERTYNAMEARTISTSUGGESTIONS, "true"));
                playerside = properties.getProperty(PROPERTYNAMEPLAYERSIDE, "1");
                battle = Boolean.valueOf(properties.getProperty(PROPERTYNAMEBATTLE, "false"));
                slim = Boolean.valueOf(properties.getProperty(PROPERTYNAMESLIM, "false"));
                blackwhite = Boolean.valueOf(properties.getProperty(PROPERTYNAMEBLACKWHITE, "false"));
                highspeed = properties.getProperty(PROPERTYNAMEHIGHSPEED, "1");
                djname = properties.getProperty(PROPERTYNAMEDJNAME, "");
                playerid = properties.getProperty(PROPERTYNAMEPLAYERID, "");
                songlist = properties.getProperty(PROPERTYNAMESONGLIST, Style.OMNIMIX);
                colorder = properties.getProperty(PROPERTYNAMECOLORDER, "0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15");
                statsClearrateNoplay = Boolean.valueOf(properties.getProperty(PROPERTYNAMESTATSCLEARRATENOPLAY, "true"));
                statsStyleCompletionDetails = Boolean.valueOf(properties.getProperty(PROPERTYNAMESTATSCOMPLETIONSTYLEDETAILS, "false"));
                statsLevelCompletionDetails = Boolean.valueOf(properties.getProperty(PROPERTYNAMESTATSCOMPLETIONLEVELDETAILS, "false"));
                version = PROGRAMVERSION;
            }

            //versions 1.0, 1.1, 1.1.1, 1.2, 1.2a, 1.2b, 1.3
            else {
                log(Module.INITIALIZE, "old settings detected, updating to new default settings");
                properties.clear();
                File ScoreFile = new File(LOCALDIR + SEPARATOR + FILENAMESCOREFILEOLD);
                if (ScoreFile.exists()) {
                    ScoreFile.delete();
                }
                setProperties_Default();
            }
        }
    }

    private void setProperties_Default() {
        version = PROGRAMVERSION;
        programTheme = THEMELIGHT;
        statusColor = false;
        showTitleSuggestions = false;
        showArtistSuggestions = true;
        playerside = "1";
        highspeed = "1";
        battle = false;
        slim = false;
        blackwhite = false;
        djname = "";
        playerid = "";
        songlist = Style.COPULAFULL;
        colorder = "0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
        statsClearrateNoplay = true;
        statsStyleCompletionDetails = false;
        statsLevelCompletionDetails = false;

    }

    static void setProperties(boolean[] columnVisibility){
        if (propFile != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(propFile.getPath());
                Properties properties = new Properties();

                properties.setProperty(PROPERTYNAMEVERSION, version);
                properties.setProperty(PROPERTYNAMETHEME, programTheme);
                properties.setProperty(PROPERTYNAMESTATUSCOLORS, String.valueOf(statusColor));
                properties.setProperty(PROPERTYNAMETITLESUGGESTIONS, String.valueOf(showTitleSuggestions));
                properties.setProperty(PROPERTYNAMEARTISTSUGGESTIONS, String.valueOf(showArtistSuggestions));
                properties.setProperty(PROPERTYNAMEPLAYERSIDE, String.valueOf(playerside));
                properties.setProperty(PROPERTYNAMEHIGHSPEED, String.valueOf(highspeed));
                properties.setProperty(PROPERTYNAMEBATTLE, String.valueOf(battle));
                properties.setProperty(PROPERTYNAMESLIM, String.valueOf(slim));
                properties.setProperty(PROPERTYNAMEBLACKWHITE, String.valueOf(blackwhite));
                properties.setProperty(PROPERTYNAMEDJNAME, djname);
                properties.setProperty(PROPERTYNAMEPLAYERID, playerid);
                properties.setProperty(PROPERTYNAMESONGLIST, songlist);
                properties.setProperty(PROPERTYNAMECOLORDER, colorder);
                properties.setProperty(PROPERTYNAMESTATSCLEARRATENOPLAY, String.valueOf(statsClearrateNoplay));
                properties.setProperty(PROPERTYNAMESTATSCOMPLETIONSTYLEDETAILS, String.valueOf(statsStyleCompletionDetails));
                properties.setProperty(PROPERTYNAMESTATSCOMPLETIONLEVELDETAILS, String.valueOf(statsLevelCompletionDetails));

                properties.setProperty(PROPERTYNAMESTYLECOL, String.valueOf(columnVisibility[0]));
                properties.setProperty(PROPERTYNAMETITLECOL, String.valueOf(columnVisibility[1]));
                properties.setProperty(PROPERTYNAMEARTISTCOL, String.valueOf(columnVisibility[2]));
                properties.setProperty(PROPERTYNAMEGENRECOL, String.valueOf(columnVisibility[3]));
                properties.setProperty(PROPERTYNAMEDIFFICULTYCOL, String.valueOf(columnVisibility[4]));
                properties.setProperty(PROPERTYNAMELEVELCOL, String.valueOf(columnVisibility[5]));
                properties.setProperty(PROPERTYNAMERATINGNCOL, String.valueOf(columnVisibility[6]));
                properties.setProperty(PROPERTYNAMERATINGHCOL, String.valueOf(columnVisibility[7]));
                properties.setProperty(PROPERTYNAMEBPMCOL, String.valueOf(columnVisibility[8]));
                properties.setProperty(PROPERTYNAMELENGTHCOL, String.valueOf(columnVisibility[9]));
                properties.setProperty(PROPERTYNAMENOTESCOL, String.valueOf(columnVisibility[10]));
                properties.setProperty(PROPERTYNAMESTATUSCOL, String.valueOf(columnVisibility[11]));
                properties.setProperty(PROPERTYNAMEGRADECOL, String.valueOf(columnVisibility[12]));
                properties.setProperty(PROPERTYNAMEEXCOL, String.valueOf(columnVisibility[13]));
                properties.setProperty(PROPERTYNAMEMISS_COUNTCOL, String.valueOf(columnVisibility[14]));
                properties.setProperty(PROPERTYNAMESCRATCHCOL, String.valueOf(columnVisibility[15]));

                properties.store(fileOutputStream, null);
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static int getOS() {
        return os;
    }

    static File getScoreFile() {
        return scoreFile;
    }

    static File getPropFile() {
        return propFile;
    }

}
