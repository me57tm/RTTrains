package me57tm.RTTrain;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Node {
	int XCoord;
	int ZCoord;
	final int STATIONSIZE= 5;
	
	int geoX;
	int geoZ;
	javafx.scene.Node display;
	
	protected ArrayList<Connection> connections;
	
	Node(int x,int z){
		XCoord = x;
		ZCoord = z;
		geoX = x;
		geoZ = z;
		connections = new ArrayList<Connection>();
		display = new Circle(x,z,STATIONSIZE,Color.BLACK.deriveColor(1, 1, 1, 0)); 
	}
	
	public void reset() {
		setCoords(geoX,geoZ);
	}
	
	public Connection[] getConnections() {
		Connection[] x = new Connection[connections.size()];
		return connections.toArray(x);
		}
	public void connect(Node n, TrainLine l) {
		Connection c = new Connection(this,n,l);
		connections.add(c);
		n.addConnection(c);
	}
	public void connect(Node n, TrainLine l,boolean pow) {
		Connection c = new Connection(this,n,l,pow);
		connections.add(c);
		n.addConnection(c);
	}
	public void addConnection(Connection c) {
		connections.add(c);
	}
		
	public int getX() {
		return XCoord;
	}
	public int getZ() {
		return ZCoord;
	}
	public void setCoords(int x, int z) {
		this.XCoord = x;
		this.ZCoord = z;
		display.setTranslateX(x);
		display.setTranslateY(z);
	}
	public javafx.scene.Node  getDisplay(){
		return display;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Node)) return false;
		Node n = (Node) o;
		return (XCoord==n.getX()) && (ZCoord==n.getZ()); 
	}
	@Override
	public String toString() {
		return "Node: ("+XCoord+","+ZCoord+")";
	}
}
