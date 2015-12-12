package com.gersonberger;


public class ScoreEntry {

    public int songid;
    public int diff;
    public int miss;
    public int clearstatus;
    public double percent;
    public String grade;

    public ScoreEntry(int songid, int diff, int clear, int miss, double percent){
        this.songid = songid;
        this.diff = diff;
        this.clearstatus = clear;
        this.miss = miss;
        this.percent = percent;
        if (percent > (double)800/9) grade = Grade.AAA;
        else if (percent > (double)700/9) grade = Grade.AA;
        else if (percent > (double)600/9) grade = Grade.A;
        else if (percent > (double)500/9) grade = Grade.B;
        else if (percent > (double)400/9) grade = Grade.C;
        else if (percent > (double)300/9) grade = Grade.D;
        else if (percent > (double)200/9) grade = Grade.E;
        else grade = Grade.F;
    }

}
