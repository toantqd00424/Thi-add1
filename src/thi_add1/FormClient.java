/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_add1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author MSI
 */
public class FormClient extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JTextField txtKm;
    private JTextField txtM;
    private JButton btnExit;
    private JButton btnCalculating;

    public FormClient() {

        this.setSize(400, 300);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        label1 = new JLabel("Kilometers");
        label1.setBounds(30, 20, 100, 30);
        this.add(label1);

        label2 = new JLabel("Miles");
        label2.setBounds(30, 60, 100, 30);
        this.add(label2);

        txtKm = new JTextField();
        txtKm.setBounds(140, 20, 200, 30);
        this.add(txtKm);

        txtM = new JTextField();
        txtM.setBounds(140, 60, 200, 30);
        this.add(txtM);

        btnExit = new JButton("Exit");
        btnExit.setBounds(235, 100, 90, 30);
        this.add(btnExit);
        btnExit.addActionListener(new BtnExitHadleClient());

        btnCalculating = new JButton("Calculating");
        btnCalculating.setBounds(140, 100, 90, 30);
        this.add(btnCalculating);
        btnCalculating.addActionListener(new BtnCluHadle());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    class BtnCluHadle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                KhuonMauTuXa khuon = (KhuonMauTuXa) Naming.lookup("rmi://localhost:5555/cong");
                double d = khuon.doiDonVi(Double.parseDouble(txtKm.getText()));
                txtM.setText(d + "");
            } catch (NotBoundException ex) {
                Logger.getLogger(BtnCluHadle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(BtnCluHadle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(BtnCluHadle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class BtnExitHadleClient implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        FormClient client = new FormClient();
    }
}
