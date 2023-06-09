package IU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author thicc
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Tetris
     */
    int segundos = 00;
    int minutos = 0;
    int filler = 0;
    int puntuacion = 0;
    boolean pause = false;
    MODELO.Xogo xogo = new MODELO.Xogo(this);

    public Timer getTimer() {
        return timer;
    }
    
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            panelXogo.updateUI();
            if (segundos < 10) {
                jTextField1.setText(String.valueOf(minutos + ":" + filler + segundos));
            } else {
                jTextField1.setText(String.valueOf(minutos + ":" + segundos));
            }
            segundos++;
            if (segundos == 60) {
                segundos = 0;
                minutos++;
            }
            jTextField2.setText(String.valueOf(puntuacion));
            puntuacion++;
            if (xogo.chocaFichaCoChan()) {
                xogo.engadirFichaAoChan();
                xogo.xenerarNovaFicha();
            } else {
                xogo.moverFichaAbaixo();
            }
        }
    });

    public VentanaPrincipal() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelXogo = new javax.swing.JPanel();
        panelPuntos = new javax.swing.JPanel();
        lblPuntos = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        panelTempo = new javax.swing.JPanel();
        labelTiempo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        bSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bPausar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 150, 200));
        setBounds(new java.awt.Rectangle(0, 0, 450, 650));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 900, 900));
        setMinimumSize(new java.awt.Dimension(900, 800));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelXogo.setBackground(new java.awt.Color(255, 255, 255));
        panelXogo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.lightGray));
        panelXogo.setMaximumSize(new java.awt.Dimension(500, 700));
        panelXogo.setMinimumSize(new java.awt.Dimension(500, 700));
        panelXogo.setPreferredSize(new java.awt.Dimension(500, 700));
        panelXogo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelXogoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                panelXogoKeyTyped(evt);
            }
        });
        panelXogo.setLayout(null);
        getContentPane().add(panelXogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 500, 700));

        panelPuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelPuntos.setPreferredSize(new java.awt.Dimension(100, 100));

        lblPuntos.setText("PUNTOS");

        jTextField2.setEditable(false);
        jTextField2.setText("0");
        jTextField2.setFocusable(false);

        javax.swing.GroupLayout panelPuntosLayout = new javax.swing.GroupLayout(panelPuntos);
        panelPuntos.setLayout(panelPuntosLayout);
        panelPuntosLayout.setHorizontalGroup(
            panelPuntosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPuntosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblPuntos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPuntosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPuntosLayout.setVerticalGroup(
            panelPuntosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPuntosLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblPuntos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        getContentPane().add(panelPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, -1, -1));

        panelTempo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTempo.setPreferredSize(new java.awt.Dimension(200, 100));

        labelTiempo.setText("TIEMPO");

        jLabel1.setText("LINEAS");

        jTextField1.setEditable(false);
        jTextField1.setText("0:00");
        jTextField1.setFocusable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTempoLayout = new javax.swing.GroupLayout(panelTempo);
        panelTempo.setLayout(panelTempoLayout);
        panelTempoLayout.setHorizontalGroup(
            panelTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTempoLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(panelTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(labelTiempo)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        panelTempoLayout.setVerticalGroup(
            panelTempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTempoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        jTextField1.getAccessibleContext().setAccessibleName("txtfieldpuntos");

        getContentPane().add(panelTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, 110));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 200));

        bSalir.setText("SALIR");
        bSalir.setFocusable(false);
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
        bSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bSalirKeyPressed(evt);
            }
        });

        jButton1.setText("INICIAR");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bPausar.setText("PAUSA");
        bPausar.setFocusable(false);
        bPausar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPausarMouseClicked(evt);
            }
        });
        bPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPausarActionPerformed(evt);
            }
        });
        bPausar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bPausarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bPausar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(bPausar)
                .addGap(30, 30, 30)
                .addComponent(bSalir)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPausarActionPerformed
        // TODO add your handling code here:
        if (!pause) {
            timer.stop();
            pause = true;
        } else {
            timer.start();
            pause = false;
        }
    }//GEN-LAST:event_bPausarActionPerformed

    private void bPausarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPausarMouseClicked

    }//GEN-LAST:event_bPausarMouseClicked

    private void bPausarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bPausarKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bPausarKeyPressed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bSalirActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        iniciarPartida();
        panelXogo.requestFocus();
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void panelXogoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelXogoKeyPressed
        // TODO add your handling code here:
        panelXogo.setFocusable(true);
         panelXogo.requestFocus();
        try {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_A -> {
                    xogo.moverFichaEsquerda();
                }
                case KeyEvent.VK_D -> {
                    xogo.moverFichaDereita();
                }
                case KeyEvent.VK_S -> {
                    xogo.moverFichaAbaixo();
                }
                case KeyEvent.VK_W -> {
                    xogo.rotarFicha();
                }
                default -> {
                }
            }
        } catch (NullPointerException e) {
          
        }
    }//GEN-LAST:event_panelXogoKeyPressed

    private void panelXogoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelXogoKeyTyped
       
    }//GEN-LAST:event_panelXogoKeyTyped

    private void bSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bSalirKeyPressed

        
    }//GEN-LAST:event_bSalirKeyPressed

    public void pintarCadrado(JLabel lblCadrado) {
        panelXogo.add(lblCadrado);
    }

    public void borrarCadrado(JLabel lblCadrado) {
        panelXogo.remove(lblCadrado);
    }

    public void mostrarNumeroLinas(int numeroLinas) {

    }

    public void mostrarFinDoXogo() {
       
    }

    private void iniciarPartida() {
        if (!pause) {
            timer.start();
            xogo.xenerarNovaFicha();
        } 

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bPausar;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelTiempo;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JPanel panelPuntos;
    private javax.swing.JPanel panelTempo;
    private javax.swing.JPanel panelXogo;
    // End of variables declaration//GEN-END:variables
}
