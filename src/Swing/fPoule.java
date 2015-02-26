/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import Console.Poule;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Swing.fEquipePoule;
import javax.swing.table.TableCellRenderer;


public class fPoule extends javax.swing.JDialog {

    private Poule poule;
    DefaultTableModel table;
    private fTournoiPoule saisieMatchPoule;
    

    //CONSTRUCTEUR
    public fPoule(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//        fEquipePoule saisieEquipe = new fEquipePoule(parent, modal);
        poule = ((fAccueil)getParent()).getPoule();
        
        table = (DefaultTableModel) tAffichagePoule.getModel(); // table ou les poules seront affichées
        
        
        for (int i = 0; i < poule.getListePoulesTournoi().size(); i++) {
            AjoutColonne(table, "Poule " + Integer.toString(i)  );
            for (int j = 0; j < 4; j++) {
                table.setValueAt(poule.getListePoulesTournoi().get(i)[j].getDescription(), j, i); //
            }
        }
    }

    public static void AjoutColonne(DefaultTableModel table, String name) {
        TableColumn col = new TableColumn();
        col.setHeaderValue(name);
        table.addColumn(col);
    }
    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAffichagePoule = new javax.swing.JTable();
        bRetourAccueil = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        bPrecedent = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bCommencer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Poules");

        tAffichagePoule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Poule 1"
            }
        ));
        jScrollPane1.setViewportView(tAffichagePoule);

        bRetourAccueil.setText("Accueil");
        bRetourAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetourAccueilActionPerformed(evt);
            }
        });

        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        bPrecedent.setText(" < Précédent");
        bPrecedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrecedentActionPerformed(evt);
            }
        });

        jLabel2.setText("Liste des poules du tournoi:");

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
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1)
                        .addGap(0, 171, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bPrecedent, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(bCommencer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bRetourAccueil)
                        .addGap(18, 18, 18)
                        .addComponent(bExit)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExit)
                    .addComponent(bRetourAccueil)
                    .addComponent(bPrecedent)
                    .addComponent(bCommencer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void bRetourAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetourAccueilActionPerformed
        //Affichage d'une fenetre demandant a l'utilisateur de confirmer son choix de revenir à l'accueil
        int choix = JOptionPane.showConfirmDialog(this, "Voulez vous retourner à l'accueil ? \n Attention, les données que vous venez de rentrer seront effacées",
                "ATTENTION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        //si l'utilisateur selectionne oui il retourne a l'accueil et si il selec non il annule son retour
        if (choix == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            //en cas de retour on charge une nouvelle fiche d'accueil
            fAccueil accueil = new fAccueil();
            accueil.setVisible(true);
        } else;
    }//GEN-LAST:event_bRetourAccueilActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bExitActionPerformed

    private void bPrecedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrecedentActionPerformed
        //recapEquipesPoule.setVisible(true);
    }//GEN-LAST:event_bPrecedentActionPerformed

    private void bCommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCommencerActionPerformed
        saisieMatchPoule = new fTournoiPoule((fAccueil)getParent(), false);
        saisieMatchPoule.setVisible(true);
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
            java.util.logging.Logger.getLogger(fPoule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                fPoule dialog = new fPoule(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bPrecedent;
    private javax.swing.JButton bRetourAccueil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tAffichagePoule;
    // End of variables declaration//GEN-END:variables
}
