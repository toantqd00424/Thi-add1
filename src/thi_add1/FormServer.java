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
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author MSI
 */
public class FormServer {
    private JFrame frameServer;
    private JTextArea txtArena;
    private JButton btnStart;
    private JButton btnStop;
    private JButton btnExit;
    
    public FormServer() {
        
        frameServer = new JFrame("Server");
        frameServer.setSize(500, 300);
        frameServer.setLayout(null);
        frameServer.setLocationRelativeTo(null);
        
        txtArena  = new JTextArea();
        txtArena.setBounds(0, 0, 500, 200);
        frameServer.add(txtArena);
        
        btnStart = new JButton("Start");
        btnStart.setBounds(30, 210, 90, 30);
        frameServer.add(btnStart);
        btnStart.addActionListener(new BtnStartHadle());
        
        btnStop = new JButton("Stop");
        btnStop.setBounds(125, 210, 90, 30);
        frameServer.add(btnStop);
        btnStop.addActionListener(new BtnStopHadle());
        
        btnExit = new JButton("Exit");
        btnExit.setBounds(220, 210, 90, 30);
        frameServer.add(btnExit);
        btnExit.addActionListener(new BtnExitHadle());
        
        
        
        
        
        
        frameServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameServer.setVisible(true);
    }
    
    class BtnStartHadle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
            LocateRegistry.createRegistry(5555);
            PhuongThucTuXa tuxa = new PhuongThucTuXa();
            Naming.rebind("rmi://localhost:5555/cong", tuxa);
            txtArena.setText("Server runing....");

        } catch (RemoteException e1) {
            Logger.getLogger(BtnStartHadle.class.getName()).log(Level.SEVERE, null, e);
        } catch (MalformedURLException ex) {
            Logger.getLogger(BtnStartHadle.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    class BtnExitHadle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    class BtnStopHadle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                Naming.unbind("rmi://localhost:5555/cong");
                txtArena.setText("Server Stop");
            } catch (RemoteException ex) {
                Logger.getLogger(FormServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(FormServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(FormServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public static void main(String[] args) {
        FormServer formServer = new FormServer();
    }
}
