/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.QuickKassa;

import java.awt.Component;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;

/**
 *
 * @author yannick.thibos
 */
public class QuickKassa extends javax.swing.JFrame {

    /**
     * Creates new form QuickKassa
     */
    public QuickKassa() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        burgerKeuze = new javax.swing.ButtonGroup();
        frietGrootte = new javax.swing.ButtonGroup();
        drinkKeuze = new javax.swing.ButtonGroup();
        drinkGrootte = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        doubleCheese = new javax.swing.JRadioButton();
        kingBurger = new javax.swing.JRadioButton();
        fishBurger = new javax.swing.JRadioButton();
        vegiBurger = new javax.swing.JRadioButton();
        chickenNuggets = new javax.swing.JRadioButton();
        cheeseHam = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        frietSmall = new javax.swing.JRadioButton();
        frietMedium = new javax.swing.JRadioButton();
        frietLarge = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        drinkCoke = new javax.swing.JRadioButton();
        drinkFanta = new javax.swing.JRadioButton();
        drinkSprite = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        drinkSmall = new javax.swing.JRadioButton();
        drinkMedium = new javax.swing.JRadioButton();
        drinkLarge = new javax.swing.JRadioButton();
        sausPanel = new javax.swing.JPanel();
        sausKetchup = new javax.swing.JCheckBox();
        sausMayo = new javax.swing.JCheckBox();
        sausCurry = new javax.swing.JCheckBox();
        sausZoetzuur = new javax.swing.JCheckBox();
        sausTartaar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        tafelNummer = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnWissen = new javax.swing.JButton();
        btnAfrekenen = new javax.swing.JButton();
        lblTotaal = new javax.swing.JLabel();
        txtKredietkaart = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblBestelling = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu's (3,00EUR)"));

        burgerKeuze.add(doubleCheese);
        doubleCheese.setText("Double Cheese");

        burgerKeuze.add(kingBurger);
        kingBurger.setText("King Burger");

        burgerKeuze.add(fishBurger);
        fishBurger.setText("Fish Burger");

        burgerKeuze.add(vegiBurger);
        vegiBurger.setText("Vegi Burger");

        burgerKeuze.add(chickenNuggets);
        chickenNuggets.setText("Chicken Nuggets");

        burgerKeuze.add(cheeseHam);
        cheeseHam.setText("Cheese & Ham");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doubleCheese)
                    .addComponent(kingBurger)
                    .addComponent(fishBurger))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cheeseHam)
                    .addComponent(chickenNuggets)
                    .addComponent(vegiBurger))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doubleCheese)
                    .addComponent(vegiBurger))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kingBurger)
                    .addComponent(chickenNuggets))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fishBurger)
                    .addComponent(cheeseHam))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Frieten"));

        frietGrootte.add(frietSmall);
        frietSmall.setText("Small (1,40EUR)");

        frietGrootte.add(frietMedium);
        frietMedium.setText("Medium (1,80EUR)");

        frietGrootte.add(frietLarge);
        frietLarge.setText("Large (2,20EUR)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frietMedium)
                    .addComponent(frietSmall)
                    .addComponent(frietLarge))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(frietSmall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frietMedium)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frietLarge))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Drinks"));

        drinkKeuze.add(drinkCoke);
        drinkCoke.setText("Coke");
        drinkCoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinkCokeActionPerformed(evt);
            }
        });

        drinkKeuze.add(drinkFanta);
        drinkFanta.setText("Fanta");

        drinkKeuze.add(drinkSprite);
        drinkSprite.setText("Sprite");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(drinkFanta)
            .addComponent(drinkCoke)
            .addComponent(drinkSprite)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(drinkCoke)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drinkFanta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(drinkSprite)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Drinksize"));

        drinkGrootte.add(drinkSmall);
        drinkSmall.setText("30 cl (1,30EUR)");

        drinkGrootte.add(drinkMedium);
        drinkMedium.setText("40 cl (1,70EUR)");

        drinkGrootte.add(drinkLarge);
        drinkLarge.setText("50 cl (2,00EUR)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drinkSmall)
                    .addComponent(drinkMedium)
                    .addComponent(drinkLarge))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(drinkSmall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drinkMedium)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drinkLarge))
        );

        sausPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Sausjes (0,50EUR)"));

        sausKetchup.setText("Ketchup");

        sausMayo.setText("Mayo");

        sausCurry.setText("Curry");

        sausZoetzuur.setText("Zoetzuur");

        sausTartaar.setText("Tartaar");

        javax.swing.GroupLayout sausPanelLayout = new javax.swing.GroupLayout(sausPanel);
        sausPanel.setLayout(sausPanelLayout);
        sausPanelLayout.setHorizontalGroup(
            sausPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sausPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sausKetchup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sausMayo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(sausCurry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sausZoetzuur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sausTartaar)
                .addContainerGap())
        );
        sausPanelLayout.setVerticalGroup(
            sausPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sausPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(sausKetchup)
                .addComponent(sausMayo)
                .addComponent(sausCurry)
                .addComponent(sausZoetzuur)
                .addComponent(sausTartaar))
        );

        jLabel1.setText("Tafel");

        jLabel2.setText("Kredietkaartnummer:");

        btnWissen.setText("Wissen");

        btnAfrekenen.setText("Afrekenen");
        btnAfrekenen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfrekenenActionPerformed(evt);
            }
        });

        lblTotaal.setText("Totaal: ");

        try {
            txtKredietkaart.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblBestelling.setColumns(20);
        lblBestelling.setRows(5);
        jScrollPane1.setViewportView(lblBestelling);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sausPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnWissen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAfrekenen)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotaal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tafelNummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKredietkaart))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sausPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tafelNummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtKredietkaart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWissen)
                    .addComponent(btnAfrekenen)
                    .addComponent(lblTotaal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drinkCokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drinkCokeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drinkCokeActionPerformed

    private void btnAfrekenenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfrekenenActionPerformed
        float werkprijs = 3.0F;
        if (frietSmall.isSelected()) {
            werkprijs += 1.4F;
        } else if (frietMedium.isSelected()) {
            werkprijs += 1.8F;
        } else if (frietLarge.isSelected()) {
            werkprijs += 2.2F;
        }

        if (drinkSmall.isSelected()) {
            werkprijs += 1.3F;
        }
        if (drinkMedium.isSelected()) {
            werkprijs += 1.7F;
        }
        if (drinkLarge.isSelected()) {
            werkprijs += 2.0F;
        }

        String sausjes = "";
        Component[] sausjesElements = sausPanel.getComponents();
        for (int i = 0; i < sausjesElements.length; i++) {
            if (sausjesElements[i] instanceof JCheckBox) {
                JCheckBox sausje = (JCheckBox) sausjesElements[i];
                if (sausje.isSelected()) {
                    werkprijs += 0.50F;
                    sausjes += sausje.getActionCommand();
                    sausjes += ", ";
                }
            }
        }
        // Trim de laatste ", " eraf indien minstens 1 saus
        if (!sausjes.equals(""))
            sausjes = sausjes.substring(0, sausjes.length() - 2);
        
        String m = String.valueOf(werkprijs) + "EUR";
        lblTotaal.setText(m);
        
        String tekst = "Tafel " + tafelNummer.getValue() + " bestelde: \n";
        
        Enumeration<AbstractButton> elements = burgerKeuze.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton radio = elements.nextElement();
            if (radio.isSelected()) tekst += radio.getActionCommand();
        }
        
        tekst += " menu met friet ";
        elements = frietGrootte.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton radio = elements.nextElement();
            if (radio.isSelected())
                tekst += radio.getActionCommand();
        }
        
        tekst += " friet \nmet daarbij een ";
        elements = drinkKeuze.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton radio = elements.nextElement();
            if (radio.isSelected()) {
                tekst += radio.getActionCommand();
            }
        }
        
        tekst += " van ";
        elements = drinkGrootte.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton radio = elements.nextElement();
            if (radio.isSelected()) tekst += radio.getActionCommand();
        }
        
        tekst += ". Sausjes: " + sausjes;
        tekst += ". Wenst te betalen met kredietkaart " + txtKredietkaart.getText();
        tekst += "<html>" + tekst + "</html>";
        lblBestelling.append(tekst);
    }//GEN-LAST:event_btnAfrekenenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuickKassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuickKassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuickKassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuickKassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuickKassa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfrekenen;
    private javax.swing.JButton btnWissen;
    private javax.swing.ButtonGroup burgerKeuze;
    private javax.swing.JRadioButton cheeseHam;
    private javax.swing.JRadioButton chickenNuggets;
    private javax.swing.JRadioButton doubleCheese;
    private javax.swing.JRadioButton drinkCoke;
    private javax.swing.JRadioButton drinkFanta;
    private javax.swing.ButtonGroup drinkGrootte;
    private javax.swing.ButtonGroup drinkKeuze;
    private javax.swing.JRadioButton drinkLarge;
    private javax.swing.JRadioButton drinkMedium;
    private javax.swing.JRadioButton drinkSmall;
    private javax.swing.JRadioButton drinkSprite;
    private javax.swing.JRadioButton fishBurger;
    private javax.swing.ButtonGroup frietGrootte;
    private javax.swing.JRadioButton frietLarge;
    private javax.swing.JRadioButton frietMedium;
    private javax.swing.JRadioButton frietSmall;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton kingBurger;
    private javax.swing.JTextArea lblBestelling;
    private javax.swing.JLabel lblTotaal;
    private javax.swing.JCheckBox sausCurry;
    private javax.swing.JCheckBox sausKetchup;
    private javax.swing.JCheckBox sausMayo;
    private javax.swing.JPanel sausPanel;
    private javax.swing.JCheckBox sausTartaar;
    private javax.swing.JCheckBox sausZoetzuur;
    private javax.swing.JSpinner tafelNummer;
    private javax.swing.JFormattedTextField txtKredietkaart;
    private javax.swing.JRadioButton vegiBurger;
    // End of variables declaration//GEN-END:variables
}
