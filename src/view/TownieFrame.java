package view;

import controller.Server;
import javax.swing.JOptionPane;
import model.EnemyStatus;
import model.Piece;
import model.Player;

public class TownieFrame extends javax.swing.JFrame {
    
    private Server server;
    private Player townie;

    public TownieFrame() {
        initComponents();
        server = new Server();
        townie = new Player(100, Piece.TOWNIE);
        start();
    }
    
    private void start(){
        healthValue.setText(String.valueOf(townie.getHealth()));
        Runtime.getRuntime().addShutdownHook(new Thread() { 
        public void run() 
        { 
            server.close();
        } 
        }); 
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                server.open();
            }
        });
        thread.start();
    }
    
    private void transferMessage(int id, String name){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    disableButton();
                    server.sendMessage(new EnemyStatus(id, name));
                    EnemyStatus message = server.receiveMessage();
                    checkCondition(id, message);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } 
            }
        });
        thread.start();
    }
    
    private void checkCondition(int townieId, EnemyStatus message){
        if (!townie.notifyWinningCondition(message.getId(),townieId)) {
            townie.subtractHealth();
            healthValue.setText(String.valueOf(townie.getHealth()));
        } 
        checkTownieHealthCondition();
    }
    
    private void checkTownieHealthCondition(){
        if (townie.getHealth() > 0)
            enableButton();
        else
            JOptionPane.showMessageDialog(this, "Pirate wins");
    }
    
    private void disableButton(){
        sidestepButton.setEnabled(false);
        chainmailButton.setEnabled(false);
        backpedalButton.setEnabled(false);
    }
    
    private void enableButton(){
        sidestepButton.setEnabled(true);
        chainmailButton.setEnabled(true);
        backpedalButton.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sidestepButton = new javax.swing.JButton();
        chainmailButton = new javax.swing.JButton();
        backpedalButton = new javax.swing.JButton();
        conditionTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        healthLabel = new javax.swing.JLabel();
        healthValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Townie (Player 2)");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Townie");

        jLabel2.setText("Choose your defense");

        sidestepButton.setText("Sidestep");
        sidestepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidestepButtonActionPerformed(evt);
            }
        });

        chainmailButton.setText("Chainmail");
        chainmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chainmailButtonActionPerformed(evt);
            }
        });

        backpedalButton.setText("Backpedal");
        backpedalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backpedalButtonActionPerformed(evt);
            }
        });

        conditionTextField.setEditable(false);

        jLabel3.setText("Win Condition");

        healthLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        healthLabel.setText("Health : ");

        healthValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        healthValue.setForeground(new java.awt.Color(255, 0, 0));
        healthValue.setText("xxx");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(conditionTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sidestepButton)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(healthLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthValue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(chainmailButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                .addGap(72, 72, 72)
                                .addComponent(backpedalButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sidestepButton)
                    .addComponent(chainmailButton)
                    .addComponent(backpedalButton))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(healthLabel)
                    .addComponent(healthValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conditionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sidestepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidestepButtonActionPerformed
        transferMessage(0, "Sidestep");
    }//GEN-LAST:event_sidestepButtonActionPerformed

    private void chainmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chainmailButtonActionPerformed
        transferMessage(1, "Chainmail");
    }//GEN-LAST:event_chainmailButtonActionPerformed

    private void backpedalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backpedalButtonActionPerformed
        transferMessage(2, "Backpedal");
    }//GEN-LAST:event_backpedalButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TownieFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backpedalButton;
    private javax.swing.JButton chainmailButton;
    private javax.swing.JTextField conditionTextField;
    private javax.swing.JLabel healthLabel;
    private javax.swing.JLabel healthValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton sidestepButton;
    // End of variables declaration//GEN-END:variables
}
