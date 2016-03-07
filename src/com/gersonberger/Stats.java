package com.gersonberger;

import javafx.collections.ObservableList;

public class Stats {
    int fullcombo;
    int exhardclear;
    int hardclear;
    int clear;
    int easyclear;
    int assistclear;
    int failed;
    int noplay;

    private int gradeAAA = 0;
    private int gradeAA = 0;
    private int gradeA = 0;
    private int gradeB = 0;
    private int gradeC = 0;
    private int gradeD = 0;
    private int gradeE = 0;
    private int gradeF = 0;

    int[] style_songs = new int[36];
    int[] np_arr = new int[36];
    int[] f_arr = new int[36];
    int[] ac_arr = new int[36];
    int[] ec_arr = new int[36];
    int[] c_arr = new int[36];
    int[] hc_arr = new int[36];
    int[] ex_arr = new int[36];
    int[] fc_arr = new int[36];
    int[] cvs_arr = new int[36];
    int[] ncvs_arr = new int[36];

    public Stats(ObservableList<SongEntry> masterData){
        int style;
        for (SongEntry songEntry : masterData) {
            style = Style.styleToInt(songEntry.getStyle()) + 1;
            style_songs[style]++;
            style_songs[Integer.parseInt(songEntry.getLevel()) + 23]++;
            switch (songEntry.getClear()) {
                case Clear.FULLCOMBO:
                    fullcombo++;
                    fc_arr[style]++;
                    fc_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    cvs_arr[style]++;
                    cvs_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    break;
                case Clear.EXHARDCLEAR:
                    exhardclear++;
                    ex_arr[style]++;
                    ex_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    cvs_arr[style]++;
                    cvs_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    break;
                case Clear.HARDCLEAR:
                    hardclear++;
                    hc_arr[style]++;
                    hc_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    cvs_arr[style]++;
                    cvs_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    break;
                case Clear.CLEAR:
                    clear++;
                    c_arr[style]++;
                    c_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    cvs_arr[style]++;
                    cvs_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    break;
                case Clear.EASYCLEAR:
                    easyclear++;
                    ec_arr[style]++;
                    ec_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    cvs_arr[style]++;
                    cvs_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    break;
                case Clear.ASSISTCLEAR:
                    assistclear++;
                    ac_arr[style]++;
                    ac_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    cvs_arr[style]++;
                    cvs_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    break;
                case Clear.FAILED:
                    failed++;
                    f_arr[style]++;
                    f_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    ncvs_arr[style]++;
                    ncvs_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    break;
                case Clear.NOPLAY_NOTEXT:
                    noplay++;
                    np_arr[style]++;
                    np_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    ncvs_arr[style]++;
                    ncvs_arr[Integer.valueOf(songEntry.getLevel()) + 23]++;
                    break;
            }

            double p = songEntry.getEx().equals("") ? 0 : Double.valueOf(songEntry.getEx()) / (double)(2 * Integer.valueOf(songEntry.getNotes()));
            if (p > (double)8/9) gradeAAA++;
            else if (p > (double)7/9) gradeAA++;
            else if (p > (double)6/9) gradeA++;
            else if (p > (double)5/9) gradeB++;
            else if (p > (double)4/9) gradeC++;
            else if (p > (double)3/9) gradeD++;
            else if (p > (double)2/9) gradeE++;
            else if (p > (double)1/9) gradeF++;
        }

    }

    public int getTotalClears(){
        return fullcombo + exhardclear + hardclear + clear + easyclear + assistclear;
    }

    public int getTotal(){
        return fullcombo + exhardclear + hardclear + clear + easyclear + assistclear + failed + noplay;
    }

    public int getTotalWONoplay(){
        return fullcombo + exhardclear + hardclear + clear + easyclear + assistclear + failed;
    }

    public int getFullcombo() {
        return fullcombo;
    }

    public int getExhardclear() {
        return exhardclear;
    }

    public int getHardclear() {
        return hardclear;
    }

    public int getClear() {
        return clear;
    }

    public int getEasyclear() {
        return easyclear;
    }

    public int getAssistclear() {
        return assistclear;
    }

    public int getFailed() {
        return failed;
    }

    public int getNoplay() {
        return noplay;
    }

    public int getGradeAAA() {
        return gradeAAA;
    }

    public int getGradeAA() {
        return gradeAA;
    }

    public int getGradeA() {
        return gradeA;
    }

    public int getGradeB() {
        return gradeB;
    }

    public int getGradeC() {
        return gradeC;
    }

    public int getGradeD() {
        return gradeD;
    }

    public int getGradeE() {
        return gradeE;
    }

    public int getGradeF() {
        return gradeF;
    }

    public int[] getNp_arr() {
        return np_arr;
    }

    public int[] getF_arr() {
        return f_arr;
    }

    public int[] getAc_arr() {
        return ac_arr;
    }

    public int[] getEc_arr() {
        return ec_arr;
    }

    public int[] getC_arr() {
        return c_arr;
    }

    public int[] getHc_arr() {
        return hc_arr;
    }

    public int[] getEx_arr() {
        return ex_arr;
    }

    public int[] getFc_arr() {
        return fc_arr;
    }

    public int[] getStyle_songs() {
        return style_songs;
    }

    public int[] getCvs_arr() {
        return cvs_arr;
    }

    public int[] getNcvs_arr() {
        return ncvs_arr;
    }

}
