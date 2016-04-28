

package GUI;


import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Henrik Tykesson
 */
public class Page3GUI extends JPanel {
    private JRadioButton radioButtonMedlem;
    private JRadioButton radioButtonEjMedlem;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textFieldName;
    private JLabel label2;
    private JTextField textFieldAdress;
    private JLabel label3;
    private JTextField textFieldEmail;
    private JLabel label4;
    private JTextField textFieldPersonnummer;
    private JLabel label5;
    private JTextField textFieldTelefonnummer;
    private JPanel panel2;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label20;
    private JLabel label10;
    private JLabel labelUtresaTill;
    private JLabel labelUtresaFrån;
    private JLabel labelUtresaDatum;
    private JLabel labelUtresaPris;
    private JLabel label14;
    private JLabel labelHemresaTill;
    private JLabel labelHemresaFrån;
    private JLabel labelHemresaDatum;
    private JLabel labelHemresaPris;
    private JButton buttonTillbaka;
    private JButton buttonSlutför;
    private JButton buttonAvsluta;
    public Page3GUI() {
        initComponents();
    }

    private void radioButtonMedlemActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void radioButtonEjMedlemActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonTillbakaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonSlutförActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonAvslutaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {

        radioButtonMedlem = new JRadioButton();
        radioButtonEjMedlem = new JRadioButton();
        panel1 = new JPanel();
        label1 = new JLabel();
        textFieldName = new JTextField();
        label2 = new JLabel();
        textFieldAdress = new JTextField();
        label3 = new JLabel();
        textFieldEmail = new JTextField();
        label4 = new JLabel();
        textFieldPersonnummer = new JTextField();
        label5 = new JLabel();
        textFieldTelefonnummer = new JTextField();
        panel2 = new JPanel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label20 = new JLabel();
        label10 = new JLabel();
        labelUtresaTill = new JLabel();
        labelUtresaFrån = new JLabel();
        labelUtresaDatum = new JLabel();
        labelUtresaPris = new JLabel();
        label14 = new JLabel();
        labelHemresaTill = new JLabel();
        labelHemresaFrån = new JLabel();
        labelHemresaDatum = new JLabel();
        labelHemresaPris = new JLabel();
        buttonTillbaka = new JButton();
        buttonSlutför = new JButton();
        buttonAvsluta = new JButton();

        //======== this ========


        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "Bokning", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new FormLayout(
            "39*(default, $lcgap), default",
            "25*(default, $lgap), default"));

        //---- radioButtonMedlem ----
        radioButtonMedlem.setText("Medlem");
        radioButtonMedlem.addActionListener(e -> radioButtonMedlemActionPerformed(e));
        add(radioButtonMedlem, CC.xy(5, 3));

        //---- radioButtonEjMedlem ----
        radioButtonEjMedlem.setText("Ej Medlem");
        radioButtonEjMedlem.addActionListener(e -> radioButtonEjMedlemActionPerformed(e));
        add(radioButtonEjMedlem, CC.xy(17, 3));

        //======== panel1 ========
        {
            panel1.setLayout(new FormLayout(
                "45*(default, $lcgap), default",
                "15*(default, $lgap), default"));

            //---- label1 ----
            label1.setText("Namn:");
            panel1.add(label1, CC.xy(1, 1));
            panel1.add(textFieldName, CC.xywh(3, 1, 89, 1));

            //---- label2 ----
            label2.setText("Adress:");
            panel1.add(label2, CC.xy(1, 3));
            panel1.add(textFieldAdress, CC.xywh(3, 3, 89, 1));

            //---- label3 ----
            label3.setText("Email:");
            panel1.add(label3, CC.xy(1, 5));
            panel1.add(textFieldEmail, CC.xywh(3, 5, 89, 1));

            //---- label4 ----
            label4.setText("Personnummer:");
            panel1.add(label4, CC.xy(1, 7));
            panel1.add(textFieldPersonnummer, CC.xywh(3, 7, 89, 1));

            //---- label5 ----
            label5.setText("Telefon:");
            panel1.add(label5, CC.xy(1, 9));
            panel1.add(textFieldTelefonnummer, CC.xywh(3, 9, 89, 1));
        }
        add(panel1, CC.xywh(5, 5, 44, 1));

        //======== panel2 ========
        {
            panel2.setLayout(new FormLayout(
                "20*(default, $lcgap), default",
                "19*(default, $lgap), default"));

            //---- label6 ----
            label6.setText("Vald Resa");
            panel2.add(label6, CC.xy(3, 1));

            //---- label7 ----
            label7.setText("Till:");
            panel2.add(label7, CC.xy(9, 1));

            //---- label8 ----
            label8.setText("Fr\u00e5n:");
            panel2.add(label8, CC.xy(17, 1));

            //---- label9 ----
            label9.setText("Datum:");
            panel2.add(label9, CC.xy(27, 1));

            //---- label20 ----
            label20.setText("Pris");
            panel2.add(label20, CC.xy(37, 1));

            //---- label10 ----
            label10.setText("Utresa:");
            panel2.add(label10, CC.xy(3, 5));

            //---- labelUtresaTill ----
            labelUtresaTill.setText("Malm\u00f6");
            panel2.add(labelUtresaTill, CC.xy(9, 5));

            //---- labelUtresaFrån ----
            labelUtresaFrån.setText("Lule\u00e5");
            panel2.add(labelUtresaFrån, CC.xy(17, 5));

            //---- labelUtresaDatum ----
            labelUtresaDatum.setText("2016-04-28");
            panel2.add(labelUtresaDatum, CC.xy(27, 5));

            //---- labelUtresaPris ----
            labelUtresaPris.setText("300");
            panel2.add(labelUtresaPris, CC.xy(37, 5));

            //---- label14 ----
            label14.setText("Hemresa:");
            panel2.add(label14, CC.xy(3, 9));

            //---- labelHemresaTill ----
            labelHemresaTill.setText("Lule\u00e5");
            panel2.add(labelHemresaTill, CC.xy(9, 9));

            //---- labelHemresaFrån ----
            labelHemresaFrån.setText("Malm\u00f6");
            panel2.add(labelHemresaFrån, CC.xy(17, 9));

            //---- labelHemresaDatum ----
            labelHemresaDatum.setText("2016-04-30");
            panel2.add(labelHemresaDatum, CC.xy(27, 9));

            //---- labelHemresaPris ----
            labelHemresaPris.setText("300");
            panel2.add(labelHemresaPris, CC.xy(37, 9));
        }
        add(panel2, CC.xywh(1, 6, 55, 28));

        //---- buttonTillbaka ----
        buttonTillbaka.setText("Tillbaka");
        buttonTillbaka.addActionListener(e -> buttonTillbakaActionPerformed(e));
        add(buttonTillbaka, CC.xy(17, 37));

        //---- buttonSlutför ----
        buttonSlutför.setText("Slutf\u00f6r");
        buttonSlutför.addActionListener(e -> buttonSlutförActionPerformed(e));
        add(buttonSlutför, CC.xy(21, 37));

        //---- buttonAvsluta ----
        buttonAvsluta.setText("Avsluta");
        buttonAvsluta.addActionListener(e -> buttonAvslutaActionPerformed(e));
        add(buttonAvsluta, CC.xy(25, 37));

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButtonMedlem);
        buttonGroup1.add(radioButtonEjMedlem);

    }

    public static void main(String[] args){
        Page3GUI page3GUI = new Page3GUI();
        JFrame frame = new JFrame();
        frame.add(page3GUI);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
