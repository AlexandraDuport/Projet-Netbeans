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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class fTournoiPoule extends javax.swing.JDialog {

    private final Elimination suitePoule; // va servir a la fin du tour de poule
    private final ArrayList<Equipe> listeIntermediaire = new ArrayList<Equipe>(); // Va stocker le gagnant de chaque match de poule avec son goal average -> on l'utilisera ensuite dans la fct ... pour sort et chopper les 2 gagnants
    private final DefaultTableModel table;
    private final Poule poule;

    /**
     * Creates new form fTournoiPoule
     */
    public fTournoiPoule(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        suitePoule = new Elimination(); // nouvelle élimination qu'on lancerea apres les tours de poule (6tours)

        poule = ((fAccueil) getParent()).getPoule();
        table = (DefaultTableModel) tPoule.getModel();

        for (int i = 0; i < poule.getListePoulesTournoi().size(); i++) {
            for (int j = 0; j < 4; j++) {
                table.addRow(new Object[]{poule.getListePoulesTournoi().get(i)[j].getDescription()});
            }
        }

    }

    public void matchPoule(Equipe[] poule, ArrayList<Equipe> listeIntermediaire) {
        //1er match
        JPanel p = new JPanel();
        JTextField score1 = new JTextField();
        JTextField score2 = new JTextField();

        p.add(score1);
        p.add(score2);

        BoxLayout b = new BoxLayout(p, BoxLayout.PAGE_AXIS);

        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, p, "****** 1er match ****** \n" + poule[0].getDescription() + " VS "
                + poule[1].getDescription(), JOptionPane.YES_NO_OPTION)) {

            poule[0].nbPointsMatch=score1.getText();
            String strScore1 = score1.getText();
            String strScore2 = score2.getText();
        }

        winLose(poule[0], poule[1]);
        teamGagnante(poule[0], poule[1]);
          //mettre le vaiqueur dans la première case de listeIntermediaire

        //2eme match
        System.out.println("2eme match de phase de poule:" + poule[0].getDescription() + " VS "
                + poule[2].getDescription());
        winLose(poule[0], poule[2]);
        teamGagnante(poule[0], poule[2]);

        System.out.println("3eme match de phase de poule:" + poule[0].getDescription() + " VS "
                + poule[3].getDescription());
        winLose(poule[0], poule[3]);
        teamGagnante(poule[0], poule[3]);

        System.out.println("4eme match de phase de poule:" + poule[1].getDescription() + " VS "
                + poule[2].getDescription());
        winLose(poule[1], poule[2]);
        teamGagnante(poule[1], poule[2]);

        System.out.println("5eme match de phase de poule:" + poule[1].getDescription() + " VS "
                + poule[3].getDescription());
        winLose(poule[1], poule[3]);
        teamGagnante(poule[1], poule[3]);

        System.out.println("6eme match de phase de poule:" + poule[2].getDescription() + " VS "
                + poule[3].getDescription());
        winLose(poule[2], poule[3]);
        teamGagnante(poule[2], poule[3]);
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

    public Equipe teamGagnante(Equipe teamUn, Equipe teamDeux) {
        Equipe EquipeGagnante;
        // affectation des goal average
        teamUn.setGoalAverage(teamUn.getNbPointsMatch()
                - teamDeux.getNbPointsMatch());
        teamDeux.setGoalAverage(teamDeux.getNbPointsMatch()
                - teamUn.getNbPointsMatch());
        if (teamDeux.getNbPointsMatch() < teamUn.getNbPointsMatch()) {
            EquipeGagnante = teamUn;
        } else {
            EquipeGagnante = teamDeux;
        }
        return EquipeGagnante;
    }

    public void winLose(Equipe eq1, Equipe eq2) {

        saisieScoresOptionPane(eq1, eq2);

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

    public void saisieScoresOptionPane(Equipe eq1, Equipe eq2) {
        // indicateur qui laisse passer à la saisie suivante que si la
        // derniere est conforme
//        boolean indicateur = false;

        int score = 0;// score du match

        try {
            // pas d'autorisation de score négatif
            if (score < 0) {
                throw new Exception();
            }
            // affectation des points en récupérant le contenu des cases
            score = Integer.parseInt((String) table.getValueAt(0, 1 + 1)); // 0 et 1 juste pour supprimer les erreurs et pouvoir lancer le programme
            eq1.setNbPointsMatch(score);
            score = Integer.parseInt((String) table.getValueAt(0 + 1, 1 + 1));
            eq2.setNbPointsMatch(score);

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
        jButton1 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        tPoule = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Saisie des scores");

        bExit.setText("Exit");

        jButton1.setText("Valider les scores et passer au tour suivant ");

        tPoule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Poules"
            }
        ));
        jScrollPane1.setViewportView(tPoule);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bExit)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(182, 182, 182))))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExit)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JButton bExit;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tPoule;
    // End of variables declaration//GEN-END:variables
}
