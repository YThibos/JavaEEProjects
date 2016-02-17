/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oefeningen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.event.ListDataListener;

/**
 *
 * @author yannick.thibos
 */
public class TaakinvullingFrame extends JFrame implements ActionListener {

    private JLabel lblMaand, lblJaar, lblNaam, lblAantalUren;
    private JComboBox lstMaand;
    private JTextField txtJaar, txtNaam, txtAantalUren;
    private JRadioButton rdbArbeider, rdbBediende, rdbKaderlid;
    private JList lstActiviteit;
    private JButton btnOK;
    private ButtonGroup functieButtons;

    public TaakinvullingFrame() {
        setTitle("Taakinvulling werknemer");
        setSize(400,200);
    }

    public static void main(String[] args) {

        TaakinvullingFrame taakFrame = new TaakinvullingFrame();
        taakFrame.createGUI();
        taakFrame.setVisible(true);

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // DATUMPANEL
        JPanel pnlDatum = new JPanel();

        // 12 maanden in object array steken, die de combobox zal vullen
        Object[] maanden = {"Januari", "Februai", "Maart", "April", "Mei", "Juni",
            "Juli", "Augustus", "September", "Oktober", "November", "December"};
        lblMaand = new JLabel("Maand: ");
        lstMaand = new JComboBox(maanden);

        lblJaar = new JLabel("Jaar: ");
        txtJaar = new JTextField(5);

        pnlDatum.add(lblMaand);
        pnlDatum.add(lstMaand);
        pnlDatum.add(lblJaar);
        pnlDatum.add(txtJaar);
        pnlDatum.setVisible(true);
        add(pnlDatum);

        lblNaam = new JLabel("Naam: ");
        txtNaam = new JTextField(30);
        // EINDE DATUMPANEL

        // NAAMPANEL
        JPanel pnlNaam = new JPanel();

        add(lblNaam);
        add(txtNaam);
        pnlNaam.add(lblNaam);
        pnlNaam.add(txtNaam);

        add(pnlNaam);
        // EINDE NAAMPANEL
        
        // FUNCTIEPANEL
        JPanel pnlFunctie = new JPanel();

        rdbArbeider = new JRadioButton("Arbeider");
        rdbBediende = new JRadioButton("Bediende");
        rdbKaderlid = new JRadioButton("Kaderlid");
        
        functieButtons = new ButtonGroup();
        functieButtons.add(rdbArbeider);
        functieButtons.add(rdbBediende);
        functieButtons.add(rdbKaderlid);

        // Voorlopig twee functies (bezigheden) in een object array
        // Gebruik object array om list te initializen
        Object[] activiteiten = {"productie","verkoop"};
        lstActiviteit = new JList(activiteiten);
        lstActiviteit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        pnlFunctie.add(rdbArbeider);
        pnlFunctie.add(rdbBediende);
        pnlFunctie.add(rdbKaderlid);
        pnlFunctie.add(lstActiviteit);

        add(pnlFunctie);
        // EINDE FUNCTIEPANEL
        
        // AANTAL UREN PANEL
        JPanel pnlAantalUren = new JPanel();
        
        lblAantalUren = new JLabel("Aantal uren: ");
        txtAantalUren = new JTextField(5);
        
        pnlAantalUren.add(lblAantalUren);
        pnlAantalUren.add(txtAantalUren);
        
        add(pnlAantalUren);
        // EINDE AANTAL UREN PANEL
        
        btnOK = new JButton("OK");
        btnOK.addActionListener(this);
        add(btnOK);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        TaakinvullingBuilder taakBuilder = new TaakinvullingBuilder();
        
        // Maak een Date object mbv geselecteerd item in maanden list en tekst in txtJaar
        // (hier zou een controle moeten komen op goeie input, maar beuh)
        Date datum = new Date(Integer.parseInt(txtJaar.getText()), lstMaand.getSelectedIndex() + 1, 0);
        taakBuilder.setDatum(datum);

        String naam = txtNaam.getText();
        taakBuilder.setNaam(naam);
        
        String functie;
        if (rdbArbeider.isSelected()) { 
            functie = "Arbeider";
        }
        else if (rdbBediende.isSelected()) { 
            functie = "Bediende";
        }
        else if (rdbKaderlid.isSelected()) { 
            functie = "Kaderlid";
        }
        else {
            // Hier zou een exception moeten gethrowd worden
            // Input check ..
            functie = "n/a";
        }
        taakBuilder.setFunctie(functie);
        
        String activiteit = lstActiviteit.getSelectedValue().toString();
        taakBuilder.setActiviteit(activiteit);
        
        int aantalUren = Integer.parseInt(txtAantalUren.getText());
        taakBuilder.setAantalUren(aantalUren);
        
        Taakinvulling taak = taakBuilder.createTaakinvulling();
        
        System.out.println(taak);
        
    }

}
