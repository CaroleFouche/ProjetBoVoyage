package fr.adaming.entities;

public enum Category {
	a("Catégorie A"), b("Categorie B"), c("Categorie C"), d("Categorie D");

	private String displayName;

	// Constructeur pour l'enum
	private Category(String displayName) {
		this.displayName = displayName;
	}

	// Getter
	public String getDisplayName() {
		return displayName;
	}

}
