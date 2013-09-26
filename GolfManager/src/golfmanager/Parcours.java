/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golfmanager;

import com.toedter.calendar.JCalendar;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Geoffrey.Candeias
 */
public class Parcours extends JPanel {
    
    private JCalendar calendrier;
    private JTable score;
    private JTextArea info;
    private int hauteur;
    private int largeur;
    
    
    Parcours(int hauteur,int largeur)
    {  
        
        this.hauteur=hauteur;
        this.largeur=largeur;
        this.setMinimumSize(new Dimension(hauteur,largeur));
        
        calendrier = new JCalendar();
        calendrier.setBorder(BorderFactory.createTitledBorder("Calendrier"));
        calendrier.setMinimumSize(new Dimension(largeur/3,hauteur/2));
        
        score = new JTable(9, 22);
        score.setBorder(BorderFactory.createTitledBorder("Tableau des scores"));
        score.getColumnModel().getColumn(0).setWidth(50);
        score.setMinimumSize(new Dimension(largeur,hauteur/2));
        
        
        info = new JTextArea("Information sur le parcours");
        info.setEditable(false);
        info.setBorder(BorderFactory.createTitledBorder("Informations sur le parcours"));
        info.setMinimumSize(new Dimension(2*(largeur/3),hauteur/2));
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill=GridBagConstraints.BOTH;
        
        cont.gridx=0;
        cont.gridy=0;
        this.add(info,cont);
        
        cont.gridx=1;
        cont.gridy=0;
        this.add(calendrier,cont);
        
        cont.gridx=0;
        cont.gridy=1;
        cont.gridwidth=2;
        this.add(score,cont);
        
        this.setVisible(true);
    }
    
    
    
}
