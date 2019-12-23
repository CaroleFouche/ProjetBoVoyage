package fr.adaming.entities;

public enum Prestation {
	hebergementSeul("Hebergement Seul"), petitDejeuner("Petit D�jeuner"), demiPension("Demi-Pension"),
	pensionComplete("Pension Compl�te");

	private String displayName;

	private Prestation(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
