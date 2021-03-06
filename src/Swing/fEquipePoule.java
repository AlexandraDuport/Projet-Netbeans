/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import Console.Enregistrements;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Console.Poule;
import Console.Equipe;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class fEquipePoule extends javax.swing.JDialog {

    public fPoule recapEquipesPoule;
    public int i = 0;
    Poule tournoiPoule = new Poule();
    Enregistrements record;
    DefaultTableModel table;
    Equipe eq;

    /**
     * Creates new form fEquipePoule
     *
     * @param parent
     * @param modal
     */
    public fEquipePoule(java.awt.Frame parent, boolean modal) throws IOException {

        super(parent, modal);
        initComponents();

        this.setTitle("Saisie des équipes pour le mode poule");
        tournoiPoule = ((fAccueil) getParent()).getPoule();

        lNombreEquipesEnregistrees.setText(Integer.toString(i));
        table = (DefaultTableModel) tPoule.getModel();

        //ajout des equipes enregistrées dans la comboBox
        record = new Enregistrements("Equipes.txt");
        record.chargerListeEquipes();
        for (int j = 0; j < record.getEquipes().size(); j++) {
            cbEnregistrer.addItem(record.getEquipes().get(j).getDescription());
        }

        recapEquipesPoule = new fPoule(parent, modal);
    }

    //METHODE
    //Retourne true si le paramètre est numérique, false dans le cas contraire
    private boolean isNumeric(String carac) {
        try {
            Integer.parseInt(String.valueOf(carac));
        } catch (NumberFormatException e) {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lAttentionMultiple4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNomEquipe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfNombreJoueur = new javax.swing.JTextField();
        bEditer = new javax.swing.JButton();
        bAjouter = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bCommencerTournoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPoule = new javax.swing.JTable();
        lErreur = new javax.swing.JLabel();
        bSupprimer = new javax.swing.JButton();
        lNombreEquipesEnregistrees = new javax.swing.JLabel();
        lVerif = new javax.swing.JLabel();
        cbEnregistrer = new javax.swing.JComboBox();
        bEnregistrements = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        bAnnuler = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Saisie des equipes pour le mode poule");

        lAttentionMultiple4.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        lAttentionMultiple4.setText("ATTENTION LE NOMBRE D'EQUIPES DOIT ETRE UN MULTIPLE DE 4");

        jLabel3.setText("Nom de l'équipe:");

        tfNomEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomEquipeActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre de joueurs:");

        tfNombreJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreJoueurActionPerformed(evt);
            }
        });

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
        bAjouter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bAjouterKeyPressed(evt);
            }
        });

        jLabel5.setText("Nombre d'équipes enregistrées:");

        bCommencerTournoi.setText("Commencer");
        bCommencerTournoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCommencerTournoiActionPerformed(evt);
            }
        });

        tPoule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom de l'équipe", "Nombre de joueurs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tPoule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPouleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tPoule);

        lErreur.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lErreur.setForeground(new java.awt.Color(255, 0, 0));

        bSupprimer.setText("Supprimer");
        bSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSupprimerActionPerformed(evt);
            }
        });

        lNombreEquipesEnregistrees.setText("   ");

        lVerif.setText("     ");

        bEnregistrements.setText("Ajouter Equipe Enregistrée");
        bEnregistrements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnregistrementsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfNomEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lNombreEquipesEnregistrees, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tfNombreJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(bAjouter))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bEditer, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bSupprimer)
                        .addGap(18, 18, 18)
                        .addComponent(bCommencerTournoi))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEnregistrements, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lVerif)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lAttentionMultiple4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lAttentionMultiple4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bAjouter)
                                .addGap(122, 122, 122))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tfNomEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tfNombreJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(lNombreEquipesEnregistrees))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bEditer)
                                    .addComponent(bSupprimer)
                                    .addComponent(bCommencerTournoi))
                                .addGap(39, 39, 39)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lVerif)
                            .addComponent(cbEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bEnregistrements))
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
        );

        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        bAnnuler.setText("Retour Accueil");
        bAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(bAnnuler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bExit)
                .addGap(368, 368, 368))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExit)
                    .addComponent(bAnnuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bExitActionPerformed

    private void tfNomEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomEquipeActionPerformed

    }//GEN-LAST:event_tfNomEquipeActionPerformed

    private void bAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterActionPerformed

        //ajout des entrées clavier dans le tableau 
        // si la case est non vide on ajoute l'entrée
        if (tfNomEquipe.getText().trim().equals("") || tfNombreJoueur.getText().trim().equals("")) {
            lErreur.setForeground(Color.RED);
            lErreur.setText("ERREUR, un des champs est vide");
        } else if (!isNumeric(tfNombreJoueur.getText())) {
            lErreur.setForeground(Color.BLACK);
            lErreur.setText("ERREUR, rentrez un chiffre dans le nombre de joueurs");
        } else {
            lErreur.setForeground(Color.blue);
            lErreur.setText("Entrée prise en compte");
            Equipe e = new Equipe(tfNomEquipe.getText(), Integer.parseInt(tfNombreJoueur.getText()));
            table.addRow(new Object[]{tfNomEquipe.getText(), tfNombreJoueur.getText()});
            i++;
            
            //proposition de l'enregistrement d'une équipe dans le fichier des equipes si celle ci n'y est pas déja
            if (record.rechercheEquipe(tfNomEquipe.getText()) == null) {
                //Affichage d'une fenetre demandant a l'utilisateur de confirmer son choix de revenir à l'accueil
                int choix = JOptionPane.showConfirmDialog(this, "Voulez vous enregistrer la nouvelle equipe cree ? \nElle sera disponible pour le prochain tournoi !",
                        "Enregistrer ? ", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                //si l'utilisateur selectionne oui il retourne a l'accueil et si il selec non il annule son retour
                if (choix == JOptionPane.YES_OPTION) {
                    try {
                        record.reecritEquipe(e);
                    } catch (IOException ex) {
                        Logger.getLogger(fEquipePoule.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            
            
            tfNomEquipe.setText("");
            tfNombreJoueur.setText("");
            lNombreEquipesEnregistrees.setText(Integer.toString(i));
        }

    }//GEN-LAST:event_bAjouterActionPerformed

    @SuppressWarnings("empty-statement")
    private void bAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnnulerActionPerformed

        //Affichage d'une fenetre demandant a l'utilisateur de confirmer son choix de revenir à l'accueil
        int choix = JOptionPane.showConfirmDialog(this, "Voulez vous retourner à l'accueil ? \nAttention, les données que vous venez de rentrer seront effacées",
                "ATTENTION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (choix == JOptionPane.YES_OPTION) {
            try {
                this.setVisible(false);
                dispose();
                //en cas de retour on charge une nouvelle fiche d'accueil
                fAccueil accueil = new fAccueil();
                accueil.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(fEquipePoule.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_bAnnulerActionPerformed

    private void bCommencerTournoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCommencerTournoiActionPerformed
try{
        if (tPoule.getRowCount() % 4 == 0 && tPoule.getRowCount() != 0) {

           boolean indicateur=true;
     for (int j = 0; j < tPoule.getRowCount(); j++) {

            eq = new Equipe(table.getValueAt(j, 0).toString(), Integer.parseInt(table.getValueAt(j, 1).toString()));
            if (tournoiPoule.rechercheEquipe(table.getValueAt(j, 0).toString()) == false) {
                tournoiPoule.getListeEquipesPoule().add(eq);
            } else{
                 JOptionPane.showMessageDialog(null, "Vous ne pouvez pas ajouter deux fois la meme equipe.\n Merci de supprimer les equipes identiques.","ATTENTION", JOptionPane.ERROR_MESSAGE);
                tournoiPoule.getListeEquipesPoule().clear();
                indicateur = false;
                break;
            }

        }

        if (indicateur == false) {
            return;
        }

       
        
             tournoiPoule.startPoule();
            ((fAccueil) getParent()).setPoule(tournoiPoule);
            recapEquipesPoule = new fPoule((fAccueil) this.getParent(), false);
            this.setVisible(false);
            recapEquipesPoule.setVisible(true);
        } else {
            lErreur.setForeground(Color.RED);
        }
        lErreur.setFont(new java.awt.Font("Courier New", 1, 12));
        lErreur.setText("Ajoutez encore " + (4 - tPoule.getRowCount() % 4) + " équipes pour compléter une poule");
}catch(Throwable e){
    
}
    }//GEN-LAST:event_bCommencerTournoiActionPerformed

    private void bEditerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditerActionPerformed
try{
        table.setValueAt(tfNomEquipe.getText(), tPoule.getSelectedRow(), 0);
        table.setValueAt(tfNombreJoueur.getText(), tPoule.getSelectedRow(), 1);
}catch(Throwable e){
    
}
    }//GEN-LAST:event_bEditerActionPerformed

    private void tPouleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPouleMouseClicked

        tfNomEquipe.setText(table.getValueAt(tPoule.getSelectedRow(), 0).toString());
        tfNombreJoueur.setText(table.getValueAt(tPoule.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tPouleMouseClicked

    private void bAjouterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bAjouterKeyPressed

    }//GEN-LAST:event_bAjouterKeyPressed

    private void tfNombreJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreJoueurActionPerformed

    }//GEN-LAST:event_tfNombreJoueurActionPerformed

    private void bSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSupprimerActionPerformed
try{
        table.removeRow(tPoule.getSelectedRow());
        i--;
        lNombreEquipesEnregistrees.setText(Integer.toString(i));
        tfNombreJoueur.setText("");
        tfNomEquipe.setText("");
}catch(Throwable e){
    
}
    }//GEN-LAST:event_bSupprimerActionPerformed

    private void bEnregistrementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnregistrementsActionPerformed
        Equipe e = record.rechercheEquipe((String) cbEnregistrer.getSelectedItem());

        table.addRow(new Object[]{e.getDescription(), Integer.toString(e.getNbJoueurs())});
        i++;
        lNombreEquipesEnregistrees.setText(Integer.toString(i));
    }//GEN-LAST:event_bEnregistrementsActionPerformed

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
            java.util.logging.Logger.getLogger(fEquipePoule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    fEquipePoule dialog = new fEquipePoule(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(fEquipePoule.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAjouter;
    private javax.swing.JButton bAnnuler;
    private javax.swing.JButton bCommencerTournoi;
    private javax.swing.JButton bEditer;
    private javax.swing.JButton bEnregistrements;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bSupprimer;
    private javax.swing.JComboBox cbEnregistrer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lAttentionMultiple4;
    private javax.swing.JLabel lErreur;
    private javax.swing.JLabel lNombreEquipesEnregistrees;
    private javax.swing.JLabel lVerif;
    private javax.swing.JTable tPoule;
    private javax.swing.JTextField tfNomEquipe;
    private javax.swing.JTextField tfNombreJoueur;
    // End of variables declaration//GEN-END:variables
}
