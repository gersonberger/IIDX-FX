package com.gersonberger;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class RivalEntry {

    private final StringProperty name = new SimpleStringProperty(this, "Name");
    private final StringProperty grade = new SimpleStringProperty(this, "Grade");
    private final IntegerProperty ex = new SimpleIntegerProperty(this, "Ex");
    private final StringProperty status = new SimpleStringProperty(this, "Status");

    RivalEntry(String name, String grade, int ex, String status) {
        this.name.setValue(name);
        this.grade.setValue(grade);
        this.ex.setValue(ex);
        if (status.equals(Status.NOPLAY_NOTEXT)) this.status.setValue(Status.NOPLAY);
        else this.status.setValue(status);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getGrade() {
        return grade.get();
    }

    public StringProperty gradeProperty() {
        return grade;
    }

    public int getEx() {
        return ex.get();
    }

    public IntegerProperty exProperty() {
        return ex;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }
}
