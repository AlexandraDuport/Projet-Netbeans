/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Swing;

import Console.Elimination;
import Console.Equipe;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fEquipeElimination extends javax.swing.JDialog {

   private fAccueil accueil;
   private fElimination recapEquipesElimination;
   private Elimination tournoiElimination;
   Equipe eq;
   public int i = 0;
   DefaultTableModel table;
    /**
     * 
     * Creates new form fEquipeElimination
     */
   
   
   //CONSTRUCTEUR
    public fEquipeElimination(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Saisie des équipes");
        
        tournoiElimination= ((fAccueil)getParent()).getElimination();
        
        
        lNombreEquipesEnregistrees.setText(Integer.toString(i));
        table = (DefaultTableModel) tElimination.getModel();
    }
   
    
    //METHODE
    private boolean isNumeric(String carac){
    try {
      Integer.parseInt(String.valueOf(carac));
    }
    catch (NumberFormatException e) {
      return false;            
    }
    return true;
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tElimination = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tfNomEquipe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfNombreJoueur = new javax.swing.JTextField();
        bEditer = new javax.swing.JButton();
        bAjouter = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bCommencer = new javax.swing.JButton();
        lErreur = new javax.swing.JLabel();
        bSupprimer = new javax.swing.JButton();
        lNombreEquipesEnregistrees = new javax.swing.JLabel();
        bAnnuler = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        bPrecedent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Saisie des equipes pour le mode Elimination Directe");

        tElimination.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom de l'équipe", "Nombre de joueurs"
            }
        ));
        tElimination.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tEliminationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tElimination);

        jLabel3.setText("Nom de l'équipe:");

        tfNomEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomEquipeActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre de joueurs:");

        bEditer.setText("Editer");
        bEditer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditerActionPerformed(evt);
            }
        });

        bAjouter.setText("Ajouter");
        bAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre d'équipes enregistrées:");

        bCommencer.setText("Commencer");
        bCommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCommencerActionPerformed(evt);
            }
        });

        lErreur.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        bSupprimer.setText("Supprimer");
        bSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSupprimerActionPerformed(evt);
            }
        });

        lNombreEquipesEnregistrees.setText("    ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bAjouter)
                        .addGap(18, 18, 18)
                        .addComponent(bEditer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bSupprimer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bCommencer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lNombreEquipesEnregistrees, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel4)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNombreJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNomEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfNomEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfNombreJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lNombreEquipesEnregistrees))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bAjouter)
                            .addComponent(bEditer)
                            .addComponent(bCommencer)
                            .addComponent(bSupprimer))
                        .addGap(93, 93, 93))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        bAnnuler.setText("Annuler");
        bAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnnulerActionPerformed(evt);
            }
        });

        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        bPrecedent.setText("< Précédent");
        bPrecedent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrecedentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bPrecedent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAnnuler)
                .addGap(18, 18, 18)
                .addComponent(bExit)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExit)
                    .addComponent(bAnnuler)
                    .addComponent(bPrecedent))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tfNomEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomEquipeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomEquipeActionPerformed
    
    private void bAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterActionPerformed
        
        if (tfNomEquipe.getText().trim().equals("") || tfNombreJoueur.getText().trim().equals("")){
            lErreur.setForeground(Color.RED);
            lErreur.setText("ERREUR, un des champs est vide");
        }
        
        else if (!isNumeric(tfNombreJoueur.getText())  ) {
            lErreur.setForeground(Color.BLACK);
            lErreur.setText("ERREUR, rentrez un chiffre dans le nombre de joueurs");
        }
        
        // ajouter exception nombre négatif en tant que Nombre de joueurs
        
        else {
            lErreur.setForeground(Color.blue);
            lErreur.setText("Entrée prise en compte");
            table.addRow(new Object[] {tfNomEquipe.getText(), tfNombreJoueur.getText()});
            i++;
            tfNomEquipe.setText("");
            tfNombreJoueur.setText("");
            lNombreEquipesEnregistrees.setText(Integer.toString(i));
             }
        
//        try{
//        lErreur.setForeground(Color.blue);
//            lErreur.setText("Entrée prise en compte");
//            table.addRow(new Object[] {tfNomEquipe.getText(), tfNombreJoueur.getText()});
//            i++;
//            tfNomEquipe.setText("");
//            tfNombreJoueur.setText("");
//            lNombreEquipesEnregistrees.setText(Integer.toString(i));
//            
//            while(tfNomEquipe!= null && tfNomEquipe != null);
//        }
//        
//        catch (Exception e) {
//                lErreur.setForeground(Color.RED);
//                lErreur.setText("ERREUR, un des champs est vide" + e.getMessage());
//        }
        
        
        
    }//GEN-LAST:event_bAjouterActionPerformed
    
    @SuppressWarnings("empty-statement")
    private void bAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnnulerActionPerformed
        //Affichage d'une fenetre demandant a l'utilisateur de confirmer son choix de revenir à l'accueil
        int choix = JOptionPane.showConfirmDialog(this, "Voulez vous retourner à l'accueil ? \nAttention, les données que vous venez de rentrer seront effacées",
         "ATTENTION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);                
        
        //si l'utilisateur selectionne oui il retourne a l'accueil et si il selec non il annule son retour
       if (choix==JOptionPane.YES_OPTION) {
            this.setVisible(false);
            dispose();
             //en cas de retour on charge une nouvelle fiche d'accueil
            
            accueil.setVisible(true);}
       
       else;
    }//GEN-LAST:event_bAnnulerActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bExitActionPerformed

    private void bEditerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditerActionPerformed
        
        table.setValueAt(tfNomEquipe.getText(), tElimination.getSelectedRow(),0);
        table.setValueAt(tfNombreJoueur.getText(), tElimination.getSelectedRow(),1);
    }//GEN-LAST:event_bEditerActionPerformed

    private void bCommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCommencerActionPerformed
            
        for (int j=0 ; j<tElimination.getRowCount() ; j++) {
                    eq = new Equipe( table.getValueAt(j,0).toString(),  Integer.parseInt(table.getValueAt(j,1).toString()) );
                    tournoiElimination.getEquipesEli().add(eq);
            }
        
        tournoiElimination.startTournois();
            ((fAccueil)getParent()).setElimination(tournoiElimination);
            recapEquipesElimination = new fElimination((fAccueil) this.getParent(), false);
            this.setVisible(false);
            recapEquipesElimination.setVisible(true);
    }//GEN-LAST:event_bCommencerActionPerformed

    private void tEliminationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tEliminationMouseClicked
       
        tfNomEquipe.setText(table.getValueAt(tElimination.getSelectedRow(),0).toString());
        tfNombreJoueur.setText(table.getValueAt(tElimination.getSelectedRow(),1).toString());
    }//GEN-LAST:event_tEliminationMouseClicked

    private void bSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSupprimerActionPerformed
        
        table.removeRow(tElimination.getSelectedRow());
        i--;
        lNombreEquipesEnregistrees.setText(Integer.toString(i));
        tfNombreJoueur.setText("");
        tfNomEquipe.setText("");
    }//GEN-LAST:event_bSupprimerActionPerformed

    private void bPrecedentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrecedentActionPerformed
       getParent().setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_bPrecedentActionPerformed

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
            java.util.logging.Logger.getLogger(fEquipeElimination.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                fEquipeElimination dialog = new fEquipeElimination(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bAjouter;
    private javax.swing.JButton bAnnuler;
    private javax.swing.JButton bCommencer;
    private javax.swing.JButton bEditer;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bPrecedent;
    private javax.swing.JButton bSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lErreur;
    private javax.swing.JLabel lNombreEquipesEnregistrees;
    private javax.swing.JTable tElimination;
    private javax.swing.JTextField tfNomEquipe;
    private javax.swing.JTextField tfNombreJoueur;
    // End of variables declaration//GEN-END:variables
}
