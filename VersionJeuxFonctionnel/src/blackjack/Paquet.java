package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {

	//Déclaration
	protected ArrayList<Carte> paquetCarte=new ArrayList<Carte>();
	
	//Constructeur sans paramètre du paquet de 52 cartes
	public Paquet() {
		String couleur;
		int nombre;
		for(int i=0; i<4; i++) {
			switch(i){
			case 0:
				couleur="Pique";
				for (int j=1; j<14; j++){
					nombre=j;
					Carte carte = new Carte(couleur, nombre);
					paquetCarte.add(carte);
				}
				break;
			case 1:	
				couleur="Coeur";
				for (int j=1; j<14; j++){
					nombre=j;
					Carte carte = new Carte(couleur, nombre);
					paquetCarte.add(carte);
				}
				break;
			case 2:
				couleur="Carreau";
				for (int j=1; j<14; j++){
					nombre=j;
					Carte carte = new Carte(couleur, nombre);
					paquetCarte.add(carte);
				}
				break;
			case 3:
				couleur="Trefle";
				for (int j=1; j<14; j++){
					nombre=j;
					Carte carte = new Carte(couleur, nombre);
					paquetCarte.add(carte);
				}
				break;
			}
		}
			
	}
	
	//Méthode afficher des carte du paquet
	public void afficherCartes() {
		for (Carte carte : paquetCarte) {
			carte.afficher();
		}
	}
	//Méthode pour ajouter une carte
	public void ajouterCarte(Carte carte) {
		paquetCarte.add(carte);
	}
}
