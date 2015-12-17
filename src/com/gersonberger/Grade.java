package com.gersonberger;

public class Grade {

    public static final String NONE = "";
    public static final String F = "F";
    public static final String E = "E";
    public static final String D = "D";
    public static final String C = "C";
    public static final String B = "B";
    public static final String A = "A";
    public static final String AA = "AA";
    public static final String AAA = "AAA";
    public static final String MAX = "MAX";

    public static final int NONE_INT = 0;
    public static final int F_INT = 1;
    public static final int E_INT = 2;
    public static final int D_INT = 3;
    public static final int C_INT = 4;
    public static final int B_INT = 5;
    public static final int A_INT = 6;
    public static final int AA_INT = 7;
    public static final int AAA_INT = 8;
    public static final int MAX_INT = 9;

    public static int gradeToInt(String grade) {
        switch (grade) {
            case F:
                return F_INT;
            case E:
                return E_INT;
            case D:
                return D_INT;
            case C:
                return C_INT;
            case B:
                return B_INT;
            case A:
                return A_INT;
            case AA:
                return AA_INT;
            case AAA:
                return AAA_INT;
            case MAX:
                return MAX_INT;
            default:
                return NONE_INT;
        }
    }

}
