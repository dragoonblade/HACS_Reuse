package hacs;

import java.io.IOException;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * <p>
 * Update to Java 8
 */

public class Hacs {
    private static String COURSE_FILE = "CourseInfo.txt";
    private static String USER_COURSE_FILE = "UserCourse.txt";
    static Facade theFacade = new Facade();

    public Hacs() {
    }

    public static void main(String[] args) {
        UserInfoItem userinfoitem = new UserInfoItem();
        try {
            theFacade.createCourseList(COURSE_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            boolean bExit = false;
            bExit = Facade.login(userinfoitem);
            if (bExit) {
                break;
            }
            theFacade.createUser(userinfoitem);
            theFacade.attachCourseToUser(USER_COURSE_FILE);
            if (userinfoitem.userType == UserInfoItem.USER_TYPE.STUDENT) // if is a student remind him of the due date
                theFacade.remind();
            boolean bLogout = false;
            while (!bLogout) {
                bLogout = theFacade.selectCourse();
                if (bLogout)
                    break;
                bLogout = theFacade.courseOperation();
            }
        }
    }
}