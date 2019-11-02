package tests;

import hacs.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private static String COURSE_NAME= "SER515";
    private static int COURSE_LEVEL = 1;
    private static int HIGH_LEVEL = 0;
    private static int LOW_LEVEL = 1;

    @Test
    void createCourseMenuHighLevel() {
        Student Student = new Student();
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        CourseMenu menu = new HighLevelCourseMenu();
        assertTrue(menu instanceof HighLevelCourseMenu);
        assertFalse(menu instanceof LowLevelCourseMenu);
    }

    @Test
    void createCourseMenuLowLevel() {
        Student Student = new Student();
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        CourseMenu menu = new LowLevelCourseMenu();
        assertTrue(menu instanceof LowLevelCourseMenu);
        assertFalse(menu instanceof HighLevelCourseMenu);
    }
}