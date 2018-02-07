package blackjack;

import java.util.Collections;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class Serveur {
	

	public static void main(String[] args) {
		/*ServerSocket socket;
		try {
		socket = new ServerSocket(2222);
		Thread t = new Thread(new AccepterJoueur(socket));
		t.start();
		System.out.println("Ouverture d'une partie");
		Paquet test = new Paquet();
		melangePaquet(test);
		client c1 = new client();
		distributionPaquet(test, c1);
		//test.afficherCartes();
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
		
		boolean fin= false;
		Paquet test = new Paquet();
		melangePaquet(test);
		client c1 = new client();	
		client c2 = new client();
		distributionPaquet(test, c1);
		distributionPaquet(test, c2);
		c2.afficherCarteAdversaire();
		System.out.println("Vos cartes : ");
		c1.afficherMain();
		c1.afficherpoint();
		if(c1.valPoint()==21) {
			System.out.println("Partie terminé.");
			System.out.println("Vous avez gagné !");
			fin=true;
		}
		while(fin==false) {
			System.out.println("Voulez vous : 1.Hint 2.Stand");
			Scanner sc = new Scanner(System.in);
			int selection = sc.nextInt();
			System.out.println("Vous avez saisi le nombre : " + selection);
			switch(selection) {
			case 1:
				hit(test, c1);
				c1.afficherpoint();;
				if(c1.valPoint()>21) {
					c2.afficherPointAdversaire();
					System.out.println("Partie terminé.");
					System.out.println("Vous avez perdu !");
					fin=true;
				} else if (c1.valPoint()==21) {
					c2.afficherPointAdversaire();
					System.out.println("Partie terminé.");
					System.out.println("Vous avez gagné !");
					fin=true;	
				}
				
				if(c2.valPoint()<17) {
					hit(test, c2);
					if(c2.valPoint()>21) {
						c2.afficherPointAdversaire();
						System.out.println("Partie terminé.");
						System.out.println("Vous avez gagné !");
						fin=true;
					}
				}
				break;
			case 2:
				if(c2.valPoint()>16) {
					System.out.println("Partie terminé.");
					if (c1.valPoint()< c2.valPoint()) {
						c2.afficherPointAdversaire();
						System.out.println("Vous avez perdu !");
						fin=true;
					} else if (c1.valPoint()==c2.valPoint()){
						c2.afficherPointAdversaire();
						System.out.println("Egalité");
						fin=true;
					} else {
						c2.afficherPointAdversaire();
						System.out.println("Vous avez gagné");
						fin=true;
					}
				}
				
				else {
					hit(test, c2);
					if(c2.valPoint()>21) {
						c2.afficherPointAdversaire();
						System.out.println("Partie terminé.");
						System.out.println("Vous avez gagné!");
						fin=true;
					} else if (c1.valPoint()< c2.valPoint()) {
						c2.afficherPointAdversaire();
						System.out.println("Partie terminé.");
						System.out.println("Vous avez perdu !");
						fin=true;
					} else if(c1.valPoint()>c2.valPoint()) {
						c2.afficherPointAdversaire();
						System.out.println("Partie terminé.");
						System.out.println("Vous avez gagné!");
						fin=true;
					}
				}
				break;
			}
		}
	}
	
	public static void melangePaquet(Paquet paquet) {
		Collections.shuffle(paquet.paquetCarte);
	}
	public static void distributionPaquet(Paquet paquet, client client) {
		for (int i=0; i<2; i++) {
			client.main.add(paquet.paquetCarte.get(i));
			paquet.paquetCarte.remove(0);
		}		
	}
	public static void hit(Paquet paquet, client client) {
		client.main.add(paquet.paquetCarte.get(0));
		paquet.paquetCarte.remove(0);
	}
}
