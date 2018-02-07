package blackjack;

import java.util.ArrayList;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


import javax.swing.JFrame;
import javax.swing.JTextField;

public class client {
	protected ArrayList<Carte> main=new ArrayList<Carte>();
	
	  public void afficherMain() {
			for (Carte carte : main) {
				carte.afficher();
			}
		}
	  public void afficherCarteAdversaire() {
		  	System.out.println("Carte adversaire : ");
			main.get(0).afficher();
		}
	  
	  public void afficherpoint() {
		  int compteur=0;
		  for (Carte carte : main) {
				compteur=compteur+carte.getValeurpoint();
			}
		  System.out.println("Vos points : " +Integer.toString(compteur));
	  }
	  
	  public void afficherPointAdversaire() {
		  int compteur=0;
		  for (Carte carte : main) {
				compteur=compteur+carte.getValeurpoint();
			}
		  System.out.println("les points de l'adversaire : " +Integer.toString(compteur));
	  }
	  
	  public int valPoint() {
		  int compteur=0;
		  for (Carte carte : main) {
				compteur=compteur+carte.getValeurpoint();
			}
		  return compteur;
	  }
}
