/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.computers.interficie;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author PROGRAMACIO3
 */
public class MyThread extends Thread{
    private JProgressBar barra;
    private boolean fini;
    @Override
    public void run() {
        //donar voltes!
        barra.setMaximum(100);
        barra.setMinimum(0);
        barra.setValue(0);
        barra.paintImmediately(0, 0, 100, 100);
        barra.setStringPainted(true);
        int voltes = 0;
        while (!fini) {
            int num = 0;
            while(num<100) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
                }
                barra.setValue(num);
                barra.repaint();
                num += 1;
                System.out.println("**" + voltes + "-" + num);
            }
            barra.setValue(100);
//            barra.paintImmediately(0, 0, 100, 100);
//            barra.setStringPainted(false);
            barra.repaint();
            voltes ++;
        }
    }
    public MyThread (JProgressBar barra) {
        this.barra = barra;
        this.fini = false;
        
    }

    @Override
    public void interrupt() {
        this.fini = true;
    }
    
    
    
}
