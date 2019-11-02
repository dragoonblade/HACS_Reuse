package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class StudentAssignmentMenu extends AssignmentMenu {
    private static String J_LABEL1_TEXT = "Assignment : ";
    private static int J_LABEL1_X = 20;
    private static int J_LABEL1_Y = 36;
    private static int J_LABEL1_WIDTH = 91;
    private static int J_LABEL1_HEIGHT = 18;

    private static String J_LABEL2_TEXT = "jLabel2";
    private static int J_LABEL2_X = 258;
    private static int J_LABEL2_Y = 35;
    private static int J_LABEL2_WIDTH = 91;
    private static int J_LABEL2_HEIGHT = 18;

    private static String J_LABEL3_TEXT = "Due Date";
    private static int J_LABEL3_X = 21;
    private static int J_LABEL3_Y = 81;
    private static int J_LABEL3_WIDTH = 92;
    private static int J_LABEL3_HEIGHT = 18;

    private static String J_LABEL4_TEXT = "jLabel4";
    private static int J_LABEL4_X = 254;
    private static int J_LABEL4_Y = 82;
    private static int J_LABEL4_WIDTH = 294;
    private static int J_LABEL4_HEIGHT = 18;

    private static String J_LABEL5_TEXT = "Solution";
    private static int J_LABEL5_X = 24;
    private static int J_LABEL5_Y = 128;
    private static int J_LABEL5_WIDTH = 93;
    private static int J_LABEL5_HEIGHT = 18;

    private static String J_TEXT_FIELD_TEXT = "jTextField1";
    private static int J_TEXT_FIELD_X = 251;
    private static int J_TEXT_FIELD_Y = 127;
    private static int J_TEXT_FIELD_WIDTH = 211;
    private static int J_TEXT_FIELD_HEIGHT = 22;

    private static String J_LABEL6_TEXT = "Suggested Solution";
    private static int J_LABEL6_X = 24;
    private static int J_LABEL6_Y = 174;
    private static int J_LABEL6_WIDTH = 117;
    private static int J_LABEL6_HEIGHT = 18;

    private static String J_LABEL7_TEXT = "Grade";
    private static int J_LABEL7_X = 23;
    private static int J_LABEL7_Y = 224;
    private static int J_LABEL7_WIDTH = 41;
    private static int J_LABEL7_HEIGHT = 18;

    private static String J_LABEL8_TEXT = "jLabel8";
    private static int J_LABEL8_X = 259;
    private static int J_LABEL8_Y = 169;
    private static int J_LABEL8_WIDTH = 201;
    private static int J_LABEL8_HEIGHT = 18;

    private static String J_LABEL9_TEXT = "jLabel9";
    private static int J_LABEL9_X = 258;
    private static int J_LABEL9_Y = 226;
    private static int J_LABEL9_WIDTH = 41;
    private static int J_LABEL9_HEIGHT = 18;

    private static String SUBMIT_TEXT = "Submit";
    private static int SUBMIT_X = 475;
    private static int SUBMIT_Y = 124;
    private static int SUBMIT_WIDTH = 79;
    private static int SUBMIT_HEIGHT = 29;

    private static String CANCEL_TEXT = "Cancel";
    private static int CANCEL_X = 475;
    private static int CANCEL_Y = 164;
    private static int CANCEL_WIDTH = 79;
    private static int CANCEL_HEIGHT = 29;


    JLabel lAssignmentName = new JLabel();
    JLabel lDueDate = new JLabel();
    JTextField tbSolution = new JTextField();
    JLabel lSuggestedSolution = new JLabel();
    JLabel lGrade = new JLabel();
    JButton bSubmit = new JButton();
    JButton bCancel = new JButton();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();

    ////  class AssignmentMenu
    private boolean boolSubmit = false;
    private Solution theSolution;
    private Assignment theAssignment;

    public StudentAssignmentMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText(J_LABEL1_TEXT);
        jLabel1.setBounds(new Rectangle(J_LABEL1_X, J_LABEL1_Y, J_LABEL1_WIDTH, J_LABEL1_HEIGHT));

        lAssignmentName.setText(J_LABEL2_TEXT);
        lAssignmentName.setBounds(new Rectangle(J_LABEL2_X, J_LABEL2_Y, J_LABEL2_WIDTH, J_LABEL2_HEIGHT));

        jLabel3.setText(J_LABEL3_TEXT);
        jLabel3.setBounds(new Rectangle(J_LABEL3_X, J_LABEL3_Y, J_LABEL3_WIDTH, J_LABEL3_HEIGHT));

        lDueDate.setText(J_LABEL4_TEXT);
        lDueDate.setBounds(new Rectangle(J_LABEL4_X, J_LABEL4_Y, J_LABEL4_WIDTH, J_LABEL4_HEIGHT));

        jLabel5.setText(J_LABEL5_TEXT);
        jLabel5.setBounds(new Rectangle(J_LABEL5_X, J_LABEL5_Y, J_LABEL5_WIDTH, J_LABEL5_HEIGHT));

        tbSolution.setText(J_TEXT_FIELD_TEXT);
        tbSolution.setBounds(new Rectangle(J_TEXT_FIELD_X, J_TEXT_FIELD_Y, J_TEXT_FIELD_WIDTH, J_TEXT_FIELD_HEIGHT));

        jLabel6.setText(J_LABEL6_TEXT);
        jLabel6.setBounds(new Rectangle(J_LABEL6_X, J_LABEL6_Y, J_LABEL6_WIDTH, J_LABEL6_HEIGHT));

        jLabel7.setText(J_LABEL7_TEXT);
        jLabel7.setBounds(new Rectangle(J_LABEL7_X, J_LABEL7_Y, J_LABEL7_WIDTH, J_LABEL7_HEIGHT));

        lSuggestedSolution.setText(J_LABEL8_TEXT);
        lSuggestedSolution.setBounds(new Rectangle(J_LABEL8_X, J_LABEL8_Y, J_LABEL8_WIDTH, J_LABEL8_HEIGHT));

        lGrade.setText(J_LABEL9_TEXT);
        lGrade.setBounds(new Rectangle(J_LABEL9_X, J_LABEL9_Y, J_LABEL9_WIDTH, J_LABEL9_HEIGHT));

        bSubmit.setText(SUBMIT_TEXT);
        bSubmit.setBounds(new Rectangle(SUBMIT_X, SUBMIT_Y, SUBMIT_WIDTH, SUBMIT_HEIGHT));
        bSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bSubmitActionPerformed(e);
            }
        });

        bCancel.setText(CANCEL_TEXT);
        bCancel.setBounds(new Rectangle(CANCEL_X, CANCEL_Y, CANCEL_WIDTH, CANCEL_HEIGHT));
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bCancelActionPerformed(e);
            }
        });

        this.getContentPane().setLayout(null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(lAssignmentName, null);
        this.getContentPane().add(lDueDate, null);
        this.getContentPane().add(tbSolution, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(lSuggestedSolution, null);
        this.getContentPane().add(lGrade, null);
        this.getContentPane().add(bSubmit, null);
        this.getContentPane().add(bCancel, null);
    }

    /*
     * check if the student has already had a solution or not. if not , create a new
     * solution for the student. after showing the solution attatch the soluiton;
     */
    public void showMenu(Assignment assignment, Person thePerson) {
        theAssignment = assignment;
        SolutionIterator theIter = null;
        try {
            theIter = theAssignment.getSolutionIterator();

            theSolution = (Solution) theIter.next(thePerson.userName);
            if (theSolution == null) {
                tbSolution.setText("");
                lGrade.setText("-1");
            } else {
                tbSolution.setText(theSolution.SolutionFileName);
                lGrade.setText(theSolution.getGradeString());

            }

            lAssignmentName.setText(theAssignment.assName);
            lDueDate.setText(theAssignment.dueDate.toString());
            lSuggestedSolution.setText(theAssignment.suggestSolution.SolutionFileName);


            setVisible(true);

            if (boolSubmit == true) {
                if (theSolution == null) {
                    theSolution = new Solution();
                    theAssignment.addSolution(theSolution);
                }
                theSolution.theAuthor = thePerson.userName;
                theSolution.SolutionFileName = tbSolution.getText();
                theSolution.theSubmissionDate = new Date();
            }
        } catch (NullPointerException e) {
            System.out.println("No Assignment Available");
        }
    }

    void bSubmitActionPerformed(ActionEvent e) {
        boolSubmit = true;
        setVisible(false);
    }

    void bCancelActionPerformed(ActionEvent e) {
        boolSubmit = false;
        setVisible(false);
    }

}