

package GUI;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.event.*;

import Controller.MainGuiController;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 * @author Henrik Tykesson
 */
public class MainGUI extends JFrame {
    private MainGuiController controller;
    private int ticket = 0;
    private JCheckBox checkBoxTur;
    private JCheckBox checkBoxRetur;
    private JComboBox comboBoxAvresa;
    private JComboBox comboBoxHemresa;
    private JButton buttonPlus;
    private JTextArea textAreaTickets;
    private JButton buttonMinus;
    private JButton buttonAvsluta;
    private JButton buttonSök;
    private JFrame frame;

    public MainGUI() {
        initComponents();


    }

    private void comboBoxAvresaPopupMenuWillBecomeVisible(PopupMenuEvent e) {
        // TODO add your code here
    }

    private void comboBoxHemresaPopupMenuWillBecomeVisible(PopupMenuEvent e) {
        // TODO add your code here
    }

    private void buttonPlusActionPerformed(ActionEvent e) {
        ticket = ticket + 1;
        textAreaTickets.setText(String.valueOf(ticket));
    }

    private void buttonMinusActionPerformed(ActionEvent e) {
        ticket = ticket - 1;
        if(ticket < 0){
            ticket = 0;
        }
        textAreaTickets.setText(String.valueOf(ticket));
    }

    private void buttonAvslutaActionPerformed(ActionEvent e) {
        System.exit(1);
    }

    private void buttonSökActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void comboBoxHemresaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void comboBoxAvresaActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    private void checkBoxTurActionPerformed(ActionEvent e) {
        controller.turIsChecked();
    }
    private void checkBoxReturActionPerformed(ActionEvent e) {
        controller.returIsChecked();
    }

    private void initComponents() {

        checkBoxTur = new JCheckBox();
        checkBoxRetur = new JCheckBox();
        comboBoxAvresa = new JComboBox();
        comboBoxHemresa = new JComboBox();
        buttonPlus = new JButton();
        textAreaTickets = new JTextArea();
        buttonMinus = new JButton();
        buttonAvsluta = new JButton();
        buttonSök = new JButton();
        frame = new JFrame("Buss Bolaget");

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
                "20*(default, $lcgap), default",
                "12*(default, $lgap), default"));

        //---- checkBoxTur ----
        checkBoxTur.setText("Tur  ");
        checkBoxTur.addActionListener(e -> checkBoxTurActionPerformed(e));
        contentPane.add(checkBoxTur, CC.xy(1, 1));

        //---- checkBoxRetur ----
        checkBoxRetur.setText("Retur");
        checkBoxRetur.addActionListener(e -> checkBoxReturActionPerformed(e));
        contentPane.add(checkBoxRetur, CC.xy(9, 1));

        //---- comboBoxAvresa ----
        comboBoxAvresa.setEditable(true);
        comboBoxAvresa.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {}
            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                comboBoxAvresaPopupMenuWillBecomeVisible(e);
            }
        });
        comboBoxAvresa.addActionListener(e -> comboBoxAvresaActionPerformed(e));

        contentPane.add(comboBoxAvresa, CC.xywh(1, 3, 7, 1, CC.LEFT, CC.DEFAULT));

        //---- comboBoxHemresa ----
        comboBoxHemresa.setEditable(true);

        comboBoxHemresa.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {}
            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                comboBoxHemresaPopupMenuWillBecomeVisible(e);
            }
        });
        comboBoxHemresa.addActionListener(e -> comboBoxHemresaActionPerformed(e));
        contentPane.add(comboBoxHemresa, CC.xywh(9, 3, 19, 1, CC.LEFT, CC.DEFAULT));

        //---- DatePickerAvresa ----
        UtilDateModel modelAvresa = new UtilDateModel();
        JDatePanelImpl datePanelAvresa = new JDatePanelImpl(modelAvresa);
        JDatePickerImpl datePickerAvresa = new JDatePickerImpl(datePanelAvresa, new DateLabelFormatter());
        contentPane.add(datePickerAvresa, CC.xy(1, 5, CC.LEFT, CC.DEFAULT));

        //---- DatePickerHemresa ----
        UtilDateModel modelHemresa = new UtilDateModel();
        JDatePanelImpl datePanelHemresa = new JDatePanelImpl(modelHemresa);
        JDatePickerImpl datePickerHemresa = new JDatePickerImpl(datePanelHemresa, new DateLabelFormatter());

        contentPane.add(datePickerHemresa, CC.xywh(9, 5, 19, 1));

        //---- buttonPlus ----
        buttonPlus.setText("+");
        buttonPlus.addActionListener(e -> buttonPlusActionPerformed(e));
        contentPane.add(buttonPlus, CC.xy(3, 11));

        //---- textAreaTickets ----
        textAreaTickets.setText(String.valueOf(ticket));
        textAreaTickets.setFont(new Font("Monospaced", Font.BOLD, 14));
        contentPane.add(textAreaTickets, CC.xy(5, 11, CC.CENTER, CC.CENTER));

        //---- buttonMinus ----
        buttonMinus.setText("-");
        buttonMinus.addActionListener(e -> buttonMinusActionPerformed(e));
        contentPane.add(buttonMinus, CC.xy(7, 11));

        //---- buttonAvsluta ----
        buttonAvsluta.setText("Avsluta");
        buttonAvsluta.addActionListener(e -> buttonAvslutaActionPerformed(e));
        contentPane.add(buttonAvsluta, CC.xy(9, 17));

        //---- buttonSök ----
        buttonSök.setText("S\u00f6k");
        buttonSök.addActionListener(e -> buttonSökActionPerformed(e));
        contentPane.add(buttonSök, CC.xy(13, 17));
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(checkBoxTur);
        buttonGroup1.add(checkBoxRetur);

        //---- JFrame ----
        frame.add(contentPane);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }



    public static void main(String[] args){
        MainGUI mainGUI = new MainGUI();


    }
}

