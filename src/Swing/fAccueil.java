/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import Console.Elimination;
import Console.Enregistrements;
import Console.Poule;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class fAccueil extends javax.swing.JFrame {

    private fEquipePoule saisieEquipePoule;
    private fEquipeElimination saisieEquipeElimination;
    public Poule poule;
    public Elimination elimination;
    Enregistrements record;

    /**
     * Creates new form fAccueil
     */
    public fAccueil() throws IOException {

        initComponents();
        this.setTitle("Accueil");
        //creation des fiches qui vont s'afficher au clic du bon bouton
        //ajout des equipes enregistrées dans la comboBox
        record = new Enregistrements("Equipes.txt");
        record.chargerListeEquipes();
        for(int j =0;j<record.getEquipes().size();j++){
        cbSupprimer.addItem(record.getEquipes().get(j).getDescription());
        }
        
       }

    public Poule getPoule() {
        return poule;
    }

    public Poule setPoule(Poule unePoule) {
        poule = unePoule;
        return poule;
    }

    public Elimination getElimination() {
        return elimination;
    }

    public Elimination setElimination(Elimination uneElimination) {
        elimination = uneElimination;
        return elimination;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bEliminationDirecte = new javax.swing.JButton();
        bPoule = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        cbSupprimer = new javax.swing.JComboBox();
        bSupprimer = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Ultimate Tournament");

        jLabel2.setText("Quel type de compétition voulez-vous organiser ?");

        bEliminationDirecte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bEliminationDirecte.setText("Elimination directe");
        bEliminationDirecte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminationDirecteActionPerformed(evt);
            }
        });

        bPoule.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bPoule.setText("Poule");
        bPoule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPouleActionPerformed(evt);
            }
        });

        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        bSupprimer.setText("Supprimer cette equipe");
        bSupprimer.setToolTipText("");
        bSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSupprimerActionPerformed(evt);
            }
        });

        jLabel3.setText("Outil de suppression des equipes enregistrées");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bSupprimer))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bExit)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(bEliminationDirecte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(bPoule))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEliminationDirecte)
                    .addComponent(bPoule))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExit)
                    .addComponent(cbSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSupprimer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bPouleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPouleActionPerformed
        try {
            poule = new Poule();
            saisieEquipePoule = new fEquipePoule(this, false);
            this.setVisible(false);
            saisieEquipePoule.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(fAccueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_bPouleActionPerformed

    private void bEliminationDirecteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminationDirecteActionPerformed
        try {
            elimination = new Elimination();
            saisieEquipeElimination = new fEquipeElimination(this, false);
            this.setVisible(false);
            saisieEquipeElimination.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(fAccueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bEliminationDirecteActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bExitActionPerformed

    private void bSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSupprimerActionPerformed
        String aSupprimer = (String) cbSupprimer.getSelectedItem();
        
        //Affichage d'une fenetre demandant a l'utilisateur de confirmer son choix de revenir à l'accueil
        int choix = JOptionPane.showConfirmDialog(this, "Etes vous sur de vouloir supprimer "+ aSupprimer+" de votre fichier equipe ?",
                "ATTENTION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (choix == JOptionPane.YES_OPTION) {
            try {
                                
            //sélection de l'equipe a supprimer
            
            //suppression de l'equipe choisie du fichier equipe
            record.suppTeam(aSupprimer);
            
            //réinitialisation de la combo box
            cbSupprimer.removeAllItems();
            for(int j =0;j<record.getEquipes().size();j++){
        cbSupprimer.addItem(record.getEquipes().get(j).getDescription());
        }
            
        } catch (IOException ex) {
            Logger.getLogger(fAccueil.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
       
        
    }//GEN-LAST:event_bSupprimerActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new fAccueil().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(fAccueil.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEliminationDirecte;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bPoule;
    private javax.swing.JButton bSupprimer;
    private javax.swing.JComboBox cbSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
