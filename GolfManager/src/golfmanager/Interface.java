/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golfmanager;

import com.toedter.calendar.JCalendar;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Geoffrey.Candeias
 */
public class Interface extends JFrame {
    Parcours p;
    
    
    
    Interface()
    {
        
        
        p = new Parcours(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setPreferredSize(new Dimension(1024, 768));
        this.setTitle("GolfManager");
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill=GridBagConstraints.BOTH;
        
        cont.gridx=cont.gridy=0;
        this.add(p,cont);
       
        this.pack();
        this.setVisible(true);
    }
    
    

}
