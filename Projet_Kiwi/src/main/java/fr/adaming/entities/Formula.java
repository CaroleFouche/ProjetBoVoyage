package fr.adaming.entities;

public enum Formula {
	avion("Avion"), hotel("Hotel"), avionHotel("Avion + Hotel"), avionVoiture("Avion + Voiture"),
	avionHotelVoiture("Avion + Hotel + Voiture");

	private String displayName;

	private Formula(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
