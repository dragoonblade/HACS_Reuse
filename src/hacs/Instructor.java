package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class Instructor extends Person {
    public Instructor() {
        type = UserInfoItem.USER_TYPE.INSTRUCTOR;
    }

    public CourseMenu createCourseMenu(Course theCourse, int theLevel) {
        if (theLevel == 0)/// 0: High level defined in CourseSelectDlg.
        {
            theCourseMenu = new HighLevelCourseMenu();
        } else/// 1: LowLevel
        {
            theCourseMenu = new LowLevelCourseMenu();
        }
        return theCourseMenu;
    }

    public boolean showMenu() {
        super.showMenu();
        showAddButton();
        showViewButtons();
        showComboxes();
        showRadios();
        show();
        return ifLogout();
    }
}