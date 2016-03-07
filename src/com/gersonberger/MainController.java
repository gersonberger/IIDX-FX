package com.gersonberger;

import javafx.animation.FadeTransition;
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
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.textfield.TextFields;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.*;
import java.util.List;


public class MainController implements Initializable {

    @FXML
    private TabPane tabPane;

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
    @FXML
    private TableColumn<SongEntry, String> exColumn;

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

    /***** CLEAR BUTTONS *****/
    @FXML
    private CheckBox checkClearAll;
    @FXML
    private CheckBox checkClearNoplay;
    @FXML
    private CheckBox checkClearFailed;
    @FXML
    private CheckBox checkClearAssistclear;
    @FXML
    private CheckBox checkClearEasyclear;
    @FXML
    private CheckBox checkClearClear;
    @FXML
    private CheckBox checkClearHardclear;
    @FXML
    private CheckBox checkClearExhardclear;
    @FXML
    private CheckBox checkClearFullcombo;

    /***** DAN *****/
    @FXML
    private ComboBox<String> danStyleSelectBox;
    @FXML
    private Label kaiden1;
    @FXML
    private Label kaiden2;
    @FXML
    private Label kaiden3;
    @FXML
    private Label kaiden4;
    @FXML
    private Label tenthdan1;
    @FXML
    private Label tenthdan2;
    @FXML
    private Label tenthdan3;
    @FXML
    private Label tenthdan4;
    @FXML
    private Label ninthdan1;
    @FXML
    private Label ninthdan2;
    @FXML
    private Label ninthdan3;
    @FXML
    private Label ninthdan4;
    @FXML
    private Label eighthdan1;
    @FXML
    private Label eighthdan2;
    @FXML
    private Label eighthdan3;
    @FXML
    private Label eighthdan4;
    @FXML
    private Label seventhdan1;
    @FXML
    private Label seventhdan2;
    @FXML
    private Label seventhdan3;
    @FXML
    private Label seventhdan4;
    @FXML
    private Label sixthdan1;
    @FXML
    private Label sixthdan2;
    @FXML
    private Label sixthdan3;
    @FXML
    private Label sixthdan4;
    @FXML
    private Label fifthdan1;
    @FXML
    private Label fifthdan2;
    @FXML
    private Label fifthdan3;
    @FXML
    private Label fifthdan4;
    @FXML
    private Label fourthdan1;
    @FXML
    private Label fourthdan2;
    @FXML
    private Label fourthdan3;
    @FXML
    private Label fourthdan4;
    @FXML
    private Label thirddan1;
    @FXML
    private Label thirddan2;
    @FXML
    private Label thirddan3;
    @FXML
    private Label thirddan4;
    @FXML
    private Label seconddan1;
    @FXML
    private Label seconddan2;
    @FXML
    private Label seconddan3;
    @FXML
    private Label seconddan4;
    @FXML
    private Label firstdan1;
    @FXML
    private Label firstdan2;
    @FXML
    private Label firstdan3;
    @FXML
    private Label firstdan4;
    @FXML
    private Label firstkyu1;
    @FXML
    private Label firstkyu2;
    @FXML
    private Label firstkyu3;
    @FXML
    private Label firstkyu4;
    @FXML
    private Label secondkyu1;
    @FXML
    private Label secondkyu2;
    @FXML
    private Label secondkyu3;
    @FXML
    private Label secondkyu4;
    @FXML
    private Label thirdkyu1;
    @FXML
    private Label thirdkyu2;
    @FXML
    private Label thirdkyu3;
    @FXML
    private Label thirdkyu4;
    @FXML
    private Label fourthkyu1;
    @FXML
    private Label fourthkyu2;
    @FXML
    private Label fourthkyu3;
    @FXML
    private Label fourthkyu4;
    @FXML
    private Label fifthkyu1;
    @FXML
    private Label fifthkyu2;
    @FXML
    private Label fifthkyu3;
    @FXML
    private Label fifthkyu4;
    @FXML
    private Label sixthkyu1;
    @FXML
    private Label sixthkyu2;
    @FXML
    private Label sixthkyu3;
    @FXML
    private Label sixthkyu4;
    @FXML
    private Label seventhkyu1;
    @FXML
    private Label seventhkyu2;
    @FXML
    private Label seventhkyu3;
    @FXML
    private Label seventhkyu4;

    /***** STATISTICS *****/
    @FXML
    private Tab statisticsTab;
    @FXML
    private Label djnameLabel;
    @FXML
    private Label playeridLabel;
    @FXML
    private Label fullcomboLabel;
    @FXML
    private Label exhardLabel;
    @FXML
    private Label hardLabel;
    @FXML
    private Label clearLabel;
    @FXML
    private Label easyclearLabel;
    @FXML
    private Label assistclearLabel;
    @FXML
    private Label failLabel;
    @FXML
    private Label noplayLabel;
    @FXML
    private Label totalclearLabel;
    @FXML
    private PieChart clearPieChart;
    @FXML
    private BarChart gradeBarChart;
    @FXML
    private StackedBarChart customStackedBarChart;
    @FXML
    private StackedBarChart levelStackedBarChart;
    @FXML
    private CheckBox noPlayCheckBox;
    @FXML
    private CheckBox styleDetailsCheckBox;
    @FXML
    private CheckBox levelDetailsCheckBox;

    /***** SETTINGS *****/
    @FXML
    private RadioButton settingsRadioLight;
    @FXML
    private RadioButton settingsRadioDark;
    @FXML
    private RadioButton settingsRadioNanahira;
    @FXML
    private CheckBox settingsShowClearColorsCheckBox;
    @FXML
    private CheckBox titleSuggestionsCheckBox;
    @FXML
    private CheckBox artistSuggestionsCheckBox;
    @FXML
    private RadioButton settingsP1;
    @FXML
    private RadioButton settingsP2;
    @FXML
    private Label settingsSaveLabel;
    @FXML
    private TextFlow settingsAboutFlow;
    @FXML
    private ComboBox<String> songlistComboBox;

    /***** MISC *****/
    @FXML
    private VBox mainBox;
    @FXML
    private VBox settingsBox;
    @FXML
    private TextField filterField;
    @FXML
    private Label matchLabel;

    private Scene scene;
    private boolean settingsVisible = false;
    private boolean saveAnimationPlaying = false;
    private ObservableList<SongEntry> masterData;

    private Stats stats;

    private Set<String> titleSuggestions = new HashSet<>();
    private Set<String> artistSuggestions = new HashSet<>();
    private List<String> suggestions = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("\n" + Main.getTime() + " OS: " + System.getProperty("os.name") + "\n" + Main.getTime() +
                " VER: " + System.getProperty("os.version") + "\n" + Main.getTime() + " ARC: " +
                System.getProperty("os.arch") + "\n" + Main.getTime() + " USR: " + System.getProperty("user.name") +
                "\n" + Main.getTime() + " HOM: " + System.getProperty("user.home") + "\n" + Main.getTime() + " SEP: " +
                System.getProperty("file.separator") + "\n" + Main.getTime() + " JAV: " +
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

            Hyperlink aboutHyperlink = new Hyperlink("About");
            aboutHyperlink.setOnAction(event -> about());
            settingsAboutFlow.getChildren().add(aboutHyperlink);

            if (Main.getScoreFile() == null) {
                statisticsTab.setDisable(true);
            }

            //set setting toggles
            switch (Main.programTheme) {
                case Main.THEMELIGHT:
                    settingsRadioLight.setSelected(true);
                    break;
                case Main.THEMEDARK:
                    settingsRadioDark.setSelected(true);
                    break;
                case Main.THEMENANAHIRA:
                    settingsRadioNanahira.setSelected(true);
                    break;
            }

            settingsShowClearColorsCheckBox.setSelected(Main.programClearColor);
            songlistComboBox.setValue(Main.songlist);
            songlistComboBox.getItems().addAll(Style.OMNIMIX, Style.PENDUALFULL);

            applyTheme();
        });

        if (Main.showTitleSuggestions) titleSuggestionsCheckBox.setSelected(true);
        if (Main.showArtistSuggestions) artistSuggestionsCheckBox.setSelected(true);

        if (Main.programPlayerside.equals("1")) settingsP1.setSelected(true);
        else settingsP2.setSelected(true);

        mainBox.getChildren().remove(settingsBox);
        onStartTableView();

        setSuggestions();
        initDan();
        initStatistics();

        //initial sort AC-style
        titleColumn.setSortType(TableColumn.SortType.ASCENDING);
        levelColumn.setSortType(TableColumn.SortType.ASCENDING);
        styleColumn.setSortType(TableColumn.SortType.DESCENDING);
        tableView.getSortOrder().add(styleColumn);
        tableView.getSortOrder().add(levelColumn);
        tableView.getSortOrder().add(titleColumn);

        refreshTable();

    }

    private int lengthToInt(final String time) {
        if (time.contains(":")) {
            String[] tmp = time.split(":");
            return 60 * Integer.valueOf(tmp[0]) + Integer.valueOf(tmp[1]);
        }
        else return -1;
    }

    //custom comparators for tableviewcolumns

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
            if (o1.equals("")) return gradeColumn.getSortType() == TableColumn.SortType.ASCENDING ? 1 : -1;
            if (o2.equals("")) return gradeColumn.getSortType() == TableColumn.SortType.ASCENDING ? -1 : 1;
            String[] arr1 = o1.split(" ");
            String[] arr2 = o2.split(" ");
            if (!arr1[0].equals(arr2[0])) {
                return Grade.gradeToInt(arr1[0]) > Grade.gradeToInt(arr2[0]) ? 1 : -1;
            } else {
                arr1 = arr1[1].split("\\.");
                arr2 = arr2[1].split("\\.");
                if (arr1[0].length() != arr2[0].length()) return arr1[0].length() > arr2[0].length() ? 1 : -1;
                else {
                    for (int i = 1; i < arr1[0].length(); i++) {
                        if (Integer.parseInt(arr1[0].substring(i, i + 1)) != Integer.parseInt(arr2[0].substring(i, i + 1)))
                            return Integer.parseInt(arr1[0].substring(i, i + 1)) > Integer.parseInt(arr2[0].substring(i, i + 1)) ? 1 : -1;
                    }
                    for (int i = 0; i < arr1[1].length() - 2; i++)
                        if (Integer.parseInt(arr1[1].substring(i, i + 1)) != Integer.parseInt(arr2[1].substring(i, i + 1)))
                            return Integer.parseInt(arr1[1].substring(i, i + 1)) > Integer.parseInt(arr2[1].substring(i, i + 1)) ? 1 : -1;
                    return 0;
                }
            }
        };
    }

    private Comparator<String> getMissComparator() {
        return (o1, o2) -> {
            if (o1.equals("")) return missColumn.getSortType() == TableColumn.SortType.ASCENDING ? 1 : -1;
            if (o2.equals("")) return missColumn.getSortType() == TableColumn.SortType.ASCENDING ? -1 : 1;
            int i1 = o1.equals("") ? -2 : o1.equals("N/A") ? -1 : Integer.valueOf(o1);
            int i2 = o2.equals("") ? -2 : o2.equals("N/A") ? -1 : Integer.valueOf(o2);
            return i1 > i2 ? 1 : i1 < i2 ? -1 : 0;
        };
    }

    private Comparator<String> getExComparator() {
        return (o1, o2) -> {
            if (o1.equals("")) return exColumn.getSortType() == TableColumn.SortType.ASCENDING ? 1 : -1;
            if (o2.equals("")) return exColumn.getSortType() == TableColumn.SortType.ASCENDING ? -1 : 1;
            if (!o1.equals(o2)) return Integer.valueOf(o1) > Integer.valueOf(o2) ? 1 : -1;
            return 0;
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
        exColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEEXCOL, "false")));
        missColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEMISSCOL, "false")));

        //column automatic resizing
        final double size = 13.64;
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        styleColumn.setMaxWidth     (1f * Integer.MAX_VALUE * (double) 81/size);
        titleColumn.setMaxWidth     (1f * Integer.MAX_VALUE * (double)240/size);
        artistColumn.setMaxWidth    (1f * Integer.MAX_VALUE * (double)170/size);
        genreColumn.setMaxWidth     (1f * Integer.MAX_VALUE * (double)125/size);
        difficultyColumn.setMaxWidth(1f * Integer.MAX_VALUE * (double) 88/size);
        levelColumn.setMaxWidth     (1f * Integer.MAX_VALUE * (double) 59/size);
        ratingNColumn.setMaxWidth   (1f * Integer.MAX_VALUE * (double) 51/size);
        ratingHColumn.setMaxWidth   (1f * Integer.MAX_VALUE * (double) 51/size);
        bpmColumn.setMaxWidth       (1f * Integer.MAX_VALUE * (double) 58/size);
        lengthColumn.setMaxWidth    (1f * Integer.MAX_VALUE * (double) 68/size);
        notesColumn.setMaxWidth     (1f * Integer.MAX_VALUE * (double) 59/size);
        clearColumn.setMaxWidth     (1f * Integer.MAX_VALUE * (double) 90/size);
        gradeColumn.setMaxWidth     (1f * Integer.MAX_VALUE * (double)104/size);
        exColumn.setMaxWidth        (1f * Integer.MAX_VALUE * (double) 60/size);
        missColumn.setMaxWidth      (1f * Integer.MAX_VALUE * (double) 60/size);

        //contextmenu
        tableView.setRowFactory(param -> {
            final TableRow<SongEntry> row = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem textage = new MenuItem("Open chart in a new tab");
            textage.setOnAction(event -> textageTab(row.getItem().getId(), row.getItem().getTitle(),
                    row.getItem().getTextage(), row.getItem().getDifficulty(), row.getItem().getLevel()));
            final SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
            final MenuItem copytitle = new MenuItem("Copy title");
            copytitle.setOnAction(event -> copyToClipboard(row.getItem().getTitle()));
            final MenuItem copyartist = new MenuItem("Copy artist");
            copyartist.setOnAction(event -> copyToClipboard(row.getItem().getArtist()));
            final MenuItem copygenre = new MenuItem("Copy genre");
            copygenre.setOnAction(event -> copyToClipboard(row.getItem().getGenre()));

            contextMenu.getItems().addAll(textage, separatorMenuItem, copytitle, copyartist, copygenre);

            contextMenu.setOnShowing(event -> {
                if (row.getItem().getTextage().equals("")) {
                    textage.setDisable(true);
                }
                if (row.getItem().getTextage().equals("na")) {
                    textage.setText("No chart available");
                    textage.setDisable(true);
                }
            });

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
        exColumn.setCellValueFactory(new PropertyValueFactory<>("Ex"));

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
        exColumn.setComparator(getExComparator());
    }

    private void setTableViewData(final ObservableList<SongEntry> masterData) {
        final FilteredList<SongEntry> filteredData = new FilteredList<>(masterData);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(songEntry -> {

                //empty list
                if (songEntry == null) return false;

                // filter
                if (!checkStyleAll.isSelected()) {
                    if ((!songEntry.getStyle().equals(Style.FIRSTSTYLE) || !checkStyle1.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.SUBSTREAM) || !checkStyleSub.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.SECONDSTYLE) || !checkStyle2.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.THIRDSTYLE) || !checkStyle3.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.FOURTHSTYLE) || !checkStyle4.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.FIFTHSTYLE) || !checkStyle5.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.SIXTHSTYLE) || !checkStyle6.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.SEVENTHSTYLE) || !checkStyle7.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.EIGHTHSTYLE) || !checkStyle8.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.NINTHSTYLE) || !checkStyle9.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.TENTHSTYLE) || !checkStyle10.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.IIDXRED) || !checkStyle11.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.HAPPYSKY) || !checkStyle12.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.DISTORTED) || !checkStyle13.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.GOLD) || !checkStyle14.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.DJTROOPERS) || !checkStyle15.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.EMPRESS) || !checkStyle16.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.SIRIUS) || !checkStyle17.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.RESORTANTHEM) || !checkStyle18.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.LINCLE) || !checkStyle19.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.TRICORO) || !checkStyle20.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.SPADA) || !checkStyle21.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.PENDUAL) || !checkStyle22.isSelected())) return false;
                }

                if (!checkLevelAll.isSelected()) {
                    if ((!songEntry.getLevel().equals("1") || !checkLevel1.isSelected()) &&
                            (!songEntry.getLevel().equals("2") || !checkLevel2.isSelected()) &&
                            (!songEntry.getLevel().equals("3") || !checkLevel3.isSelected()) &&
                            (!songEntry.getLevel().equals("4") || !checkLevel4.isSelected()) &&
                            (!songEntry.getLevel().equals("5") || !checkLevel5.isSelected()) &&
                            (!songEntry.getLevel().equals("6") || !checkLevel6.isSelected()) &&
                            (!songEntry.getLevel().equals("7") || !checkLevel7.isSelected()) &&
                            (!songEntry.getLevel().equals("8") || !checkLevel8.isSelected()) &&
                            (!songEntry.getLevel().equals("9") || !checkLevel9.isSelected()) &&
                            (!songEntry.getLevel().equals("10") || !checkLevel10.isSelected()) &&
                            (!songEntry.getLevel().equals("11") || !checkLevel11.isSelected()) &&
                            (!songEntry.getLevel().equals("12") || !checkLevel12.isSelected())) return false;
                }

                if (!checkDiffAll.isSelected()) {
                    if ((!songEntry.getDifficulty().equals(Difficulty.NORMAL) || !checkDiffN.isSelected()) &&
                            (!songEntry.getDifficulty().equals(Difficulty.HYPER) || !checkDiffH.isSelected()) &&
                            (!songEntry.getDifficulty().equals(Difficulty.ANOTHER) || !checkDiffA.isSelected()) &&
                            (!songEntry.getDifficulty().equals(Difficulty.BLACKANOTHER) || !checkDiffB.isSelected()) &&
                            (!songEntry.getDifficulty().equals(Difficulty.LEGGENDARIA) || !checkDiffL.isSelected()))
                        return false;
                }

                if (!checkClearAll.isSelected()) {
                    if ((!songEntry.getClear().equals(Clear.NOPLAY_NOTEXT) || !checkClearNoplay.isSelected()) &&
                            (!songEntry.getClear().equals(Clear.FAILED) || !checkClearFailed.isSelected()) &&
                            (!songEntry.getClear().equals(Clear.ASSISTCLEAR) || !checkClearAssistclear.isSelected()) &&
                            (!songEntry.getClear().equals(Clear.EASYCLEAR) || !checkClearEasyclear.isSelected()) &&
                            (!songEntry.getClear().equals(Clear.CLEAR) || !checkClearClear.isSelected()) &&
                            (!songEntry.getClear().equals(Clear.HARDCLEAR) || !checkClearHardclear.isSelected()) &&
                            (!songEntry.getClear().equals(Clear.EXHARDCLEAR) || !checkClearExhardclear.isSelected()) &&
                            (!songEntry.getClear().equals(Clear.FULLCOMBO) || !checkClearFullcombo.isSelected()))
                        return false;
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

    private void onStartTableView() {
        masterData = FXCollections.observableArrayList();
        List<SongEntry> entries = new ArrayList<>();

        String chartlistFile;
        String idlistFile;
        switch (Main.songlist) {
            case Style.OMNIMIX:
                chartlistFile = "chartlist.txt";
                idlistFile = "idlist.txt";
                break;
            case Style.PENDUALFULL:
                chartlistFile = "chartlist_22.txt";
                idlistFile = "idlist_22.txt";
                break;
            default:
                System.err.println("UNKNOWN SONGLIST REQUESTED\nUSING OMNIMIX AS DEFAULT");
                chartlistFile = "chartlist.txt";
                idlistFile = "idlist.txt";
        }

        InputStream chartInputStream = getClass().getResourceAsStream("/data/" + chartlistFile);
        InputStream idInputStream = getClass().getResourceAsStream("/data/" + idlistFile);
        File scoreFile = Main.getScoreFile();

        if (chartInputStream != null && idInputStream != null) {

            String[] data;
            String[][] idList = new String[22200][6];
            String[][][] clearList = null;

            //read idlist
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
                        idList[id][5] = data.length > 6 ? data[6] : ""; //textage

                        //add title and artist to suggestions
                        if (!titleSuggestions.contains(data[1])) titleSuggestions.add(data[1]); //title
                        if (!artistSuggestions.contains(data[3])) artistSuggestions.add(data[3]); //artist
                    }
                    line = bufferedReader.readLine();
                }

                //read scorelist
                if (scoreFile != null) {
                    FileInputStream scoreFileInputStream = new FileInputStream(scoreFile);
                    InputStreamReader scoreInputStreamReader = new InputStreamReader(scoreFileInputStream, "UTF-8");
                    bufferedReader = new BufferedReader(scoreInputStreamReader);
                    line = bufferedReader.readLine();
                    clearList = new String[22200][3][4];
                    int dif_int;
                    while (line != null) {
                        if (!line.startsWith("//") && !line.isEmpty() && !line.equals("")) {
                            data = line.split(",");
                            id = Integer.parseInt(data[0]); //id
                            dif_int = Integer.parseInt(data[1]) - 1;
                            if (dif_int > 2) dif_int = 2;
                            clearList[id][dif_int][0] = data[2]; //clear
                            clearList[id][dif_int][1] = data[3]; //miss
                            clearList[id][dif_int][2] = data[4]; //grade
                            clearList[id][dif_int][3] = data[5]; //percent
                        }
                        line = bufferedReader.readLine();
                    }
                }

                //read chartlist, merge data, create entries
                bufferedReader = new BufferedReader(new InputStreamReader(chartInputStream, "UTF-8"));
                line = bufferedReader.readLine();
                String title, title_r, artist, artist_r, genre, difficulty, grade, percent, textage;
                int style, difficulty_int, level, nRating, hRating, bpmMin, bpmMax, length, notes, clear, miss, ex;
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
                        textage = idList[id][5];
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
                                percent = clearList[id][difficulty_int - 1][3];
                                if (percent.split("\\.")[1].length() < 2) percent += 0;
                                grade = clearList[id][difficulty_int - 1][2] + " (" + percent + "%)";
                                miss = Integer.parseInt(clearList[id][difficulty_int - 1][1]);
                                ex = getExScore(clearList[id][difficulty_int - 1][3], notes);
                            } else {
                                clear = 0;
                                grade = "";
                                miss = -2;
                                ex = 0;
                            }
                        } else {
                            clear = 0;
                            grade = "";
                            miss = -2;
                            ex = 0;
                        }
                        entries.add(new SongEntry(id, style, title, title_r, artist, artist_r, genre, difficulty, level,
                                nRating, hRating, bpmMin, bpmMax, length, notes, clear, grade, miss, ex, textage));
                    }
                    line = bufferedReader.readLine();
                }
                System.out.println(Main.getTime() + " created " + entries.size() + " entries");
                masterData.addAll(entries);
                System.out.println(Main.getTime() + " added entries to masterdata");
                initColumns();
                setTableViewData(masterData);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println(Main.getTime() + " INIT FAILED");
                System.exit(-1);
            }
        }
    }

    //songid to style translation for blackanother and substream charts
    private int getStyleFromID(int songID) {
        if (songID == 21244 || songID == 21241 || songID == 21240 || songID == 21257 || songID == 21238 ||
                songID == 21260 || songID == 21242 || songID == 21245 || songID == 21250 || songID == 21252 ||
                songID == 21253 || songID == 21256 || songID == 21254 || songID == 21255 || songID == 21247 ||
                songID == 21258 || songID == 21259 || songID == 21251 || songID == 21246 || songID == 21249 ||
                songID == 21243 || songID == 21262 || songID == 21239) return Style.EMPRESSINT;
        else if (songID == 21223 || songID == 21235 || songID == 21225 || songID == 21232 || songID == 21261 ||
                songID == 21231 || songID == 21234 || songID == 21228 || songID == 21263 || songID == 21226 ||
                songID == 21233 || songID == 21229 || songID == 21237 || songID == 21236 || songID == 21224) return Style.DJTROOPERSINT;
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

    //calculate ex score
    private int getExScore(String percentage, int notes) {
        return (int)Math.round(notes * 2 * (Double.valueOf(percentage) / 100));
    }

    @FXML
    private void hideSettings() {
        settingsVisible = !settingsVisible;
        if (!settingsVisible) mainBox.getChildren().remove(settingsBox);
        else  mainBox.getChildren().add(1, settingsBox);
    }


    //level select toggles
    @FXML
    private void levelAll() {
        if (checkLevelAll.isSelected()) {
            checkLevel1.setSelected(false);
            checkLevel2.setSelected(false);
            checkLevel3.setSelected(false);
            checkLevel4.setSelected(false);
            checkLevel5.setSelected(false);
            checkLevel6.setSelected(false);
            checkLevel7.setSelected(false);
            checkLevel8.setSelected(false);
            checkLevel9.setSelected(false);
            checkLevel10.setSelected(false);
            checkLevel11.setSelected(false);
            checkLevel12.setSelected(false);
        }
        checkLevelAll.setSelected(checkLevelAll.isSelected());
        refreshTable();
    }

    @FXML
    private void level1() {
        if (checkLevel1.isSelected()) checkLevelAll.setSelected(false);
        checkLevel1.setSelected(checkLevel1.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level2() {
        if (checkLevel2.isSelected()) checkLevelAll.setSelected(false);
        checkLevel2.setSelected(checkLevel2.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level3() {
        if (checkLevel3.isSelected()) checkLevelAll.setSelected(false);
        checkLevel3.setSelected(checkLevel3.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level4() {
        if (checkLevel4.isSelected()) checkLevelAll.setSelected(false);
        checkLevel4.setSelected(checkLevel4.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level5() {
        if (checkLevel5.isSelected()) checkLevelAll.setSelected(false);
        checkLevel5.setSelected(checkLevel5.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level6() {
        if (checkLevel6.isSelected()) checkLevelAll.setSelected(false);
        checkLevel6.setSelected(checkLevel6.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level7() {
        if (checkLevel7.isSelected()) checkLevelAll.setSelected(false);
        checkLevel7.setSelected(checkLevel7.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level8() {
        if (checkLevel8.isSelected()) checkLevelAll.setSelected(false);
        checkLevel8.setSelected(checkLevel8.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level9() {
        if (checkLevel9.isSelected()) checkLevelAll.setSelected(false);
        checkLevel9.setSelected(checkLevel9.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level10() {
        if (checkLevel10.isSelected()) checkLevelAll.setSelected(false);
        checkLevel10.setSelected(checkLevel10.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level11() {
        if (checkLevel11.isSelected()) checkLevelAll.setSelected(false);
        checkLevel11.setSelected(checkLevel11.isSelected());
        levelempty();
        refreshTable();
    }

    @FXML
    private void level12() {
        if (checkLevel12.isSelected()) checkLevelAll.setSelected(false);
        checkLevel12.setSelected(checkLevel12.isSelected());
        levelempty();
        refreshTable();
    }

    private void levelempty() {
        if (!checkLevelAll.isSelected() && !checkLevel1.isSelected() && !checkLevel2.isSelected() &&
                !checkLevel3.isSelected() && !checkLevel4.isSelected() && !checkLevel5.isSelected() &&
                !checkLevel6.isSelected() && !checkLevel7.isSelected() && !checkLevel8.isSelected() &&
                !checkLevel9.isSelected() && !checkLevel10.isSelected() && !checkLevel11.isSelected() &&
                !checkLevel12.isSelected()) checkLevelAll.setSelected(true);
    }

    //style select toggles
    @FXML
    private void styleAll() {
        if (checkStyleAll.isSelected()) {
            checkStyle1.setSelected(false);
            checkStyleSub.setSelected(false);
            checkStyle2.setSelected(false);
            checkStyle3.setSelected(false);
            checkStyle4.setSelected(false);
            checkStyle5.setSelected(false);
            checkStyle6.setSelected(false);
            checkStyle7.setSelected(false);
            checkStyle8.setSelected(false);
            checkStyle9.setSelected(false);
            checkStyle10.setSelected(false);
            checkStyle11.setSelected(false);
            checkStyle12.setSelected(false);
            checkStyle13.setSelected(false);
            checkStyle14.setSelected(false);
            checkStyle15.setSelected(false);
            checkStyle16.setSelected(false);
            checkStyle17.setSelected(false);
            checkStyle18.setSelected(false);
            checkStyle19.setSelected(false);
            checkStyle20.setSelected(false);
            checkStyle21.setSelected(false);
            checkStyle22.setSelected(false);
        }
        checkStyleAll.setSelected(checkStyleAll.isSelected());
        refreshTable();
    }

    @FXML
    private void style1() {
        if (checkStyle1.isSelected()) checkStyleAll.setSelected(false);
        checkStyle1.setSelected(checkStyle1.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void styleSub() {
        if (checkStyleSub.isSelected()) checkStyleAll.setSelected(false);
        checkStyleSub.setSelected(checkStyleSub.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style2() {
        if (checkStyle2.isSelected()) checkStyleAll.setSelected(false);
        checkStyle2.setSelected(checkStyle2.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style3() {
        if (checkStyle3.isSelected()) checkStyleAll.setSelected(false);
        checkStyle3.setSelected(checkStyle3.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style4() {
        if (checkStyle4.isSelected()) checkStyleAll.setSelected(false);
        checkStyle4.setSelected(checkStyle4.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style5() {
        if (checkStyle5.isSelected()) checkStyleAll.setSelected(false);
        checkStyle5.setSelected(checkStyle5.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style6() {
        if (checkStyle6.isSelected()) checkStyleAll.setSelected(false);
        checkStyle6.setSelected(checkStyle6.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style7() {
        if (checkStyle7.isSelected()) checkStyleAll.setSelected(false);
        checkStyle7.setSelected(checkStyle7.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style8() {
        if (checkStyle8.isSelected()) checkStyleAll.setSelected(false);
        checkStyle8.setSelected(checkStyle8.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style9() {
        if (checkStyle9.isSelected()) checkStyleAll.setSelected(false);
        checkStyle9.setSelected(checkStyle9.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style10() {
        if (checkStyle10.isSelected()) checkStyleAll.setSelected(false);
        checkStyle10.setSelected(checkStyle10.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style11() {
        if (checkStyle11.isSelected()) checkStyleAll.setSelected(false);
        checkStyle11.setSelected(checkStyle11.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style12() {
        if (checkStyle12.isSelected()) checkStyleAll.setSelected(false);
        checkStyle12.setSelected(checkStyle12.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style13() {
        if (checkStyle13.isSelected()) checkStyleAll.setSelected(false);
        checkStyle13.setSelected(checkStyle13.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style14() {
        if (checkStyle14.isSelected()) checkStyleAll.setSelected(false);
        checkStyle14.setSelected(checkStyle14.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style15() {
        if (checkStyle15.isSelected()) checkStyleAll.setSelected(false);
        checkStyle15.setSelected(checkStyle15.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style16() {
        if (checkStyle16.isSelected()) checkStyleAll.setSelected(false);
        checkStyle16.setSelected(checkStyle16.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style17() {
        if (checkStyle17.isSelected()) checkStyleAll.setSelected(false);
        checkStyle17.setSelected(checkStyle17.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style18() {
        if (checkStyle18.isSelected()) checkStyleAll.setSelected(false);
        checkStyle18.setSelected(checkStyle18.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style19() {
        if (checkStyle19.isSelected()) checkStyleAll.setSelected(false);
        checkStyle19.setSelected(checkStyle19.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style20() {
        if (checkStyle20.isSelected()) checkStyleAll.setSelected(false);
        checkStyle20.setSelected(checkStyle20.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style21() {
        if (checkStyle21.isSelected()) checkStyleAll.setSelected(false);
        checkStyle21.setSelected(checkStyle21.isSelected());
        styleempty();
        refreshTable();
    }

    @FXML
    private void style22() {
        if (checkStyle22.isSelected()) checkStyleAll.setSelected(false);
        checkStyle22.setSelected(checkStyle22.isSelected());
        styleempty();
        refreshTable();
    }

    private void styleempty() {
        if (!checkStyle1.isSelected() && !checkStyleSub.isSelected() && !checkStyle2.isSelected() &&
                !checkStyle3.isSelected() && !checkStyle4.isSelected() && !checkStyle5.isSelected() &&
                !checkStyle6.isSelected() && !checkStyle7.isSelected() && !checkStyle8.isSelected() &&
                !checkStyle9.isSelected() && !checkStyle10.isSelected() && !checkStyle11.isSelected() &&
                !checkStyle12.isSelected() && !checkStyle13.isSelected() && !checkStyle14.isSelected() &&
                !checkStyle15.isSelected() && !checkStyle16.isSelected() && !checkStyle17.isSelected() &&
                !checkStyle18.isSelected() && !checkStyle19.isSelected() && !checkStyle20.isSelected() &&
                !checkStyle21.isSelected() && !checkStyle22.isSelected()) checkStyleAll.setSelected(true);
    }


    //difficulty select toggles
    @FXML
    private void diffAll() {
        if (checkDiffAll.isSelected()) {
            checkDiffN.setSelected(false);
            checkDiffH.setSelected(false);
            checkDiffA.setSelected(false);
            checkDiffB.setSelected(false);
            checkDiffL.setSelected(false);
        }
        checkDiffAll.setSelected(checkDiffAll.isSelected());
        refreshTable();
    }

    @FXML
    private void diffN() {
        if (checkDiffN.isSelected()) checkDiffAll.setSelected(false);
        checkDiffN.setSelected(checkDiffN.isSelected());
        diffempty();
        refreshTable();
    }

    @FXML
    private void diffH() {
        if (checkDiffH.isSelected()) checkDiffAll.setSelected(false);
        checkDiffH.setSelected(checkDiffH.isSelected());
        diffempty();
        refreshTable();
    }

    @FXML
    private void diffA() {
        if (checkDiffA.isSelected()) checkDiffAll.setSelected(false);
        checkDiffA.setSelected(checkDiffA.isSelected());
        diffempty();
        refreshTable();
    }

    @FXML
    private void diffB() {
        if (checkDiffB.isSelected()) checkDiffAll.setSelected(false);
        checkDiffB.setSelected(checkDiffB.isSelected());
        diffempty();
        refreshTable();
    }

    @FXML
    private void diffL() {
        if (checkDiffL.isSelected()) checkDiffAll.setSelected(false);
        checkDiffL.setSelected(checkDiffL.isSelected());
        diffempty();
        refreshTable();
    }

    private void diffempty() {
        if (!checkDiffN.isSelected() && !checkDiffH.isSelected() && !checkDiffA.isSelected() &&
                !checkDiffL.isSelected() && !checkDiffB.isSelected()) checkDiffAll.setSelected(true);
    }

    //clear select toggles
    @FXML
    private void clearAll() {
        if (checkClearAll.isSelected()) {
            checkClearNoplay.setSelected(false);
            checkClearFailed.setSelected(false);
            checkClearAssistclear.setSelected(false);
            checkClearEasyclear.setSelected(false);
            checkClearClear.setSelected(false);
            checkClearHardclear.setSelected(false);
            checkClearExhardclear.setSelected(false);
            checkClearFullcombo.setSelected(false);
        }
        checkClearAll.setSelected(checkClearAll.isSelected());
        refreshTable();
    }

    @FXML
    private void clearNoplay() {
        if (checkClearNoplay.isSelected()) checkClearAll.setSelected(false);
        checkClearNoplay.setSelected(checkClearNoplay.isSelected());
        clearempty();
        refreshTable();
    }

    @FXML
    private void clearFailed() {
        if (checkClearFailed.isSelected()) checkClearAll.setSelected(false);
        checkClearFailed.setSelected(checkClearFailed.isSelected());
        clearempty();
        refreshTable();
    }

    @FXML
    private void clearAssistclear() {
        if (checkClearAssistclear.isSelected()) checkClearAll.setSelected(false);
        checkClearAssistclear.setSelected(checkClearAssistclear.isSelected());
        clearempty();
        refreshTable();
    }

    @FXML
    private void clearEasyclear() {
        if (checkClearEasyclear.isSelected()) checkClearAll.setSelected(false);
        checkClearEasyclear.setSelected(checkClearEasyclear.isSelected());
        clearempty();
        refreshTable();
    }

    @FXML
    private void clearClear() {
        if (checkClearClear.isSelected()) checkClearAll.setSelected(false);
        checkClearClear.setSelected(checkClearClear.isSelected());
        clearempty();
        refreshTable();
    }

    @FXML
    private void clearHardclear() {
        if (checkClearHardclear.isSelected()) checkClearAll.setSelected(false);
        checkClearHardclear.setSelected(checkClearHardclear.isSelected());
        clearempty();
        refreshTable();
    }

    @FXML
    private void clearExhardclear() {
        if (checkClearExhardclear.isSelected()) checkClearAll.setSelected(false);
        checkClearExhardclear.setSelected(checkClearExhardclear.isSelected());
        clearempty();
        refreshTable();
    }

    @FXML
    private void clearFullcombo() {
        if (checkClearFullcombo.isSelected()) checkClearAll.setSelected(false);
        checkClearFullcombo.setSelected(checkClearFullcombo.isSelected());
        clearempty();
        refreshTable();
    }

    private void clearempty() {
        if (!checkClearNoplay.isSelected() && !checkClearFailed.isSelected() &&
                !checkClearAssistclear.isSelected() && !checkClearEasyclear.isSelected() &&
                !checkClearClear.isSelected() && !checkClearHardclear.isSelected() &&
                !checkClearExhardclear.isSelected() && !checkClearFullcombo.isSelected())
            checkClearAll.setSelected(true);
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

    @FXML
    private void setThemeLight() {
        settingsRadioLight.setSelected(true);
        settingsRadioDark.setSelected(false);
        settingsRadioNanahira.setSelected(false);
    }

    @FXML
    private void setThemeDark() {
        settingsRadioLight.setSelected(false);
        settingsRadioDark.setSelected(true);
        settingsRadioNanahira.setSelected(false);
    }

    @FXML
    private void setThemeNanahira(){
        settingsRadioLight.setSelected(false);
        settingsRadioDark.setSelected(false);
        settingsRadioNanahira.setSelected(true);
    }

    @FXML
    private void applyTheme() {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMECLEARCOLORS).toExternalForm());
        switch (Main.programTheme) {
            case Main.THEMELIGHT:
                scene.getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMELIGHT).toExternalForm());
                break;
            case Main.THEMEDARK:
                scene.getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMEDARK).toExternalForm());
                break;
            case Main.THEMENANAHIRA:
                scene.getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMENANAHIRA).toExternalForm());
                break;
            default:
                scene.getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMELIGHT).toExternalForm());
                break;
        }
        refreshTable();
    }

    public void setP1() {
        settingsP1.setSelected(true);
        settingsP2.setSelected(false);
    }

    public void setP2() {
        settingsP2.setSelected(true);
        settingsP1.setSelected(false);
    }

    public void quit() {
        ((Stage)scene.getWindow()).close();
        boolean[] columnVisibility = {styleColumn.isVisible(), titleColumn.isVisible(), artistColumn.isVisible(),
                genreColumn.isVisible(), difficultyColumn.isVisible(), levelColumn.isVisible(),
                ratingNColumn.isVisible(), ratingHColumn.isVisible(), bpmColumn.isVisible(), lengthColumn.isVisible(),
                notesColumn.isVisible(), clearColumn.isVisible(), gradeColumn.isVisible(), exColumn.isVisible(),
                missColumn.isVisible()};
        Main.setProperties(columnVisibility);
    }

    @FXML
    private void importData() {
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
                boolean[] columnVisibility = {styleColumn.isVisible(), titleColumn.isVisible(),
                        artistColumn.isVisible(), genreColumn.isVisible(), difficultyColumn.isVisible(),
                        levelColumn.isVisible(), ratingNColumn.isVisible(), ratingHColumn.isVisible(),
                        bpmColumn.isVisible(), lengthColumn.isVisible(), notesColumn.isVisible(),
                        clearColumn.isVisible(), gradeColumn.isVisible(), exColumn.isVisible(), missColumn.isVisible()};
                Main.setProperties(columnVisibility);
                onStartTableView();

                //display columns on success
                clearColumn.setVisible(true);
                gradeColumn.setVisible(true);
                missColumn.setVisible(true);
                exColumn.setVisible(true);

                initStatistics();
                if (statisticsTab.isDisabled()) statisticsTab.setDisable(false);

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

    private void initDan() {
        danStyleSelectBox.setValue(Style.PENDUALFULL);
        danStyleSelectBox.getItems().addAll(Style.PENDUALFULL, Style.SPADAFULL, Style.TRICOROFULL, Style.LINCLEFULL,
                Style.RESORTANTHEMFULL, Style.SIRIUSFULL, Style.EMPRESSFULL);
        danStyleSelectBox.valueProperty().addListener((observable, oldValue, newValue) -> setDanData(Style.styleFullToInt(newValue)));
        setDanData(Style.PENDUALINT);
    }

    private void setDanData(int style) {
        style = 22 - style;
        for (int i = 0; i < 18; i++) {
            if (i == 0) {
                kaiden1.setText(Dan.danData[style][i][0]);
                kaiden2.setText(Dan.danData[style][i][1]);
                kaiden3.setText(Dan.danData[style][i][2]);
                kaiden4.setText(Dan.danData[style][i][3]);
            } else if (i == 1) {
                tenthdan1.setText(Dan.danData[style][i][0]);
                tenthdan2.setText(Dan.danData[style][i][1]);
                tenthdan3.setText(Dan.danData[style][i][2]);
                tenthdan4.setText(Dan.danData[style][i][3]);
            } else if (i == 2) {
                ninthdan1.setText(Dan.danData[style][i][0]);
                ninthdan2.setText(Dan.danData[style][i][1]);
                ninthdan3.setText(Dan.danData[style][i][2]);
                ninthdan4.setText(Dan.danData[style][i][3]);
            } else if (i == 3) {
                eighthdan1.setText(Dan.danData[style][i][0]);
                eighthdan2.setText(Dan.danData[style][i][1]);
                eighthdan3.setText(Dan.danData[style][i][2]);
                eighthdan4.setText(Dan.danData[style][i][3]);
            } else if (i == 4) {
                seventhdan1.setText(Dan.danData[style][i][0]);
                seventhdan2.setText(Dan.danData[style][i][1]);
                seventhdan3.setText(Dan.danData[style][i][2]);
                seventhdan4.setText(Dan.danData[style][i][3]);
            } else if (i == 5) {
                sixthdan1.setText(Dan.danData[style][i][0]);
                sixthdan2.setText(Dan.danData[style][i][1]);
                sixthdan3.setText(Dan.danData[style][i][2]);
                sixthdan4.setText(Dan.danData[style][i][3]);
            } else if (i == 6) {
                fifthdan1.setText(Dan.danData[style][i][0]);
                fifthdan2.setText(Dan.danData[style][i][1]);
                fifthdan3.setText(Dan.danData[style][i][2]);
                fifthdan4.setText(Dan.danData[style][i][3]);
            } else if (i == 7) {
                fourthdan1.setText(Dan.danData[style][i][0]);
                fourthdan2.setText(Dan.danData[style][i][1]);
                fourthdan3.setText(Dan.danData[style][i][2]);
                fourthdan4.setText(Dan.danData[style][i][3]);
            } else if (i == 8) {
                thirddan1.setText(Dan.danData[style][i][0]);
                thirddan2.setText(Dan.danData[style][i][1]);
                thirddan3.setText(Dan.danData[style][i][2]);
                thirddan4.setText(Dan.danData[style][i][3]);
            } else if (i == 9) {
                seconddan1.setText(Dan.danData[style][i][0]);
                seconddan2.setText(Dan.danData[style][i][1]);
                seconddan3.setText(Dan.danData[style][i][2]);
                seconddan4.setText(Dan.danData[style][i][3]);
            } else if (i == 10) {
                firstdan1.setText(Dan.danData[style][i][0]);
                firstdan2.setText(Dan.danData[style][i][1]);
                firstdan3.setText(Dan.danData[style][i][2]);
                firstdan4.setText(Dan.danData[style][i][3]);
            } else if (i == 11) {
                firstkyu1.setText(Dan.danData[style][i][0]);
                firstkyu2.setText(Dan.danData[style][i][1]);
                firstkyu3.setText(Dan.danData[style][i][2]);
                firstkyu4.setText(Dan.danData[style][i][3]);
            } else if (i == 12) {
                secondkyu1.setText(Dan.danData[style][i][0]);
                secondkyu2.setText(Dan.danData[style][i][1]);
                secondkyu3.setText(Dan.danData[style][i][2]);
                secondkyu4.setText(Dan.danData[style][i][3]);
            } else if (i == 13) {
                thirdkyu1.setText(Dan.danData[style][i][0]);
                thirdkyu2.setText(Dan.danData[style][i][1]);
                thirdkyu3.setText(Dan.danData[style][i][2]);
                thirdkyu4.setText(Dan.danData[style][i][3]);
            } else if (i == 14) {
                fourthkyu1.setText(Dan.danData[style][i][0]);
                fourthkyu2.setText(Dan.danData[style][i][1]);
                fourthkyu3.setText(Dan.danData[style][i][2]);
                fourthkyu4.setText(Dan.danData[style][i][3]);
            } else if (i == 15) {
                fifthkyu1.setText(Dan.danData[style][i][0]);
                fifthkyu2.setText(Dan.danData[style][i][1]);
                fifthkyu3.setText(Dan.danData[style][i][2]);
                fifthkyu4.setText(Dan.danData[style][i][3]);
            } else if (i == 16) {
                sixthkyu1.setText(Dan.danData[style][i][0]);
                sixthkyu2.setText(Dan.danData[style][i][1]);
                sixthkyu3.setText(Dan.danData[style][i][2]);
                sixthkyu4.setText(Dan.danData[style][i][3]);
            } else if (i == 17) {
                seventhkyu1.setText(Dan.danData[style][i][0]);
                seventhkyu2.setText(Dan.danData[style][i][1]);
                seventhkyu3.setText(Dan.danData[style][i][2]);
                seventhkyu4.setText(Dan.danData[style][i][3]);
            }
        }
    }

    private void setSuggestions(){
        //suggestions.clear();
        if (Main.showTitleSuggestions) suggestions.addAll(titleSuggestions);
        if (Main.showArtistSuggestions) suggestions.addAll(artistSuggestions);
        TextFields.bindAutoCompletion(filterField, suggestions);
        if (suggestions.size() > 0) System.out.println(Main.getTime() + " added " + suggestions.size() + " suggestions to searchbar");
    }

    @FXML
    private void saveSettings() {
        //prevent overload by clicking the button too much
        if (!saveAnimationPlaying) {
            saveAnimationPlaying = true;

            Main.programPlayerside = settingsP1.isSelected() ? "1" : "2";
            Main.showTitleSuggestions = titleSuggestionsCheckBox.isSelected();
            Main.showArtistSuggestions = artistSuggestionsCheckBox.isSelected();

            if (!songlistComboBox.getValue().equals(Main.songlist)) {
                Main.songlist = songlistComboBox.getValue();
                onStartTableView();
                initStatistics();
                refreshTable();
            }

            if (settingsShowClearColorsCheckBox.isSelected() != Main.programClearColor) {
                Main.programClearColor = settingsShowClearColorsCheckBox.isSelected();
                refreshTable();
            }

            if (settingsRadioDark.isSelected() && !Main.programTheme.equals(Main.THEMEDARK)) {
                Main.programTheme = Main.THEMEDARK;
                applyTheme();
            }

            else if (settingsRadioLight.isSelected() && !Main.programTheme.equals(Main.THEMELIGHT)) {
                Main.programTheme = Main.THEMELIGHT;
                applyTheme();
            }

            else if (settingsRadioNanahira.isSelected() && !Main.programTheme.equals(Main.THEMENANAHIRA)) {
                Main.programTheme = Main.THEMENANAHIRA;
                applyTheme();
            }


            FadeTransition ft2 = new FadeTransition(Duration.millis(333), settingsSaveLabel);
            ft2.setFromValue(1);
            ft2.setToValue(0);
            ft2.setOnFinished(event2 -> saveAnimationPlaying = false);
            FadeTransition ft1 = new FadeTransition(Duration.millis(200), settingsSaveLabel);
            ft1.setFromValue(0);
            ft1.setToValue(1);
            ft1.setOnFinished(event1 -> new Thread(() -> {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ft2.play();
            }).start());
            new Thread(ft1::play).start();
        }
    }

    private String texStyle(int id) {
        String str;
        if (id == 22096 || id == 22097 || id == 15202 || id == 14214) str = String.valueOf(Style.COPULAINT);
        else if (id == 13212) str = String.valueOf(Style.IIDXREDINT);
        else if (id == 13203) str = String.valueOf(Style.TENTHSTYLEINT);
        else if (id == 16201 || id == 16202 || id == 16203 || id == 16204 || id == 16205 || id == 16206 || id == 16208
                || id == 16209 || id == 16210 || id == 16211 || id == 15201 || id == 15203 || id == 15206 || id == 15210
                || id == 15211 || id == 15212 || id == 15213 || id == 15214 || id == 15216 || id == 14201 || id == 14203
                || id == 14204 || id == 14205 || id == 14206 || id == 14207 || id == 14208 || id == 14209 || id == 14212
                || id == 14213 || id == 13202 || id == 13204 || id == 13205 || id == 13206 || id == 13207 || id == 13208
                || id == 13209 || id == 13210 || id == 13211 || id == 13213 || id == 13214 || id == 13201 || id == 12202
                || id == 12203 || id == 12205 || id == 11201 || id == 11202 || id == 11203 || id == 10201 || id == 10202
                || id == 10204 || id == 10205 || id == 10206 || id == 9204 || id == 9205 || id == 9201 || id == 9202
                || id == 8201 || id == 8202 || id == 8203 || id == 8204 || id == 6211 || id == 5206 || id == 5207
                || id == 5208 || id == 5209 || id == 4212 || id == 4214 || id == 4215) str = String.valueOf(Style.OTHERINT);
        else str = String.valueOf(getStyleFromID(id));
        if (str.equals("-1")) str = "s";
        return str;
    }

    private void textageTab(int id, String title, String textage, String difficulty, String level) {
        if (!textage.equals("")) {
            if (title.length() > 20) title = title.substring(0, 16) + "...";
            difficulty = Difficulty.difficultyToSingleString(difficulty);
            switch (level) {
                case "10":
                    level = "A";
                    break;
                case "11":
                    level = "B";
                    break;
                case "12":
                    level = "C";
                    break;
            }
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();

            webEngine.setPromptHandler(param -> {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/prompt.fxml"));
                    VBox page = loader.load();
                    Stage dialogStage = new Stage();
                    dialogStage.initModality(Modality.APPLICATION_MODAL);
                    dialogStage.initStyle(StageStyle.UTILITY);
                    dialogStage.getIcons().add(new Image(getClass().getResource("/img/icon32.png").toString()));
                    dialogStage.getIcons().add(new Image(getClass().getResource("/img/icon256.png").toString()));
                    dialogStage.setResizable(false);
                    Scene scene = new Scene(page);
                    dialogStage.setScene(scene);
                    PromptController controller = loader.getController();
                    controller.setDialogStage(dialogStage, param);
                    dialogStage.showAndWait();
                    if (controller.getStatus() == PromptController.SUCCESS) {
                        return controller.getValue();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            });

            webEngine.setOnAlert(param -> {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/alert.fxml"));
                    VBox page = loader.load();
                    Stage dialogStage = new Stage();
                    dialogStage.initModality(Modality.APPLICATION_MODAL);
                    dialogStage.initStyle(StageStyle.UTILITY);
                    dialogStage.getIcons().add(new Image(getClass().getResource("/img/icon32.png").toString()));
                    dialogStage.getIcons().add(new Image(getClass().getResource("/img/icon256.png").toString()));
                    dialogStage.setResizable(false);
                    Scene scene = new Scene(page);
                    dialogStage.setScene(scene);
                    AlertController controller = loader.getController();
                    controller.setDialogStage(dialogStage, param);
                    dialogStage.showAndWait();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            webEngine.load("http://textage.cc/score/" + texStyle(id) + "/" + textage + ".html?" + Main.programPlayerside + difficulty + level + "00");
            if (difficulty.toLowerCase().equals("x")) difficulty = "黒";
            Tab tab = new Tab("Chart: " + title + " [" + difficulty.toLowerCase() + "]");
            tab.setContent(webView);
            tabPane.getTabs().add(tab);
        }
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void initStatistics(){
        stats = new Stats(masterData);

        noPlayCheckBox.setSelected(true);
        styleDetailsCheckBox.setSelected(false);
        levelDetailsCheckBox.setSelected(false);

        playeridLabel.setText(Main.playerid);
        djnameLabel.setText(("DJ " + Main.djname).toUpperCase());
        fullcomboLabel.setText(String.valueOf(stats.getFullcombo()));
        exhardLabel.setText(String.valueOf(stats.getExhardclear()));
        hardLabel.setText(String.valueOf(stats.getHardclear()));
        clearLabel.setText(String.valueOf(stats.getClear()));
        easyclearLabel.setText(String.valueOf(stats.getEasyclear()));
        assistclearLabel.setText(String.valueOf(stats.getAssistclear()));
        failLabel.setText(String.valueOf(stats.getFailed()));
        noplayLabel.setText(String.valueOf(stats.getNoplay()));
        totalclearLabel.setText(String.valueOf(stats.getTotalClears()));

        fillClearPieChart();
        fillGradeBarChart();
        fillCustomStackedBarChart(false);
        fillLevelBarChart(false);
    }

    //inaccurate
    private int calcDJPoints(){
        double djpoints = 0, currentDJP, toAddDJP = 0;
        ObservableList<SongEntry> data = masterData;
        FXCollections.sort(data, (o1, o2) -> o1.getId() > o2.getId() ? 1 : o1.getId() < o2.getId() ? -1 : 0);
        int oldid = 0, newid = 0;
        for (SongEntry songEntry : data) {
            if (oldid == 0 && newid == 0)  oldid = songEntry.getId();
            newid = songEntry.getId();
            if (newid > oldid) {
                oldid = newid;
                djpoints += toAddDJP;
                toAddDJP = 0;
            }

            int c;
            switch (songEntry.getClear()) {
                case Clear.FULLCOMBO:
                    c = 30;
                    break;
                case Clear.EXHARDCLEAR:
                    c = 25;
                    break;
                case Clear.HARDCLEAR:
                    c = 20;
                    break;
                case Clear.CLEAR:
                    c = 10;
                    break;
                case Clear.EASYCLEAR:
                    c = 5;
                    break;
                default:
                    c = 0;
            }

            int l = 0;
            double p = songEntry.getEx().equals("") ? 0 : Double.valueOf(songEntry.getEx()) / (double)(2 * Integer.valueOf(songEntry.getNotes()));
            if (p > (double)8/9) l = 20;
            else if (p > (double)7/9) l = 15;
            else if (p > (double)6/9) l = 10;

            currentDJP = songEntry.getEx().equals("") ? 0 : Double.valueOf(songEntry.getEx()) * (double)(100 + c + l) / 10000;
            if (currentDJP > toAddDJP) toAddDJP = currentDJP;
        }
        return (int)djpoints;
    }

    private void fillClearPieChart(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        if (stats.getFullcombo() > 0) pieChartData.add(new PieChart.Data(Clear.FULLCOMBO, stats.getFullcombo()));
        if (stats.getExhardclear() > 0) pieChartData.add(new PieChart.Data(Clear.EXHARDCLEAR, stats.getExhardclear()));
        if (stats.getHardclear() > 0) pieChartData.add(new PieChart.Data(Clear.HARDCLEAR, stats.getHardclear()));
        if (stats.getClear() > 0) pieChartData.add(new PieChart.Data(Clear.CLEAR, stats.getClear()));
        if (stats.getEasyclear() > 0) pieChartData.add(new PieChart.Data(Clear.EASYCLEAR, stats.getEasyclear()));
        if (stats.getAssistclear() > 0) pieChartData.add(new PieChart.Data(Clear.ASSISTCLEAR, stats.getAssistclear()));
        if (stats.getFailed() > 0) pieChartData.add(new PieChart.Data(Clear.FAILED, stats.getFailed()));
        if (stats.getNoplay() > 0) pieChartData.add(new PieChart.Data(Clear.NOPLAY, stats.getNoplay()));
        clearPieChart.setData(pieChartData);
        setPieTooltips();
    }

    private void setPieTooltips(){
        for (PieChart.Data data : clearPieChart.getData()) {
            if (noPlayCheckBox.isSelected()){
                Tooltip.install(data.getNode(), new Tooltip(round(100 * data.getPieValue() / stats.getTotal(), 2) + "%"));
            } else {
                Tooltip.install(data.getNode(), new Tooltip(round(100 * data.getPieValue() / stats.getTotalWONoplay(), 2) + "%"));
            }
        }
    }

    @FXML
    private void setPieNoPlay(){
        if (!noPlayCheckBox.isSelected()) {
            clearPieChart.getData().remove(clearPieChart.getData().size() - 1);
            setPieTooltips();
        } else {
            clearPieChart.getData().add(new PieChart.Data(Clear.NOPLAY, stats.getNoplay()));
            setPieTooltips();
        }
    }

    private void fillGradeBarChart(){
        ObservableList<BarChart.Data> barChartData = FXCollections.observableArrayList();
        if (stats.getGradeAAA() > 0) barChartData.add(new BarChart.Data<>(Grade.AAA, stats.getGradeAAA()));
        if (stats.getGradeAAA() + stats.getGradeAA() > 0) barChartData.add(new BarChart.Data<>(Grade.AA, stats.getGradeAA()));
        if (stats.getGradeAAA() + stats.getGradeAA() + stats.getGradeA() > 0) barChartData.add(new BarChart.Data<>(Grade.A, stats.getGradeA()));
        if (stats.getGradeB() + stats.getGradeC() + stats.getGradeD() + stats.getGradeE() + stats.getGradeF() > 0) barChartData.add(new BarChart.Data<>(Grade.B, stats.getGradeB()));
        if (stats.getGradeC() + stats.getGradeD() + stats.getGradeE() + stats.getGradeF() > 0) barChartData.add(new BarChart.Data<>(Grade.C, stats.getGradeC()));
        if (stats.getGradeD() + stats.getGradeE() + stats.getGradeF() > 0) barChartData.add(new BarChart.Data<>(Grade.D, stats.getGradeD()));
        if (stats.getGradeE() + stats.getGradeF() > 0) barChartData.add(new BarChart.Data<>(Grade.E, stats.getGradeE()));
        if (stats.getGradeF() > 0) barChartData.add(new BarChart.Data<>(Grade.F, stats.getGradeF()));
        ObservableList<BarChart.Series> barChartSeries = FXCollections.observableArrayList(new BarChart.Series("Grade", barChartData));
        gradeBarChart.setData(barChartSeries);

        for (BarChart.Data data : barChartData){
            Tooltip.install(data.getNode(), new Tooltip(String.valueOf(data.getYValue())));
        }
    }

    private void fillCustomStackedBarChart(boolean details) {
        customStackedBarChart.getData().clear();
        if (details) {
            XYChart.Series<String, Number> npSeries = new XYChart.Series<>();
            npSeries.setName(Clear.NOPLAY);
            XYChart.Series<String, Number> fSeries = new XYChart.Series<>();
            fSeries.setName(Clear.FAILED);
            XYChart.Series<String, Number> acSeries = new XYChart.Series<>();
            acSeries.setName(Clear.ASSISTCLEAR);
            XYChart.Series<String, Number> ecSeries = new XYChart.Series<>();
            ecSeries.setName(Clear.EASYCLEAR);
            XYChart.Series<String, Number> cSeries = new XYChart.Series<>();
            cSeries.setName(Clear.CLEAR);
            XYChart.Series<String, Number> hcSeries = new XYChart.Series<>();
            hcSeries.setName(Clear.HARDCLEAR);
            XYChart.Series<String, Number> exSeries = new XYChart.Series<>();
            exSeries.setName(Clear.EXHARDCLEAR);
            XYChart.Series<String, Number> fcSeries = new XYChart.Series<>();
            fcSeries.setName(Clear.FULLCOMBO);

            for (String style : Style.ALLSTYLES) {
                int styleInt = Style.styleToInt(style) + 1;
                npSeries.getData().add(new XYChart.Data<>(style, (double)100 * stats.getNp_arr()[Style.styleToInt(style) + 1] / stats.getStyle_songs()[styleInt]));
                fSeries.getData().add(new XYChart.Data<>(style, (double)100 * stats.getF_arr()[Style.styleToInt(style) + 1] / stats.getStyle_songs()[styleInt]));
                acSeries.getData().add(new XYChart.Data<>(style, (double)100 * stats.getAc_arr()[Style.styleToInt(style) + 1] / stats.getStyle_songs()[styleInt]));
                ecSeries.getData().add(new XYChart.Data<>(style, (double)100 * stats.getEc_arr()[Style.styleToInt(style) + 1] / stats.getStyle_songs()[styleInt]));
                cSeries.getData().add(new XYChart.Data<>(style, (double)100 * stats.getC_arr()[Style.styleToInt(style) + 1] / stats.getStyle_songs()[styleInt]));
                hcSeries.getData().add(new XYChart.Data<>(style, (double)100 * stats.getHc_arr()[Style.styleToInt(style) + 1] / stats.getStyle_songs()[styleInt]));
                exSeries.getData().add(new XYChart.Data<>(style, (double)100 * stats.getEx_arr()[Style.styleToInt(style) + 1] / stats.getStyle_songs()[styleInt]));
                fcSeries.getData().add(new XYChart.Data<>(style, (double)100 * stats.getFc_arr()[Style.styleToInt(style) + 1] / stats.getStyle_songs()[styleInt]));
            }

            customStackedBarChart.getData().addAll(npSeries, fSeries, acSeries, ecSeries, cSeries, hcSeries, exSeries, fcSeries);
        } else {
            XYChart.Series<String, Number> cSeries = new XYChart.Series<>();
            cSeries.setName("Cleared");
            XYChart.Series<String, Number> ncSeries = new XYChart.Series<>();
            ncSeries.setName("Not Cleared");

            for (String style : Style.ALLSTYLES) {
                int styleInt = Style.styleToInt(style) + 1;
                cSeries.getData().add(new XYChart.Data<>(style, (double)100 * stats.getCvs_arr()[Style.styleToInt(style) + 1] / stats.getStyle_songs()[styleInt]));
                ncSeries.getData().add(new XYChart.Data<>(style, (double)100 * stats.getNcvs_arr()[Style.styleToInt(style) + 1] / stats.getStyle_songs()[styleInt]));
            }

            customStackedBarChart.getData().addAll(cSeries, ncSeries);
        }

        //add tooltips
        for (int i = 0; i < customStackedBarChart.getData().size(); i++) {
            XYChart.Series series = (XYChart.Series)customStackedBarChart.getData().get(i);
            for (int j = 0; j < series.getData().size(); j++) {
                XYChart.Data data = ((XYChart.Data)series.getData().get(j));
                Tooltip.install(data.getNode(), new Tooltip(round((double)data.getYValue(), 2) + "%"));
            }
        }
    }

    @FXML
    private void setStyleBarChartDetails(){
        if (styleDetailsCheckBox.isSelected()) {
            fillCustomStackedBarChart(true);
        } else {
            fillCustomStackedBarChart(false);
        }
    }

    private void fillLevelBarChart(boolean details){
        levelStackedBarChart.getData().clear();

        if (details) {
            XYChart.Series<String, Number> npSeries = new XYChart.Series<>();
            npSeries.setName(Clear.NOPLAY);
            XYChart.Series<String, Number> fSeries = new XYChart.Series<>();
            fSeries.setName(Clear.FAILED);
            XYChart.Series<String, Number> acSeries = new XYChart.Series<>();
            acSeries.setName(Clear.ASSISTCLEAR);
            XYChart.Series<String, Number> ecSeries = new XYChart.Series<>();
            ecSeries.setName(Clear.EASYCLEAR);
            XYChart.Series<String, Number> cSeries = new XYChart.Series<>();
            cSeries.setName(Clear.CLEAR);
            XYChart.Series<String, Number> hcSeries = new XYChart.Series<>();
            hcSeries.setName(Clear.HARDCLEAR);
            XYChart.Series<String, Number> exSeries = new XYChart.Series<>();
            exSeries.setName(Clear.EXHARDCLEAR);
            XYChart.Series<String, Number> fcSeries = new XYChart.Series<>();
            fcSeries.setName(Clear.FULLCOMBO);

            for (int i = 1; i <= 12; i++) {
                npSeries.getData().add(new XYChart.Data<>(String.valueOf(i), (double)100 * stats.getNp_arr()[i + 23] / stats.getStyle_songs()[i + 23]));
                fSeries.getData().add(new XYChart.Data<>(String.valueOf(i), (double)100 * stats.getF_arr()[i + 23] / stats.getStyle_songs()[i + 23]));
                acSeries.getData().add(new XYChart.Data<>(String.valueOf(i), (double)100 * stats.getAc_arr()[i + 23] / stats.getStyle_songs()[i + 23]));
                ecSeries.getData().add(new XYChart.Data<>(String.valueOf(i), (double)100 * stats.getEc_arr()[i + 23] / stats.getStyle_songs()[i + 23]));
                cSeries.getData().add(new XYChart.Data<>(String.valueOf(i), (double)100 * stats.getC_arr()[i + 23] / stats.getStyle_songs()[i + 23]));
                hcSeries.getData().add(new XYChart.Data<>(String.valueOf(i), (double)100 * stats.getHc_arr()[i + 23] / stats.getStyle_songs()[i + 23]));
                exSeries.getData().add(new XYChart.Data<>(String.valueOf(i), (double)100 * stats.getEx_arr()[i + 23] / stats.getStyle_songs()[i + 23]));
                fcSeries.getData().add(new XYChart.Data<>(String.valueOf(i), (double)100 * stats.getFc_arr()[i + 23] / stats.getStyle_songs()[i + 23]));
            }

            levelStackedBarChart.getData().addAll(npSeries, fSeries, acSeries, ecSeries, cSeries, hcSeries, exSeries, fcSeries);
        }
        else {
            XYChart.Series<String, Number> cSeries = new XYChart.Series<>();
            cSeries.setName("Cleared");
            XYChart.Series<String, Number> ncSeries = new XYChart.Series<>();
            ncSeries.setName("Not Cleared");

            for (int i = 1; i <= 12; i++) {
                cSeries.getData().add(new XYChart.Data<>(String.valueOf(i), (double)100 * stats.getCvs_arr()[i + 23] / stats.getStyle_songs()[i + 23]));
                ncSeries.getData().add(new XYChart.Data<>(String.valueOf(i), (double)100 * stats.getNcvs_arr()[i + 23] / stats.getStyle_songs()[i + 23]));
            }

            levelStackedBarChart.getData().addAll(cSeries, ncSeries);
        }

        //add tooltips
        for (int i = 0; i < levelStackedBarChart.getData().size(); i++) {
            XYChart.Series series = (XYChart.Series)levelStackedBarChart.getData().get(i);
            for (int j = 0; j < series.getData().size(); j++) {
                XYChart.Data data = (XYChart.Data)series.getData().get(j);
                Tooltip.install(data.getNode(), new Tooltip(round((double)data.getYValue(), 2) + "%"));
            }
        }

    }

    @FXML
    private void setLevelBarChartDetails(){
        if (levelDetailsCheckBox.isSelected()) {
            fillLevelBarChart(true);
        } else {
            fillLevelBarChart(false);
        }
    }

    @FXML
    private void export() {
        FileChooser fileChooser = new FileChooser();
        String userDir = System.getProperty("user.home");
        if (Main.os == Main.WINDOWS) userDir += "/Desktop";
        fileChooser.setInitialDirectory(new File(userDir));
        fileChooser.setInitialFileName("IIDX-FX_data.csv");
        FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Comma-separated values (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(csvFilter);
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(txtFilter);
        File file = fileChooser.showSaveDialog(scene.getWindow());
        if (file != null) {
            exportCSV(file);
        }
    }

    private void exportCSV(File file) {
        if (file != null) {
            try {
                OutputStream outputStream = new FileOutputStream(file.getPath());
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                printWriter.println("\"SongID\",\"Style\",\"Title\",\"Artist\",\"Genre\",\"Difficulty\",\"Level\",\"Normal Rating\",\"Hard Rating\",\"BPM\",\"Length\",\"Notes\",\"Clear\",\"Grade\",\"Percent\",\"Ex Score\",\"Miss Count\"");
                for (SongEntry songEntry : masterData) {
                    int songid = songEntry.getId();
                    String style = "\"" + songEntry.getStyle() + "\"";
                    String title = "\"" + songEntry.getTitle().replaceAll("\"","\"\"") + "\"";
                    String artist = "\"" + songEntry.getArtist().replaceAll("\"","\"\"") + "\"";
                    String genre = "\"" + songEntry.getGenre() + "\"";
                    String difficulty = "\"" + songEntry.getDifficulty() + "\"";
                    int level = isInteger(songEntry.getLevel()) ? Integer.parseInt(songEntry.getLevel()) : -1;
                    int nRating = songEntry.getnRating();
                    int hRating = songEntry.gethRating();
                    String bpm = "\"" + songEntry.getBpm() + "\"";
                    String length = "\"" + songEntry.getLength() + "\"";
                    int notes = isInteger(songEntry.getNotes()) ? Integer.parseInt(songEntry.getNotes()) : -1;
                    String clear = songEntry.getClear().equals("") ? "" : "\"" + songEntry.getClear() + "\"";
                    String grade = songEntry.getGrade().equals("") ? "" : "\"" + songEntry.getGrade().split(" ")[0] + "\"";
                    String percent = songEntry.getGrade().equals("") ? "" : "\"" + songEntry.getGrade().split(" ")[1].substring(1, songEntry.getGrade().split(" ")[1].length() - 1) + "\"";
                    String ex = songEntry.getEx().equals("") ? "" : songEntry.getEx();
                    String miss = songEntry.getMiss().equals("") ? "" : songEntry.getMiss();

                    String line = songid + "," + style + "," + title + "," + artist + "," + genre + "," + difficulty +
                            "," + level + "," + nRating + "," + hRating + "," + bpm + "," + length + "," + notes + "," +
                            clear + "," + grade + "," + percent + "," + ex + "," + miss;

                    printWriter.println(line);
                }
                printWriter.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

}