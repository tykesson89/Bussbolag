/*
 * Created by JFormDesigner on Thu Apr 28 10:23:20 CEST 2016
 */

package GUI;

import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Henrik Tykesson
 */
public class Page2GUI extends JPanel {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton buttonUtresaDatumBak;
    private JLabel labelDatumUtresa;
    private JButton buttonUtresaDatumFram;
    private JLabel label13;
    private JScrollPane scrollPane2;
    private JTextPane textPaneUtresa;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JButton buttonHemresaDatumBak;
    private JLabel labelDatumHemresa;
    private JButton buttonHemresaDatumFram;
    private JScrollPane scrollPane1;
    private JTextPane textPaneHemresa;
    private JLabel label14;
    private JButton buttonTillbaka;
    private JButton buttonTillBokning;
    private JButton buttonAvsluta;

    public Page2GUI() {
        initComponents();
    }

    private void buttonUtresaDatumBakActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonUtresaDatumFramActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonHemresaDatumBakActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonHemresaDatumFramActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonTillbakaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonTillBokningActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonAvslutaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {

        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        buttonUtresaDatumBak = new JButton();
        labelDatumUtresa = new JLabel();
        buttonUtresaDatumFram = new JButton();
        label13 = new JLabel();
        scrollPane2 = new JScrollPane();
        textPaneUtresa = new JTextPane();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        buttonHemresaDatumBak = new JButton();
        labelDatumHemresa = new JLabel();
        buttonHemresaDatumFram = new JButton();
        scrollPane1 = new JScrollPane();
        textPaneHemresa = new JTextPane();
        label14 = new JLabel();
        buttonTillbaka = new JButton();
        buttonTillBokning = new JButton();
        buttonAvsluta = new JButton();

        //======== this ========


        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "Bokning", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new FormLayout(
            "39*(default, $lcgap), default",
            "41*(default, $lgap), default"));

        //---- label1 ----
        label1.setText("Avg\u00e5ng");
        add(label1, CC.xy(5, 3));

        //---- label2 ----
        label2.setText("Ankomst");
        add(label2, CC.xy(9, 3));

        //---- label3 ----
        label3.setText("Restid");
        add(label3, CC.xy(15, 3));

        //---- label4 ----
        label4.setText("Byte");
        add(label4, CC.xy(21, 3));

        //---- label5 ----
        label5.setText("Pris");
        add(label5, CC.xy(27, 3));

        //---- buttonUtresaDatumBak ----
        buttonUtresaDatumBak.setText("<--");
        buttonUtresaDatumBak.addActionListener(e -> buttonUtresaDatumBakActionPerformed(e));
        add(buttonUtresaDatumBak, CC.xy(33, 3));

        //---- labelDatumUtresa ----
        labelDatumUtresa.setText("2016-04-28  Torsdag");
        add(labelDatumUtresa, CC.xy(35, 3));

        //---- buttonUtresaDatumFram ----
        buttonUtresaDatumFram.setText("-->");
        buttonUtresaDatumFram.addActionListener(e -> buttonUtresaDatumFramActionPerformed(e));
        add(buttonUtresaDatumFram, CC.xy(37, 3));

        //---- label13 ----
        label13.setText("Utresa");
        add(label13, CC.xy(1, 5));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textPaneUtresa);
        }
        add(scrollPane2, CC.xywh(3, 5, 35, 13));

        //---- label7 ----
        label7.setText("Avg\u00e5ng");
        add(label7, CC.xy(5, 19));

        //---- label8 ----
        label8.setText("Ankomst");
        add(label8, CC.xy(9, 19));

        //---- label9 ----
        label9.setText("Restid");
        add(label9, CC.xy(15, 19));

        //---- label10 ----
        label10.setText("Byte");
        add(label10, CC.xy(21, 19));

        //---- label11 ----
        label11.setText("Pris");
        add(label11, CC.xy(27, 19));

        //---- buttonHemresaDatumBak ----
        buttonHemresaDatumBak.setText("<--");
        buttonHemresaDatumBak.addActionListener(e -> buttonHemresaDatumBakActionPerformed(e));
        add(buttonHemresaDatumBak, CC.xy(33, 19));

        //---- labelDatumHemresa ----

        labelDatumHemresa.setText("2016-04-30  Lördag");
        add(labelDatumHemresa, CC.xy(35, 19));

        //---- buttonHemresaDatumFram ----
        buttonHemresaDatumFram.setText("-->");
        buttonHemresaDatumFram.addActionListener(e -> buttonHemresaDatumFramActionPerformed(e));
        add(buttonHemresaDatumFram, CC.xy(37, 19));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textPaneHemresa);
        }
        add(scrollPane1, CC.xywh(3, 21, 35, 14));

        //---- label14 ----
        label14.setText("Hemresa");
        add(label14, CC.xy(1, 23));

        //---- buttonTillbaka ----
        buttonTillbaka.setText("Tillbaka");
        buttonTillbaka.addActionListener(e -> buttonTillbakaActionPerformed(e));
        add(buttonTillbaka, CC.xy(25, 43));

        //---- buttonTillBokning ----
        buttonTillBokning.setText("Till Bokning");
        buttonTillBokning.addActionListener(e -> buttonTillBokningActionPerformed(e));
        add(buttonTillBokning, CC.xy(29, 43));

        //---- buttonAvsluta ----
        buttonAvsluta.setText("Avsluta");
        buttonAvsluta.addActionListener(e -> buttonAvslutaActionPerformed(e));
        add(buttonAvsluta, CC.xy(33, 43));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Henrik Tykesson




    public static void main(String[] args){
        Page2GUI page2GUI = new Page2GUI();
        JFrame frame = new JFrame("BussBolag");
        frame.add(page2GUI);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
