package com.gersonberger;

import javafx.collections.ObservableList;

import java.util.Arrays;


class Stats {

    //statsAllStatus[status]
    //status: 0=noplay, 1=failed, ..., 7=fullcombo
    private int[] statsAllStatus = new int[8];

    //statsAllGrade[grade]
    //grade: 0=none, 1=F, 2=E, ..., 7=AA, 8=AAA, 8=MAX
    private int[] statsAllGrade = new int[10];

    //statsLevel[level][status]
    //level: 0=1, 1=2, ..., 11=12
    //status: 0=noplay, 1=failed, ..., 7=fullcombo
    private int[][] statsLevel = new int[12][8];

    //statsLevel[style][status]
    //style: 0=1st Style, 1=Substream, ..., 23=copula
    //status: 0=noplay, 1=failed, ..., 7=fullcombo
    private int[][] statsStyle = new int[24][8];


    Stats(ObservableList<SongEntry> masterData){
        //init array with 0
        for (int[] row : statsLevel) Arrays.fill(row, 0);
        for (int[] row : statsStyle) Arrays.fill(row, 0);

        int style;
        int grade;
        int status;
        int level;
        for (SongEntry songEntry : masterData) {
            if (songEntry.getOmnimix() == 1 && Main.songlist.equals(Style.COPULAFULL)) continue;
            style = Style.styleToInt(songEntry.getStyle());
            grade = songEntry.getGrade().equals("") ? Grade.NONE_INT : Grade.gradeToInt(songEntry.getGrade().split(" ")[0]);
            status = Status.statusToInt(songEntry.getStatus());
            level = Integer.valueOf(songEntry.getLevel()) - 1;

            statsAllStatus[status]++;
            statsAllGrade[grade]++;
            statsLevel[level][status]++;
            statsStyle[style][status]++;
        }
    }

    int getAllStatus(int status) {
        return statsAllStatus[status];
    }

    int getAllGrade(int grade) {
        return statsAllGrade[grade];
    }

    int getTotalClears() {
        return getAllStatus(Status.CLEAR_INT) + getAllStatus(Status.HARDCLEAR_INT) + getAllStatus(Status.EXHARDCLEAR_INT) + getAllStatus(Status.FULLCOMBO_INT);
    }

    int getTotal() {
        return getAllStatus(Status.NOPLAY_INT) + getAllStatus(Status.FAILED_INT) + getAllStatus(Status.ASSISTCLEAR_INT) + getAllStatus(Status.EASYCLEAR_INT)
            + getAllStatus(Status.CLEAR_INT) + getAllStatus(Status.HARDCLEAR_INT) + getAllStatus(Status.EXHARDCLEAR_INT) + getAllStatus(Status.FULLCOMBO_INT);
    }

    int getTotalPlayed() {
        return getAllStatus(Status.FAILED_INT) + getAllStatus(Status.ASSISTCLEAR_INT) + getAllStatus(Status.EASYCLEAR_INT)
        + getAllStatus(Status.CLEAR_INT) + getAllStatus(Status.HARDCLEAR_INT) + getAllStatus(Status.EXHARDCLEAR_INT) + getAllStatus(Status.FULLCOMBO_INT);
    }

    int getAllStyle(int style) {
        int val = 0;
        for (int i = 0; i < statsStyle[style].length; i++) {
            val += statsStyle[style][i];
        }
        return val;
    }

    int getAllLevel(int level) {
        level--;
        int val = 0;
        for (int i = 0; i < statsLevel[level].length; i++) {
            val += statsLevel[level][i];
        }
        return val;
    }

    int getLevelStatus(int level, int status) {
        return statsLevel[level - 1][status];
    }

    int getLevelCleared(int level) {
        level--;
        return statsLevel[level][Status.CLEAR_INT] + statsLevel[level][Status.HARDCLEAR_INT] + statsLevel[level][Status.EXHARDCLEAR_INT] + statsLevel[level][Status.FULLCOMBO_INT];
    }

    int getLevelNotCleared(int level) {
        level--;
        return statsLevel[level][Status.NOPLAY_INT] + statsLevel[level][Status.FAILED_INT] + statsLevel[level][Status.ASSISTCLEAR_INT] + statsLevel[level][Status.EASYCLEAR_INT];
    }

    int getStyleStatus(int style, int status) {
        return statsStyle[style][status];
    }

    int getStyleCleared(int style) {
        return statsStyle[style][Status.CLEAR_INT] + statsStyle[style][Status.HARDCLEAR_INT] + statsStyle[style][Status.EXHARDCLEAR_INT] + statsStyle[style][Status.FULLCOMBO_INT];
    }

    int getStyleNotCleared(int style) {
        return statsStyle[style][Status.NOPLAY_INT] + statsStyle[style][Status.FAILED_INT] + statsStyle[style][Status.ASSISTCLEAR_INT] + statsStyle[style][Status.EASYCLEAR_INT];
    }

}
