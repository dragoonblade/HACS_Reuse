package hacs;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class ClassCourseListTest {
    private static String COURSE_FILE = "CourseInfo.txt";
    private static String COURSE_NAME = "SER515";
    private static int COURSE_LEVEL = 1;

    @Test
    void testInitializeFromFileFailure() {
        ClassCourseList courses = new ClassCourseList();
        assertThrows(NullPointerException.class, () -> courses.initializeFromFile(COURSE_FILE + "e"));
    }

    @Test
    void testInitializeFromFileSuccess() {
        ClassCourseList courses = new ClassCourseList();
        assertDoesNotThrow(() -> courses.initializeFromFile(COURSE_FILE));
    }

    @Test
    void testFindCourseByCourseNameFailure() throws IOException {
        ClassCourseList list = new ClassCourseList();
        list.initializeFromFile(COURSE_FILE);
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        list.add(course);
        assertNotEquals(new Course(COURSE_NAME, COURSE_LEVEL), list.findCourseByCourseName(COURSE_NAME));
    }

    @Test
    void testFindCourseByCourseNameSuccess() throws IOException {
        ClassCourseList list = new ClassCourseList();
        list.initializeFromFile(COURSE_FILE);
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        list.add(course);
        assertEquals(course, list.findCourseByCourseName(COURSE_NAME));
    }
}

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

    public ClassCourseList() {
    }

    //// initialize the list by reading from the file.
    void initializeFromFile(String theFileName) throws IOException, NullPointerException {
        BufferedReader file;
        String strCourseName = null;
        URL path = Login.class.getResource(theFileName);
        File courseInfo = new File(path.getFile());
        file = new BufferedReader(new FileReader(courseInfo));
        while ((strCourseName = file.readLine()) != null) {
            Course theCourse;
            theCourse = new Course(strCourseName, 0);
            theCourse.courseName = strCourseName;
            add(theCourse);
        }
    }

    Course findCourseByCourseName(String CourseName) {
        int nCourseCount = size();
        for (int i = 0; i < nCourseCount; i++) {
            Course theCourse;
            theCourse = get(i);
            if (theCourse.courseName.compareTo(CourseName) == 0)
                return theCourse;
        }
        return null;
    }
}