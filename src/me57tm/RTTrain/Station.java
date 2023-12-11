package me57tm.RTTrain;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class Station extends Node{
	String name;
	
	public Station(String name, int XCoord, int YCoord) {
		super(XCoord,YCoord);
		display = new Circle(XCoord,YCoord,STATIONSIZE,Color.BLACK);
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	@Override
	public void setCoords(int x, int z) {
		this.XCoord = x;
		this.ZCoord = z;
		display = new Circle(x,z,STATIONSIZE,Color.BLACK);
		TrainLine line = null;
		for (Connection con :this.getConnections()) {
			if (line==null) {
				line = con.getLine();
				continue;
			}
			if (!line.equals(con.getLine())) {
				Circle c = new Circle(XCoord,ZCoord,STATIONSIZE+1,Color.WHITE);
				c.setStroke(Color.BLACK);
				c.setStrokeType(StrokeType.CENTERED);
				c.setStrokeWidth(3);
				display = c;
				return;
			}
		}
	}
	public Label getLabel() {
		Label l = new Label(name);
		l.setTranslateX(this.XCoord);
		l.setTranslateY(this.ZCoord);
		return l;
	}
	
	@Override
	public String toString() {
		return "Station "+name+":("+XCoord+","+ZCoord+")";
	}
}
