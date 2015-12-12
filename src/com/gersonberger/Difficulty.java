package com.gersonberger;


public class Difficulty {

    public static final String NORMAL = "Normal";
    public static final String HYPER = "Hyper";
    public static final String ANOTHER = "Another";
    public static final String BEGINNER = "Beginner";
    public static final String BLACKANOTHER = "Black Another";
    public static final String LEGGENDARIA = "LEGGENDARIA";
    public static final String OTHER = "Other";

    public static final int NORMALINT = 1;
    public static final int HYPERINT = 2;
    public static final int ANOTHERINT = 3;
    public static final int BEGINNERINT = 4;
    public static final int BLACKANOTHERINT = 5;
    public static final int LEGGENDARIAINT = 6;
    public static final int OTHERINT = 0;

//    public static final String[] ALLDIFFICULTIES = {NORMAL, HYPER, ANOTHER, BEGINNER, BLACKANOTHER, LEGGENDARIA};

    public static int difficultyToInt(String difficulty) {
        switch (difficulty) {
            case NORMAL:
                return NORMALINT;
            case HYPER:
                return HYPERINT;
            case ANOTHER:
                return ANOTHERINT;
            case BEGINNER:
                return BEGINNERINT;
            case BLACKANOTHER:
                return BLACKANOTHERINT;
            case LEGGENDARIA:
                return LEGGENDARIAINT;
            default:
                return OTHERINT;
        }
    }

    public static String difficultyToString(int difficulty) {
        switch (difficulty) {
            case NORMALINT:
                return NORMAL;
            case HYPERINT:
                return HYPER;
            case ANOTHERINT:
                return ANOTHER;
            case BEGINNERINT:
                return BEGINNER;
            case BLACKANOTHERINT:
                return BLACKANOTHER;
            case LEGGENDARIAINT:
                return LEGGENDARIA;
            default:
                return OTHER;
        }
    }

}
