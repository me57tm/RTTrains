package me57tm.RTTrain;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class TrainLine {
	String name;
	Paint[] colours;
	String companyName;

	public TrainLine(String name,String cname,Color col) {
		this.name = name;
		this.companyName = cname;
		this.colours = new Color[] {col};
	}

	public TrainLine(String name,String cname,Paint[] col) {
		this.name = name;
		this.companyName = cname;
		this.colours = col;
	}


	public String getName() {
		return name;
	}
	public Color getColour() {
		return (Color) colours[0];
	}
	public Paint[] getColours() {
		return colours;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof TrainLine)) return false;
		TrainLine t = (TrainLine) o;
		return t.getName().equals(name);
	}
}
