/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import Console.Elimination;
import static Console.Elimination.tabSize;
import Console.Equipe;
import java.awt.Color;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

 
public class fTournoiElimination extends javax.swing.JDialog {

    private final Elimination elimination;
    private final DefaultTableModel table;
    Equipe[] tabInitial;
    int indiceCol = 0;
    int indiceRow = 0;
    private Color couleur;
   boolean asChange = false;//variable qui indiquera si le tableau a changé
   
  //permettra de changer la valeur de l'indicateur dans lancer tour 
   public void setAsChange(boolean change){
            this.asChange=change;
        }
   
    /**
     * Creates new form fTournois
     *
     * @param parent
     * @param modal
     */
    public fTournoiElimination(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        tpAffichageGagnant.setVisible(false); // on n'affiche pas encore le TextPane qui va dire le gagnant du tournoi

        elimination = ((fAccueil) getParent()).getElimination();
        //tabInitial initialisé
        tabInitial = (Equipe[]) elimination.getEquipesEli().toArray();
        table = (DefaultTableModel) tElimination.getModel();
        couleur = Color.RED;
        for (int i = 0; i < elimination.getEquipesEli().size(); i++) {
            tElimination.getCellRenderer(i * 2, 0).getTableCellRendererComponent(tElimination, elimination.getEquipesEli().get(i).getDescription(), true, true, i, 0).setBackground(couleur);
            tElimination.getCellRenderer(i, 1).getTableCellRendererComponent(tElimination, "", true, true, i, 1).setBackground(couleur);
            //on ajoute les equipes de la listes au tournois//on commence le tournois pour avoir le tableau initial d'équipes
            table.addRow(new Object[]{elimination.getEquipesEli().get(i).getDescription()});

            if (i % 2 == 0) {
                if (couleur == Color.RED) {
                    couleur = Color.cyan;
                } else {
                    couleur = Color.RED;
                }
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tElimination = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bValider = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpAffichageGagnant = new javax.swing.JTextPane();
        jAccueil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tElimination.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nouveau  Tour !", "Scores :"
            }
        ));
        tElimination.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tElimination.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tElimination);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Saisie des scores");

        bValider.setText("Valider les scores et passer au tour suivant");
        bValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bValiderActionPerformed(evt);
            }
        });

        tpAffichageGagnant.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(tpAffichageGagnant);

        jAccueil.setText("Retour Accueil");
        jAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAccueilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1)
                .addContainerGap(372, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bValider, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jAccueil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bValider, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jAccueil)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValiderActionPerformed
        //notification que la table a changé
     
        
        table.fireTableDataChanged();

        try {

            //réinitialisation de l'indice des lignes pour le tour suivant
            indiceRow = 0;

            //tab Initial est maintenant rempli passage au tour suivant en écrasant le tableau initial par le tableau d'après
            tabInitial = lancerTour(elimination, tabInitial, asChange);

            indiceRow = 0;

            if (indiceRow != 0) {
                throw new Exception();
            }

            //en cas de probleme de saisie, on arrête la fonction
        } catch (Exception saisie) {
            indiceRow = 0;
            return;
        }

        //ajout de nouvelles colonnes dans le tableau avec entrée des équipes du nouveau tour (maintenant dans le nouveau tableau initial)
        if (asChange == true) {
            if (tabInitial != null) {
                TableColumn colNvxTour = new TableColumn();
                colNvxTour.setHeaderValue("Nouveau Tour !");
                table.addColumn(colNvxTour);

                if (tabInitial.length != 1) {
                    TableColumn colNvxScore = new TableColumn();
                    colNvxScore.setHeaderValue("Scores: ");
                    table.addColumn(colNvxScore);
                } else {
                    //on empêche l'utilisateur de passer au tour suivant
                    bValider.setVisible(false);
                    //On affiche le nom du gagnant dans le panel
                    tpAffichageGagnant.setVisible(true);
                    tpAffichageGagnant.setText("Le grand gagnant du tournois est : " + tabInitial[0].getDescription());
                }

                indiceCol = indiceCol + 2;
//ecriture du tableau avec traitement des impairs
                for (int i = 0; i < tabInitial.length; i++) {
                    //on ecrit tout normallement si le tableau est pair
                    if ((tabInitial.length % 2 == 0) || (tabInitial.length == 1)) {
                        table.setValueAt(tabInitial[i].getDescription(), indiceRow, indiceCol); //
                        indiceRow++;
                        //sinon on ecrit pas la meilleure des equipes que l'on réserve pour le tour suivant
                    } else {
                        Equipe e = elimination.best(tabInitial);
                        if (e.getDescription().matches(tabInitial[i].getDescription()) == false) {
                            table.setValueAt(tabInitial[i].getDescription(), indiceRow, indiceCol); //
                            indiceRow++;
                        }

                    }
                }
}
                table.fireTableStructureChanged();
                indiceRow = 0;
            }
        
    }//GEN-LAST:event_bValiderActionPerformed

    private void jAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAccueilActionPerformed
        //Affichage d'une fenetre demandant a l'utilisateur de confirmer son choix de revenir à l'accueil
        int choix = JOptionPane.showConfirmDialog(this, "Voulez vous retourner à l'accueil ? \nAttention, les données que vous venez de rentrer seront effacées",
                "ATTENTION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        //si l'utilisateur selectionne oui il retourne a l'accueil et si il selec non il annule son retour
        if (choix == JOptionPane.YES_OPTION) {
            this.setVisible(false);

            //en cas de retour on charge une nouvelle fiche d'accueil
            fAccueil accueil = new fAccueil();
            accueil.setVisible(true);
        }


    }//GEN-LAST:event_jAccueilActionPerformed

    // détermine les gagnant et crée le nouveau tableau
    public Equipe[] lancerTour(Elimination eli, Equipe[] tabInitial, boolean asChange) throws Exception {
        int i = 0;// incrémenteur tableau initial
        int j = 0;// incrémenteur tableau du tour suivant
        Equipe tabSuivant[] = new Equipe[tabSize(tabInitial)];// tableau du tour

        // cas d'un tableau impair
        if ((tabInitial.length) % 2 != 0) {
			// On cherche le champion avec le meilleur goal average et on le
            // place automatiquement dans la première case du tableau suivant
            tabSuivant[0] = eli.best(tabInitial);
            j = 1; // incrémenteur du tableau suivant passe à 1
        }

        while (i < (tabInitial.length) && (j < (tabSuivant.length))) {

            // affectation des points de tournois et de match
            if (pasEgalite(tabInitial[i], tabInitial[i + 1]) == false) {
                setAsChange(false);
                return tabInitial;
            }
            tabSuivant[j] = eli.teamGagnante(tabInitial[i], tabInitial[i + 1]);
            // passage au prochain match du meme tour
            i = i + 2;
            // passage a la prochaine case du tableau du tour suivant
            j++;
        }
        // On retourne le nouveau tableau de tour
        setAsChange(true);
        return tabSuivant;
    }

    public boolean pasEgalite(Equipe eq1, Equipe eq2) {

        try {
            saisieScores(eq1, eq2);
            if (eq1.getNbPointsMatch() == eq2.getNbPointsMatch()) {
                throw new Exception();
            }
        } catch (Exception egalite) {
            JOptionPane.showMessageDialog(null, "Attention, pas d'egalité dans les eliminations!\n Merci de retaper vos scores !", "ATTENTION", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void saisieScores(Equipe eq1, Equipe eq2) {

        int score = 0;// score du match

        try {
            // pas d'autorisation de score négatif
            if (score < 0) {
                throw new Exception();
            }
            // affectation des points equipe 1 puis passage a la ligne suivante
            score = Integer.parseInt((String) table.getValueAt(indiceRow, indiceCol + 1));
            eq1.setNbPointsMatch(score);
            indiceRow++;
            // affectation des points equipe 1 puis passage a la ligne suivante
            score = Integer.parseInt((String) table.getValueAt(indiceRow, indiceCol + 1));
            eq2.setNbPointsMatch(score);
            indiceRow++;

            // levée de l'exception d'un score négatif
        } catch (InputMismatchException pbFormat) {
            JOptionPane.showMessageDialog(null, "Attention, rentrez un nombre entier", "ATTENTION", JOptionPane.ERROR_MESSAGE);

        } catch (Exception nbPositif) {
            JOptionPane.showMessageDialog(null, "Attention, un score de match ne peut pas être négatif", "ATTENTION", JOptionPane.ERROR_MESSAGE);

        }

    }

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
            java.util.logging.Logger.getLogger(fTournoiElimination.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fTournoiElimination.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fTournoiElimination.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fTournoiElimination.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                fTournoiElimination dialog = new fTournoiElimination(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bValider;
    private javax.swing.JButton jAccueil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tElimination;
    private javax.swing.JTextPane tpAffichageGagnant;
    // End of variables declaration//GEN-END:variables
}
