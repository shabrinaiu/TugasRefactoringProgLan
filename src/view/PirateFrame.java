package view;

import controller.Client;
import javax.swing.JOptionPane;
import model.Player;
import model.EnemyStatus;
import model.Piece;

public class PirateFrame extends javax.swing.JFrame {

    private Client client;
    private Player pirate;

    public PirateFrame() {
        initComponents();
        client = new Client();
        pirate = new Player(100, Piece.PIRATE);
        start();
    }
    
    private void start(){
        healthValue.setText(String.valueOf(pirate.getHealth()));
        Runtime.getRuntime().addShutdownHook(new Thread() { 
        public void run() 
        { 
            client.close();
        } 
        });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                client.open();
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
                    client.sendMessage(new EnemyStatus(id, name));
                    EnemyStatus message = client.receiveMessage();
                    checkCondition(id, message);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        thread.start();
    }
    
    private void checkCondition(int pirateId, EnemyStatus message){
        final boolean notifyWinningCondition = pirate.notifyWinningCondition(pirateId, message.getId());
        conditionTextField.setText("Townie chose " + message.getName()
        + " to defend. " + pirate.setCondition(notifyWinningCondition));
        if (!notifyWinningCondition) {
            pirate.subtractHealth();
            healthValue.setText(String.valueOf(pirate.getHealth()));
        } 
        checkPirateHealthCondition();
    }
    
    private void checkPirateHealthCondition(){
        if (pirate.getHealth() > 0)
            enableButton();
        else
            JOptionPane.showMessageDialog(this, "Townie wins");
    }
    
    private void disableButton(){
        schimitarButton.setEnabled(false);
        rapierButton.setEnabled(false);
        pistolButton.setEnabled(false);
    }
    
    private void enableButton(){
        schimitarButton.setEnabled(true);
        rapierButton.setEnabled(true);
        pistolButton.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        schimitarButton = new javax.swing.JButton();
        rapierButton = new javax.swing.JButton();
        pistolButton = new javax.swing.JButton();
        conditionTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        healthValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pirate (Player 1)");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pirate");

        jLabel2.setText("Choose your weapon");

        schimitarButton.setText("Schimitar");
        schimitarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schimitarButtonActionPerformed(evt);
            }
        });

        rapierButton.setText("Rapier");
        rapierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapierButtonActionPerformed(evt);
            }
        });

        pistolButton.setText("Pistol");
        pistolButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pistolButtonActionPerformed(evt);
            }
        });

        conditionTextField.setEditable(false);

        jLabel3.setText("Win Condition");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Heatlh :");

        healthValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        healthValue.setForeground(new java.awt.Color(255, 0, 51));
        healthValue.setText("xxx");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(schimitarButton)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthValue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(rapierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(pistolButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(conditionTextField)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(schimitarButton)
                    .addComponent(rapierButton)
                    .addComponent(pistolButton))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(healthValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conditionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void schimitarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schimitarButtonActionPerformed
        transferMessage(0, "Schimitar");
    }//GEN-LAST:event_schimitarButtonActionPerformed

    private void rapierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapierButtonActionPerformed
        transferMessage(1, "Rapier");
    }//GEN-LAST:event_rapierButtonActionPerformed

    private void pistolButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pistolButtonActionPerformed
        transferMessage(2, "Pistol");
    }//GEN-LAST:event_pistolButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PirateFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField conditionTextField;
    private javax.swing.JLabel healthValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton pistolButton;
    private javax.swing.JButton rapierButton;
    private javax.swing.JButton schimitarButton;
    // End of variables declaration//GEN-END:variables
}
