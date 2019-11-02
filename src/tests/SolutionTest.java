package tests;

import hacs.Solution;
import hacs.SolutionGradingDlg;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private static String AUTHOR_NAME = "Dr. Michael J. Findler";
    private static String SOLUTION_FILE_NAME = "Solution";
    private static int DEFAULT_GRADE = -1;
    private static int GRADE = 100;

    @Test
    void testToStringUnReported() {
        Solution solution = new Solution(AUTHOR_NAME, SOLUTION_FILE_NAME, new Date());
        String string = String.format("%s %s Grade = %s not reported", AUTHOR_NAME, SOLUTION_FILE_NAME, DEFAULT_GRADE);
        assertEquals(string, solution.toString());
    }

    @Test
    void testToStringReported() {
        Solution solution = new Solution(AUTHOR_NAME, SOLUTION_FILE_NAME, new Date());
        solution.setReported(true);
        solution.setGradeInt(GRADE);
        String string = String.format("%s %s Grade = %s reported", AUTHOR_NAME, SOLUTION_FILE_NAME, GRADE);
        assertEquals(string, solution.toString());
    }

    @Test
    void testIsReportedSuccess() {
        Solution solution = new Solution(AUTHOR_NAME, SOLUTION_FILE_NAME, new Date());
        assertEquals(false, solution.isReported());
    }

    @Test
    void testIsReportedFailure() {
        Solution solution = new Solution(AUTHOR_NAME, SOLUTION_FILE_NAME, new Date());
        solution.setReported(true);
        assertEquals(true, solution.isReported());
    }
}