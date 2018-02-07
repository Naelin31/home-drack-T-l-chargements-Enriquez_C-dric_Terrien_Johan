package blackjack;

public class Carte {
	//Déclaration 
	private String couleur;
	private int nombre;
	private int valeurpoint;
	private String libelle;
		
	//Constructeur avec paramètres
	public Carte(String couleur, int nombre) {
		this.couleur=couleur;
		this.nombre=nombre;
		for (int i=2; i<11;i++) {
			if (nombre==i) 
				valeurpoint=nombre;
				libelle=Integer.toString(nombre) + " de " + couleur; 
		}
		switch(nombre){
		case 1:
			valeurpoint=11;
			libelle= "AS de " + couleur;
			break;
		case 11:
			valeurpoint=10;
			libelle= "Valet de " + couleur;
			break;
		case 12:
			valeurpoint=10;
			libelle= "Dame de " + couleur;
			break;
		case 13:
			valeurpoint=10;
			libelle= "Roi de " + couleur;
			break;
		}
	}
		
	//Afficher carte	
	public void afficher() {
		System.out.println(getLibelle());
	}
		
	// getter et setter	
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getValeurpoint() {
		return valeurpoint;
	}

	public void setValeurpoint(int valeurpoint) {
		this.valeurpoint = valeurpoint;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
