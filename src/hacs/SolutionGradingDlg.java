package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class SolutionGradingDlg extends JDialog {
    private static int MODAL_WIDTH = 316;
    private static int MODAL_HEIGHT = 186;

    private static String J_LABEL_TEXT = "Solution File Name";
    private static int J_LABEL_X = 23;
    private static int J_LABEL_Y = 30;
    private static int J_LABEL_WIDTH = 121;
    private static int J_LABEL_HEIGHT = 18;

    private static int TF_GRAD_X = 25;
    private static int TF_GRAD_Y = 66;
    private static int TF_GRAD_WIDTH = 100;
    private static int TF_GRAD_HEIGHT = 22;

    private static String OK_BUTTON_TEXT = "OK";
    private static int OK_BUTTON_X = 217;
    private static int OK_BUTTON_Y = 67;
    private static int OK_BUTTON_WIDTH = 69;
    private static int OK_BUTTON_HEIGHT = 29;

    private static int SOLUTION_FILE_X = 212;
    private static int SOLUTION_FILE_Y = 34;
    private static int SOLUTION_FILE_WIDTH = 163;
    private static int SOLUTION_FILE_HEIGHT = 18;

    Solution theSolution;
    JLabel jLabel1 = new JLabel();
    JTextField tfGrad = new JTextField();
    JButton buttonOK = new JButton();
    JLabel labelSolutionFileName = new JLabel();

    public SolutionGradingDlg() {
        try {
            jbInit();
            setSize(MODAL_WIDTH, MODAL_HEIGHT);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText(J_LABEL_TEXT);
        jLabel1.setBounds(new Rectangle(J_LABEL_X, J_LABEL_Y, J_LABEL_WIDTH, J_LABEL_HEIGHT));

        tfGrad.setBounds(new Rectangle(TF_GRAD_X, TF_GRAD_Y, TF_GRAD_WIDTH, TF_GRAD_HEIGHT));

        buttonOK.setText(OK_BUTTON_TEXT);
        buttonOK.setBounds(new Rectangle(OK_BUTTON_X, OK_BUTTON_Y, OK_BUTTON_WIDTH, OK_BUTTON_HEIGHT));
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOKActionPerformed(e);
            }
        });

        labelSolutionFileName.setBounds(new Rectangle(SOLUTION_FILE_X, SOLUTION_FILE_Y, SOLUTION_FILE_WIDTH, SOLUTION_FILE_HEIGHT));

        this.getContentPane().setLayout(null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tfGrad, null);
        this.getContentPane().add(labelSolutionFileName, null);
        this.getContentPane().add(buttonOK, null);
    }

    void show(Solution solution) {
        theSolution = solution;
        tfGrad.setText("" + theSolution.getGradeInt());
        labelSolutionFileName.setText(theSolution.SolutionFileName);
        setVisible(true);
    }

    void buttonOKActionPerformed(ActionEvent e) {
        theSolution.setGradeInt(Integer.parseInt(tfGrad.getText()));
        setVisible(false);
    }

}