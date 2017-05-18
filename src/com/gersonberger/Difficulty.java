package com.gersonberger;


public class Difficulty {

    static final String NORMAL = "Normal";
    static final String HYPER = "Hyper";
    static final String ANOTHER = "Another";
    static final String BEGINNER = "Beginner";
    static final String BLACKANOTHER = "Black Another";
    static final String LEGGENDARIA = "LEGGENDARIA";
    static final String OTHER = "Other";

    static final int NORMAL_INT = 1;
    static final int HYPER_INT = 2;
    static final int ANOTHER_INT = 3;
    static final int BEGINNER_INT = 4;
    static final int BLACKANOTHER_INT = 5;
    static final int LEGGENDARIA_INT = 6;
    static final int OTHER_INT = 0;

    static int difficultyToInt(String difficulty) {
        switch (difficulty) {
            case NORMAL:
                return NORMAL_INT;
            case HYPER:
                return HYPER_INT;
            case ANOTHER:
                return ANOTHER_INT;
            case BEGINNER:
                return BEGINNER_INT;
            case BLACKANOTHER:
                return BLACKANOTHER_INT;
            case LEGGENDARIA:
                return LEGGENDARIA_INT;
            default:
                return OTHER_INT;
        }
    }

    static String difficultyToString(int difficulty) {
        switch (difficulty) {
            case NORMAL_INT:
                return NORMAL;
            case HYPER_INT:
                return HYPER;
            case ANOTHER_INT:
                return ANOTHER;
            case BEGINNER_INT:
                return BEGINNER;
            case BLACKANOTHER_INT:
                return BLACKANOTHER;
            case LEGGENDARIA_INT:
                return LEGGENDARIA;
            default:
                return OTHER;
        }
    }

    static String difficultyToTextageChar(String difficulty) {
        switch (difficulty) {
            case NORMAL:
                return "N";
            case HYPER:
                return "H";
            case ANOTHER:
                return "A";
            case BEGINNER:
                return "R";
            case BLACKANOTHER:
                return "X";
            case LEGGENDARIA:
                return "A";
            default:
                return "H";
        }
    }

    static int networkDifficultyToInt(String difficulty) {
        switch (difficulty) {
            case "NORMAL":
                return NORMAL_INT;
            case "HYPER":
                return HYPER_INT;
            case "ANOTHER":
                return ANOTHER_INT;
            case "BLACK":
                return BLACKANOTHER_INT;
            default:
                return OTHER_INT;
        }
    }

}
