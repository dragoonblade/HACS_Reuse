package hacs;

import java.util.Date;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 *
 * @author Ji Zhang, Wei Zhu
 * @author mjfindler
 * @version 2.0
 * <p>
 * update to Java 8
 */

public class Solution {
    String theAuthor;
    String SolutionFileName;
    Date theSubmissionDate;
    int theGrade;
    boolean reported;

    public Solution() {
        this.theAuthor = "";
        this.SolutionFileName = "";
        this.theSubmissionDate = new Date();
        this.theGrade = -1;
        this.reported = false;
    }

    public Solution(String theAuthor, String SolutionFileName, Date theSubmissionDate) {
        this.theAuthor = theAuthor;
        this.SolutionFileName = SolutionFileName;
        this.theSubmissionDate = theSubmissionDate;
        this.theGrade = -1;
        this.reported = false;
    }

    @Override
    public String toString() {
        String string;
        string = String.format("%s %s Grade = %s ", theAuthor, SolutionFileName, getGradeInt());
        if (isReported())
            string += "reported";
        else
            string += "not reported";
        return (string);
    }

    String getGradeString() {
        if (isReported())
            return "" + theGrade;
        else
            return "-1";
    }

    int getGradeInt() {
        return theGrade;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }

    public void setGradeInt(int theGrade) {
        this.theGrade = theGrade;
    }
}