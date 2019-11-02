package tests;

import hacs.Assignment;
import hacs.Course;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseTest {
    private static String COURSE_NAME= "SER515";
    private static String ASSIGNMENT_NAME= "Assignment";
    private static int COURSE_LEVEL = 1;

    @Test
    void testAddAssignment() {
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        Assignment assignment = new Assignment(ASSIGNMENT_NAME, new Date());
        course.addAssignment(assignment);
        assertEquals(1, course.assignmentList.size());
    }

    @Test
    void testToString() {
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        assertEquals(COURSE_NAME, course.toString());
    }
}