package com.gersonberger;


public class Clear {

    /** offer short version string of clears?
     * public static final String NOPLAY = "";
     * public static final String FAILED = "FLD";
     * public static final String ASSISTCLEAR = "AC";
     * public static final String EASYCLEAR = "EC";
     * public static final String CLEAR = "CLR";
     * public static final String HARDCLEAR = "HC";
     * public static final String EXHARDCLEAR = "EXHC";
     * public static final String FULLCOMBO = "FC";
     **/

    public static final String NOPLAY = "";
    public static final String FAILED = "Failed";
    public static final String ASSISTCLEAR = "Assist Clear";
    public static final String EASYCLEAR = "Easy Clear";
    public static final String CLEAR = "Clear";
    public static final String HARDCLEAR = "Hard Clear";
    public static final String EXHARDCLEAR = "Ex Hard Clear";
    public static final String FULLCOMBO = "Full Combo";

    public static final int NOPLAY_INT = 0;
    public static final int FAILED_INT = 1;
    public static final int ASSISTCLEAR_INT= 2;
    public static final int EASYCLEAR_INT = 3;
    public static final int CLEAR_INT = 4;
    public static final int HARDCLEAR_INT = 5;
    public static final int EXHARDCLEAR_INT = 6;
    public static final int FULLCOMBO_INT = 7;

    public static String clearToString(int clear) {
        switch (clear) {
            case FAILED_INT:
                return FAILED;
            case ASSISTCLEAR_INT:
                return ASSISTCLEAR;
            case EASYCLEAR_INT:
                return EASYCLEAR;
            case CLEAR_INT:
                return CLEAR;
            case HARDCLEAR_INT:
                return HARDCLEAR;
            case EXHARDCLEAR_INT:
                return EXHARDCLEAR;
            case FULLCOMBO_INT:
                return FULLCOMBO;
            default:
                return NOPLAY;
        }
    }

    public static int clearToInt(String clear) {
        switch (clear) {
            case FAILED:
                return FAILED_INT;
            case ASSISTCLEAR:
                return ASSISTCLEAR_INT;
            case EASYCLEAR:
                return EASYCLEAR_INT;
            case CLEAR:
                return CLEAR_INT;
            case HARDCLEAR:
                return HARDCLEAR_INT;
            case EXHARDCLEAR:
                return EXHARDCLEAR_INT;
            case FULLCOMBO:
                return FULLCOMBO_INT;
            default:
                return NOPLAY_INT;
        }
    }

}
