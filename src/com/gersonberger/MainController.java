package com.gersonberger;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


public class MainController implements Initializable {

    /***** TABLEVIEW *****/
    @FXML
    private TableView<SongEntry> tableView;
    @FXML
    private TableColumn<SongEntry, String> styleColumn;
    @FXML
    private TableColumn<SongEntry, String> titleColumn;
    @FXML
    private TableColumn<SongEntry, String> artistColumn;
    @FXML
    private TableColumn<SongEntry, String> genreColumn;
    @FXML
    private TableColumn<SongEntry, String> difficultyColumn;
    @FXML
    private TableColumn<SongEntry, String> levelColumn;
    @FXML
    private TableColumn<SongEntry, String> ratingNColumn;
    @FXML
    private TableColumn<SongEntry, String> ratingHColumn;
    @FXML
    private TableColumn<SongEntry, String> bpmColumn;
    @FXML
    private TableColumn<SongEntry, String> lengthColumn;
    @FXML
    private TableColumn<SongEntry, String> notesColumn;
    @FXML
    private TableColumn<SongEntry, String> clearColumn;
    @FXML
    private TableColumn<SongEntry, String> gradeColumn;
    @FXML
    private TableColumn<SongEntry, String> missColumn;

    /***** STYLE BUTTONS *****/
    @FXML
    private CheckBox checkStyleAll;
    @FXML
    private CheckBox checkStyle1;
    @FXML
    private CheckBox checkStyleSub;
    @FXML
    private CheckBox checkStyle2;
    @FXML
    private CheckBox checkStyle3;
    @FXML
    private CheckBox checkStyle4;
    @FXML
    private CheckBox checkStyle5;
    @FXML
    private CheckBox checkStyle6;
    @FXML
    private CheckBox checkStyle7;
    @FXML
    private CheckBox checkStyle8;
    @FXML
    private CheckBox checkStyle9;
    @FXML
    private CheckBox checkStyle10;
    @FXML
    private CheckBox checkStyle11;
    @FXML
    private CheckBox checkStyle12;
    @FXML
    private CheckBox checkStyle13;
    @FXML
    private CheckBox checkStyle14;
    @FXML
    private CheckBox checkStyle15;
    @FXML
    private CheckBox checkStyle16;
    @FXML
    private CheckBox checkStyle17;
    @FXML
    private CheckBox checkStyle18;
    @FXML
    private CheckBox checkStyle19;
    @FXML
    private CheckBox checkStyle20;
    @FXML
    private CheckBox checkStyle21;
    @FXML
    private CheckBox checkStyle22;

    private boolean styleAll = true;
    private boolean style1 = false;
    private boolean styleSub = false;
    private boolean style2 = false;
    private boolean style3 = false;
    private boolean style4 = false;
    private boolean style5 = false;
    private boolean style6 = false;
    private boolean style7 = false;
    private boolean style8 = false;
    private boolean style9 = false;
    private boolean style10 = false;
    private boolean style11 = false;
    private boolean style12 = false;
    private boolean style13 = false;
    private boolean style14 = false;
    private boolean style15 = false;
    private boolean style16 = false;
    private boolean style17 = false;
    private boolean style18 = false;
    private boolean style19 = false;
    private boolean style20 = false;
    private boolean style21 = false;
    private boolean style22 = false;

    /***** LEVEL BUTTONS *****/
    @FXML
    private CheckBox checkLevelAll;
    @FXML
    private CheckBox checkLevel1;
    @FXML
    private CheckBox checkLevel2;
    @FXML
    private CheckBox checkLevel3;
    @FXML
    private CheckBox checkLevel4;
    @FXML
    private CheckBox checkLevel5;
    @FXML
    private CheckBox checkLevel6;
    @FXML
    private CheckBox checkLevel7;
    @FXML
    private CheckBox checkLevel8;
    @FXML
    private CheckBox checkLevel9;
    @FXML
    private CheckBox checkLevel10;
    @FXML
    private CheckBox checkLevel11;
    @FXML
    private CheckBox checkLevel12;

    private boolean levelAll = true;
    private boolean level1 = false;
    private boolean level2 = false;
    private boolean level3 = false;
    private boolean level4 = false;
    private boolean level5 = false;
    private boolean level6 = false;
    private boolean level7 = false;
    private boolean level8 = false;
    private boolean level9 = false;
    private boolean level10 = false;
    private boolean level11 = false;
    private boolean level12 = false;

    /***** DIFFICULTY BUTTONS *****/
    @FXML
    private CheckBox checkDiffAll;
    @FXML
    private CheckBox checkDiffN;
    @FXML
    private CheckBox checkDiffH;
    @FXML
    private CheckBox checkDiffA;
    @FXML
    private CheckBox checkDiffB;
    @FXML
    private CheckBox checkDiffL;

    private boolean diffAll = true;
    private boolean diffN = false;
    private boolean diffH = false;
    private boolean diffA = false;
    private boolean diffB = false;
    private boolean diffL = false;

    /***** MENU *****/
    @FXML
    private CheckMenuItem checkMenuClearColors;
    @FXML
    private RadioMenuItem radioMenuLight;
    @FXML
    private RadioMenuItem radioMenuDark;


    /***** MISC *****/
    @FXML
    private VBox mainBox;
    @FXML
    private VBox settingsBox;
    @FXML
    private TextField filterField;
    @FXML
    private ImageView checkImageView;
    @FXML
    private Label matchLabel;
    @FXML
    private Label savedLabel;
    @FXML
    private Label fileLabel;
    @FXML
    private MenuItem menuSave;

    private Scene scene;
    private boolean settingsVisible = false;
    private ObservableList<SongEntry> masterData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("\n" + getTime() + " OS: " + System.getProperty("os.name") + "\n" + getTime() +
                " VER: " + System.getProperty("os.version") + "\n" + getTime() + " ARC: " +
                System.getProperty("os.arch") + "\n" + getTime() + " USR: " + System.getProperty("user.name") + "\n" +
                getTime() + " HOM: " + System.getProperty("user.home") + "\n" + getTime() + " SEP: " +
                System.getProperty("file.separator") + "\n" + getTime() + " JAV: " +
                System.getProperty("java.version") + "\n");

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                if (tableView.getItems().size() != 1) matchLabel.setText(tableView.getItems().size() + " matches");
                else matchLabel.setText("1 match");
            });
        });

        Platform.runLater(() -> {
            scene = tableView.getScene();
            scene.getWindow().setOnCloseRequest(event -> {
                quit();
                event.consume();
            });

            //load stylesheets and setting toggles
            scene.getStylesheets().add(getClass().getResource("/css/clear.css").toExternalForm());
            if (Main.programTheme.equals(Main.THEMELIGHT)) {
                radioMenuLight.setSelected(true);
                scene.getStylesheets().add(getClass().getResource("/css/modena-adjust.css").toExternalForm());
            }
            if (Main.programTheme.equals(Main.THEMEDARK)) {
                radioMenuDark.setSelected(true);
                scene.getStylesheets().add(getClass().getResource("/css/dark.css").toExternalForm());
            }
            checkMenuClearColors.setSelected(Main.programClearColor);
        });

        mainBox.getChildren().remove(settingsBox);
        onStartTableView();

        //initial sort AC-style
        titleColumn.setSortType(TableColumn.SortType.ASCENDING);
        levelColumn.setSortType(TableColumn.SortType.ASCENDING);
        styleColumn.setSortType(TableColumn.SortType.DESCENDING);
        tableView.getSortOrder().add(styleColumn);
        tableView.getSortOrder().add(levelColumn);
        tableView.getSortOrder().add(titleColumn);
        refreshTable();

    }

    /*
    private String getMD5(final File file) {
        byte[] bytes = new byte[0];
        MessageDigest messageDigest = null;
        String hexString = "";
        try {
            bytes = Files.readAllBytes(Paths.get(file.getPath()));
            messageDigest = MessageDigest.getInstance("MD5");
            bytes = messageDigest.digest(bytes);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        if (messageDigest != null) {
            for (byte b : bytes) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) hexString += "0";
                hexString += hex;
            }
        }
        return hexString;
    }
    */

    private int lengthToInt(final String time) {
        if (time.contains(":")) {
            String[] tmp = time.split(":");
            return 60 * Integer.valueOf(tmp[0]) + Integer.valueOf(tmp[1]);
        }
        else return -1;
    }

    private Comparator<String> getStyleComparator() {
        return (o1, o2) -> {
            float f1 = Style.styleToInt(o1);
            float f2 = Style.styleToInt(o2);
            if (f1 == -1) f1 = 1.5f;
            if (f2 == -1) f2 = 1.5f;
            return f1 > f2 ? 1 : f1 < f2 ? -1 : 0;
        };
    }

    private Comparator<String> getDifficultyComparator() {
        return (o1, o2) -> {
            int i1 = Difficulty.difficultyToInt(o1);
            int i2 = Difficulty.difficultyToInt(o2);
            return i1 > i2 ? 1 : i1 < i2 ? -1 : 0;
        };
    }

    //TODO: rewrite this
    private Comparator<String> getRatingComparator() {
        return (o1, o2) -> {
            if (o1.equals(o2)) return 0;

            if (o1.equals(Rating.LOW)) return -1;
            if (o2.equals(Rating.LOW)) return 1;
            if (o1.equals(Rating.NA)) return 1;
            if (o2.equals(Rating.NA)) return -1;

            if (o1.contains(".") && !o2.contains(".")) return -1;
            if (!o1.contains(".") && o2.contains(".")) return 1;

            if (o1.contains(".") && o2.contains(".")) {
                int value1 = Integer.parseInt(o1.substring(0, o1.indexOf(".")));
                int value2 = Integer.parseInt(o2.substring(0, o2.indexOf(".")));
                if (value1 != value2) return value1 < value2 ? -1 : 1;
                else {
                    if (o1.contains("+")) return 1;
                    if (o2.contains("+")) return -1;
                    value1 = Integer.parseInt(o1.substring(o1.indexOf(".") + 1, o1.length()));
                    value2 = Integer.parseInt(o2.substring(o2.indexOf(".") + 1, o2.length()));
                    if (value1 != value2) return value1 < value2 ? -1 : 1;
                }
            }
            return 0;
        };
    }

    private Comparator<String> getBpmComparator() {
        return (o1, o2) -> {
            int[] s1 = new int[2], s2 = new int[2];
            if (o1.contains("-")) {
                String[] tmp = o1.split("-");
                s1[0] = Integer.parseInt(tmp[0]);
                s1[1] = Integer.parseInt(tmp[1]);
            } else {
                s1[0] = Integer.parseInt(o1);
                s2[1] = 0;
            }
            if (o2.contains("-")) {
                String[] tmp = o2.split("-");
                s2[0] = Integer.parseInt(tmp[0]);
                s2[1] = Integer.parseInt(tmp[1]);
            } else {
                s2[0] = Integer.parseInt(o2);
                s2[1] = 0;
            }
            if (s1[1] == 0 || s2[1] == 0) return s1[0] > s2[0] ? 1 : s1[0] < s2[0] ? -1 : 0;
            else {
                if (s1[0] != s2[0]) return s1[0] > s2[0] ? 1 : s1[0] < s2[0] ? -1 : 0;
                else return s1[1] > s2[1] ? 1 : s1[1] < s2[1] ? -1 : 0;
            }
        };
    }

    private Comparator<String> getIntegerComparator() {
        return (o1, o2) -> {
            if (!o1.equals(o2)) return Integer.valueOf(o1) > Integer.valueOf(o2) ? 1 : -1;
            return 0;
        };
    }

    private Comparator<String> getClearComparator() {
        return (o1, o2) -> {
            if (!o1.equals(o2)) return Clear.clearToInt(o1) > Clear.clearToInt(o2) ? 1 : -1;
            return 0;
        };
    }

    private Comparator<String> getGradeComparator() {
        return (o1, o2) -> {
            if (!o1.equals(o2)) return Grade.gradeToInt(o1) > Grade.gradeToInt(o2) ? 1 : -1;
            return 0;
        };
    }

    private Comparator<String> getMissComparator() {
        return (o1, o2) -> {
            int i1 = o1.equals("") ? -2 : o1.equals("N/A") ? -1 : Integer.valueOf(o1);
            int i2 = o2.equals("") ? -2 : o2.equals("N/A") ? -1 : Integer.valueOf(o2);
            return i1 > i2 ? 1 : i1 < i2 ? -1 : 0;
        };
    }

    private void copyToClipboard(String string) {
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(new StringSelection(string), null);
    }

    private void initColumns() throws IOException {

        //don't show columns the user has hidden last launch
        //read column visibility from propertyfile
        FileInputStream fileInputStream = new FileInputStream(Main.getPropFile().getPath());
        Properties properties = new Properties();
        properties.load(fileInputStream);
        styleColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMESTYLECOL, "true")));
        titleColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMETITLECOL, "true")));
        artistColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEARTISTCOL, "true")));
        genreColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEGENRECOL, "true")));
        difficultyColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEDIFFICULTYCOL, "true")));
        levelColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMELEVELCOL, "true")));
        ratingNColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMERATINGNCOL, "true")));
        ratingHColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMERATINGHCOL, "true")));
        bpmColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEBPMCOL, "true")));
        lengthColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMELENGTHCOL, "true")));
        notesColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMENOTESCOL, "true")));
        clearColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMECLEARCOL, "false")));
        gradeColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEGRADECOL, "false")));
        missColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEMISSCOL, "false")));

        //contextmenu
        tableView.setRowFactory(param -> {
            final TableRow<SongEntry> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem copytitle = new MenuItem("Copy title");
            copytitle.setOnAction(event -> copyToClipboard(row.getItem().getTitle()));
            final MenuItem copyartist = new MenuItem("Copy artist");
            copyartist.setOnAction(event -> copyToClipboard(row.getItem().getArtist()));
            final MenuItem copygenre = new MenuItem("Copy genre");
            copygenre.setOnAction(event -> copyToClipboard(row.getItem().getGenre()));
            contextMenu.getItems().addAll(copytitle, copyartist, copygenre);

            //set context menu on row, but use a binding to make it only show for non-empty rows:
            row.contextMenuProperty().bind(Bindings.when(row.emptyProperty()).then((ContextMenu) null).otherwise(contextMenu));

            return row;
        });

        //set columns
        styleColumn.setCellValueFactory(new PropertyValueFactory<>("Style"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("Artist"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("Genre"));
        difficultyColumn.setCellValueFactory(new PropertyValueFactory<>("Difficulty"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>("Level"));
        ratingNColumn.setCellValueFactory(new PropertyValueFactory<>("nRating_s"));
        ratingHColumn.setCellValueFactory(new PropertyValueFactory<>("hRating_s"));
        bpmColumn.setCellValueFactory(new PropertyValueFactory<>("Bpm"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("Length"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("Notes"));
        clearColumn.setCellValueFactory(new PropertyValueFactory<>("Clear"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("Grade"));
        missColumn.setCellValueFactory(new PropertyValueFactory<>("Miss"));

        //clear theming via css/clear.css if selected in settings
        clearColumn.setCellFactory(new Callback<TableColumn<SongEntry, String>, TableCell<SongEntry, String>>() {
            @Override
            public TableCell<SongEntry, String> call(TableColumn<SongEntry, String> param) {
                return new TableCell<SongEntry, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        this.getStyleClass().removeAll("failed", "assistclear", "easyclear", "clear", "hardclear", "exhardclear", "fullcombo");
                        if (!isEmpty() && Main.programClearColor) {
                            switch (item) {
                                case Clear.FAILED:
                                    this.getStyleClass().add("failed");
                                    break;
                                case Clear.ASSISTCLEAR:
                                    this.getStyleClass().add("assistclear");
                                    break;
                                case Clear.EASYCLEAR:
                                    this.getStyleClass().add("easyclear");
                                    break;
                                case Clear.CLEAR:
                                    this.getStyleClass().add("clear");
                                    break;
                                case Clear.HARDCLEAR:
                                    this.getStyleClass().add("hardclear");
                                    break;
                                case Clear.EXHARDCLEAR:
                                    this.getStyleClass().add("exhardclear");
                                    break;
                                case Clear.FULLCOMBO:
                                    this.getStyleClass().add("fullcombo");
                                    break;
                                default:
                            }
                        }
                        setText(item);
                    }
                };
            }
        });

        //custom comparators
        styleColumn.setComparator(getStyleComparator());
        difficultyColumn.setComparator(getDifficultyComparator());
        levelColumn.setComparator(getIntegerComparator());
        ratingNColumn.setComparator(getRatingComparator());
        ratingHColumn.setComparator(getRatingComparator());
        bpmColumn.setComparator(getBpmComparator());
        notesColumn.setComparator(getIntegerComparator());
        clearColumn.setComparator(getClearComparator());
        gradeColumn.setComparator(getGradeComparator());
        missColumn.setComparator(getMissComparator());
    }

    private void setTableViewData(final ObservableList<SongEntry> masterData) {
        final FilteredList<SongEntry> filteredData = new FilteredList<>(masterData);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(songEntry -> {

                //empty list
                if (songEntry == null) return false;

                // filter
                if (!styleAll) {
                    if ((!songEntry.getStyle().equals(Style.FIRSTSTYLE) || !style1) &&
                            (!songEntry.getStyle().equals(Style.SUBSTREAM) || !styleSub) &&
                            (!songEntry.getStyle().equals(Style.SECONDSTYLE) || !style2) &&
                            (!songEntry.getStyle().equals(Style.THIRDSTYLE) || !style3) &&
                            (!songEntry.getStyle().equals(Style.FOURTHSTYLE) || !style4) &&
                            (!songEntry.getStyle().equals(Style.FIFTHSTYLE) || !style5) &&
                            (!songEntry.getStyle().equals(Style.SIXTHSTYLE) || !style6) &&
                            (!songEntry.getStyle().equals(Style.SEVENTHSTYLE) || !style7) &&
                            (!songEntry.getStyle().equals(Style.EIGHTHSTYLE) || !style8) &&
                            (!songEntry.getStyle().equals(Style.NINTHSTYLE) || !style9) &&
                            (!songEntry.getStyle().equals(Style.TENTHSTYLE) || !style10) &&
                            (!songEntry.getStyle().equals(Style.IIDXRED) || !style11) &&
                            (!songEntry.getStyle().equals(Style.HAPPYSKY) || !style12) &&
                            (!songEntry.getStyle().equals(Style.DISTORTED) || !style13) &&
                            (!songEntry.getStyle().equals(Style.GOLD) || !style14) &&
                            (!songEntry.getStyle().equals(Style.DJTROOPERS) || !style15) &&
                            (!songEntry.getStyle().equals(Style.EMPRESS) || !style16) &&
                            (!songEntry.getStyle().equals(Style.SIRIUS) || !style17) &&
                            (!songEntry.getStyle().equals(Style.RESORTANTHEM) || !style18) &&
                            (!songEntry.getStyle().equals(Style.LINCLE) || !style19) &&
                            (!songEntry.getStyle().equals(Style.TRICORO) || !style20) &&
                            (!songEntry.getStyle().equals(Style.SPADA) || !style21) &&
                            (!songEntry.getStyle().equals(Style.PENDUAL) || !style22)) return false;
                }

                if (!levelAll) {
                    if ((!songEntry.getLevel().equals("1") || !level1) &&
                            (!songEntry.getLevel().equals("2") || !level2) &&
                            (!songEntry.getLevel().equals("3") || !level3) &&
                            (!songEntry.getLevel().equals("4") || !level4) &&
                            (!songEntry.getLevel().equals("5") || !level5) &&
                            (!songEntry.getLevel().equals("6") || !level6) &&
                            (!songEntry.getLevel().equals("7") || !level7) &&
                            (!songEntry.getLevel().equals("8") || !level8) &&
                            (!songEntry.getLevel().equals("9") || !level9) &&
                            (!songEntry.getLevel().equals("10") || !level10) &&
                            (!songEntry.getLevel().equals("11") || !level11) &&
                            (!songEntry.getLevel().equals("12") || !level12)) return false;
                }

                if (!diffAll) {
                    if ((!songEntry.getDifficulty().equals(Difficulty.NORMAL) || !diffN) &&
                            (!songEntry.getDifficulty().equals(Difficulty.HYPER) || !diffH) &&
                            (!songEntry.getDifficulty().equals(Difficulty.ANOTHER) || !diffA) &&
                            (!songEntry.getDifficulty().equals(Difficulty.BLACKANOTHER) || !diffB) &&
                            (!songEntry.getDifficulty().equals(Difficulty.LEGGENDARIA) || !diffL)) return false;
                }

                //if empty show all
                if (newValue == null || newValue.isEmpty()) return true;

                //hits
                final String[] lowerCaseFilter = newValue.toLowerCase().split(" ");
                int found = 0;
                for (String query : lowerCaseFilter) {
                    if (songEntry.getTitle().toLowerCase().contains(query)) found++;
                    else if (songEntry.getTitle_r().toLowerCase().contains(query)) found++;
                    else if (songEntry.getArtist().toLowerCase().contains(query)) found++;
                    else if (songEntry.getArtist_r().toLowerCase().contains(query)) found++;
                    else if (songEntry.getGenre().toLowerCase().contains(query)) found++;
                    //else if (songEntry.getStyle().toLowerCase().contains(query)) found++;
                    //else if (songEntry.getDifficulty().toLowerCase().contains(query)) found++;
                }
                return found == lowerCaseFilter.length;
            });

            final SortedList<SongEntry> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tableView.comparatorProperty());
            tableView.setItems(sortedData);
        });
    }

    //TODO: comment this
    private void onStartTableView() {
        masterData = FXCollections.observableArrayList();
        List<SongEntry> entries = new ArrayList<>();

        InputStream chartInputStream = getClass().getResourceAsStream("/data/chartlist.txt");
        InputStream idInputStream = getClass().getResourceAsStream("/data/idlist.txt");
        File scoreFile = Main.getScoreFile();

        if (chartInputStream != null && idInputStream != null) {

            String[] data;
            String[][] idList = new String[22200][5];
            String[][][] clearList = null;

            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(idInputStream, "UTF-8"));
                String line = bufferedReader.readLine();
                int id;
                while (line != null) {
                    if (!line.startsWith("//") && !line.isEmpty() && !line.equals("")) {
                        data = line.split(",");
                        id = Integer.parseInt(data[0]); //id
                        idList[id][0] = data[1]; //title
                        idList[id][1] = data[2]; //title_r
                        idList[id][2] = data[3]; //artist
                        idList[id][3] = data[4]; //artist_r
                        idList[id][4] = data[5]; //genre
                    }
                    line = bufferedReader.readLine();
                }

                if (scoreFile != null) {
                    FileInputStream scoreFileInputStream = new FileInputStream(scoreFile);
                    InputStreamReader scoreInputStreamReader = new InputStreamReader(scoreFileInputStream, "UTF-8");
                    bufferedReader = new BufferedReader(scoreInputStreamReader);
                    line = bufferedReader.readLine();
                    clearList = new String[22200][3][4];
                    while (line != null) {
                        if (!line.startsWith("//") && !line.isEmpty() && !line.equals("")) {
                            data = line.split(",");
                            id = Integer.parseInt(data[0]); //id
                            clearList[id][Integer.parseInt(data[1]) - 1][0] = data[2]; //clear
                            clearList[id][Integer.parseInt(data[1]) - 1][1] = data[3]; //miss
                            clearList[id][Integer.parseInt(data[1]) - 1][2] = data[4]; //grade
                            clearList[id][Integer.parseInt(data[1]) - 1][3] = data[5]; //percent
                        }
                        line = bufferedReader.readLine();
                    }
                }

                bufferedReader = new BufferedReader(new InputStreamReader(chartInputStream, "UTF-8"));
                line = bufferedReader.readLine();
                String title, title_r, artist, artist_r, genre, difficulty, grade;
                int style, difficulty_int, level, nRating, hRating, bpmMin, bpmMax, length, notes, clear, miss;
                while (line != null) {
                    if (!line.startsWith("//") && !line.isEmpty() && !line.equals("")) {
                        data = line.split(",");
                        id = Integer.valueOf(data[0]);
                        style = getStyleFromID(id);
                        title = idList[id][0];
                        title_r = idList[id][1];
                        artist = idList[id][2];
                        artist_r = idList[id][3];
                        genre = idList[id][4];
                        difficulty = Difficulty.difficultyToString(Integer.valueOf(data[1]));
                        difficulty_int = Integer.valueOf(data[1]);
                        level = Integer.valueOf(data[4]);
                        nRating =  Integer.valueOf(data[5]);
                        hRating =  Integer.valueOf(data[6]);
                        length = lengthToInt(data[3]);
                        notes = Integer.valueOf(data[7]);
                        if (data[2].contains("-")) {
                            String[] bpm = data[2].split("-");
                            bpmMin = Integer.valueOf(bpm[0]);
                            bpmMax = Integer.valueOf(bpm[1]);
                        } else {
                            bpmMin = Integer.valueOf(data[2]);
                            bpmMax = 0;
                        }
                        if (difficulty_int > 3) difficulty_int = 3;
                        if (clearList != null) {
                            if (clearList[id][difficulty_int - 1][0] != null) {
                                clear = Integer.parseInt(clearList[id][difficulty_int - 1][0]);
                                grade = clearList[id][difficulty_int - 1][2];
                                miss = Integer.parseInt(clearList[id][difficulty_int - 1][1]);
                            } else {
                                clear = 0;
                                grade = "";
                                miss = -2;
                            }
                        } else {
                            clear = 0;
                            grade = "";
                            miss = -2;
                        }
                        entries.add(new SongEntry(style, title, title_r, artist, artist_r, genre, difficulty, level,
                                nRating, hRating, bpmMin, bpmMax, length, notes, clear, grade, miss));
                    }
                    line = bufferedReader.readLine();
                }
                System.out.println(getTime() + " created " + entries.size() + " entries");
                masterData.addAll(entries);
                System.out.println(getTime() + " added entries to masterdata");
                initColumns();
                setTableViewData(masterData);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println(getTime() + " INIT FAILED");
                System.exit(-1);
            }
        }
    }

    private int getStyleFromID(int songID) {
        if (songID == 21244 || songID == 21241 || songID == 21240 || songID == 21257 || songID == 21238 ||
                songID == 21260 || songID == 21242 || songID == 21245 || songID == 21250 || songID == 21252 ||
                songID == 21253 || songID == 21256 || songID == 21254 || songID == 21255 || songID == 21247 ||
                songID == 21258 || songID == 21259 || songID == 21251 || songID == 21246 || songID == 21249 ||
                songID == 21243 || songID == 21262 || songID == 21239) return Style.EMPRESSINT;
        else if (songID == 21223 || songID == 21235 || songID == 21225 || songID == 21232 || songID == 21261 ||
                songID == 21231 || songID == 21234 || songID == 21228 || songID == 21263 || songID == 21226 ||
                songID == 21233 || songID == 21229 || songID == 21237 || songID == 21236) return Style.DJTROOPERSINT;
        else if (songID == 21221 || songID == 21222 || songID == 21220 || songID == 21264) return Style.GOLDINT;
        else if (songID == 21216 || songID == 21201 || songID == 21219 || songID == 21218 || songID == 21217) return Style.HAPPYSKYINT;
        else if (songID == 21214 || songID == 21215) return Style.IIDXREDINT;
        else if (songID == 21212 || songID == 21211 || songID == 21213) return Style.NINTHSTYLEINT;
        else if (songID == 21209 || songID == 21210) return Style.EIGHTHSTYLEINT;
        else if (songID == 21208) return Style.SEVENTHSTYLEINT;
        else if (songID == 21207) return Style.SIXTHSTYLEINT;
        else if (songID == 21206) return Style.FIFTHSTYLEINT;
        else if (songID == 21205) return Style.FOURTHSTYLEINT;
        else if (songID == 1013 || songID == 1015 || songID == 1008 || songID == 1007 || songID == 1019 ||
                songID == 1004 || songID == 1020 || songID == 1017 || songID == 1005 || songID == 21204 ||
                songID == 1402) return Style.SUBSTREAMINT;
        else if (songID > 9999 ) return Integer.parseInt(String.valueOf(songID).substring(0,2));
        else return Integer.parseInt(String.valueOf(songID).substring(0,1));
    }

    public void hideSettings() {
        if (settingsVisible) {
            mainBox.getChildren().remove(settingsBox);
            settingsVisible = false;
        } else {
            mainBox.getChildren().add(1, settingsBox);
            settingsVisible = true;
        }
    }

    private String getTime() {
        Date date = new Date(System.currentTimeMillis());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
        return formatter.format(date);
    }


    //level select toggles

    public void levelAll() {
        if (levelAll) {
            checkLevelAll.setSelected(false);
            setDisableLevel(false);
            levelAll = false;
        } else {
            checkLevelAll.setSelected(true);
            setDisableLevel(true);
            levelAll = true;
        }
        refreshTable();
    }

    public void level1() {
        if (level1) {
            checkLevel1.setSelected(false);
            level1 = false;
        }
        else {
            checkLevel1.setSelected(true);
            level1 = true;
        }
        refreshTable();
    }

    public void level2() {
        if (level2) {
            checkLevel2.setSelected(false);
            level2 = false;
        }
        else {
            checkLevel2.setSelected(true);
            level2 = true;
        }
        refreshTable();
    }

    public void level3() {
        if (level3) {
            checkLevel3.setSelected(false);
            level3 = false;
        }
        else {
            checkLevel3.setSelected(true);
            level3 = true;
        }
        refreshTable();
    }

    public void level4() {
        if (level4) {
            checkLevel4.setSelected(false);
            level4 = false;
        }
        else {
            checkLevel4.setSelected(true);
            level4 = true;
        }
        refreshTable();
    }

    public void level5() {
        if (level5) {
            checkLevel5.setSelected(false);
            level5 = false;
        }
        else {
            checkLevel5.setSelected(true);
            level5 = true;
        }
        refreshTable();
    }

    public void level6() {
        if (level6) {
            checkLevel6.setSelected(false);
            level6 = false;
        }
        else {
            checkLevel6.setSelected(true);
            level6 = true;
        }
        refreshTable();
    }

    public void level7() {
        if (level7) {
            checkLevel7.setSelected(false);
            level7 = false;
        }
        else {
            checkLevel7.setSelected(true);
            level7 = true;
        }
        refreshTable();
    }

    public void level8() {
        if (level8) {
            checkLevel8.setSelected(false);
            level8 = false;
        }
        else {
            checkLevel8.setSelected(true);
            level8 = true;
        }
        refreshTable();
    }

    public void level9() {
        if (level9) {
            checkLevel9.setSelected(false);
            level9 = false;
        }
        else {
            checkLevel9.setSelected(true);
            level9 = true;
        }
        refreshTable();
    }

    public void level10() {
        if (level10) {
            checkLevel10.setSelected(false);
            level10 = false;
        }
        else {
            checkLevel10.setSelected(true);
            level10 = true;
        }
        refreshTable();
    }

    public void level11() {
        if (level11) {
            checkLevel11.setSelected(false);
            level11 = false;
        }
        else {
            checkLevel11.setSelected(true);
            level11 = true;
        }
        refreshTable();
    }

    public void level12() {
        if (level12) {
            checkLevel12.setSelected(false);
            level12 = false;
        }
        else {
            checkLevel12.setSelected(true);
            level12 = true;
        }
        refreshTable();
    }

    private void setDisableLevel(boolean bool) {
        checkLevel1.setDisable(bool);
        checkLevel2.setDisable(bool);
        checkLevel3.setDisable(bool);
        checkLevel4.setDisable(bool);
        checkLevel5.setDisable(bool);
        checkLevel6.setDisable(bool);
        checkLevel7.setDisable(bool);
        checkLevel8.setDisable(bool);
        checkLevel9.setDisable(bool);
        checkLevel10.setDisable(bool);
        checkLevel11.setDisable(bool);
        checkLevel12.setDisable(bool);
    }


    //style select toggles

    public void styleAll() {
        if (styleAll) {
            checkStyleAll.setSelected(false);
            setDisableStyle(false);
            styleAll = false;
        } else {
            checkStyleAll.setSelected(true);
            setDisableStyle(true);
            styleAll = true;
        }
        refreshTable();
    }

    public void style1() {
        if (style1) {
            checkStyle1.setSelected(false);
            style1 = false;
        } else {
            checkStyle1.setSelected(true);
            style1 = true;
        }
        refreshTable();
    }

    public void styleSub() {
        if (styleSub) {
            checkStyleSub.setSelected(false);
            styleSub = false;
        } else {
            checkStyleSub.setSelected(true);
            styleSub = true;
        }
        refreshTable();
    }

    public void style2() {
        if (style2) {
            checkStyle2.setSelected(false);
            style2 = false;
        } else {
            checkStyle2.setSelected(true);
            style2 = true;
        }
        refreshTable();
    }

    public void style3() {
        if (style3) {
            checkStyle3.setSelected(false);
            style3 = false;
        } else {
            checkStyle3.setSelected(true);
            style3 = true;
        }
        refreshTable();
    }

    public void style4() {
        if (style4) {
            checkStyle4.setSelected(false);
            style4 = false;
        } else {
            checkStyle4.setSelected(true);
            style4 = true;
        }
        refreshTable();
    }

    public void style5() {
        if (style5) {
            checkStyle5.setSelected(false);
            style5 = false;
        } else {
            checkStyle5.setSelected(true);
            style5 = true;
        }
        refreshTable();
    }

    public void style6() {
        if (style6) {
            checkStyle6.setSelected(false);
            style6 = false;
        } else {
            checkStyle6.setSelected(true);
            style6 = true;
        }
        refreshTable();
    }

    public void style7() {
        if (style7) {
            checkStyle7.setSelected(false);
            style7 = false;
        } else {
            checkStyle7.setSelected(true);
            style7 = true;
        }
        refreshTable();
    }

    public void style8() {
        if (style8) {
            checkStyle8.setSelected(false);
            style8 = false;
        } else {
            checkStyle8.setSelected(true);
            style8 = true;
        }
        refreshTable();
    }

    public void style9() {
        if (style9) {
            checkStyle9.setSelected(false);
            style9 = false;
        } else {
            checkStyle9.setSelected(true);
            style9 = true;
        }
        refreshTable();
    }

    public void style10() {
        if (style10) {
            checkStyle10.setSelected(false);
            style10 = false;
        } else {
            checkStyle10.setSelected(true);
            style10 = true;
        }
        refreshTable();
    }

    public void style11() {
        if (style11) {
            checkStyle11.setSelected(false);
            style11 = false;
        } else {
            checkStyle11.setSelected(true);
            style11 = true;
        }
        refreshTable();
    }

    public void style12() {
        if (style12) {
            checkStyle12.setSelected(false);
            style12 = false;
        } else {
            checkStyle12.setSelected(true);
            style12 = true;
        }
        refreshTable();
    }

    public void style13() {
        if (style13) {
            checkStyle13.setSelected(false);
            style13 = false;
        } else {
            checkStyle13.setSelected(true);
            style13 = true;
        }
        refreshTable();
    }

    public void style14() {
        if (style14) {
            checkStyle14.setSelected(false);
            style14 = false;
        } else {
            checkStyle14.setSelected(true);
            style14 = true;
        }
        refreshTable();
    }

    public void style15() {
        if (style15) {
            checkStyle15.setSelected(false);
            style15 = false;
        } else {
            checkStyle15.setSelected(true);
            style15 = true;
        }
        refreshTable();
    }

    public void style16() {
        if (style16) {
            checkStyle16.setSelected(false);
            style16 = false;
        } else {
            checkStyle16.setSelected(true);
            style16 = true;
        }
        refreshTable();
    }

    public void style17() {
        if (style17) {
            checkStyle17.setSelected(false);
            style17 = false;
        } else {
            checkStyle17.setSelected(true);
            style17 = true;
        }
        refreshTable();
    }

    public void style18() {
        if (style18) {
            checkStyle18.setSelected(false);
            style18 = false;
        } else {
            checkStyle18.setSelected(true);
            style18 = true;
        }
        refreshTable();
    }

    public void style19() {
        if (style19) {
            checkStyle19.setSelected(false);
            style19 = false;
        } else {
            checkStyle19.setSelected(true);
            style19 = true;
        }
        refreshTable();
    }

    public void style20() {
        if (style20) {
            checkStyle20.setSelected(false);
            style20 = false;
        } else {
            checkStyle20.setSelected(true);
            style20 = true;
        }
        refreshTable();
    }

    public void style21() {
        if (style21) {
            checkStyle21.setSelected(false);
            style21 = false;
        } else {
            checkStyle21.setSelected(true);
            style21 = true;
        }
        refreshTable();
    }

    public void style22() {
        if (style22) {
            checkStyle22.setSelected(false);
            style22 = false;
        } else {
            checkStyle22.setSelected(true);
            style22 = true;
        }
        refreshTable();
    }

    private void setDisableStyle(boolean bool) {
        checkStyle1.setDisable(bool);
        checkStyleSub.setDisable(bool);
        checkStyle2.setDisable(bool);
        checkStyle3.setDisable(bool);
        checkStyle4.setDisable(bool);
        checkStyle5.setDisable(bool);
        checkStyle6.setDisable(bool);
        checkStyle7.setDisable(bool);
        checkStyle8.setDisable(bool);
        checkStyle9.setDisable(bool);
        checkStyle10.setDisable(bool);
        checkStyle11.setDisable(bool);
        checkStyle12.setDisable(bool);
        checkStyle13.setDisable(bool);
        checkStyle14.setDisable(bool);
        checkStyle15.setDisable(bool);
        checkStyle16.setDisable(bool);
        checkStyle17.setDisable(bool);
        checkStyle18.setDisable(bool);
        checkStyle19.setDisable(bool);
        checkStyle20.setDisable(bool);
        checkStyle21.setDisable(bool);
        checkStyle22.setDisable(bool);
    }


    //difficulty select toggles

    public void diffAll() {
        if (diffAll) {
            checkDiffAll.setSelected(false);
            setDisableDiff(false);
            diffAll = false;
        } else {
            checkDiffAll.setSelected(true);
            setDisableDiff(true);
            diffAll = true;
        }
        refreshTable();
    }

    public void diffN() {
        if (diffN) {
            checkDiffN.setSelected(false);
            diffN = false;
        }
        else {
            checkDiffN.setSelected(true);
            diffN = true;
        }
        refreshTable();
    }

    public void diffH() {
        if (diffH) {
            checkDiffH.setSelected(false);
            diffH = false;
        }
        else {
            checkDiffH.setSelected(true);
            diffH = true;
        }
        refreshTable();
    }

    public void diffA() {
        if (diffA) {
            checkDiffA.setSelected(false);
            diffA = false;
        }
        else {
            checkDiffA.setSelected(true);
            diffA = true;
        }
        refreshTable();
    }

    public void diffB() {
        if (diffB) {
            checkDiffB.setSelected(false);
            diffB = false;
        }
        else {
            checkDiffB.setSelected(true);
            diffB = true;
        }
        refreshTable();
    }

    public void diffL() {
        if (diffL) {
            checkDiffL.setSelected(false);
            diffL = false;
        }
        else {
            checkDiffL.setSelected(true);
            diffL = true;
        }
        refreshTable();
    }

    private void setDisableDiff(boolean bool) {
        checkDiffN.setDisable(bool);
        checkDiffH.setDisable(bool);
        checkDiffA.setDisable(bool);
        checkDiffB.setDisable(bool);
        checkDiffL.setDisable(bool);
    }

    //workaround for refreshing the table data
    //threading this sometimes causes nullpointerexception
    private void refreshTable() {
        if (filterField.getText().isEmpty() || filterField.getText().equals("")) {
            filterField.setText(",");
            filterField.setText("");
        } else {
            final String tmp = filterField.getText();
            filterField.setText(",");
            filterField.setText(tmp);
        }
    }

    public void setClearColors() {
        Main.programClearColor = !Main.programClearColor;
        refreshTable();
    }

    public void setThemeLight() {
        radioMenuLight.setSelected(true);
        radioMenuDark.setSelected(false);
        Main.programTheme = Main.THEMELIGHT;
        applyTheme();
    }

    /** Theme **/

    public void setThemeDark() {
        radioMenuDark.setSelected(true);
        radioMenuLight.setSelected(false);
        Main.programTheme = Main.THEMEDARK;
        applyTheme();
    }

    private void applyTheme() {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/css/clear.css").toExternalForm());
        if (Main.programTheme.equals(Main.THEMELIGHT)) scene.getStylesheets().add(getClass().getResource("/css/modena-adjust.css").toExternalForm());
        else scene.getStylesheets().add(getClass().getResource("/css/dark.css").toExternalForm());
        refreshTable();
    }

    public void quit() {
        ((Stage)scene.getWindow()).close();
        boolean[] columnVisibility = {styleColumn.isVisible(), titleColumn.isVisible(), artistColumn.isVisible(),
                genreColumn.isVisible(), difficultyColumn.isVisible(), levelColumn.isVisible(),
                ratingNColumn.isVisible(), ratingHColumn.isVisible(), bpmColumn.isVisible(), lengthColumn.isVisible(),
                notesColumn.isVisible(), clearColumn.isVisible(), gradeColumn.isVisible(), missColumn.isVisible()};
        Main.setProperties(columnVisibility);
    }

    public void importData() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/import.fxml"));
            GridPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.getIcons().add(new Image(getClass().getResource("/img/icon32.png").toString()));
            dialogStage.getIcons().add(new Image(getClass().getResource("/img/icon256.png").toString()));
            dialogStage.setResizable(false);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            ImportController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
            if (controller.getStatus() == ImportController.SUCCESS) {
                Main.findScoreFile();
                boolean[] columnVisibility = {styleColumn.isVisible(), titleColumn.isVisible(), artistColumn.isVisible(),
                        genreColumn.isVisible(), difficultyColumn.isVisible(), levelColumn.isVisible(),
                        ratingNColumn.isVisible(), ratingHColumn.isVisible(), bpmColumn.isVisible(), lengthColumn.isVisible(),
                        notesColumn.isVisible(), clearColumn.isVisible(), gradeColumn.isVisible(), missColumn.isVisible()};
                Main.setProperties(columnVisibility);
                onStartTableView();
                clearColumn.setVisible(true);
                gradeColumn.setVisible(true);
                missColumn.setVisible(true);
                refreshTable();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void about() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/about.fxml"));
            VBox page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle(Main.PROGRAMNAME);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setResizable(false);
            dialogStage.getIcons().add(new Image(getClass().getResource("/img/icon32.png").toString()));
            dialogStage.getIcons().add(new Image(getClass().getResource("/img/icon256.png").toString()));
            dialogStage.setResizable(false);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            AboutController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}