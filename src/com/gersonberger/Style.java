package com.gersonberger;


public class Style {

    private static final String beatmania = "beatmania IIDX";

    static final String OMNIMIX = "Omnimix";

    static final String COPULA = "copula";
    static final String PENDUAL = "PENDUAL";
    static final String SPADA = "SPADA";
    static final String TRICORO = "tricoro";
    static final String LINCLE = "Lincle";
    static final String RESORTANTHEM = "Resort Anthem";
    static final String SIRIUS = "SIRIUS";
    static final String EMPRESS = "EMPRESS";
    static final String DJTROOPERS = "DJ TROOPERS";
    static final String GOLD = "GOLD";
    static final String DISTORTED = "DistorteD";
    static final String HAPPYSKY = "HAPPY SKY";
    static final String IIDXRED = "IIDX RED";
    static final String TENTHSTYLE = "10th Style";
    static final String NINTHSTYLE = "9th Style";
    static final String EIGHTHSTYLE = "8th Style";
    static final String SEVENTHSTYLE = "7th Style";
    static final String SIXTHSTYLE = "6th Style";
    static final String FIFTHSTYLE = "5th Style";
    static final String FOURTHSTYLE = "4th Style";
    static final String THIRDSTYLE = "3rd Style";
    static final String SECONDSTYLE = "2nd Style";
    static final String SUBSTREAM = "Substream";
    static final String FIRSTSTYLE = "1st Style";
    static final String OTHER = "Other";

    static final String[] ALLSTYLES = {FIRSTSTYLE, SUBSTREAM, SECONDSTYLE, THIRDSTYLE, FOURTHSTYLE, FIFTHSTYLE,
            SIXTHSTYLE, SEVENTHSTYLE, EIGHTHSTYLE, NINTHSTYLE, TENTHSTYLE, IIDXRED, HAPPYSKY, DISTORTED, GOLD,
            DJTROOPERS, EMPRESS, SIRIUS, RESORTANTHEM, LINCLE, TRICORO, SPADA, PENDUAL, COPULA};

    static final int COPULAINT = 23;
    static final int PENDUALINT = 22;
    static final int SPADAINT = 21;
    static final int TRICOROINT = 20;
    static final int LINCLEINT = 19;
    static final int RESORTANTHEMINT = 18;
    static final int SIRIUSINT = 17;
    static final int EMPRESSINT = 16;
    static final int DJTROOPERSINT = 15;
    static final int GOLDINT = 14;
    static final int DISTORTEDINT = 13;
    static final int HAPPYSKYINT = 12;
    static final int IIDXREDINT = 11;
    static final int TENTHSTYLEINT = 10;
    static final int NINTHSTYLEINT = 9;
    static final int EIGHTHSTYLEINT = 8;
    static final int SEVENTHSTYLEINT = 7;
    static final int SIXTHSTYLEINT = 6;
    static final int FIFTHSTYLEINT = 5;
    static final int FOURTHSTYLEINT = 4;
    static final int THIRDSTYLEINT = 3;
    static final int SECONDSTYLEINT = 2;
    static final int SUBSTREAMINT = 1;
    static final int FIRSTSTYLEINT = 0;
    static final int OTHERINT = -1;

    static final String COPULAFULL = beatmania + " " + COPULAINT + " " + COPULA;
    static final String PENDUALFULL = beatmania + " " + PENDUALINT + " " + PENDUAL;
    static final String SPADAFULL = beatmania + " " + SPADAINT + " " + SPADA;
    static final String TRICOROFULL = beatmania + " " + TRICOROINT + " " + TRICORO;
    static final String LINCLEFULL = beatmania + " " + LINCLEINT+ " " + LINCLE;
    static final String RESORTANTHEMFULL = beatmania + " " + RESORTANTHEMINT + " " + RESORTANTHEM;
    static final String SIRIUSFULL = beatmania + " " + SIRIUSINT + " " + SIRIUS;
    static final String EMPRESSFULL = beatmania + " " + EMPRESSINT + " " + EMPRESS;

    static int styleFullToInt(String style) {
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
            case EMPRESSFULL:
                return EMPRESSINT;
            default:
                return OTHERINT;
        }
    }

    static int styleToInt(String style) {
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

    static String styleToString(int style) {
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
