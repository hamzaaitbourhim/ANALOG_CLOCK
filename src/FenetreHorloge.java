/*
	Nom : Ait Bourhim.
	Prenom : Hamza.

*/

import java.awt.*;
import javax.swing.*;
import java.util.Date;

public class FenetreHorloge extends JFrame {

    public int heures; 
    public int minutes;
    public int secondes;
    Horloge horloge;

    public FenetreHorloge() { // le constructeur de la fenêtre
    	
    	// **** configuration de la fenêtre *************************************************************************************
    	
        setSize(510,530); // la taille de la fenêtre
        setResizable(false); // on peut pas chnager la taille de la fenêtre
        setLocationRelativeTo(null);  // cela va centrer la fenêtre
        setTitle("Horloge (devoir JAVA)"); // titre de la fenêtre
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // quittez l'application à l'aide de la méthode de sortie du système
        setVisible(true); // la fenêtre doit être visible
        
        // **** création de l'horloge *******************************************************************************************
        
        horloge = new Horloge(this); // creer l'horloge en passant la fenêtre comme argument
        
        // **** récupération du temps courants **********************************************************************************
        
        Date dateCourante = new Date(); // prendre la date actuelle
        String dateCouranteString = dateCourante.toString(); // convertir la date en chaîne de caractères (exemple du résultat : "Sat Jan 02 09:47:57 WEST 2021")
        heures = Integer.parseInt(dateCouranteString.substring(11,13)); // prendre les heures de la chaîne dateCouranteString et les convertir en entier
        minutes = Integer.parseInt(dateCouranteString.substring(14,16)); // prendre les minutes de la chaîne dateCouranteString et les convertir en entier
        secondes = Integer.parseInt(dateCouranteString.substring(17,19)); // prendre les secondes de la chaîne dateCouranteString et les convertir en entier
        
        // **** configuration du moteur de l'horloge ****************************************************************************
        
        while(true) // démarrer l'horloge
		{
        	
        	int nouvellesSecondes = (secondes + 1) % 60; // les secondes après ajouter 1 seconde
        	int nouvellesMinutes = (minutes + (secondes + 1) / 60) % 60; // les minutes après ajouter 1 seconde
			heures = (heures + (minutes + (secondes + 1) / 60) / 60) % 12; // les heures après ajouter 1 seconde
			secondes = nouvellesSecondes;
			minutes = nouvellesMinutes;

			try {

				Thread.sleep(1000); // arrêter pendant 1 seconde

			} catch (InterruptedException ex) {} // exception levée lorsqu'un thread est en attente ou en veille(sleep)

			horloge.repaint(); // redessiner l'horloge après avoir changer les attributs de l'heure
		}
        
    }
    
    // **** démarrer l'application **********************************************************************************************

    public static void main(String args[]) { // la fonction main de l'application
           
    	new FenetreHorloge(); // creer la fenêtre
    	
    }
    
} // fin de la classe FenetreHorloge.

	// **** la classe Horloge gère le dessin de l'horloge  **********************************************************************

class Horloge extends JPanel{

	FenetreHorloge fenetre; // la fenêtre où l'horloge va être ajoutée
		
	public Horloge(FenetreHorloge fntr){ // le constructeur de l'horloge
			
		setSize(520,530); // la taille de l'horloge
        fenetre = fntr; // prendre la fenêtre pour utiliser ses attributs dans la classe Horloge
        fenetre.getContentPane().add(this); // ajouter l'horloge à la fenêtre
       
		}

	// **** la fonction qui va dessiner l'horloge *******************************************************************************
	
    @Override
    public void paintComponent(Graphics g) { // redéfinir la méthode paintComponent() qui prend un objet de type Graphics comme argument
    	
        g.setColor(Color.RED); // changer la couleur du dessin (rouge)
        g.fillRect(0, 0, getWidth(), getHeight()); // Remplit le rectangle spécifié avec la couleur actuelle (colorer tout l'arrière-plan en rouge)
        g.setColor(Color.WHITE); // changer la couleur du dessin (blanc)
        g.fillOval(5, 5, 480, 480); // Remplit un ovale délimité par le rectangle spécifié avec la couleur actuelle (dessiner un disque blanc)
        g.setColor(Color.BLACK); // changer la couleur du dessin (noir)
        g.fillOval(10, 10, 470, 470); // Remplit un ovale délimité par le rectangle spécifié avec la couleur actuelle (dessinez un disque noir à l'intérieur du disque blanc)
        g.setColor(Color.WHITE); // changer la couleur du dessin (blanc)
        g.fillOval(237, 237, 15, 15); // Remplit un ovale délimité par le rectangle spécifié avec la couleur actuelle (dessiner un petit disque blanc au centre de l'horloge)
        
        g.setFont(g.getFont().deriveFont(Font.BOLD,32)); // changer la police pour dessiner les chiffres
        for(int i=1; i<=12; i++) // pour chaque chiffre de 1 à 12
            g.drawString(Integer.toString(i), 240-(i/12)*11+(int)(210*Math.sin(i*Math.PI/6)), 253-(int)(210*Math.cos(i*Math.PI/6))); // dessiner le chiffre dans sa position

        double minsecdeg = (double)Math.PI/30;
        double hrdeg = (double)Math.PI/6;
        int x,y;
        int xpoints[] = new int[3];
        int ypoints[] = new int[3];
 
       // aiguille des secondes :
        x = 245 + (int)(210 * Math.sin(fenetre.secondes * minsecdeg));
        y = 245 - (int)(210 * Math.cos(fenetre.secondes * minsecdeg));
        g.drawLine(245,245,x,y);

        // aiguille des minutes :
        x = 245 + (int)(190 * Math.sin(fenetre.minutes * minsecdeg));
        y = 245 - (int)(190 * Math.cos(fenetre.minutes * minsecdeg));
        xpoints[0] = 245;
        xpoints[1] = x+2;
        xpoints[2] = x-2;
        ypoints[0] = 245;
        ypoints[1] = y+2;
        ypoints[2] = y-2;
        g.fillPolygon(xpoints, ypoints,3); 

        // aiguille des heures :
        x = 245 + (int)(160 * Math.sin(fenetre.heures * hrdeg + fenetre.minutes * Math.PI/360));
        y = 245 - (int)(160 * Math.cos(fenetre.heures * hrdeg + fenetre.minutes * Math.PI/360));
        xpoints[1] = x+4;
        xpoints[2] = x-4;
        ypoints[1] = y-4;
        ypoints[2] = y+4;
        g.fillPolygon(xpoints, ypoints, 3);
        
    }

} // fin de la classe Horloge.
