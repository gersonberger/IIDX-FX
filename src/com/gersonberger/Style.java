package com.gersonberger;


public class Style {

    private static final String beatmania = "beatmania IIDX";

    public static final String OMNIMIX = "Omnimix";
    public static final String COPULA = "Copula";
    public static final String PENDUAL = "Pendual";
    public static final String SPADA = "Spada";
    public static final String TRICORO = "Tricoro";
    public static final String LINCLE = "Lincle";
    public static final String RESORTANTHEM = "Resort Anthem";
    public static final String SIRIUS = "Sirius";
    public static final String EMPRESS = "Empress";
    public static final String DJTROOPERS = "DJ Troopers";
    public static final String GOLD = "Gold";
    public static final String DISTORTED = "Distorted";
    public static final String HAPPYSKY = "Happy Sky";
    public static final String IIDXRED = "IIDX Red";
    public static final String TENTHSTYLE = "10th Style";
    public static final String NINTHSTYLE = "9th Style";
    public static final String EIGHTHSTYLE = "8th Style";
    public static final String SEVENTHSTYLE = "7th Style";
    public static final String SIXTHSTYLE = "6th Style";
    public static final String FIFTHSTYLE = "5th Style";
    public static final String FOURTHSTYLE = "4th Style";
    public static final String THIRDSTYLE = "3rd Style";
    public static final String SECONDSTYLE = "2nd Style";
    public static final String SUBSTREAM = "Substream";
    public static final String FIRSTSTYLE = "1st Style";
    public static final String OTHER = "Other";

    public static final int COPULAINT = 23;
    public static final int PENDUALINT = 22;
    public static final int SPADAINT = 21;
    public static final int TRICOROINT = 20;
    public static final int LINCLEINT = 19;
    public static final int RESORTANTHEMINT = 18;
    public static final int SIRIUSINT = 17;
    public static final int EMPRESSINT = 16;
    public static final int DJTROOPERSINT = 15;
    public static final int GOLDINT = 14;
    public static final int DISTORTEDINT = 13;
    public static final int HAPPYSKYINT = 12;
    public static final int IIDXREDINT = 11;
    public static final int TENTHSTYLEINT = 10;
    public static final int NINTHSTYLEINT = 9;
    public static final int EIGHTHSTYLEINT = 8;
    public static final int SEVENTHSTYLEINT = 7;
    public static final int SIXTHSTYLEINT = 6;
    public static final int FIFTHSTYLEINT = 5;
    public static final int FOURTHSTYLEINT = 4;
    public static final int THIRDSTYLEINT = 3;
    public static final int SECONDSTYLEINT = 2;
    public static final int SUBSTREAMINT = -1;
    public static final int FIRSTSTYLEINT = 1;
    public static final int OTHERINT = 0;

    public static final String COPULAFULL = beatmania + " " + COPULAINT + " " + COPULA;
    public static final String PENDUALFULL = beatmania + " " + PENDUALINT + " " + PENDUAL;
    public static final String SPADAFULL = beatmania + " " + SPADAINT + " " + SPADA;
    public static final String TRICOROFULL = beatmania + " " + TRICOROINT + " " + TRICORO;
    public static final String LINCLEFULL = beatmania + " " + LINCLEINT+ " " + LINCLE;
    public static final String RESORTANTHEMFULL = beatmania + " " + RESORTANTHEMINT + " " + RESORTANTHEM;
    public static final String SIRIUSFULL = beatmania + " " + SIRIUSINT + " " + SIRIUS;

    public static int styleFullToInt(String style) {
        switch (style) {
            case COPULAFULL:
                return COPULAINT;
            case PENDUALFULL:
                return PENDUALINT;
            case SPADAFULL:
                return SPADAINT;
            case TRICOROFULL:
                return TRICOROINT;
            case LINCLEFULL:
                return LINCLEINT;
            case RESORTANTHEMFULL:
                return RESORTANTHEMINT;
            case SIRIUSFULL:
                return SIRIUSINT;
            default:
                return OTHERINT;
        }
    }

    public static int styleToInt(String style) {
        switch (style) {
            case FIRSTSTYLE:
                return FIRSTSTYLEINT;
            case SUBSTREAM:
                return SUBSTREAMINT;
            case SECONDSTYLE:
                return SECONDSTYLEINT;
            case THIRDSTYLE:
                return THIRDSTYLEINT;
            case FOURTHSTYLE:
                return FOURTHSTYLEINT;
            case FIFTHSTYLE:
                return FIFTHSTYLEINT;
            case SIXTHSTYLE:
                return SIXTHSTYLEINT;
            case SEVENTHSTYLE:
                return SEVENTHSTYLEINT;
            case EIGHTHSTYLE:
                return EIGHTHSTYLEINT;
            case NINTHSTYLE:
                return NINTHSTYLEINT;
            case TENTHSTYLE:
                return TENTHSTYLEINT;
            case IIDXRED:
                return IIDXREDINT;
            case HAPPYSKY:
                return HAPPYSKYINT;
            case DISTORTED:
                return DISTORTEDINT;
            case GOLD:
                return GOLDINT;
            case DJTROOPERS:
                return DJTROOPERSINT;
            case EMPRESS:
                return EMPRESSINT;
            case SIRIUS:
                return SIRIUSINT;
            case RESORTANTHEM:
                return RESORTANTHEMINT;
            case LINCLE:
                return LINCLEINT;
            case TRICORO:
                return TRICOROINT;
            case SPADA:
                return SPADAINT;
            case PENDUAL:
                return PENDUALINT;
            case COPULA:
                return COPULAINT;
            default:
                return OTHERINT;
        }
    }

    public static String styleToString(int style) {
        switch (style) {
            case FIRSTSTYLEINT:
                return FIRSTSTYLE;
            case SUBSTREAMINT:
                return SUBSTREAM;
            case SECONDSTYLEINT:
                return SECONDSTYLE;
            case THIRDSTYLEINT:
                return THIRDSTYLE;
            case FOURTHSTYLEINT:
                return FOURTHSTYLE;
            case FIFTHSTYLEINT:
                return FIFTHSTYLE;
            case SIXTHSTYLEINT:
                return SIXTHSTYLE;
            case SEVENTHSTYLEINT:
                return SEVENTHSTYLE;
            case EIGHTHSTYLEINT:
                return EIGHTHSTYLE;
            case NINTHSTYLEINT:
                return NINTHSTYLE;
            case TENTHSTYLEINT:
                return TENTHSTYLE;
            case IIDXREDINT:
                return IIDXRED;
            case HAPPYSKYINT:
                return HAPPYSKY;
            case DISTORTEDINT:
                return DISTORTED;
            case GOLDINT:
                return GOLD;
            case DJTROOPERSINT:
                return DJTROOPERS;
            case EMPRESSINT:
                return EMPRESS;
            case SIRIUSINT:
                return SIRIUS;
            case RESORTANTHEMINT:
                return RESORTANTHEM;
            case LINCLEINT:
                return LINCLE;
            case TRICOROINT:
                return TRICORO;
            case SPADAINT:
                return SPADA;
            case PENDUALINT:
                return PENDUAL;
            case COPULAINT:
                return COPULA;
            default:
                return OTHER;
        }
    }

}
