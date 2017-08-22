package com.gersonberger;

import javafx.collections.ObservableList;

import java.util.Arrays;


class Stats {

    //statsAllStatus[status][difficulty]
    //status: 0=noplay, 1=failed, ..., 7=fullcombo
    //difficulty: 0=normal, 1=hyper, 2=another
    //level: 0=level 1, 1=level 2, 11=level 12
    private int[][][] statsAllStatus = new int[8][3][12];

    //statsAllGrade[grade]
    //grade: 0=none, 1=F, 2=E, ..., 7=AA, 8=AAA, 8=MAX
    //difficulty: 0=normal, 1=hyper, 2=another
    //level: 0=level 1, 1=level 2, 11=level 12
    private int[][][] statsAllGrade = new int[10][3][12];

    //statsStyle[style][status]
    //style: 0=1st Style, 1=Substream, ..., 23=copula
    //status: 0=noplay, 1=failed, ..., 7=fullcombo
    //difficulty: 0=normal, 1=hyper, 2=another
    //level: 0=level 1, 1=level 2, 11=level 12
    private int[][][][] statsStyle = new int[24][8][3][12];


    Stats(ObservableList<SongEntry> masterData){
        //init array with 0
        for (int[][][] grid3 : statsStyle) {
            for (int[][] grid2 : grid3) {
                for (int[] grid : grid2) {
                    Arrays.fill(grid, 0);
                }
            }
        }

        int style;
        int grade;
        int status;
        int level;
        int difficulty;
        for (SongEntry songEntry : masterData) {
            if (songEntry.getOmnimix() == 1 && Main.songlist.equals(Style.COPULAFULL)) continue;
            style = Style.styleToInt(songEntry.getStyle());
            grade = songEntry.getGrade().equals("") ? Grade.NONE_INT : Grade.gradeToInt(songEntry.getGrade().split(" ")[0]);
            status = Status.statusToInt(songEntry.getStatus());
            level = Integer.valueOf(songEntry.getLevel()) - 1;
            switch (songEntry.getDifficulty()) {
                case Difficulty.NORMAL:
                    difficulty = Difficulty.NORMAL_INT;
                    break;
                case Difficulty.HYPER:
                    difficulty = Difficulty.HYPER_INT;
                    break;
                case Difficulty.ANOTHER:
                case Difficulty.BLACKANOTHER:
                case Difficulty.LEGGENDARIA:
                    difficulty = Difficulty.ANOTHER_INT;
                    break;
                default:
                    difficulty = Difficulty.ANOTHER_INT;
            }
            difficulty--;

            statsAllStatus[status][difficulty][level]++;
            statsAllGrade[grade][difficulty][level]++;
            statsStyle[style][status][difficulty][level]++;
        }
    }

    int getAllStatus(int status, int levelLow, int levelHigh, int... difficulty) {
        int val = 0;
        if (difficulty.length == 0) difficulty = new int[]{1, 2, 3};
        for (int d : difficulty) {
            for (int l = levelLow; l <= levelHigh; l++) {
                val += statsAllStatus[status][d - 1][l - 1];
            }

        }
        return val;
    }

    int getAllGrade(int grade, int levelLow, int levelHigh, int... difficulty) {
        int val = 0;
        if (difficulty.length == 0) difficulty = new int[]{1, 2, 3};
        for (int d : difficulty) {
            for (int l = levelLow; l <= levelHigh; l++) {
                val += statsAllGrade[grade][d - 1][l - 1];
            }
        }
        return val;
    }

    int getTotalClears(int levelLow, int levelHigh, int... difficulty) {
        return getAllStatus(Status.CLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.HARDCLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.EXHARDCLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.FULLCOMBO_INT, levelLow, levelHigh, difficulty);
    }

    int getTotal(int levelLow, int levelHigh, int... difficulty) {
        return getAllStatus(Status.NOPLAY_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.FAILED_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.ASSISTCLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.EASYCLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.CLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.HARDCLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.EXHARDCLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.FULLCOMBO_INT, levelLow, levelHigh, difficulty);
    }

    int getTotalPlayed(int levelLow, int levelHigh, int... difficulty) {
        return getAllStatus(Status.FAILED_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.ASSISTCLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.EASYCLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.CLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.HARDCLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.EXHARDCLEAR_INT, levelLow, levelHigh, difficulty) +
                getAllStatus(Status.FULLCOMBO_INT, levelLow, levelHigh, difficulty);
    }

    int getAllStyle(int style, int levelLow, int levelHigh, int... difficulty) {
        int val = 0;
        if (difficulty.length == 0) difficulty = new int[]{1, 2, 3};
        for (int s = 0; s < statsStyle[style].length; s++) {
            for (int d : difficulty) {
                for (int l = levelLow; l <= levelHigh; l++) {
                    val += statsStyle[style][s][d - 1][l - 1];
                }
            }
        }
        return val;
    }

    int getStyleStatus(int style, int status, int levelLow, int levelHigh, int... difficulty) {
        int val = 0;
        if (difficulty.length == 0) difficulty = new int[]{1,2,3};
        for (int d : difficulty) {
            for (int l = levelLow; l <= levelHigh; l++) {
                val += statsStyle[style][status][d - 1][l - 1];
            }
        }
        return val;
    }

    int getStyleCleared(int style, int levelLow, int levelHigh, int... difficulty) {
        levelLow--;
        levelHigh--;
        int val = 0;
        if (difficulty.length == 0) difficulty = new int[]{1,2,3};
        for (int d : difficulty) {
            for (int l = levelLow; l <= levelHigh; l++) {
                val +=statsStyle[style][Status.CLEAR_INT][d - 1][l];
                val +=statsStyle[style][Status.HARDCLEAR_INT][d - 1][l];
                val +=statsStyle[style][Status.EXHARDCLEAR_INT][d - 1][l];
                val +=statsStyle[style][Status.FULLCOMBO_INT][d - 1][l];
            }
        }
        return val;
    }

    int getStyleNotCleared(int style, int levelLow, int levelHigh, int... difficulty) {
        levelLow--;
        levelHigh--;
        int val = 0;
        if (difficulty.length == 0) difficulty = new int[]{1,2,3};
        for (int d : difficulty) {
            for (int l = levelLow; l <= levelHigh; l++) {
                val += statsStyle[style][Status.NOPLAY_INT][d - 1][l];
                val += statsStyle[style][Status.FAILED_INT][d - 1][l];
                val += statsStyle[style][Status.ASSISTCLEAR_INT][d - 1][l];
                val += statsStyle[style][Status.EASYCLEAR_INT][d - 1][l];
            }
        }
        return val;
    }

}
