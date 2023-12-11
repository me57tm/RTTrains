package me57tm.RTTrain;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class Connection {
	TrainLine line;
	Node start;
	Node end;
	boolean powered;

	public Connection(Node s1, Node s2,TrainLine l) {
		powered = true;
		this.start = s1;
		this.end = s2;
		this.line = l;
	}
	public Connection(Node s1, Node s2,TrainLine l,boolean pow) {
		powered = true;
		this.start = s1;
		this.end = s2;
		this.line = l;
		powered = pow;
	}
	public boolean isPowered() {
		return powered;
	}

	public Node[] getNodes() {
		return new Node[] {start,end};
	}
	public Node getOtherNode(Node n) {
		if (n == start) {
			return end;
		}
		return start;
	}

	public TrainLine getLine() {
		return line;
	}

	public Group getFXLine() {
		final float STROKEWIDTH = 3; 
		Group g = new Group();
		int numColours = line.getColours().length;

		if (numColours == 1) {
			Line l = new Line(start.getX(),start.getZ(),end.getX(),end.getZ());
			if (!powered) l.getStrokeDashArray().add(6d);
			l.setStroke(line.getColour());
			l.setStrokeWidth(STROKEWIDTH);
			g.getChildren().add(l);
		}
		else {
			double gradient = this.getGrad();
			for (int i = 0; i < numColours;i++) {
				Paint peepee = line.getColours()[i];
				double modifier = i - (STROKEWIDTH)/2;
				System.out.println(modifier);
				Line l = new Line(start.getX() + (STROKEWIDTH+2)/numColours * modifier,start.getZ()+ (STROKEWIDTH*2)/numColours * modifier,
						end.getX()+ (STROKEWIDTH*2)/numColours * modifier,end.getZ()+ (STROKEWIDTH*2)/numColours * modifier);
				if (!powered) l.getStrokeDashArray().add(6d);
				l.setStroke(peepee);
				l.setStrokeWidth((STROKEWIDTH*2)/numColours);
				g.getChildren().add(l);
			}

		}
		return g;
	}


	public double length() {
		double x = start.getX() - end.getX();
		double z = start.getZ() - end.getZ();
		return Math.sqrt(Math.pow(x/*/GRIDSIZE*/, 2) + Math.pow(z/*/GRIDSIZE*/, 2));
	}

	public double getGrad() {
		double x = start.getX() - end.getX();
		double z = start.getZ() - end.getZ();
		if (z == 0)return 0;
		return x/z;
	}
	public double[] getVector() {
		return new double[] {start.getX()-end.getX(),start.getZ()-end.getZ()};
	}

	public boolean isOnEdge(Node n) {
		if (n==end ||n==start) return true;
		if (!(((start.getX() <= n.getX()) && (n.getX() <= end.getX()))
				&& ((start.getZ() <= n.getZ()) && (n.getZ() <= end.getZ())))) {
			return false; 			
		}
		/*if (!(((start.getX() >= n.getX()) && (n.getX() >= end.getX()))
				&& ((start.getZ() >= n.getZ()) && (n.getZ() >= end.getZ())))) {
			return false;
		}*/

		double[] AB = new double[] {start.getX() - n.getX(),start.getZ() - n.getZ()};
		double[] BC = this.getVector();
		return AB[0]*BC[1] - AB[1]*BC[0] == 0;
	}

	public double calcAngle(Connection c) {
		if (this == c) {
			System.out.println("dumdum");
			return 0;
		}
		double thisLen = this.length();
		double cLen = c.length();
		double dot = (this.getVector()[0]*c.getVector()[0]) + (this.getVector()[1]*c.getVector()[1]);
		return Math.acos(dot/(thisLen*cLen));
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Connection)) return false;
		Connection c = (Connection) o;
		return (start.equals(c.getNodes()[0])) && (end.equals(c.getNodes()[1])); 
	}
}
