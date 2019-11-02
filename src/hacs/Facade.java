package hacs;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    private static String COURSE_FILE = "CourseInfo.txt";
    private static String USER_COURSE_FILE = "UserCourse.txt";
    private static String STUDENT_USER = "pepe";
    private static String INSTRUCTOR_USER = "Inst1";

    @Test
    void testCreateUserStudent() {
        Facade facade = new Facade();
        UserInfoItem userInfoItem = new UserInfoItem();
        userInfoItem.strUserName = STUDENT_USER;
        userInfoItem.userType = UserInfoItem.USER_TYPE.STUDENT;
        facade.createUser(userInfoItem);
        assertEquals(facade.thePerson.userName, userInfoItem.strUserName);
        assertTrue(facade.thePerson instanceof Student);
        assertFalse(facade.thePerson instanceof Instructor);
    }

    @Test
    void testCreateUserInstructor() {
        Facade facade = new Facade();
        UserInfoItem userInfoItem = new UserInfoItem();
        userInfoItem.userType = UserInfoItem.USER_TYPE.INSTRUCTOR;
        userInfoItem.strUserName = INSTRUCTOR_USER;
        facade.createUser(userInfoItem);
        assertEquals(facade.thePerson.userName, userInfoItem.strUserName);
        assertTrue(facade.thePerson instanceof Instructor);
        assertFalse(facade.thePerson instanceof Student);
    }

    @Test
    void testCreateCourseList() throws IOException {
        Facade facade = new Facade();
        facade.createCourseList(COURSE_FILE);
        assertTrue(facade.theCourseList.size() > 0);
    }

    @Test
    void testAttachCourseToUserFailure() throws IOException {
        Facade facade = new Facade();
        UserInfoItem userInfoItem = new UserInfoItem();
        userInfoItem.strUserName = STUDENT_USER;
        userInfoItem.userType = UserInfoItem.USER_TYPE.STUDENT;
        facade.createUser(userInfoItem);
        facade.createCourseList(COURSE_FILE);
        facade.attachCourseToUser(USER_COURSE_FILE+"e");
        assertEquals(0, facade.thePerson.courseList.size());
    }

    @Test
    void testAttachCourseToUserSuccess() throws IOException {
        Facade facade = new Facade();
        UserInfoItem userInfoItem = new UserInfoItem();
        userInfoItem.strUserName = STUDENT_USER;
        userInfoItem.userType = UserInfoItem.USER_TYPE.STUDENT;
        facade.createUser(userInfoItem);
        facade.createCourseList(COURSE_FILE);
        facade.attachCourseToUser(USER_COURSE_FILE);
        assertTrue(facade.thePerson.courseList.size() > 0);
    }

}

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * <p>
 * Update to Jave 8
 */

public class Facade {
    private static char SEPARATOR = ':';

    public int userType;
    ClassCourseList theCourseList;
    Person thePerson;
    private Course theSelectedCourse = null;
    private int nCourseLevel = 0;

    public Facade() {
    }

    static public boolean login(UserInfoItem userinfoItem) {
        Login login = new Login();
        login.setModal(true);
        login.setVisible(true);
        userinfoItem.strUserName = login.getUserName();
        userinfoItem.userType = login.getUserType();
        return login.isExit();
    }

/////////////////////////
//functions for CourseMenu
    /*
     * When click the add button of the CourseMenu , call this function this
     * function will new an assignment fill the required infomation this function
     * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
     * type of the user it will not update the course menu. the coursemenu need to
     * refreshed outside the function
     */

    void addAssignment(Course theCourse) {
        AssignmentMenu theAssignmentMenu;
        switch (thePerson.type) {
            case STUDENT:
                theAssignmentMenu = new StudentAssignmentMenu();
                break;
            case INSTRUCTOR:
                theAssignmentMenu = new InstructorAssignmentMenu();
                break;
            default: return;
        }
        Assignment theAssignment = new Assignment();
        theAssignmentMenu.showMenu(theAssignment, thePerson);
        theCourse.addAssignment(theAssignment);
    }

    /*
     * When click the view button of the CourseMenu , call this function and pass
     * the pointer of the Assignment and the person pointer to this function this
     * function will new an assignment fill the required infomation this function
     * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
     * type of the user
     */
    void viewAssignment(Assignment theAssignment) {
        AssignmentMenu theAssignmentMenu;
        switch (thePerson.type) {
            case STUDENT:
                theAssignmentMenu = new StudentAssignmentMenu();
                break;
            case INSTRUCTOR:
                theAssignmentMenu = new InstructorAssignmentMenu();
                break;
            default: return;
        }

        theAssignmentMenu.showMenu(theAssignment, thePerson);
    }

//functions for InstructorAssignmentMenu
    /*
     * this function will grade the give Solution: theSolution this function calls
     */

    void gradeSolution(Solution theSolution) {
        SolutionMenu solutionMenu = new SolutionMenu();
        solutionMenu.showMenu(theSolution);
    }

    void reportSolutions(Assignment theAssignment) {
        Solution theSolution;
        SolutionIterator theSolutionIterator;
        theSolutionIterator = theAssignment.getSolutionIterator();
        theSolution = (Solution) theSolutionIterator.next();
        while (theSolution != null) {
            theSolution.setReported(true);
            theSolution = (Solution) theSolutionIterator.next();
        }
    }
////////////////////

    //functions for StudentAssignmentMenu
    void submitSolution(Assignment theAssignment, Solution theSolution) {
        theAssignment.addSolution(theSolution);
    }

    //////////
    void remind() {
        Reminder theReminder = new Reminder();
        theReminder.showReminder();
    }

    void createUser(UserInfoItem userinfoitem) {
        if (userinfoitem.userType == UserInfoItem.USER_TYPE.STUDENT) /// student
        {
            thePerson = new Student();
        } else /// instructor
        {
            thePerson = new Instructor();
        }
        thePerson.userName = userinfoitem.strUserName;
    }

    /*
     * create a course list and initialize it with the file CourseInfo.txt
     */
    void createCourseList(String courseFileName) throws IOException {
        theCourseList = new ClassCourseList();
        theCourseList.initializeFromFile(courseFileName);
    }

    /*
     * call this function after create user, create courselist read the
     * UserCourse.txt file match the coursename with theCouresList attach the
     * Matched course object to the new create user Facade.thePerson.CourseList
     */
    void attachCourseToUser(String userCourseFileName) {
        BufferedReader file;
        try {
            URL path = Login.class.getResource(userCourseFileName);
            File UserCourse = new File(path.getFile());
            file = new BufferedReader(new FileReader(UserCourse));
            String aline, strUserName, strCourseName;
            while ((aline = file.readLine()) != null) // not the EOF
            {
                strUserName = getUserName(aline);
                strCourseName = getCourseName(aline);
                if (strUserName.compareTo(thePerson.userName) == 0) /// the UserName matches
                {
                    theSelectedCourse = findCourseByCourseName(strCourseName);
                    if (theSelectedCourse != null) /// Find the Course in the CourseList--->attach
                    {
                        thePerson.addCourse(theSelectedCourse);
                    }
                }
            }
        } catch (Exception ee) {
		}
    }

    /*
     * get the user name from aline UserName:CourseName
     */
    private String getUserName(String aline) {
        int Sep = aline.lastIndexOf(SEPARATOR);
        return aline.substring(0, Sep);
    }

    /*
     * get the CourseName from aline UserName:CourseName
     */
    private String getCourseName(String aline) {
        int Sep = aline.lastIndexOf(SEPARATOR);
        return aline.substring(Sep + 1);
    }

    /*
     * show the course selection dlg, show the course attatched to theperson and
     * return the selected course and assign the course to the class member
     * theSelecteCourse, the Course Level to CourseLevel CourseLevel=0 High,
     * CourseLevel=1 Low
     */
    public boolean selectCourse() {
        CourseSelectDlg theDlg = new CourseSelectDlg();
        theSelectedCourse = theDlg.ShowDlg(thePerson.courseList);
        thePerson.currentCourse = theSelectedCourse;
        nCourseLevel = theDlg.nCourseLevel;
        return theDlg.isLogout();
    }

    /*
     * call the thePerson.CreateCourseMenu according to the really object(student or
     * instructor) and the nCourseLevel it will call different menu creator and show
     * the menu;
     */

    public boolean courseOperation() {
        thePerson.createCourseMenu(theSelectedCourse, nCourseLevel);
        return thePerson.showMenu();//// 0: logout 1 select an other course
    }

    /*
     * find the course in theCourseList that matches strCourseName 1 create a
     * CourseIterator for the List 2 Find the Course with the Iterator return the
     * pointer of the Course if not fine, return null;
     */
    private Course findCourseByCourseName(String strCourseName) {
        CourseIterator Iterator = new CourseIterator(theCourseList);
        return (Course) Iterator.next(strCourseName);
    }

}