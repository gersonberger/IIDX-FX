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
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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
import netscape.javascript.JSObject;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.SegmentedButton;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.glyphfont.Glyph;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.ScrollPane;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static java.lang.Thread.sleep;


public class MainController implements Initializable {

    /**** TABPANE, TABS *****/
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab songsTab;
    @FXML
    private Tab danCourseTab;
    @FXML
    private Tab statisticsTab;
    @FXML
    private Tab settingsTab;

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
    private TableColumn<SongEntry, String> statusColumn;
    @FXML
    private TableColumn<SongEntry, String> gradeColumn;
    @FXML
    private TableColumn<SongEntry, String> miss_countColumn;
    @FXML
    private TableColumn<SongEntry, String> ex_scoreColumn;
    @FXML
    private TableColumn<SongEntry, String> scratchColumn;

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
    @FXML
    private CheckBox checkStyle23;

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

    /***** STATUS BUTTONS *****/
    @FXML
    private CheckBox checkStatusAll;
    @FXML
    private CheckBox checkStatusNoplay;
    @FXML
    private CheckBox checkStatusFailed;
    @FXML
    private CheckBox checkStatusAssistclear;
    @FXML
    private CheckBox checkStatusEasyclear;
    @FXML
    private CheckBox checkStatusClear;
    @FXML
    private CheckBox checkStatusHardclear;
    @FXML
    private CheckBox checkStatusExhardclear;
    @FXML
    private CheckBox checkStatusFullcombo;

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
    @FXML
    private Label chuuden1;
    @FXML
    private Label chuuden2;
    @FXML
    private Label chuuden3;
    @FXML
    private Label chuuden4;
    @FXML
    private ImageView chuudenImage;
    @FXML
    private Label chuudenLabel;

    /***** STATISTICS *****/
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
    private Label totalclearedLabel;
    @FXML
    private PieChart statusPieChart;
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
    private Label settingsThemeLabel;
    @FXML
    private RadioButton settingsThemeLightRadioButton;
    @FXML
    private RadioButton settingsThemeDarkRadioButton;
    @FXML
    private RadioButton settingsThemeNanahiraRadioButton;
    @FXML
    private CheckBox settingsStatusColorsCheckBox;
    @FXML
    private Label settingsSearchbarLabel;
    @FXML
    private CheckBox settingsTitleSuggestionsCheckBox;
    @FXML
    private CheckBox settingsArtistSuggestionsCheckBox;
    @FXML
    private Label settingsChartsLabel;
    @FXML
    private RadioButton settingsP1RadioButton;
    @FXML
    private RadioButton settingsP2RadioButton;
    @FXML
    private Label settingsHSLabel;
    @FXML
    private SegmentedButton settingsHSSegmentedButton;
    @FXML
    private ToggleButton settingsHS0ToggleButton;
    @FXML
    private ToggleButton settingsHS1ToggleButton;
    @FXML
    private ToggleButton settingsHS2ToggleButton;
    @FXML
    private ToggleButton settingsHS3ToggleButton;
    @FXML
    private CheckBox settingsBattleCheckBox;
    @FXML
    private CheckBox settingsSlimCheckBox;
    @FXML
    private CheckBox settingsBWCheckBox;
    @FXML
    private Label settingsSonglistLabel;
    @FXML
    private ComboBox<String> settingsSonglistComboBox;
    @FXML
    private Label settingsExportLabel;
    @FXML
    private Button settingsSaveButton;
    @FXML
    private Label settingsSaveLabel;
    @FXML
    private TextFlow settingsAboutFlow;

    /***** JSON KEYS*****/
    private final String jsonKeyId = "i";
    private final String jsonKeyMusicId = "mi";
    private final String jsonKeyStyle = "s";
    private final String jsonKeyTitle = "t";
    private final String jsonKeyTitleR = "tr";
    private final String jsonKeyArtist = "a";
    private final String jsonKeyArtistR = "ar";
    private final String jsonKeyGenre = "g";
    private final String jsonKeyDifficulty = "d";
    private final String jsonKeyLevel = "l";
    private final String jsonKeyRatingN = "rn";
    private final String jsonKeyRatingH = "rh";
    private final String jsonKeyBpmMin = "b-";
    private final String jsonKeyBpmMax = "b+";
    private final String jsonKeyLength = "ln";
    private final String jsonKeyNotes = "n";
    private final String jsonKeyScratchNotes = "ns";
    private final String jsonKeyTextage = "tx";
    private final String jsonKeyOmnimix = "o";
    private final String jsonKeyStatus = "s";
    private final String jsonKeyEx_score = "e";
    private final String jsonKeyMiss_count = "m";
    private final String jsonKeyRivalName = "n";
    private final String jsonKeyRivalScores = "sc";

    /***** MISC *****/
    @FXML
    private VBox mainBox;
    @FXML
    private VBox filterBox;
    @FXML
    private TextField filterField;
    @FXML
    private Button filterButton;
    @FXML
    private Label matchLabel;

    private static final int NETWORKERRORAUTHORIZATION = -20;
    private static final int NETWORKERRORPROFILE = -21;
    private static final int NETWORKERRORSERVER = -22;

    private static final String glyphFont = "FontAwesome";

    private Scene scene;
    private Set<String> titleSuggestions = new HashSet<>();
    private Set<String> artistSuggestions = new HashSet<>();
    private List<String> suggestions = new ArrayList<>();
    private ObservableList<SongEntry> masterData;

    private boolean filtersVisible = false;
    private boolean settingsSaveAnimationPlaying = false;

    private ServerSocket serverSocket;

    private Stats stats;

    /***** INIT *****/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        filterField.textProperty().addListener((observable, oldValue, newValue) -> Platform.runLater(() -> {

            //hide label if no filter is applied
            if (filterField.getText().isEmpty() && checkStyleAll.isSelected()
                    && checkLevelAll.isSelected() && checkDiffAll.isSelected() && checkStatusAll.isSelected())
                matchLabel.setText("");
            else if (tableView.getItems().size() != 1) matchLabel.setText(tableView.getItems().size() + " matches");
            else matchLabel.setText("1 match");
        }));

        //glyphs
        songsTab.setGraphic(new Glyph(glyphFont, '\uf03a'));
        danCourseTab.setGraphic(new Glyph(glyphFont, '\uf005'));
        statisticsTab.setGraphic(new Glyph(glyphFont, '\uf080'));
        settingsTab.setGraphic(new Glyph(glyphFont, '\uf013'));

        filterButton.setGraphic(new Glyph(glyphFont, '\uf0b0'));

        settingsThemeLabel.setGraphic(new Glyph(glyphFont, '\uf1fc'));
        settingsSearchbarLabel.setGraphic(new Glyph(glyphFont, '\uf002'));
        settingsChartsLabel.setGraphic(new Glyph(glyphFont, '\uf0c9'));
        settingsHSLabel.setGraphic(new Glyph(glyphFont, '\uf0e4'));
        settingsSonglistLabel.setGraphic(new Glyph(glyphFont, '\uf022'));
        settingsExportLabel.setGraphic(new Glyph(glyphFont, '\uf15c'));
        settingsSaveButton.setGraphic(new Glyph(glyphFont, '\uf0c7'));

        Platform.runLater(() -> {
            scene = tableView.getScene();
            scene.getWindow().setOnCloseRequest(event -> {
                quit();
                event.consume();
            });
            applyTheme();
        });

        //hide mainpage filterbox
        mainBox.getChildren().remove(filterBox);

        //enable statistics if scores exist
        if (Main.getScoreFile() != null) {
            statisticsTab.setDisable(false);
        }

        //theme toggles
        switch (Main.programTheme) {
            case Main.THEMELIGHT:
                settingsThemeLightRadioButton.setSelected(true);
                break;
            case Main.THEMEDARK:
                settingsThemeDarkRadioButton.setSelected(true);
                break;
            case Main.THEMENANAHIRA:
                settingsThemeNanahiraRadioButton.setSelected(true);
                break;
        }

        //statuscolor toggle
        settingsStatusColorsCheckBox.setSelected(Main.statusColor);

        //suggestion toggles
        if (Main.showTitleSuggestions) settingsTitleSuggestionsCheckBox.setSelected(true);
        if (Main.showArtistSuggestions) settingsArtistSuggestionsCheckBox.setSelected(true);

        //playerside toggles
        if (Main.playerside.equals("1")) settingsP1RadioButton.setSelected(true);
        else settingsP2RadioButton.setSelected(true);

        //hispeed toggle
        switch (Main.highspeed) {
            case "0":
                settingsHS0ToggleButton.setSelected(true);
                break;
            case "1":
                settingsHS1ToggleButton.setSelected(true);
                break;
            case "2":
                settingsHS2ToggleButton.setSelected(true);
                break;
            case "3":
                settingsHS3ToggleButton.setSelected(true);
                break;
            default:
                settingsHS1ToggleButton.setSelected(true);
        }

        //textage option toggles
        if (Main.battle) settingsBattleCheckBox.setSelected(true);
        if (Main.slim) settingsSlimCheckBox.setSelected(true);
        if (Main.blackwhite) settingsBWCheckBox.setSelected(true);

        //set songlist
        settingsSonglistComboBox.getItems().addAll(Style.OMNIMIX, Style.COPULAFULL);
        settingsSonglistComboBox.setValue(Main.songlist);

        //set aboutlink
        Hyperlink aboutHyperlink = new Hyperlink("About");
        aboutHyperlink.setOnAction(event -> about());
        settingsAboutFlow.getChildren().add(aboutHyperlink);

        //init main data
        initTable();
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

    private void cellFactoryStatusColors(TableColumn column) {
        column.setCellFactory(new Callback<TableColumn<SongEntry, String>, TableCell<SongEntry, String>>() {
            @Override
            public TableCell<SongEntry, String> call(TableColumn<SongEntry, String> param) {
                return new TableCell<SongEntry, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        this.getStyleClass().removeAll("failed", "assistclear", "easyclear", "clear", "hardclear", "exhardclear", "fullcombo");
                        if (!isEmpty() && Main.statusColor) {
                            switch (item) {
                                case Status.FAILED:
                                    this.getStyleClass().add("failed");
                                    break;
                                case Status.ASSISTCLEAR:
                                    this.getStyleClass().add("assistclear");
                                    break;
                                case Status.EASYCLEAR:
                                    this.getStyleClass().add("easyclear");
                                    break;
                                case Status.CLEAR:
                                    this.getStyleClass().add("clear");
                                    break;
                                case Status.HARDCLEAR:
                                    this.getStyleClass().add("hardclear");
                                    break;
                                case Status.EXHARDCLEAR:
                                    this.getStyleClass().add("exhardclear");
                                    break;
                                case Status.FULLCOMBO:
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
        genreColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEGENRECOL, "false")));
        difficultyColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEDIFFICULTYCOL, "true")));
        levelColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMELEVELCOL, "true")));
        ratingNColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMERATINGNCOL, "true")));
        ratingHColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMERATINGHCOL, "true")));
        bpmColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEBPMCOL, "true")));
        lengthColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMELENGTHCOL, "true")));
        notesColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMENOTESCOL, "true")));
        scratchColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMESCRATCHCOL, "true")));
        statusColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMESTATUSCOL, "false")));
        gradeColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEGRADECOL, "false")));
        ex_scoreColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEEXCOL, "false")));
        miss_countColumn.setVisible(Boolean.valueOf(properties.getProperty(Main.PROPERTYNAMEMISS_COUNTCOL, "false")));

        //column order
        applyColumnOrder(Main.colorder);

        //column automatic resizing
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        styleColumn.setMaxWidth(1f * Integer.MAX_VALUE * 81);
        titleColumn.setMaxWidth(1f * Integer.MAX_VALUE * 240);
        artistColumn.setMaxWidth(1f * Integer.MAX_VALUE * 170);
        genreColumn.setMaxWidth(1f * Integer.MAX_VALUE * 125);
        difficultyColumn.setMaxWidth(1f * Integer.MAX_VALUE * 88);
        levelColumn.setMaxWidth(1f * Integer.MAX_VALUE * 59);
        ratingNColumn.setMaxWidth(1f * Integer.MAX_VALUE * 51);
        ratingHColumn.setMaxWidth(1f * Integer.MAX_VALUE * 51);
        bpmColumn.setMaxWidth(1f * Integer.MAX_VALUE * 58);
        lengthColumn.setMaxWidth(1f * Integer.MAX_VALUE * 68);
        notesColumn.setMaxWidth(1f * Integer.MAX_VALUE * 59);
        statusColumn.setMaxWidth(1f * Integer.MAX_VALUE * 90);
        gradeColumn.setMaxWidth(1f * Integer.MAX_VALUE * 104);
        ex_scoreColumn.setMaxWidth(1f * Integer.MAX_VALUE * 60);
        miss_countColumn.setMaxWidth(1f * Integer.MAX_VALUE * 60);
        scratchColumn.setMaxWidth(1f * Integer.MAX_VALUE * 70);

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

            //disable chart contextmenu if chart has no textage link or no link is available
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
        scratchColumn.setCellValueFactory(new PropertyValueFactory<>("Scratch"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("Grade"));
        miss_countColumn.setCellValueFactory(new PropertyValueFactory<>("Miss_count"));
        ex_scoreColumn.setCellValueFactory(new PropertyValueFactory<>("Ex_score"));

        //status theming via css/status.css if selected in settings
        cellFactoryStatusColors(statusColumn);

        //double click listener for grade
        gradeColumn.setCellFactory(new Callback<TableColumn<SongEntry, String>, TableCell<SongEntry, String>>() {
            @Override
            public TableCell<SongEntry, String> call(TableColumn<SongEntry, String> param) {
                return new TableCell<SongEntry, String>() {
                    long lastclick = System.nanoTime();

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                            //prevent odd multiclicks
                            if (event.getClickCount() > 1 && System.nanoTime() - lastclick > 1000000000) {
                                lastclick = System.nanoTime();
                                showGradePopOver(this);
                            }
                        });
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
        statusColumn.setComparator(getStatusComparator());
        gradeColumn.setComparator(getGradeComparator());
        miss_countColumn.setComparator(getMiss_countComparator());
        ex_scoreColumn.setComparator(getEx_scoreComparator());
        scratchColumn.setComparator(getScratchComparator());
    }

    private String getColumnOrder() {
        String order = "";
        for (TableColumn<SongEntry, ?> column : tableView.getColumns()) {
            if (column.equals(styleColumn)) order += "0,";
            else if (column.equals(titleColumn)) order += "1,";
            else if (column.equals(artistColumn)) order += "2,";
            else if (column.equals(genreColumn)) order += "3,";
            else if (column.equals(difficultyColumn)) order += "4,";
            else if (column.equals(levelColumn)) order += "5,";
            else if (column.equals(ratingNColumn)) order += "6,";
            else if (column.equals(ratingHColumn)) order += "7,";
            else if (column.equals(bpmColumn)) order += "8,";
            else if (column.equals(lengthColumn)) order += "9,";
            else if (column.equals(notesColumn)) order += "10,";
            else if (column.equals(scratchColumn)) order += "11,";
            else if (column.equals(statusColumn)) order += "12,";
            else if (column.equals(gradeColumn)) order += "13,";
            else if (column.equals(ex_scoreColumn)) order += "14,";
            else if (column.equals(miss_countColumn)) order += "15,";
        }
        return order.substring(0, order.length()-1);
    }

    private void applyColumnOrder(String order) {
        ObservableList<TableColumn<SongEntry, ?>> columns = tableView.getColumns();
        final List<TableColumn<SongEntry, ?>> defaultColumns = Collections.unmodifiableList(new ArrayList<>(columns));
        columns.clear();
        String[] cols = order.split(",");
        for (String col : cols) {
            columns.add(defaultColumns.get(Integer.valueOf(col)));
        }
    }

    private void initTable() {
        masterData = FXCollections.observableArrayList();
        List<SongEntry> entries = new ArrayList<>();

        JSONArray musicArr = createLocalJsonArray(Main.FILENAMEMUSICFILE);
        JSONArray chartsArr = createLocalJsonArray(Main.FILENAMECHARTSFILE);
        JSONArray scoreArr = null;

        if (Main.getScoreFile() != null) {
            String json = "";
            try {
                FileInputStream scoreFileInputStream = new FileInputStream(Main.getScoreFile());
                InputStreamReader scoreInputStreamReader = new InputStreamReader(scoreFileInputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(scoreInputStreamReader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    json += line;
                    line = bufferedReader.readLine();
                }
                scoreFileInputStream.close();
                scoreInputStreamReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            scoreArr = new JSONArray(json);
        }

        for (int i = 0; i < chartsArr.length(); i++) {
            JSONObject chart = (JSONObject) chartsArr.get(i);
            int id = chart.getInt(jsonKeyId);
            String musicId = chart.getString(jsonKeyMusicId);
            int style = 0;
            String title = null;
            String title_r = null;
            String artist = null;
            String artist_r = null;
            String genre = null;
            int difficulty = chart.getInt(jsonKeyDifficulty);
            int level = chart.getInt(jsonKeyLevel);
            int nRating = chart.getInt(jsonKeyRatingN);
            int hRating = chart.getInt(jsonKeyRatingH);
            int bpmMin = chart.getInt(jsonKeyBpmMin);
            int bpmMax = chart.getInt(jsonKeyBpmMax);
            int length = chart.getInt(jsonKeyLength);
            int notes = chart.getInt(jsonKeyNotes);
            int scratch = chart.getInt(jsonKeyScratchNotes);
            int status = 0;
            int ex_score = 0;
            String grade = "";
            int miss_count = -2;

            if (scoreArr != null) {
                for (int j = 0; j < scoreArr.length(); j++) {
                    JSONObject score = (JSONObject) scoreArr.get(j);
                    if (!score.has(jsonKeyMusicId)) System.out.println(musicId);
                    if (musicId.equals(score.getString(jsonKeyMusicId))) {
                        int score_difficulty = score.getInt(jsonKeyDifficulty);
                        if (score_difficulty == Difficulty.BLACKANOTHER_INT && isLeggendaria(id)) {
                            score_difficulty = Difficulty.LEGGENDARIA_INT;
                        }
                        if (difficulty == score_difficulty) {
                            status = score.getInt(jsonKeyStatus);
                            ex_score = score.getInt(jsonKeyEx_score);
                            String percentage = String.valueOf(round(ex_score / (notes * 2d) * 100));
                            if (percentage.length() <= 4) {
                                if (percentage.length() == 4 && percentage.charAt(2) == '.') {
                                    percentage += "0";
                                } else if (percentage.length() == 3) {
                                    percentage = percentage.charAt(0) + ".0" + percentage.charAt(2);
                                }
                            }
                            grade = Grade.percentageToString(ex_score, notes) + " (" + percentage + "%)";
                            miss_count = score.getInt(jsonKeyMiss_count);
                            break;
                        }
                    }
                }
            }

            String textage = null;
            int omnimix = -1;
            for (int j = 0; j < musicArr.length(); j++) {
                if (id == ((JSONObject) musicArr.get(j)).getInt(jsonKeyId)) {
                    JSONObject music = (JSONObject) musicArr.get(j);
                    style = music.getInt(jsonKeyStyle);
                    title = music.getString(jsonKeyTitle);
                    title_r = music.getString(jsonKeyTitleR);
                    artist = music.getString(jsonKeyArtist);
                    artist_r = music.getString(jsonKeyArtistR);
                    genre = music.getString(jsonKeyGenre);
                    textage = music.getString(jsonKeyTextage);
                    omnimix = music.getInt(jsonKeyOmnimix);
                    break;
                }
            }

            entries.add(
                    new SongEntry(
                            id, style, title, title_r, artist, artist_r, genre, difficulty, level, nRating, hRating,
                            bpmMin, bpmMax, length, notes, scratch, status, grade, miss_count, ex_score, textage, omnimix, musicId
                    )
            );

        }

        Main.log(Module.INITIALIZE, "created " + entries.size() + " entries");
        masterData.addAll(entries);
        Main.log(Module.INITIALIZE, "added entries to masterdata");
        try {
            initColumns();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTableData(masterData);
    }

    private JSONArray createLocalJsonArray(String path) {
        String str = "";
        InputStream jsonInputStream = getClass().getResourceAsStream("/data/" + path);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jsonInputStream, "UTF-8"));
            String line = bufferedReader.readLine();
            while (line != null) {
                str += line;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONArray(str);
    }

    private void setTableData(final ObservableList<SongEntry> masterData) {
        final FilteredList<SongEntry> filteredData = new FilteredList<>(masterData);

        //make list filterable via filterfield
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(songEntry -> {

                //empty list
                if (songEntry == null) return false;

                //omnimix filter
                if (!Main.songlist.equals(Style.OMNIMIX) && songEntry.getOmnimix() == 1) return false;

                //style filter
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
                            (!songEntry.getStyle().equals(Style.PENDUAL) || !checkStyle22.isSelected()) &&
                            (!songEntry.getStyle().equals(Style.COPULA) || !checkStyle23.isSelected()))
                        return false;
                }

                //level filter
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
                            (!songEntry.getLevel().equals("12") || !checkLevel12.isSelected()))
                        return false;
                }

                //difficulty filter
                if (!checkDiffAll.isSelected()) {
                    if ((!songEntry.getDifficulty().equals(Difficulty.NORMAL) || !checkDiffN.isSelected()) &&
                            (!songEntry.getDifficulty().equals(Difficulty.HYPER) || !checkDiffH.isSelected()) &&
                            (!songEntry.getDifficulty().equals(Difficulty.ANOTHER) || !checkDiffA.isSelected()) &&
                            (!songEntry.getDifficulty().equals(Difficulty.BLACKANOTHER) || !checkDiffB.isSelected()) &&
                            (!songEntry.getDifficulty().equals(Difficulty.LEGGENDARIA) || !checkDiffL.isSelected()))
                        return false;
                }

                //status filter
                if (!checkStatusAll.isSelected()) {
                    if ((!songEntry.getStatus().equals(Status.NOPLAY_NOTEXT) || !checkStatusNoplay.isSelected()) &&
                            (!songEntry.getStatus().equals(Status.FAILED) || !checkStatusFailed.isSelected()) &&
                            (!songEntry.getStatus().equals(Status.ASSISTCLEAR) || !checkStatusAssistclear.isSelected()) &&
                            (!songEntry.getStatus().equals(Status.EASYCLEAR) || !checkStatusEasyclear.isSelected()) &&
                            (!songEntry.getStatus().equals(Status.CLEAR) || !checkStatusClear.isSelected()) &&
                            (!songEntry.getStatus().equals(Status.HARDCLEAR) || !checkStatusHardclear.isSelected()) &&
                            (!songEntry.getStatus().equals(Status.EXHARDCLEAR) || !checkStatusExhardclear.isSelected()) &&
                            (!songEntry.getStatus().equals(Status.FULLCOMBO) || !checkStatusFullcombo.isSelected()))
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

            //bind data
            final SortedList<SongEntry> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tableView.comparatorProperty());
            tableView.setItems(sortedData);
        });
    }

    /***** POPOVER *****/
    private void showGradePopOver(TableCell cell) {
        SongEntry entry = (SongEntry) cell.getTableRow().getItem();
        if (!entry.getGrade().equals("")) {
            String grade = entry.getGrade().split(" ")[0];
            int notes = Integer.valueOf(entry.getNotes());
            int ex_score = entry.getEx_score().equals("") ? 0 : Integer.valueOf(entry.getEx_score());
            String txt = Grade.getNextGrade(grade) + " -" + Grade.getDifferenceNextGrade(grade, notes, ex_score);
            if (grade.equals(Grade.MAX)) txt = "STAY COOL!!";
            Label label = new Label(txt);
            label.setPadding(new Insets(12));

            PopOver popOver = new PopOver(label);
            popOver.setArrowLocation(PopOver.ArrowLocation.BOTTOM_CENTER);
            popOver.setDetachable(false);
            popOver.setArrowSize(8);

            showPopOverWithTheme(popOver, cell);
            popOver.detach();
        }
    }

    private void showPopOverWithTheme(PopOver popOver, TableCell cell) {
        //show popover here to be able to access it's skin property
        popOver.show(cell, -4);
        switch (Main.programTheme) {
            case Main.THEMELIGHT:
                if (popOver.getContentNode().getClass().equals(Label.class)) {
                    popOver.getContentNode().setStyle("-fx-text-fill: #333333; -fx-font-size: 15;");
                }
                ((Parent) popOver.getSkin().getNode()).getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMELIGHT).toExternalForm());
                break;
            case Main.THEMEDARK:
                if (popOver.getContentNode().getClass().equals(Label.class)) {
                    popOver.getContentNode().setStyle("-fx-text-fill: #DCDCDC; -fx-font-size: 15;");
                }
                ((Parent) popOver.getSkin().getNode()).getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMEDARK).toExternalForm());
                break;
            case Main.THEMENANAHIRA:
                if (popOver.getContentNode().getClass().equals(Label.class)) {
                    popOver.getContentNode().setStyle("-fx-text-fill: #333333; -fx-font-size: 15;");
                }
                ((Parent) popOver.getSkin().getNode()).getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMETHEMENANAHIRA).toExternalForm());
                break;
        }
        //call method again to update
        popOver.show(cell, -4);
    }

    /***** COMPARATORS *****/
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

    private Comparator<String> getScratchComparator() {
        return (o1, o2) -> {
            if (o1 == null || o1.equals("") || o1.equals("N/A") || o1.isEmpty())
                return scratchColumn.getSortType() == TableColumn.SortType.ASCENDING ? 1 : -1;
            if (o2 == null || o2.equals("") || o2.equals("N/A") || o2.isEmpty())
                return scratchColumn.getSortType() == TableColumn.SortType.ASCENDING ? -1 : 1;
            final String s1 = o1.substring(0, o1.length() - 1), s2 = o2.substring(0, o2.length() - 1);
            if (!o1.equals(o2)) return Double.valueOf(s1) > Double.valueOf(s2) ? 1 : -1;
            return 0;
        };
    }

    private Comparator<String> getStatusComparator() {
        return (o1, o2) -> {
            if (!o1.equals(o2)) return Status.statusToInt(o1) > Status.statusToInt(o2) ? 1 : -1;
            return 0;
        };
    }

    private Comparator<String> getGradeComparator() {
        return (o1, o2) -> {
            if (o1 == null || o1.equals("") || o1.isEmpty())
                return gradeColumn.getSortType() == TableColumn.SortType.ASCENDING ? 1 : -1;
            if (o2 == null || o2.equals("") || o2.isEmpty())
                return gradeColumn.getSortType() == TableColumn.SortType.ASCENDING ? -1 : 1;
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
                    for (int i = 0; i < arr1[1].length() - 2; i++) {
                        if (Integer.parseInt(arr1[1].substring(i, i + 1)) != Integer.parseInt(arr2[1].substring(i, i + 1)))
                            return Integer.parseInt(arr1[1].substring(i, i + 1)) > Integer.parseInt(arr2[1].substring(i, i + 1)) ? 1 : -1;
                    }

                    return 0;
                }
            }
        };
    }

    private Comparator<String> getMiss_countComparator() {
        return (o1, o2) -> {
            if (o1 == null || o1.equals(""))
                return miss_countColumn.getSortType() == TableColumn.SortType.ASCENDING ? 1 : -1;
            if (o2 == null || o2.equals(""))
                return miss_countColumn.getSortType() == TableColumn.SortType.ASCENDING ? -1 : 1;
            if (o1.equals("N/A")) return miss_countColumn.getSortType() == TableColumn.SortType.ASCENDING ? 1 : -1;
            if (o2.equals("N/A")) return miss_countColumn.getSortType() == TableColumn.SortType.ASCENDING ? -1 : 1;
            int i1 = Integer.valueOf(o1);
            int i2 = Integer.valueOf(o2);
            return i1 > i2 ? 1 : i1 < i2 ? -1 : 0;
        };
    }

    private Comparator<String> getEx_scoreComparator() {
        return (o1, o2) -> {
            if (o1 == null || o1.equals(""))
                return ex_scoreColumn.getSortType() == TableColumn.SortType.ASCENDING ? 1 : -1;
            if (o2 == null || o2.equals(""))
                return ex_scoreColumn.getSortType() == TableColumn.SortType.ASCENDING ? -1 : 1;
            if (!o1.equals(o2)) return Integer.valueOf(o1) > Integer.valueOf(o2) ? 1 : -1;
            return 0;
        };
    }

    /***** TOGGLES *****/
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
            checkStyle23.setSelected(false);
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

    @FXML
    private void style23() {
        if (checkStyle23.isSelected()) checkStyleAll.setSelected(false);
        checkStyle23.setSelected(checkStyle23.isSelected());
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
                !checkStyle21.isSelected() && !checkStyle22.isSelected() && !checkStyle23.isSelected())
            checkStyleAll.setSelected(true);
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
    private void difficultyNormal() {
        if (checkDiffN.isSelected()) checkDiffAll.setSelected(false);
        checkDiffN.setSelected(checkDiffN.isSelected());
        diffempty();
        refreshTable();
    }

    @FXML
    private void difficultyHyper() {
        if (checkDiffH.isSelected()) checkDiffAll.setSelected(false);
        checkDiffH.setSelected(checkDiffH.isSelected());
        diffempty();
        refreshTable();
    }

    @FXML
    private void difficultyAnother() {
        if (checkDiffA.isSelected()) checkDiffAll.setSelected(false);
        checkDiffA.setSelected(checkDiffA.isSelected());
        diffempty();
        refreshTable();
    }

    @FXML
    private void difficultyBlack() {
        if (checkDiffB.isSelected()) checkDiffAll.setSelected(false);
        checkDiffB.setSelected(checkDiffB.isSelected());
        diffempty();
        refreshTable();
    }

    @FXML
    private void difficultyLeggendaria() {
        if (checkDiffL.isSelected()) checkDiffAll.setSelected(false);
        checkDiffL.setSelected(checkDiffL.isSelected());
        diffempty();
        refreshTable();
    }

    private void diffempty() {
        if (!checkDiffN.isSelected() && !checkDiffH.isSelected() && !checkDiffA.isSelected() &&
                !checkDiffL.isSelected() && !checkDiffB.isSelected()) checkDiffAll.setSelected(true);
    }

    //status select toggles
    @FXML
    private void statusAll() {
        if (checkStatusAll.isSelected()) {
            checkStatusNoplay.setSelected(false);
            checkStatusFailed.setSelected(false);
            checkStatusAssistclear.setSelected(false);
            checkStatusEasyclear.setSelected(false);
            checkStatusClear.setSelected(false);
            checkStatusHardclear.setSelected(false);
            checkStatusExhardclear.setSelected(false);
            checkStatusFullcombo.setSelected(false);
        }
        checkStatusAll.setSelected(checkStatusAll.isSelected());
        refreshTable();
    }

    @FXML
    private void statusNoplay() {
        if (checkStatusNoplay.isSelected()) checkStatusAll.setSelected(false);
        checkStatusNoplay.setSelected(checkStatusNoplay.isSelected());
        statusEmpty();
        refreshTable();
    }

    @FXML
    private void statusFailed() {
        if (checkStatusFailed.isSelected()) checkStatusAll.setSelected(false);
        checkStatusFailed.setSelected(checkStatusFailed.isSelected());
        statusEmpty();
        refreshTable();
    }

    @FXML
    private void statusAssistclear() {
        if (checkStatusAssistclear.isSelected()) checkStatusAll.setSelected(false);
        checkStatusAssistclear.setSelected(checkStatusAssistclear.isSelected());
        statusEmpty();
        refreshTable();
    }

    @FXML
    private void statusEasyclear() {
        if (checkStatusEasyclear.isSelected()) checkStatusAll.setSelected(false);
        checkStatusEasyclear.setSelected(checkStatusEasyclear.isSelected());
        statusEmpty();
        refreshTable();
    }

    @FXML
    private void statusClear() {
        if (checkStatusClear.isSelected()) checkStatusAll.setSelected(false);
        checkStatusClear.setSelected(checkStatusClear.isSelected());
        statusEmpty();
        refreshTable();
    }

    @FXML
    private void statusHardclear() {
        if (checkStatusHardclear.isSelected()) checkStatusAll.setSelected(false);
        checkStatusHardclear.setSelected(checkStatusHardclear.isSelected());
        statusEmpty();
        refreshTable();
    }

    @FXML
    private void statusExhardclear() {
        if (checkStatusExhardclear.isSelected()) checkStatusAll.setSelected(false);
        checkStatusExhardclear.setSelected(checkStatusExhardclear.isSelected());
        statusEmpty();
        refreshTable();
    }

    @FXML
    private void statusFullcombo() {
        if (checkStatusFullcombo.isSelected()) checkStatusAll.setSelected(false);
        checkStatusFullcombo.setSelected(checkStatusFullcombo.isSelected());
        statusEmpty();
        refreshTable();
    }

    private void statusEmpty() {
        if (!checkStatusNoplay.isSelected() && !checkStatusFailed.isSelected() &&
                !checkStatusAssistclear.isSelected() && !checkStatusEasyclear.isSelected() &&
                !checkStatusClear.isSelected() && !checkStatusHardclear.isSelected() &&
                !checkStatusExhardclear.isSelected() && !checkStatusFullcombo.isSelected())
            checkStatusAll.setSelected(true);
    }

    /***** SETTINGS *****/
    @FXML
    private void hideFilters() {
        filtersVisible = !filtersVisible;
        if (!filtersVisible) mainBox.getChildren().remove(filterBox);
        else mainBox.getChildren().add(1, filterBox);
    }

    @FXML
    private void setThemeLight() {
        settingsThemeLightRadioButton.setSelected(true);
        settingsThemeDarkRadioButton.setSelected(false);
        settingsThemeNanahiraRadioButton.setSelected(false);
    }

    @FXML
    private void setThemeDark() {
        settingsThemeLightRadioButton.setSelected(false);
        settingsThemeDarkRadioButton.setSelected(true);
        settingsThemeNanahiraRadioButton.setSelected(false);
    }

    @FXML
    private void setThemeNanahira() {
        settingsThemeLightRadioButton.setSelected(false);
        settingsThemeDarkRadioButton.setSelected(false);
        settingsThemeNanahiraRadioButton.setSelected(true);
    }

    @FXML
    private void applyTheme() {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("/css/" + Main.FILENAMESTATUSCOLORS).toExternalForm());
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

    @FXML
    private void setP1() {
        settingsP1RadioButton.setSelected(true);
        settingsP2RadioButton.setSelected(false);
    }

    @FXML
    private void setP2() {
        settingsP2RadioButton.setSelected(true);
        settingsP1RadioButton.setSelected(false);
    }

    @FXML
    private void about() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/about.fxml"));
            VBox page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle(Main.PROGRAMNAME);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
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

    /***** DAN *****/
    private void initDan() {
        danStyleSelectBox.setValue(Style.COPULAFULL);
        danStyleSelectBox.getItems().addAll(Style.COPULAFULL, Style.PENDUALFULL, Style.SPADAFULL, Style.TRICOROFULL, Style.LINCLEFULL,
                Style.RESORTANTHEMFULL, Style.SIRIUSFULL, Style.EMPRESSFULL);
        danStyleSelectBox.valueProperty().addListener((observable, oldValue, newValue) -> setDanData(Style.styleFullToInt(newValue)));

        //Chuuden
        chuuden1.setText(Dan.danData[0][18][0]);
        chuuden2.setText(Dan.danData[0][18][1]);
        chuuden3.setText(Dan.danData[0][18][2]);
        chuuden4.setText(Dan.danData[0][18][3]);

        setDanData(Style.COPULAINT);
    }

    private void setDanData(int style) {
        if (style == Style.COPULAINT) {
            chuudenImage.setVisible(true);
            chuudenLabel.setVisible(true);
            chuuden1.setVisible(true);
            chuuden2.setVisible(true);
            chuuden3.setVisible(true);
            chuuden4.setVisible(true);
        } else {
            chuudenImage.setVisible(false);
            chuudenLabel.setVisible(false);
            chuuden1.setVisible(false);
            chuuden2.setVisible(false);
            chuuden3.setVisible(false);
            chuuden4.setVisible(false);
        }

        style = 23 - style;
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

    private void setSuggestions() {
        if (Main.showTitleSuggestions) suggestions.addAll(titleSuggestions);
        if (Main.showArtistSuggestions) suggestions.addAll(artistSuggestions);
        TextFields.bindAutoCompletion(filterField, suggestions);
        if (suggestions.size() > 0)
            Main.log(Module.INITIALIZE, "added " + suggestions.size() + " suggestions to searchbar");
    }

    @FXML
    private void saveSettings() {
        //prevent overload by clicking the button too much
        if (!settingsSaveAnimationPlaying) {
            settingsSaveAnimationPlaying = true;
            boolean refresh = false;

            if (settingsThemeLightRadioButton.isSelected() && !Main.programTheme.equals(Main.THEMELIGHT)) {
                Main.programTheme = Main.THEMELIGHT;
                applyTheme();
            } else if (settingsThemeDarkRadioButton.isSelected() && !Main.programTheme.equals(Main.THEMEDARK)) {
                Main.programTheme = Main.THEMEDARK;
                applyTheme();
            } else if (settingsThemeNanahiraRadioButton.isSelected() && !Main.programTheme.equals(Main.THEMENANAHIRA)) {
                Main.programTheme = Main.THEMENANAHIRA;
                applyTheme();
            }

            if (settingsStatusColorsCheckBox.isSelected() != Main.statusColor) {
                Main.statusColor = settingsStatusColorsCheckBox.isSelected();
                refresh = true;
            }

            Main.showTitleSuggestions = settingsTitleSuggestionsCheckBox.isSelected();
            Main.showArtistSuggestions = settingsArtistSuggestionsCheckBox.isSelected();
            Main.playerside = settingsP1RadioButton.isSelected() ? "1" : "2";
            Main.highspeed = settingsHS0ToggleButton.isSelected() ? "0" : settingsHS1ToggleButton.isSelected() ? "1" : settingsHS2ToggleButton.isSelected() ? "2" : "3";
            Main.battle = settingsBattleCheckBox.isSelected();
            Main.slim = settingsSlimCheckBox.isSelected();
            Main.blackwhite = settingsBWCheckBox.isSelected();

            if (!settingsSonglistComboBox.getValue().equals(Main.songlist)) {
                Main.songlist = settingsSonglistComboBox.getValue();
                initStatistics();
                refresh = true;
            }

            if (refresh) refreshTable();

            Main.colorder = getColumnOrder();
            boolean[] columnVisibility = {styleColumn.isVisible(), titleColumn.isVisible(), artistColumn.isVisible(),
                    genreColumn.isVisible(), difficultyColumn.isVisible(), levelColumn.isVisible(),
                    ratingNColumn.isVisible(), ratingHColumn.isVisible(), bpmColumn.isVisible(), lengthColumn.isVisible(),
                    notesColumn.isVisible(), statusColumn.isVisible(), gradeColumn.isVisible(), ex_scoreColumn.isVisible(),
                    miss_countColumn.isVisible(), scratchColumn.isVisible()};
            Main.setProperties(columnVisibility);

            FadeTransition ft2 = new FadeTransition(Duration.millis(300), settingsSaveLabel);
            ft2.setFromValue(1);
            ft2.setToValue(0);
            ft2.setOnFinished(event2 -> settingsSaveAnimationPlaying = false);
            FadeTransition ft1 = new FadeTransition(Duration.millis(300), settingsSaveLabel);
            ft1.setFromValue(0);
            ft1.setToValue(1);
            ft1.setOnFinished(event1 -> new Thread(() -> {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ft2.play();
            }).run());
            new Thread(ft1::play).start();
        }
    }

    /***** TEXTAGE *****/
    private void textageTab(int id, String title, String textage, String difficulty, String level) {
        if (!textage.equals("")) {
            if (title.length() > 24) title = title.substring(0, 20) + "...";
            String player = Main.battle ? "B" : Main.playerside.equals("1") ? "1" : "2";
            int hs;
            switch (Main.highspeed) {
                case "0":
                    hs = 6;
                    break;
                case "1":
                    hs = 0;
                    break;
                case "2":
                    hs = 2;
                    break;
                case "3":
                    hs = 4;
                    break;
                default:
                    hs = 0;
            }
            if (Main.slim) hs++;
            difficulty = Difficulty.difficultyToTextageChar(difficulty);
            if (Main.blackwhite) difficulty = difficulty.toLowerCase();
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

            setWebEngineHandlers(webEngine);

            webEngine.load("http://textage.cc/score/" + texStyle(id) + "/" + textage + ".html?" + player + difficulty
                    + level + hs + "5");
            if (difficulty.toLowerCase().equals("x")) difficulty = "黒";
            Tab tab = new Tab(title + " [" + difficulty.toLowerCase() + "]");
            tab.setContent(webView);
            tabPane.getTabs().add(tab);
        }
    }

    private void setWebEngineHandlers(WebEngine webEngine) {
        //prompt window
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

        //alert window
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
    }

    private String texStyle(int id) {
        String str;
        if (id == 15202 || id == 14214) str = String.valueOf(Style.COPULAINT);
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
                || id == 5208 || id == 5209 || id == 4212 || id == 4214 || id == 4215)
            str = String.valueOf(Style.OTHERINT);
        else str = String.valueOf(getStyleFromID(id));
        if (str.equals("-1")) str = "s";
        return str;
    }

    private boolean isLeggendaria(int id) {
        return id == 22102 || id == 22103 || id == 22104 || id == 22101 || id == 22105 || id == 21102 || id == 21100
                || id == 21104 || id == 21103 || id == 21101 || id == 21106 || id == 21105 || id == 18100
                || id == 5100 || id == 4100;
    }

    /***** STATISTICS *****/
    private void initStatistics() {
        stats = new Stats(masterData);

        noPlayCheckBox.setSelected(Main.statsClearrateNoplay);
        styleDetailsCheckBox.setSelected(Main.statsStyleCompletionDetails);
        levelDetailsCheckBox.setSelected(Main.statsLevelCompletionDetails);

        playeridLabel.setText(Main.playerid);
        djnameLabel.setText((Main.djname).toUpperCase());
        fullcomboLabel.setText(String.valueOf(stats.getAllStatus(Status.FULLCOMBO_INT)));
        exhardLabel.setText(String.valueOf(stats.getAllStatus(Status.EXHARDCLEAR_INT)));
        hardLabel.setText(String.valueOf(stats.getAllStatus(Status.HARDCLEAR_INT)));
        clearLabel.setText(String.valueOf(stats.getAllStatus(Status.CLEAR_INT)));
        easyclearLabel.setText(String.valueOf(stats.getAllStatus(Status.EASYCLEAR_INT)));
        assistclearLabel.setText(String.valueOf(stats.getAllStatus(Status.ASSISTCLEAR_INT)));
        failLabel.setText(String.valueOf(stats.getAllStatus(Status.FAILED_INT)));
        noplayLabel.setText(String.valueOf(stats.getAllStatus(Status.NOPLAY_INT)));
        totalclearedLabel.setText(String.valueOf(stats.getTotalClears()));

        fillStatusPieChart();
        fillGradeBarChart();
        fillCustomStackedBarChart(false);
        fillLevelBarChart(false);

        if (!Main.statsClearrateNoplay) setPieNoPlay();
        setStyleBarChartDetails();
        setLevelBarChartDetails();
    }

    private void fillStatusPieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        if (stats.getAllStatus(Status.FULLCOMBO_INT) > 0)
            pieChartData.add(new PieChart.Data(Status.FULLCOMBO, stats.getAllStatus(Status.FULLCOMBO_INT)));
        if (stats.getAllStatus(Status.EXHARDCLEAR_INT) > 0)
            pieChartData.add(new PieChart.Data(Status.EXHARDCLEAR, stats.getAllStatus(Status.EXHARDCLEAR_INT)));
        if (stats.getAllStatus(Status.HARDCLEAR_INT) > 0)
            pieChartData.add(new PieChart.Data(Status.HARDCLEAR, stats.getAllStatus(Status.HARDCLEAR_INT)));
        if (stats.getAllStatus(Status.CLEAR_INT) > 0)
            pieChartData.add(new PieChart.Data(Status.CLEAR, stats.getAllStatus(Status.CLEAR_INT)));
        if (stats.getAllStatus(Status.EASYCLEAR_INT) > 0)
            pieChartData.add(new PieChart.Data(Status.EASYCLEAR, stats.getAllStatus(Status.EASYCLEAR_INT)));
        if (stats.getAllStatus(Status.ASSISTCLEAR_INT) > 0)
            pieChartData.add(new PieChart.Data(Status.ASSISTCLEAR, stats.getAllStatus(Status.ASSISTCLEAR_INT)));
        if (stats.getAllStatus(Status.FAILED_INT) > 0)
            pieChartData.add(new PieChart.Data(Status.FAILED, stats.getAllStatus(Status.FAILED_INT)));
        if (stats.getAllStatus(Status.NOPLAY_INT) > 0)
            pieChartData.add(new PieChart.Data(Status.NOPLAY, stats.getAllStatus(Status.NOPLAY_INT)));
        statusPieChart.setData(pieChartData);
        setPieTooltips();
    }

    private void setPieTooltips() {
        for (PieChart.Data data : statusPieChart.getData()) {
            if (noPlayCheckBox.isSelected()) {
                Tooltip.install(data.getNode(), new Tooltip(round(100 * data.getPieValue() / stats.getTotal()) + "%"));
            } else {
                Tooltip.install(data.getNode(), new Tooltip(round(100 * data.getPieValue() / stats.getTotalPlayed()) + "%"));
            }
        }
    }

    @FXML
    private void setPieNoPlay() {
        if (!noPlayCheckBox.isSelected()) {
            statusPieChart.getData().remove(statusPieChart.getData().size() - 1);
            setPieTooltips();
        } else {
            statusPieChart.getData().add(new PieChart.Data(Status.NOPLAY, stats.getAllStatus(Status.NOPLAY_INT)));
            setPieTooltips();
        }
        Main.statsClearrateNoplay = noPlayCheckBox.isSelected();
    }

    private void fillGradeBarChart() {
        ObservableList<BarChart.Data> barChartData = FXCollections.observableArrayList();
        if (stats.getAllGrade(Grade.MAX_INT) > 0)
            barChartData.add(new BarChart.Data<>(Grade.MAX, stats.getAllGrade(Grade.MAX_INT)));
        if (stats.getAllGrade(Grade.MAX_INT) + stats.getAllGrade(Grade.AAA_INT) > 0)
            barChartData.add(new BarChart.Data<>(Grade.AAA, stats.getAllGrade(Grade.AAA_INT)));
        if (stats.getAllGrade(Grade.MAX_INT) + stats.getAllGrade(Grade.AAA_INT) + stats.getAllGrade(Grade.AA_INT) > 0)
            barChartData.add(new BarChart.Data<>(Grade.AA, stats.getAllGrade(Grade.AA_INT)));
        barChartData.add(new BarChart.Data<>(Grade.A, stats.getAllGrade(Grade.A_INT)));
        if (stats.getAllGrade(Grade.F_INT) + stats.getAllGrade(Grade.E_INT) + stats.getAllGrade(Grade.D_INT) + stats.getAllGrade(Grade.C_INT) + stats.getAllGrade(Grade.B_INT) > 0)
            barChartData.add(new BarChart.Data<>(Grade.B, stats.getAllGrade(Grade.B_INT)));
        if (stats.getAllGrade(Grade.F_INT) + stats.getAllGrade(Grade.E_INT) + stats.getAllGrade(Grade.D_INT) + stats.getAllGrade(Grade.C_INT) > 0)
            barChartData.add(new BarChart.Data<>(Grade.C, stats.getAllGrade(Grade.C_INT)));
        if (stats.getAllGrade(Grade.F_INT) + stats.getAllGrade(Grade.E_INT) + stats.getAllGrade(Grade.D_INT) > 0)
            barChartData.add(new BarChart.Data<>(Grade.D, stats.getAllGrade(Grade.D_INT)));
        if (stats.getAllGrade(Grade.F_INT) + stats.getAllGrade(Grade.E_INT) > 0)
            barChartData.add(new BarChart.Data<>(Grade.E, stats.getAllGrade(Grade.E_INT)));
        if (stats.getAllGrade(Grade.F_INT) > 0)
            barChartData.add(new BarChart.Data<>(Grade.F, stats.getAllGrade(Grade.F_INT)));
        ObservableList<BarChart.Series> barChartSeries = FXCollections.observableArrayList(new BarChart.Series("Grade", barChartData));
        gradeBarChart.setData(barChartSeries);

        for (BarChart.Data data : barChartData) {
            Tooltip.install(data.getNode(), new Tooltip(String.valueOf(data.getYValue())));
        }
    }

    private void fillCustomStackedBarChart(boolean details) {
        customStackedBarChart.getData().clear();
        if (details) {
            XYChart.Series<String, Number> npSeries = new XYChart.Series<>();
            npSeries.setName(Status.NOPLAY);
            XYChart.Series<String, Number> fSeries = new XYChart.Series<>();
            fSeries.setName(Status.FAILED);
            XYChart.Series<String, Number> acSeries = new XYChart.Series<>();
            acSeries.setName(Status.ASSISTCLEAR);
            XYChart.Series<String, Number> ecSeries = new XYChart.Series<>();
            ecSeries.setName(Status.EASYCLEAR);
            XYChart.Series<String, Number> cSeries = new XYChart.Series<>();
            cSeries.setName(Status.CLEAR);
            XYChart.Series<String, Number> hcSeries = new XYChart.Series<>();
            hcSeries.setName(Status.HARDCLEAR);
            XYChart.Series<String, Number> exSeries = new XYChart.Series<>();
            exSeries.setName(Status.EXHARDCLEAR);
            XYChart.Series<String, Number> fcSeries = new XYChart.Series<>();
            fcSeries.setName(Status.FULLCOMBO);

            for (String styleStr : Style.ALLSTYLES) {
                int style = Style.styleToInt(styleStr);
                int styleSongs = stats.getAllStyle(style);
                npSeries.getData().add(new XYChart.Data<>(styleStr, (double) 100 * stats.getStyleStatus(style, Status.NOPLAY_INT) / styleSongs));
                fSeries.getData().add(new XYChart.Data<>(styleStr, (double) 100 * stats.getStyleStatus(style, Status.FAILED_INT) / styleSongs));
                acSeries.getData().add(new XYChart.Data<>(styleStr, (double) 100 * stats.getStyleStatus(style, Status.ASSISTCLEAR_INT) / styleSongs));
                ecSeries.getData().add(new XYChart.Data<>(styleStr, (double) 100 * stats.getStyleStatus(style, Status.EASYCLEAR_INT) / styleSongs));
                cSeries.getData().add(new XYChart.Data<>(styleStr, (double) 100 * stats.getStyleStatus(style, Status.CLEAR_INT) / styleSongs));
                hcSeries.getData().add(new XYChart.Data<>(styleStr, (double) 100 * stats.getStyleStatus(style, Status.HARDCLEAR_INT) / styleSongs));
                exSeries.getData().add(new XYChart.Data<>(styleStr, (double) 100 * stats.getStyleStatus(style, Status.EXHARDCLEAR_INT) / styleSongs));
                fcSeries.getData().add(new XYChart.Data<>(styleStr, (double) 100 * stats.getStyleStatus(style, Status.FULLCOMBO_INT) / styleSongs));
            }

            customStackedBarChart.getData().addAll(npSeries, fSeries, acSeries, ecSeries, cSeries, hcSeries, exSeries, fcSeries);
        } else {
            XYChart.Series<String, Number> cSeries = new XYChart.Series<>();
            cSeries.setName("Cleared");
            XYChart.Series<String, Number> ncSeries = new XYChart.Series<>();
            ncSeries.setName("Not Cleared");

            for (String styleStr : Style.ALLSTYLES) {
                int style = Style.styleToInt(styleStr);
                cSeries.getData().add(new XYChart.Data<>(styleStr, (double) 100 * stats.getStyleCleared(style) / stats.getAllStyle(style)));
                ncSeries.getData().add(new XYChart.Data<>(styleStr, (double) 100 * stats.getStyleNotCleared(style) / stats.getAllStyle(style)));
            }

            customStackedBarChart.getData().addAll(cSeries, ncSeries);
        }

        //add tooltips
        for (int i = 0; i < customStackedBarChart.getData().size(); i++) {
            XYChart.Series series = (XYChart.Series) customStackedBarChart.getData().get(i);
            for (int j = 0; j < series.getData().size(); j++) {
                XYChart.Data data = ((XYChart.Data) series.getData().get(j));
                Tooltip.install(data.getNode(), new Tooltip(round((double) data.getYValue()) + "%"));
            }
        }
    }

    @FXML
    private void setStyleBarChartDetails() {
        if (styleDetailsCheckBox.isSelected()) {
            fillCustomStackedBarChart(true);
        } else {
            fillCustomStackedBarChart(false);
        }
        Main.statsStyleCompletionDetails = styleDetailsCheckBox.isSelected();
    }

    private void fillLevelBarChart(boolean details) {
        levelStackedBarChart.getData().clear();

        if (details) {
            XYChart.Series<String, Number> npSeries = new XYChart.Series<>();
            npSeries.setName(Status.NOPLAY);
            XYChart.Series<String, Number> fSeries = new XYChart.Series<>();
            fSeries.setName(Status.FAILED);
            XYChart.Series<String, Number> acSeries = new XYChart.Series<>();
            acSeries.setName(Status.ASSISTCLEAR);
            XYChart.Series<String, Number> ecSeries = new XYChart.Series<>();
            ecSeries.setName(Status.EASYCLEAR);
            XYChart.Series<String, Number> cSeries = new XYChart.Series<>();
            cSeries.setName(Status.CLEAR);
            XYChart.Series<String, Number> hcSeries = new XYChart.Series<>();
            hcSeries.setName(Status.HARDCLEAR);
            XYChart.Series<String, Number> exSeries = new XYChart.Series<>();
            exSeries.setName(Status.EXHARDCLEAR);
            XYChart.Series<String, Number> fcSeries = new XYChart.Series<>();
            fcSeries.setName(Status.FULLCOMBO);

            for (int level = 1; level <= 12; level++) {
                int levelSongs = stats.getAllLevel(level);
                npSeries.getData().add(new XYChart.Data<>(String.valueOf(level), (double) 100 * stats.getLevelStatus(level, Status.NOPLAY_INT) / levelSongs));
                fSeries.getData().add(new XYChart.Data<>(String.valueOf(level), (double) 100 * stats.getLevelStatus(level, Status.FAILED_INT) / levelSongs));
                acSeries.getData().add(new XYChart.Data<>(String.valueOf(level), (double) 100 * stats.getLevelStatus(level, Status.ASSISTCLEAR_INT) / levelSongs));
                ecSeries.getData().add(new XYChart.Data<>(String.valueOf(level), (double) 100 * stats.getLevelStatus(level, Status.EASYCLEAR_INT) / levelSongs));
                cSeries.getData().add(new XYChart.Data<>(String.valueOf(level), (double) 100 * stats.getLevelStatus(level, Status.CLEAR_INT) / levelSongs));
                hcSeries.getData().add(new XYChart.Data<>(String.valueOf(level), (double) 100 * stats.getLevelStatus(level, Status.HARDCLEAR_INT) / levelSongs));
                exSeries.getData().add(new XYChart.Data<>(String.valueOf(level), (double) 100 * stats.getLevelStatus(level, Status.EXHARDCLEAR_INT) / levelSongs));
                fcSeries.getData().add(new XYChart.Data<>(String.valueOf(level), (double) 100 * stats.getLevelStatus(level, Status.FULLCOMBO_INT) / levelSongs));
            }

            levelStackedBarChart.getData().addAll(npSeries, fSeries, acSeries, ecSeries, cSeries, hcSeries, exSeries, fcSeries);
        } else {
            XYChart.Series<String, Number> cSeries = new XYChart.Series<>();
            cSeries.setName("Cleared");
            XYChart.Series<String, Number> ncSeries = new XYChart.Series<>();
            ncSeries.setName("Not Cleared");

            for (int level = 1; level <= 12; level++) {
                int levelSongs = stats.getAllLevel(level);
                cSeries.getData().add(new XYChart.Data<>(String.valueOf(level), (double) 100 * stats.getLevelCleared(level) / levelSongs));
                ncSeries.getData().add(new XYChart.Data<>(String.valueOf(level), (double) 100 * stats.getLevelNotCleared(level) / levelSongs));
            }

            levelStackedBarChart.getData().addAll(cSeries, ncSeries);
        }

        //add tooltips
        for (int i = 0; i < levelStackedBarChart.getData().size(); i++) {
            XYChart.Series series = (XYChart.Series) levelStackedBarChart.getData().get(i);
            for (int j = 0; j < series.getData().size(); j++) {
                XYChart.Data data = (XYChart.Data) series.getData().get(j);
                Tooltip.install(data.getNode(), new Tooltip(round((double) data.getYValue()) + "%"));
            }
        }

    }

    @FXML
    private void setLevelBarChartDetails() {
        if (levelDetailsCheckBox.isSelected()) {
            fillLevelBarChart(true);
        } else {
            fillLevelBarChart(false);
        }
        Main.statsLevelCompletionDetails = levelDetailsCheckBox.isSelected();
    }


    /***** EXPORT *****/
    @FXML
    private void export() {
        FileChooser fileChooser = new FileChooser();
        String userDir = System.getProperty("user.home");
        if (Main.getOS() == Main.WINDOWS) userDir += "/Desktop";
        fileChooser.setInitialDirectory(new File(userDir));
        fileChooser.setInitialFileName("IIDX-FX_data.csv");
        FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Comma-separated values (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(csvFilter);
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(txtFilter);
        FileChooser.ExtensionFilter jsonFilter = new FileChooser.ExtensionFilter("JSON file (*.json)", "*.json");
        File file = fileChooser.showSaveDialog(scene.getWindow());
        if (fileChooser.getSelectedExtensionFilter() != null) {
            if (fileChooser.getSelectedExtensionFilter().equals(csvFilter)) exportCSV(file);
            else if (fileChooser.getSelectedExtensionFilter().equals(txtFilter)) exportCSV(file);
            else if (fileChooser.getSelectedExtensionFilter().equals(jsonFilter)) exportJSON(file);
        }
    }

    private void exportJSON(File file) {
        if (file != null) {
            JSONArray jsArr = new JSONArray();

            boolean exists;
            int nr;

            for (SongEntry entry : masterData) {
                exists = false;
                nr = 0;

                for (int i = 0; i < jsArr.length(); i++) {
                    if (entry.getId() == jsArr.getJSONObject(i).getInt("id")) {
                        exists = true;
                        nr = i;
                        break;
                    }
                }

                if (exists) {
                    JSONObject chartObject = new JSONObject();
                    chartObject.put("difficulty", Difficulty.difficultyToInt(entry.getDifficulty()));
                    chartObject.put("level", Integer.valueOf(entry.getLevel()));
                    chartObject.put("notes", Integer.valueOf(entry.getNotes()));
                    chartObject.put("length", lengthToInt(entry.getLength()));
                    chartObject.put("rating_n", entry.getnRating());
                    chartObject.put("rating_h", entry.gethRating());
                    chartObject.put("scratch_notes", entry.getScratchRaw());
                    final String bpm = entry.getBpm();
                    if (bpm.contains("-")) {
                        chartObject.put("bpmmin", Integer.valueOf(bpm.split("-")[0]));
                        chartObject.put("bpmmax", Integer.valueOf(bpm.split("-")[1]));
                    } else {
                        chartObject.put("bpmmin", Integer.valueOf(bpm));
                        chartObject.put("bpmmax", Integer.valueOf(bpm));
                    }
                    jsArr.getJSONObject(nr).getJSONArray("charts").put(chartObject);
                } else {
                    JSONObject jsObj = new JSONObject();
                    jsObj.put("id", entry.getId());
                    if (entry.getMusicId() != null) jsObj.put("arcanaid", entry.getMusicId());
                    jsObj.put("style", Style.styleToInt(entry.getStyle()));
                    jsObj.put("title", entry.getTitle());
                    jsObj.put("title_r", entry.getTitle_r());
                    jsObj.put("artist", entry.getArtist());
                    jsObj.put("artist_r", entry.getArtist_r());
                    jsObj.put("genre", entry.getGenre());
                    jsObj.put("textage", entry.getTextage());
                    jsObj.put("omni", entry.getOmnimix());

                    JSONArray chartArray = new JSONArray();
                    JSONObject chartObject = new JSONObject();
                    chartObject.put("difficulty", Difficulty.difficultyToInt(entry.getDifficulty()));
                    chartObject.put("level", Integer.valueOf(entry.getLevel()));
                    chartObject.put("notes", Integer.valueOf(entry.getNotes()));
                    chartObject.put("length", lengthToInt(entry.getLength()));
                    chartObject.put("rating_n", entry.getnRating());
                    chartObject.put("rating_h", entry.gethRating());
                    chartObject.put("scratch_notes", entry.getScratchRaw());
                    final String bpm = entry.getBpm();
                    if (bpm.contains("-")) {
                        chartObject.put("bpmmin", Integer.valueOf(bpm.split("-")[0]));
                        chartObject.put("bpmmax", Integer.valueOf(bpm.split("-")[1]));
                    } else {
                        chartObject.put("bpmmin", Integer.valueOf(bpm));
                        chartObject.put("bpmmax", Integer.valueOf(bpm));
                    }
                    chartArray.put(chartObject);

                    jsObj.put("charts", chartArray);

                    jsArr.put(jsObj);
                }
            }

            try {
                OutputStream outputStream = new FileOutputStream(file.getPath());
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                printWriter.println(jsArr.toString());
                printWriter.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    private void exportCSV(File file) {
        if (file != null) {
            try {
                OutputStream outputStream = new FileOutputStream(file.getPath());
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                printWriter.println("\"SongID\",\"Style\",\"Title\",\"Artist\",\"Genre\",\"Difficulty\",\"Level\",\"Normal Rating\",\"Hard Rating\",\"BPM\",\"Length\",\"Notes\",\"Scratch Notes\",\"Omnimix\",\"Status\",\"Grade\",\"Percent\",\"Ex Score\",\"Miss Count\"");
                for (SongEntry songEntry : masterData) {
                    int songid = songEntry.getId();
                    String style = "\"" + songEntry.getStyle() + "\"";
                    String title = "\"" + songEntry.getTitle().replaceAll("\"", "\"\"") + "\"";
                    String artist = "\"" + songEntry.getArtist().replaceAll("\"", "\"\"") + "\"";
                    String genre = "\"" + songEntry.getGenre() + "\"";
                    String difficulty = "\"" + songEntry.getDifficulty() + "\"";
                    int level = isInteger(songEntry.getLevel()) ? Integer.parseInt(songEntry.getLevel()) : -1;
                    int nRating = songEntry.getnRating();
                    int hRating = songEntry.gethRating();
                    String bpm = "\"" + songEntry.getBpm() + "\"";
                    String length = "\"" + songEntry.getLength() + "\"";
                    int notes = isInteger(songEntry.getNotes()) ? Integer.parseInt(songEntry.getNotes()) : -1;
                    int scratch_notes = songEntry.getScratchRaw();
                    String omnimix = songEntry.getOmnimix() == 0 ? "FALSE" : "TRUE";
                    String status = songEntry.getStatus().equals("") ? "" : "\"" + songEntry.getStatus() + "\"";
                    String grade = songEntry.getGrade().equals("") ? "" : "\"" + songEntry.getGrade().split(" ")[0] + "\"";
                    String percent = songEntry.getGrade().equals("") ? "" : "\"" + songEntry.getGrade().split(" ")[1].substring(1, songEntry.getGrade().split(" ")[1].length() - 1) + "\"";
                    String ex_score = songEntry.getEx_score().equals("") ? "" : songEntry.getEx_score();
                    String miss_count = songEntry.getMiss_count().equals("") ? "" : songEntry.getMiss_count();

                    String line = songid + "," + style + "," + title + "," + artist + "," + genre + "," + difficulty +
                            "," + level + "," + nRating + "," + hRating + "," + bpm + "," + length + "," + notes + "," + scratch_notes + "," + omnimix + "," +
                            status + "," + grade + "," + percent + "," + ex_score + "," + miss_count;

                    printWriter.println(line);
                }
                printWriter.close();
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    /***** DATA *****/
    //songid to style translation for blackanother, substream and revival charts
    private int getStyleFromID(int songID) {
        if (songID == 21244 || songID == 21241 || songID == 21240 || songID == 21257 || songID == 21238 ||
                songID == 21260 || songID == 21242 || songID == 21245 || songID == 21250 || songID == 21252 ||
                songID == 21253 || songID == 21256 || songID == 21254 || songID == 21255 || songID == 21247 ||
                songID == 21258 || songID == 21259 || songID == 21251 || songID == 21246 || songID == 21249 ||
                songID == 21243 || songID == 21262 || songID == 21239) return Style.EMPRESSINT;
        else if (songID == 21223 || songID == 21235 || songID == 21225 || songID == 21232 || songID == 21261 ||
                songID == 21231 || songID == 21234 || songID == 21228 || songID == 21263 || songID == 21226 ||
                songID == 21233 || songID == 21229 || songID == 21237 || songID == 21236 || songID == 21224)
            return Style.DJTROOPERSINT;
        else if (songID == 21221 || songID == 21222 || songID == 21220 || songID == 21264) return Style.GOLDINT;
        else if (songID == 21216 || songID == 21201 || songID == 21219 || songID == 21218 || songID == 21217)
            return Style.HAPPYSKYINT;
        else if (songID == 21214 || songID == 21215) return Style.IIDXREDINT;
        else if (songID == 21212 || songID == 21211 || songID == 21213) return Style.NINTHSTYLEINT;
        else if (songID == 21209 || songID == 21210) return Style.EIGHTHSTYLEINT;
        else if (songID == 21208) return Style.SEVENTHSTYLEINT;
        else if (songID == 21207) return Style.SIXTHSTYLEINT;
        else if (songID == 21206) return Style.FIFTHSTYLEINT;
        else if (songID == 21205) return Style.FOURTHSTYLEINT;
        else if (songID == 1013 || songID == 1015 || songID == 1008 || songID == 1007 || songID == 1019 ||
                songID == 1004 || songID == 1020 || songID == 1017 || songID == 1005 || songID == 21204 ||
                songID == 1401 || songID == 1402) return Style.SUBSTREAMINT;
        else if (songID > 9999) return Integer.parseInt(String.valueOf(songID).substring(0, 2));
        else return Integer.parseInt(String.valueOf(songID).substring(0, 1));
    }

    /***** MISC *****/
    private void copyToClipboard(String string) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(string), null);
    }

    private int lengthToInt(final String time) {
        if (time.contains(":")) {
            String[] tmp = time.split(":");
            return 60 * Integer.valueOf(tmp[0]) + Integer.valueOf(tmp[1]);
        } else return -1;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    private double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    //workaround for refreshing the table data
    //threading this sometimes causes nullpointerexception
    private void refreshTable() {
        if (filterField.getText().isEmpty() || filterField.getText().equals("")) {
            filterField.setText(" ");
            filterField.setText("");
        } else {
            final String tmp = filterField.getText();
            filterField.setText("");
            filterField.setText(tmp);
        }
        tableView.refresh();
    }

    @FXML
    private void quit() {
        ((Stage) scene.getWindow()).close();
        //save settings on exit
        Main.colorder = getColumnOrder();
        boolean[] columnVisibility = {styleColumn.isVisible(), titleColumn.isVisible(), artistColumn.isVisible(),
                genreColumn.isVisible(), difficultyColumn.isVisible(), levelColumn.isVisible(),
                ratingNColumn.isVisible(), ratingHColumn.isVisible(), bpmColumn.isVisible(), lengthColumn.isVisible(),
                notesColumn.isVisible(), statusColumn.isVisible(), gradeColumn.isVisible(), ex_scoreColumn.isVisible(),
                miss_countColumn.isVisible(), scratchColumn.isVisible()};
        Main.setProperties(columnVisibility);
    }

}
