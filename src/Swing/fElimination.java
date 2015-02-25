/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Swing;

import Console.Elimination;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;


public class fElimination extends javax.swing.JDialog {

    DefaultTableModel table;
    private final Elimination elimination;
    private fTournoiElimination saisieMatchElimination;
    
//CONSTRUCTEUR
    public fElimination(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        elimination = ((fAccueil)getParent()).getElimination();
        
        table = (DefaultTableModel) tElimination.getModel();
        
        for (int i=0 ; i< elimination.getEquipesEli().size() ; i++) {
              table.addRow(new Object[] {elimination.getEquipesEli().get(i).getDescription()});
        }
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bPrecedent = new javax.swing.JButton();
        bRetour = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bRetourAccueil = new javax.swing.JButton();
        bExit1 = new javax.swing.JButton();
        bPrecedent1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tElimination = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        bCommencer = new javax.swing.JButton();

        bPrecedent.setText(" < Précédent");
        bPrecedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrecedentActionPerformed(evt);
            }
        });

        bRetour.setText("Accueil");
        bRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetourActionPerformed(evt);
            }
        });

        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Eliminations Directes");

        bRetourAccueil.setText("Accueil");
        bRetourAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetourAccueilActionPerformed(evt);
            }
        });

        bExit1.setText("Exit");
        bExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExit1ActionPerformed(evt);
            }
        });

        bPrecedent1.setText("< Précédent");
        bPrecedent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrecedent1ActionPerformed(evt);
            }
        });

        tElimination.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tElimination);

        jLabel2.setText("Liste des équipes du tournoi:");

        bCommencer.setText("Commencer !");
        bCommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCommencerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2)))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bPrecedent1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bCommencer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bRetourAccueil)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(bExit1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExit1)
                    .addComponent(bPrecedent1)
                    .addComponent(bCommencer)
                    .addComponent(bRetourAccueil))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bPrecedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrecedentActionPerformed
        
    }//GEN-LAST:event_bPrecedentActionPerformed

    private void bRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetourActionPerformed
        //Affichage d'une fenetre demandant a l'utilisateur de confirmer son choix de revenir à l'accueil
        int choix = JOptionPane.showConfirmDialog(this, "Voulez vous retourner à l'accueil ? \nAttention, les données que vous venez de rentrer seront effacées",
            "ATTENTION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        //si l'utilisateur selectionne oui il retourne a l'accueil et si il selec non il annule son retour
        if (choix==JOptionPane.YES_OPTION) {
            this.setVisible(false);
            //en cas de retour on charge une nouvelle fiche d'accueil
            fAccueil accueil = new fAccueil();
            accueil.setVisible(true);}

        else;
    }//GEN-LAST:event_bRetourActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bExitActionPerformed

    private void bRetourAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetourAccueilActionPerformed
        //Affichage d'une fenetre demandant a l'utilisateur de confirmer son choix de revenir à l'accueil
        int choix = JOptionPane.showConfirmDialog(this, "Voulez vous retourner à l'accueil ? \nAttention, les données que vous venez de rentrer seront effacées",
            "ATTENTION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        //si l'utilisateur selectionne oui il retourne a l'accueil et si il selec non il annule son retour
        if (choix==JOptionPane.YES_OPTION) {
            this.setVisible(false);
            //en cas de retour on charge une nouvelle fiche d'accueil
            fAccueil accueil = new fAccueil();
            accueil.setVisible(true);}

        else;
    }//GEN-LAST:event_bRetourAccueilActionPerformed

    private void bExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExit1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bExit1ActionPerformed

    private void bPrecedent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrecedent1ActionPerformed
        getParent().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bPrecedent1ActionPerformed

    private void bCommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCommencerActionPerformed
        saisieMatchElimination = new fTournoiElimination(((fAccueil)getParent()), false);
        //this.setVisible(false);
        saisieMatchElimination.setVisible(true);
    }//GEN-LAST:event_bCommencerActionPerformed

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
            java.util.logging.Logger.getLogger(fElimination.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                fElimination dialog = new fElimination(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCommencer;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bExit1;
    private javax.swing.JButton bPrecedent;
    private javax.swing.JButton bPrecedent1;
    private javax.swing.JButton bRetour;
    private javax.swing.JButton bRetourAccueil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tElimination;
    // End of variables declaration//GEN-END:variables
}
