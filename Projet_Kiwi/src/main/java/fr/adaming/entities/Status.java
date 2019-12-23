package fr.adaming.entities;

public enum Status {
	enAttente("En Attente"), enCours("En Cours"), accepte("Accepté"), refuse("Refusé");

	private String displayName;

	private Status(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
