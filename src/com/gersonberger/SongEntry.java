package com.gersonberger;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class SongEntry {

    private final StringProperty style = new SimpleStringProperty(this, "Style");
    private final StringProperty title = new SimpleStringProperty(this, "Title");
    private final StringProperty title_r = new SimpleStringProperty(this, "Title_r");
    private final StringProperty artist = new SimpleStringProperty(this, "Artist");
    private final StringProperty artist_r = new SimpleStringProperty(this, "Artist_r");
    private final StringProperty genre = new SimpleStringProperty(this, "Genre");
    private final StringProperty difficulty = new SimpleStringProperty(this, "Difficulty");
    private final StringProperty level = new SimpleStringProperty(this, "Level");
    private final IntegerProperty nRating = new SimpleIntegerProperty(this, "nRating");
    private final StringProperty nRating_s = new SimpleStringProperty(this, "nRating_s");
    private final StringProperty hRating_s = new SimpleStringProperty(this, "hRating_s");
    private final IntegerProperty hRating = new SimpleIntegerProperty(this, "hRating");
    private final StringProperty bpm = new SimpleStringProperty(this, "Bpm");
    private final StringProperty length = new SimpleStringProperty(this, "Length");
    private final StringProperty notes = new SimpleStringProperty(this, "Notes");
    private final StringProperty scratch = new SimpleStringProperty(this, "Scratch");
    private final StringProperty status = new SimpleStringProperty(this, "Status");
    private final StringProperty grade = new SimpleStringProperty(this, "Grade");
    private final StringProperty miss_count = new SimpleStringProperty(this, "Miss_count");
    private final StringProperty ex_score = new SimpleStringProperty(this, "Ex_score");

    private int id;
    private String musicId;
    private String chartId;

    private String textage;
    private int scratchRaw;
    private int omnimix;


    public SongEntry(int id, int style, String title, String title_r, String artist, String artist_r, String genre,
                     int difficulty, int level, int nRating, int hRating, int bpmMin, int bpmMax, int length,
                     int notes, int scratch, int status, String grade, int miss_count, int ex_score, String textage, int omnimix) {
        this.id = id;
        this.style.set(Style.styleToString(style));
        this.title.set(title);
        this.title_r.set(title_r);
        this.artist.set(artist);
        this.artist_r.set(artist_r);
        this.genre.set(genre);
        this.difficulty.set(Difficulty.difficultyToString(difficulty));
        this.level.set(String.valueOf(level));
        this.nRating_s.set(formatRating(level, nRating));
        this.nRating.set(nRating);
        this.hRating_s.set(formatRating(level, hRating));
        this.hRating.set(hRating);
        if (bpmMin == bpmMax) this.bpm.set(String.valueOf(bpmMin));
        else this.bpm.set(bpmMin + "-" + bpmMax);
        this.length.set(formatLength(length));
        this.notes.set(String.valueOf(notes));
        this.status.set(Status.statusToString(status));
        this.grade.set(grade);
        this.miss_count.set(miss_count == -2 ? "" : miss_count == -1 ? "N/A" : String.valueOf(miss_count));
        this.ex_score.set(ex_score == 0 ? "" : String.valueOf(ex_score));
        this.scratchRaw = scratch;
        if (scratch == -1) this.scratch.set("N/A");
        else {
            String scr = String.valueOf(round(100d * scratch / notes, 2));
            if (scr.split("\\.")[1].length() < 2) scr += "0%";
            else scr += "%";
            this.scratch.set(scr);
        }
        this.textage = textage;
        this.omnimix = omnimix;
    }

    public SongEntry(int id, int style, String title, String title_r, String artist, String artist_r, String genre,
                     int difficulty, int level, int nRating, int hRating, int bpmMin, int bpmMax, int length,
                     int notes, int scratch, int status, String grade, int miss_count, int ex_score, String textage, int omnimix, String arcanaMusicId) {
        this.id = id;
        this.style.set(Style.styleToString(style));
        this.title.set(title);
        this.title_r.set(title_r);
        this.artist.set(artist);
        this.artist_r.set(artist_r);
        this.genre.set(genre);
        this.difficulty.set(Difficulty.difficultyToString(difficulty));
        this.level.set(String.valueOf(level));
        this.nRating_s.set(formatRating(level, nRating));
        this.nRating.set(nRating);
        this.hRating_s.set(formatRating(level, hRating));
        this.hRating.set(hRating);
        if (bpmMin == bpmMax) this.bpm.set(String.valueOf(bpmMin));
        else this.bpm.set(bpmMin + "-" + bpmMax);
        this.length.set(formatLength(length));
        this.notes.set(String.valueOf(notes));
        this.status.set(Status.statusToString(status));
        this.grade.set(grade);
        this.miss_count.set(miss_count == -2 ? "" : miss_count == -1 ? "N/A" : String.valueOf(miss_count));
        this.ex_score.set(ex_score == 0 ? "" : String.valueOf(ex_score));
        this.scratchRaw = scratch;
        if (scratch == -1) this.scratch.set("N/A");
        else {
            String scr = String.valueOf(round(100d * scratch / notes, 2));
            if (scr.split("\\.")[1].length() < 2) scr += "0%";
            else scr += "%";
            this.scratch.set(scr);
        }
        this.textage = textage;
        //if (id > 21xxx)
        this.omnimix = omnimix;
        this.musicId = arcanaMusicId;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        if (Double.isNaN(value)) {
            return 0.0;
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private String formatLength(int length){
        int minutes = 0;
        while (length >= 60){
            minutes++;
            length -= 60;
        }
        if (length < 10) return minutes + ":0" + length;
        else return minutes + ":" + length;
    }

    private String formatRating(int level, int rating) {
        if (rating == -1) return Rating.NA;
        if (rating == 0) return Rating.LOW;
        if (level < 12 && rating > 10) return level + "." + Rating.PLUS10;
        if (level == 12 && rating > 15) return level + "." + Rating.PLUS15;
        if (rating > 0 && rating <= 15) return level + "." + rating;
        else return Rating.ERROR;
    }

    public int getId() {
        return id;
    }

    public String getStyle() {
        return style.get();
    }

    public StringProperty styleProperty() {
        return style;
    }

    public void setStyle(String style) {
        this.style.set(style);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getTitle_r() {
        return title_r.get();
    }

    public StringProperty title_rProperty() {
        return title_r;
    }

    public void setTitle_r(String title_r) {
        this.title_r.set(title_r);
    }

    public String getArtist() {
        return artist.get();
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getArtist_r() {
        return artist_r.get();
    }

    public StringProperty artist_rProperty() {
        return artist_r;
    }

    public void setArtist_r(String artist_r) {
        this.artist_r.set(artist_r);
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getDifficulty() {
        return difficulty.get();
    }

    public StringProperty difficultyProperty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty.set(difficulty);
    }

    public String getLevel() {
        return level.get();
    }

    public StringProperty levelProperty() {
        return level;
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public int getnRating() {
        return nRating.get();
    }

    public IntegerProperty nRatingProperty() {
        return nRating;
    }

    public void setnRating(int nRating) {
        this.nRating.set(nRating);
    }

    public String getnRating_s() {
        return nRating_s.get();
    }

    public StringProperty nRating_sProperty() {
        return nRating_s;
    }

    public void setnRating_s(String nRating_s) {
        this.nRating_s.set(nRating_s);
    }

    public String gethRating_s() {
        return hRating_s.get();
    }

    public StringProperty hRating_sProperty() {
        return hRating_s;
    }

    public void sethRating_s(String hRating_s) {
        this.hRating_s.set(hRating_s);
    }

    public int gethRating() {
        return hRating.get();
    }

    public IntegerProperty hRatingProperty() {
        return hRating;
    }

    public void sethRating(int hRating) {
        this.hRating.set(hRating);
    }

    public String getBpm() {
        return bpm.get();
    }

    public StringProperty bpmProperty() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm.set(bpm);
    }

    public String getLength() {
        return length.get();
    }

    public StringProperty lengthProperty() {
        return length;
    }

    public void setLength(String length) {
        this.length.set(length);
    }

    public String getNotes() {
        return notes.get();
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getGrade() {
        return grade.get();
    }

    public StringProperty gradeProperty() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public String getMiss_count() {
        return miss_count.get();
    }

    public StringProperty miss_countProperty() {
        return miss_count;
    }

    public void setMiss_count(String miss_count) {
        this.miss_count.set(miss_count);
    }

    public String getEx_score() {
        return ex_score.get();
    }

    public StringProperty ex_scoreProperty() {
        return ex_score;
    }

    public void setEx_score(String ex_score) {
        this.ex_score.set(ex_score);
    }

    public String getScratch() {
        return scratch.get();
    }

    public StringProperty scratchProperty() {
        return scratch;
    }

    public void setScratch(String scratch) {
        this.scratch.set(scratch);
    }

    public int getScratchRaw() { return scratchRaw; }

    public String getTextage() {
        return textage;
    }

    public int getOmnimix() {
        return omnimix;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getChartId() {
        return chartId;
    }

    public void setChartId(String chartId) {
        this.chartId = chartId;
    }
}
