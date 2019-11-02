package tests;

import hacs.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {
    private static String COURSE_NAME= "SER515";
    private static int COURSE_LEVEL = 1;
    private static int HIGH_LEVEL = 0;
    private static int LOW_LEVEL = 1;

    @Test
    void createCourseMenuHighLevel() {
        Instructor instructor = new Instructor();
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        CourseMenu menu = instructor.createCourseMenu(course, HIGH_LEVEL);
        assertTrue(menu instanceof HighLevelCourseMenu);
        assertFalse(menu instanceof LowLevelCourseMenu);
    }

    @Test
    void createCourseMenuLowLevel() {
        Instructor instructor = new Instructor();
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        CourseMenu menu = instructor.createCourseMenu(course, LOW_LEVEL);
        assertTrue(menu instanceof LowLevelCourseMenu);
        assertFalse(menu instanceof HighLevelCourseMenu);
    }
}