package hacs;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * <p>
 * update to Java 8
 */

/*
 * this class will iterate the course list attatched to on student and in turn
 * iterate the assignments of a course. after Function Visit(CourseList) it will
 * point to the location before the fist class, hasNext will retrun weather
 * there is next item. the next() will return the next Item Assignment;
 */

public class ReminderVisitor extends NodeVisitor {

    Reminder reminder;

    public ReminderVisitor() {
    }

    public ReminderVisitor(Reminder reminder) {
        this.reminder = reminder;
    }

    public void visitFacade(Facade facade) {
        CourseIterator courseList = new CourseIterator(facade.theCourseList);
        while (courseList.hasNext()) {
            Course course = (Course) courseList.next();
            course.accept(this);
        }
    }

    public void visitCourse(Course course) {
        Iterator<Assignment> assignmentList = course.assignmentList.listIterator();
        while (assignmentList.hasNext()) {
            Assignment assignment = assignmentList.next();
            assignment.accept(this);
        }
    }

    public void visitAssignment(Assignment assignment) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int nToday = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(assignment.dueDate);
        int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
        String dateString = null;
        if (nDueDate <= (nToday + 1) && nDueDate >= nToday) /// upcoming
        {
            dateString = String.format("today is %s %s Due Date is %s", today.toString(), assignment.assName, assignment.getDueDateString());
            reminder.listUpcoming.add(dateString);
        }
        if (nDueDate < nToday) {
            dateString = String.format("%s Due Date is %s", assignment.assName, assignment.getDueDateString());
            reminder.listOverdue.add(dateString);
        }
    }

}