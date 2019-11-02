package hacs;

import javax.swing.*;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract public class AssignmentMenu extends JDialog {
    private static int WIDTH = 575;
    private static int HEIGHT = 575;

    public AssignmentMenu() {
        setModal(true);
        setSize(WIDTH, HEIGHT);
    }

    abstract void showMenu(Assignment ass, Person per);
}