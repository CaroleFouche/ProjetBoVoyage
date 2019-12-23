package fr.adaming.entities;

public enum Prestation {
	hebergementSeul("Hebergement Seul"), petitDejeuner("Petit Déjeuner"), demiPension("Demi-Pension"),
	pensionComplete("Pension Complète");

	private String displayName;

	private Prestation(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
