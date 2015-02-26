/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import Console.Elimination;
import Console.Equipe;
import Console.Poule;
import static Swing.fPoule.AjoutColonne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class fTournoiPoule extends javax.swing.JDialog {

    private Elimination suitePoule; // va servir a la fin du tour de poule

    private final ArrayList<Equipe> listeApresPoule = new ArrayList<Equipe>();
    private final DefaultTableModel table;
    private final Poule poule;
    private fElimination fApresPoule;

    /**
     * Creates new form fTournoiPoule
     */
    public fTournoiPoule(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        poule = ((fAccueil) getParent()).getPoule();
        table = (DefaultTableModel) tPoule.getModel();

        for (int i = 0; i < poule.getListePoulesTournoi().size(); i++) {
            for (int j = 0; j < 4; j++) {
                table.addRow(new Object[]{poule.getListePoulesTournoi().get(i)[j].getDescription()});
            }
        }
        bContinuer.setVisible(false);
    }

    public void matchPoule(Equipe[] poule) {
        //1er match
        JPanel p1 = new JPanel();
        JTextField score11 = new JTextField("    ");
        score11.setSize(30, 10);
        JTextField score12 = new JTextField("    ");
        score12.setSize(30, 10);
        JLabel descriptifMatch1 = new JLabel();
        descriptifMatch1.setText(poule[0].getDescription() + " VS " + poule[1].getDescription());

        p1.add(score11);
        p1.add(score12);
        p1.add(descriptifMatch1);

        BoxLayout b1 = new BoxLayout(p1, BoxLayout.PAGE_AXIS);

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, p1, "1er match", JOptionPane.OK_OPTION)) {

            try {

                if (Integer.parseInt(score11.getText().trim().toString()) < 0 || Integer.parseInt(score12.getText().trim().toString()) < 0) {
                    throw new Exception();
                }
                // affectation des points en récupérant le contenu des cases
                poule[0].setNbPointsMatch(Integer.parseInt(score11.getText().trim().toString()));
                poule[1].setNbPointsMatch(Integer.parseInt(score12.getText().trim().toString()));

//                indicateur = true;
                // levée de l'exception d'un score négatif
            } catch (InputMismatchException pbFormat) {
                JOptionPane.showMessageDialog(null, "Attention, rentrez un nombre entier", "ATTENTION", JOptionPane.ERROR_MESSAGE);

//                indicateur = false;
            } catch (Exception nbPositif) {
                JOptionPane.showMessageDialog(null, "Attention, un score de match ne peut pas être négatif", "ATTENTION", JOptionPane.ERROR_MESSAGE);
//                indicateur = false;

            }

        }

        winLose(poule[0], poule[1]);
        affectationGoalAverage(poule[0], poule[1]);

        //2eme match
        JPanel p2 = new JPanel();
        JTextField score21 = new JTextField("    ");
        score21.setSize(20, 10);
        JTextField score22 = new JTextField("    ");
        score22.setSize(20, 10);
        JLabel descriptifMatch2 = new JLabel();
        descriptifMatch2.setText(poule[0].getDescription() + " VS " + poule[2].getDescription());

        p2.add(score21);
        p2.add(score22);
        p2.add(descriptifMatch2);

        BoxLayout b2 = new BoxLayout(p2, BoxLayout.PAGE_AXIS);

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, p2, "2eme match", JOptionPane.YES_NO_OPTION)) {

            try {

                if (Integer.parseInt(score21.getText().trim().toString()) < 0 || Integer.parseInt(score22.getText().trim().toString()) < 0) {
                    throw new Exception();
                }
                // affectation des points en récupérant le contenu des cases
                poule[0].setNbPointsMatch(Integer.parseInt(score21.getText().trim().toString()));
                poule[2].setNbPointsMatch(Integer.parseInt(score22.getText().trim().toString()));

//                indicateur = true;
                // levée de l'exception d'un score négatif
            } catch (InputMismatchException pbFormat) {
                JOptionPane.showMessageDialog(null, "Attention, rentrez un nombre entier", "ATTENTION", JOptionPane.ERROR_MESSAGE);

//                indicateur = false;
            } catch (Exception nbPositif) {
                JOptionPane.showMessageDialog(null, "Attention, un score de match ne peut pas être négatif", "ATTENTION", JOptionPane.ERROR_MESSAGE);
//                indicateur = false;

            }

        }

        winLose(poule[0], poule[2]);
        affectationGoalAverage(poule[0], poule[2]);

        //3eme match
        JPanel p3 = new JPanel();
        JTextField score31 = new JTextField("    ");
        score31.setSize(20, 10);
        JTextField score32 = new JTextField("    ");
        score32.setSize(20, 10);
        JLabel descriptifMatch3 = new JLabel();
        descriptifMatch3.setText(poule[0].getDescription() + " VS " + poule[3].getDescription());

        p3.add(score31);
        p3.add(score32);
        p3.add(descriptifMatch3);

        BoxLayout b3 = new BoxLayout(p3, BoxLayout.PAGE_AXIS);

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, p3, "3eme match", JOptionPane.YES_NO_OPTION)) {

            try {

                if (Integer.parseInt(score31.getText().trim().toString()) < 0 || Integer.parseInt(score32.getText().trim().toString()) < 0) {
                    throw new Exception();
                }
                // affectation des points en récupérant le contenu des cases
                poule[0].setNbPointsMatch(Integer.parseInt(score31.getText().trim().toString()));
                poule[3].setNbPointsMatch(Integer.parseInt(score32.getText().trim().toString()));

//                indicateur = true;
                // levée de l'exception d'un score négatif
            } catch (InputMismatchException pbFormat) {
                JOptionPane.showMessageDialog(null, "Attention, rentrez un nombre entier", "ATTENTION", JOptionPane.ERROR_MESSAGE);

//                indicateur = false;
            } catch (Exception nbPositif) {
                JOptionPane.showMessageDialog(null, "Attention, un score de match ne peut pas être négatif", "ATTENTION", JOptionPane.ERROR_MESSAGE);
//                indicateur = false;

            }
        }

        winLose(poule[0], poule[3]);
        affectationGoalAverage(poule[0], poule[3]);

//4eme match
        JPanel p4 = new JPanel();
        JTextField score41 = new JTextField("    ");
        score41.setSize(20, 10);
        JTextField score42 = new JTextField("    ");
        score42.setSize(20, 10);
        JLabel descriptifMatch4 = new JLabel();
        descriptifMatch4.setText(poule[1].getDescription() + " VS " + poule[2].getDescription());

        p4.add(score41);
        p4.add(score42);
        p4.add(descriptifMatch4);

        BoxLayout b4 = new BoxLayout(p4, BoxLayout.PAGE_AXIS);

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, p4, "4eme match", JOptionPane.YES_NO_OPTION)) {

            try {

                if (Integer.parseInt(score41.getText().trim().toString()) < 0 || Integer.parseInt(score42.getText().trim().toString()) < 0) {
                    throw new Exception();
                }
                // affectation des points en récupérant le contenu des cases
                poule[1].setNbPointsMatch(Integer.parseInt(score41.getText().trim().toString()));
                poule[2].setNbPointsMatch(Integer.parseInt(score42.getText().trim().toString()));

//                indicateur = true;
                // levée de l'exception d'un score négatif
            } catch (InputMismatchException pbFormat) {
                JOptionPane.showMessageDialog(null, "Attention, rentrez un nombre entier", "ATTENTION", JOptionPane.ERROR_MESSAGE);

//                indicateur = false;
            } catch (Exception nbPositif) {
                JOptionPane.showMessageDialog(null, "Attention, un score de match ne peut pas être négatif", "ATTENTION", JOptionPane.ERROR_MESSAGE);
//                indicateur = false;

            }

        }

        winLose(poule[1], poule[2]);
        affectationGoalAverage(poule[1], poule[2]);

        //5eme match
        JPanel p5 = new JPanel();
        JTextField score51 = new JTextField("    ");
        score51.setSize(20, 10);
        JTextField score52 = new JTextField("    ");
        score52.setSize(20, 10);
        JLabel descriptifMatch5 = new JLabel();
        descriptifMatch5.setText(poule[1].getDescription() + " VS " + poule[3].getDescription());

        p5.add(score51);
        p5.add(score52);
        p5.add(descriptifMatch5);

        BoxLayout b5 = new BoxLayout(p5, BoxLayout.PAGE_AXIS);

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, p5, "5eme match", JOptionPane.YES_NO_OPTION)) {

            try {

                if (Integer.parseInt(score51.getText().trim().toString()) < 0 || Integer.parseInt(score52.getText().trim().toString()) < 0) {
                    throw new Exception();
                }
                // affectation des points en récupérant le contenu des cases
                poule[1].setNbPointsMatch(Integer.parseInt(score51.getText().trim().toString()));
                poule[3].setNbPointsMatch(Integer.parseInt(score52.getText().trim().toString()));

//                indicateur = true;
                // levée de l'exception d'un score négatif
            } catch (InputMismatchException pbFormat) {
                JOptionPane.showMessageDialog(null, "Attention, rentrez un nombre entier", "ATTENTION", JOptionPane.ERROR_MESSAGE);

//                indicateur = false;
            } catch (Exception nbPositif) {
                JOptionPane.showMessageDialog(null, "Attention, un score de match ne peut pas être négatif", "ATTENTION", JOptionPane.ERROR_MESSAGE);
//                indicateur = false;

            }

        }

        winLose(poule[1], poule[3]);
        affectationGoalAverage(poule[1], poule[3]);

        //6eme match
        JPanel p6 = new JPanel();
        JTextField score61 = new JTextField("    ");
        score61.setSize(20, 10);
        JTextField score62 = new JTextField("    ");
        score62.setSize(20, 10);
        JLabel descriptifMatch6 = new JLabel();
        descriptifMatch1.setText(poule[2].getDescription() + " VS " + poule[3].getDescription());

        p6.add(score61);
        p6.add(score62);
        p6.add(descriptifMatch1);

        BoxLayout b6 = new BoxLayout(p6, BoxLayout.PAGE_AXIS);

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, p6, "6eme match", JOptionPane.YES_NO_OPTION)) {

            try {

                if (Integer.parseInt(score61.getText().trim().toString()) < 0 || Integer.parseInt(score62.getText().trim().toString()) < 0) {
                    throw new Exception();
                }
                // affectation des points en récupérant le contenu des cases
                poule[2].setNbPointsMatch(Integer.parseInt(score61.getText().trim().toString()));
                poule[3].setNbPointsMatch(Integer.parseInt(score62.getText().trim().toString()));

                // levée de l'exception d'un score négatif
            } catch (InputMismatchException pbFormat) {
                JOptionPane.showMessageDialog(null, "Attention, rentrez un nombre entier", "ATTENTION", JOptionPane.ERROR_MESSAGE);

            } catch (Exception nbPositif) {
                JOptionPane.showMessageDialog(null, "Attention, un score de match ne peut pas être négatif", "ATTENTION", JOptionPane.ERROR_MESSAGE);
            }
        }

        winLose(poule[2], poule[3]);
        affectationGoalAverage(poule[2], poule[3]);

    }

    // methode qui va trier les poules en fct du nombre de points de chaques
    // equipes et qui va ajouter les 2 gagnants dans la liste de gagnants qu'on
    // va ensuite transformer en tableau fixe pour l'insérer dans l'algorithme
    // d'elimination
    public void gagnantsPoule(Equipe[] poule, ArrayList<Equipe> listeApresPoule) {

        Comparator<Equipe> pointsTournoi;
        pointsTournoi = new Comparator<Equipe>() {
            @Override
            public int compare(Equipe eq1, Equipe eq2) {
                return eq1.getNbPointsTournois() - eq2.getNbPointsTournois();
            }
        };

        Arrays.sort(poule, pointsTournoi);

        // une fois le tableau de poule trié selon le nb de points de chaque
        // équipe on prend les 2 gagnants qu'on range dans la liste de gagnants
        // des poules
        listeApresPoule.add(poule[2]);
        listeApresPoule.add(poule[3]);
    }

    public void affectationGoalAverage(Equipe teamUn, Equipe teamDeux) {
        //Equipe EquipeGagnante;
        // affectation des goal average
        teamUn.setGoalAverage(teamUn.getNbPointsMatch()
                - teamDeux.getNbPointsMatch());
        teamDeux.setGoalAverage(teamDeux.getNbPointsMatch()
                - teamUn.getNbPointsMatch());
//        if (teamDeux.getNbPointsMatch() < teamUn.getNbPointsMatch()) {
//            return EquipeGagnante = teamUn;
//        } else {
//           return  EquipeGagnante = teamDeux;
//        }

    }

    public void winLose(Equipe eq1, Equipe eq2) {

        if (eq1.getNbPointsMatch() < eq2.getNbPointsMatch()) {
            eq2.setNbPointsTournois(eq2.getNbPointsTournois() + 3);
        }

        if (eq1.getNbPointsMatch() > eq2.getNbPointsMatch()) {
            eq1.setNbPointsTournois(eq1.getNbPointsTournois() + 3);
        }

        if (eq1.getNbPointsMatch() == eq2.getNbPointsMatch()) {
            eq2.setNbPointsTournois(eq2.getNbPointsTournois() + 1);
            eq2.setNbPointsTournois(eq2.getNbPointsTournois() + 1);
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

        jLabel1 = new javax.swing.JLabel();
        bExit = new javax.swing.JButton();
        bLancerTourPoule = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        tPoule = new javax.swing.JTable();
        bContinuer = new javax.swing.JButton();
        lVerif = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Saisie des scores");

        bExit.setText("Exit");

        bLancerTourPoule.setText("Lancer tour poule");
        bLancerTourPoule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLancerTourPouleActionPerformed(evt);
            }
        });

        tPoule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Poules"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tPoule);

        bContinuer.setText("Continuer le tournoi");
        bContinuer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bContinuerActionPerformed(evt);
            }
        });

        lVerif.setText("        ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bContinuer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bLancerTourPoule)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bExit)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addComponent(lVerif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(lVerif)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExit)
                    .addComponent(bLancerTourPoule)
                    .addComponent(bContinuer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLancerTourPouleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLancerTourPouleActionPerformed
        for (int i = 0; i < poule.getListePoulesTournoi().size(); i++) {
            matchPoule(poule.getListePoulesTournoi().get(i));
            gagnantsPoule(poule.getListePoulesTournoi().get(i), listeApresPoule);
        }
        bContinuer.setVisible(true);
        lVerif.setText("2 meilleurs de chaque poule (2premières poules) /VERIFICATION\" : " + listeApresPoule.get(0).getDescription() + "   ET   " + listeApresPoule.get(1).getDescription()
                + "  *******  " + listeApresPoule.get(2).getDescription() + "   ET   " + listeApresPoule.get(3).getDescription());

    }//GEN-LAST:event_bLancerTourPouleActionPerformed

    private void bContinuerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bContinuerActionPerformed
        suitePoule = new Elimination(); // nouvelle élimination qu'on lancerea apres les tours de poule (6tours)
        
        
        
               
        
        
        suitePoule.setEquipesEli(listeApresPoule);
        
         Equipe[] tabInter = suitePoule.startTournois();
        suitePoule.setEquipesEli(Arrays.asList(tabInter));

        ((fAccueil) getParent()).setElimination(suitePoule);
        fApresPoule = new fElimination((fAccueil) getParent(), false);
        this.setVisible(false);
        fApresPoule.setVisible(true);
        
        
        
        
 /*       
        ((fAccueil) getParent()).setElimination(suitePoule);
        
        

        this.setVisible(false);
        fApresPoule.setVisible(true);*/

    }//GEN-LAST:event_bContinuerActionPerformed

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
            java.util.logging.Logger.getLogger(fTournoiPoule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fTournoiPoule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fTournoiPoule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fTournoiPoule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fTournoiPoule dialog = new fTournoiPoule(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bContinuer;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bLancerTourPoule;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lVerif;
    private javax.swing.JTable tPoule;
    // End of variables declaration//GEN-END:variables
}
