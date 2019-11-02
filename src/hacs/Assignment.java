package hacs;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 *
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AssignmentTest {

    @Test
    void testIsOverDueSuccess() {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.MONTH, 11);
        date.set(Calendar.DATE, 05);
        date.set(Calendar.YEAR, 2010);
        Assignment assignment = new Assignment("Assignment for isOverDue Test", date.getTime());
        assertEquals(true, assignment.isOverDue());
    }

    @Test
    void testIsOverDueFailure() {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.MONTH, 11);
        date.set(Calendar.DATE, 05);
        date.set(Calendar.YEAR, 2019);
        Assignment assignment = new Assignment("Assignment for isOverDue Test", date.getTime());
        assertNotEquals(true, assignment.isOverDue());
    }

    @Test
    void testToString() {
        Assignment assignment = new Assignment("Assignment for toString Test", new Date());
        assertEquals("Assignment for toString Test", assignment.toString());
    }

    @Test
    void testAddSolution() {
        Assignment assignment = new Assignment();
        Solution solution = new Solution();
        assignment.addSolution(solution);
        assertEquals(1, assignment.theSolutionList.size());
    }

    @Test
    void testAccept() {
    }
}

public class Assignment {

    protected String assName;
    protected String strAssignmentFilename;
    protected Date dueDate = new Date();
    protected String assSpec;
    protected SolutionList theSolutionList = new SolutionList();
    protected Solution suggestSolution = new Solution();


    public Assignment() {
    }


    public Assignment(String assName, Date dueDate) {
        this.assName = assName;
        this.dueDate = dueDate;
    }

    public Assignment(String assName, String strAssignmentFilename, Date dueDate, SolutionList theSolutionList, Solution suggestSolution) {
        this.assName = assName;
        this.strAssignmentFilename = strAssignmentFilename;
        this.dueDate = dueDate;
        this.theSolutionList = theSolutionList;
        this.suggestSolution = suggestSolution;
    }

    public void setDueDate(Date theDueDate) {
        this.dueDate = theDueDate;
    }

    public void setAssSpec(String theSpec) {
        this.assSpec = theSpec;
    }

    public boolean isOverDue() {
        Date today;
        today = new Date();
      return today.after(this.dueDate);
    }

    ////add the theSolution to the Solution list
    public void addSolution(Solution theSolution) {
        theSolutionList.add(theSolution);
    }

    public void submitSolution() {
    }

    public void getSolutionList() {
    }

    /* return the solution of the give name
     */
    public Solution getSolution(String studentname) {
        SolutionIterator Iterator = (SolutionIterator) theSolutionList.iterator();
        return (Solution) Iterator.next(studentname);
    }

    public Solution getSugSolution() {
        return suggestSolution;
    }

    public SolutionIterator getSolutionIterator() {
        SolutionIterator theSolutionIterator = new SolutionIterator(theSolutionList);
        return theSolutionIterator;
    }

    public String toString() {
        return assName;
    }

    public String getDueDateString() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return dateFormat.format(dueDate);
    }

    public void accept(NodeVisitor visitor) {
        visitor.visitAssignment(this);
    }
}