package com.gersonberger;


class Grade {

    static final String F = "F";
    static final String E = "E";
    static final String D = "D";
    static final String C = "C";
    static final String B = "B";
    static final String A = "A";
    static final String AA = "AA";
    static final String AAA = "AAA";
    static final String MAX = "MAX";
    static final String NONE = "";

    static final int NONE_INT = 0;
    static final int F_INT = 1;
    static final int E_INT = 2;
    static final int D_INT = 3;
    static final int C_INT = 4;
    static final int B_INT = 5;
    static final int A_INT = 6;
    static final int AA_INT = 7;
    static final int AAA_INT = 8;
    static final int MAX_INT = 9;

    static int gradeToInt(String grade) {
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

    static String gradeToString(int grade) {
        switch (grade) {
            case F_INT:
                return F;
            case E_INT:
                return E;
            case D_INT:
                return D;
            case C_INT:
                return C;
            case B_INT:
                return B;
            case A_INT:
                return A;
            case AA_INT:
                return AA;
            case AAA_INT:
                return AAA;
            case MAX_INT:
                return MAX;
            default:
                return NONE;
        }
    }

    static String percentageToString(int ex_score, int notes) {
        double percentage = ex_score / (notes * 2d);
        if (percentage == 1d) return MAX;
        else if (percentage >= 8d/9d) return AAA;
        else if (percentage >= 7d/9d) return AA;
        else if (percentage >= 6d/9d) return A;
        else if (percentage >= 5d/9d) return B;
        else if (percentage >= 4d/9d) return C;
        else if (percentage >= 3d/9d) return D;
        else if (percentage >= 2d/9d) return E;
        else return F;
    }

    static int getDifferenceNextGrade(String grade, int notes, int ex) {
        switch (grade) {
            case MAX:
                return -1;
            case AAA:
                return (notes * 2 + 1) - ex;
            case AA:
                return (notes * 2 * 8 / 9 + 1) - ex;
            case A:
                return (notes * 2 * 7 / 9 + 1) - ex;
            case B:
                return (notes * 2 * 6 / 9 + 1) - ex;
            case C:
                return (notes * 2 * 5 / 9 + 1) - ex;
            case D:
                return (notes * 2 * 4 / 9 + 1) - ex;
            case E:
                return (notes * 2 * 3 / 9 + 1) - ex;
            case F:
                return (notes * 2 * 2 / 9 + 1) - ex;
            default:
                return -1;
        }
    }

    static int getDifferenceCurrentGrade(String grade, int notes, int ex) {
        switch (grade) {
            case MAX:
                return 0;
            case AAA:
                return ex - (notes * 2 * 8 / 9 + 1);
            case AA:
                return ex - (notes * 2 * 7 / 9 + 1);
            case A:
                return ex - (notes * 2 * 6 / 9 + 1);
            case B:
                return ex - (notes * 2 * 5 / 9 + 1);
            case C:
                return ex - (notes * 2 * 4 / 9 + 1);
            case D:
                return ex - (notes * 2 * 3 / 9 + 1);
            case E:
                return ex - (notes * 2 * 2 / 9 + 1);
            case F:
                return ex;
            default:
                return -1;
        }
    }

    static String getNextGrade(String grade) {
        switch (grade) {
            case MAX:
                return "";
            case AAA:
                return MAX;
            case AA:
                return AAA;
            case A:
                return AA;
            case B:
                return A;
            case C:
                return B;
            case D:
                return C;
            case E:
                return D;
            case F:
                return E;
            default:
                return "";
        }
    }

}
