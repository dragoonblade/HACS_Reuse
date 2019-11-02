package tests;

import hacs.ClassCourseList;
import hacs.Course;
import hacs.CourseIterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseIteratorTest {
    private static String COURSE_NAME= "SER515";
    private static int COURSE_LEVEL = 1;

    @Test
    void testHasNextSuccess() {
        ClassCourseList list = new ClassCourseList();
        list.add(new Course(COURSE_NAME, COURSE_LEVEL));
        CourseIterator iterator = new CourseIterator(list);
        assertEquals(true, iterator.hasNext());
    }

    @Test
    void testHasNextFailure() {
        ClassCourseList list = new ClassCourseList();
        CourseIterator iterator = new CourseIterator(list);
        assertEquals(false, iterator.hasNext());
    }

    @Test
    void testNextSuccess() {
        ClassCourseList list = new ClassCourseList();
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        list.add(course);
        CourseIterator iterator = new CourseIterator(list);
        assertEquals(course, iterator.next());
    }

    @Test
    void testNextFailure() {
        ClassCourseList list = new ClassCourseList();
        CourseIterator iterator = new CourseIterator(list);
        assertEquals(null, iterator.next());
    }

    @Test
    void testRemoveSuccess() {
        ClassCourseList list = new ClassCourseList();
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        list.add(course);
        CourseIterator iterator = new CourseIterator(list);
        iterator.next();
        iterator.remove();
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveFailure() {
        ClassCourseList list = new ClassCourseList();
        CourseIterator iterator = new CourseIterator(list);
        iterator.next();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> iterator.remove());
    }

    @Test
    void testNextObjectSuccess() {
        ClassCourseList list = new ClassCourseList();
        Course course = new Course(COURSE_NAME, COURSE_LEVEL);
        list.add(course);
        CourseIterator iterator = new CourseIterator(list);
        assertEquals(course, iterator.next(COURSE_NAME));
    }

    @Test
    void testNextObjectFailure() {
        ClassCourseList list = new ClassCourseList();
        CourseIterator iterator = new CourseIterator(list);
        assertEquals(null, iterator.next(COURSE_NAME));
    }
}