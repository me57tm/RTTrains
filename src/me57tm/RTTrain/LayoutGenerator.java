package me57tm.RTTrain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javafx.scene.paint.Color;

public class LayoutGenerator {
	static ExecutorService executor;
	static final int GRIDSIZE = Main.GRIDSIZE;
	HashMap<String,Node> nodes;

	@SuppressWarnings("unused")
	private LayoutGenerator() {}
	public LayoutGenerator(HashMap<String,Node> nodes) {
		this.nodes = nodes;
	}
	public void snapToGrid(Node n) {
		int x = n.getX();
		int z = n.getZ();
		if(x%GRIDSIZE >= GRIDSIZE/2) {
			x += GRIDSIZE-x%GRIDSIZE;
		}
		else {
			x -= x%GRIDSIZE;
		}
		if(z%GRIDSIZE >= GRIDSIZE/2) {
			z += GRIDSIZE-z%GRIDSIZE;
		}
		else {
			z -= z%GRIDSIZE;
		}
		if (checkMove(x,z,n,nodes)) n.setCoords(x, z);
		else {
			for (int k = 1; true; k++) {
				for (int i = -GRIDSIZE*k; i < GRIDSIZE*k; i+= GRIDSIZE) {
					for (int j = -GRIDSIZE*k; j < GRIDSIZE*k; j+= GRIDSIZE) {
						if (checkMove(x+i,z+j,n,nodes)) {
							n.setCoords(x+i, z+j);
							return;
						}
					}
				}
			}
		}
	}

	public HashMap<String,Node> layOut(){
		executor = Executors.newCachedThreadPool();
		int SqSize = 5;
		double health = getHealth();
		System.out.println(health);
		int x;
		int z;
		int newX;
		int newZ;
		double newHealth;
		double prevHealth;
		for(int k = 0; k < 10; k++) {
			prevHealth = health;
			//for (Node n : nodes.values()) {
			for (Node n : nodes.values()) {
				int[] originalCoords = new int[] {n.getX(),n.getZ()};
				x = n.getX();
				newX = n.getX();
				z = n.getZ();
				newZ = n.getZ();
				health = getHealth();
				for (int i = -SqSize*GRIDSIZE; i<=SqSize*GRIDSIZE;i+=GRIDSIZE) {
					boolean flag = false;
					for (int j = -SqSize*GRIDSIZE; j<=SqSize*GRIDSIZE;j+=GRIDSIZE) {
						//System.out.println((x+i)+ " " +(z+j));
						n.setCoords(x+i, z+j);
						newHealth =getHealth();
						//System.out.println(newHealth);
						if(newHealth < health /*&& checkMove(newX,newZ,n,nodes.values())*/) {
							newX = x+i;
							newZ = z+j;
							//System.out.println("gaming! "+ String.valueOf(health)+" ---> "+String.valueOf(newHealth)+" x: "+newX+" z: "+newZ);
							if (checkMove(newX,newZ,n,nodes)) {
								//System.out.println("ULTRAGAMING MY DUUUUUUUUDES");
								health = newHealth;
								originalCoords = new int[]{newX,newZ};
							}
							//flag = true;
							//break;
						}

						//n.setCoords(newX,newZ);
					}
					//if (flag) break;
					SqSize = 10;
					//n.setCoords(newX,newZ);
				}
				n.setCoords(originalCoords[0], originalCoords[1]);
				if (checkMove(newX,newZ,n,nodes)) {
					n.setCoords(newX, newZ);
				}
				/*else{
					System.out.println("ILLEGAL MOVE");
				}*/
			}
			if (prevHealth == health) return nodes;
			//System.out.println(health);
			System.out.println("Iteration: "+(k+1)+" Health: "+getHealth());
		}
		executor.shutdown();
		return nodes;

	}

	public static boolean checkMove(int x, int z,Node n,HashMap<String,Node> map) {
		//if ((x == n.getX()) && (z == n.getZ())) return true;
		Node newNode = new Node(x,z);
		TrainLine dummy = new TrainLine("dummy",null,Color.BLACK);
		HashSet<Node> nodes = new HashSet<Node>();
		nodes.addAll(map.values());
		nodes.add(newNode);
		nodes.remove(n);

		for (Connection c : n.getConnections()) {
			if (c.getNodes()[0] == n) {
				newNode.addConnection(new Connection(c.getNodes()[1],newNode,dummy));
			}
			else {
				newNode.addConnection(new Connection(c.getNodes()[0],newNode,dummy));
			}
		}

		int maxX = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE;
		int maxZ = Integer.MIN_VALUE;
		int minZ = Integer.MAX_VALUE;
		for (Node check : nodes) {
			if (check.getX() > maxX) maxX = check.getX();
			if (check.getZ() > maxZ) maxZ = check.getZ();
			if (check.getX() < minX) minX = check.getX();
			if (check.getZ() < minZ) minZ = check.getZ();
		}
		/*if ((mod(maxX-minX) > 1500) || (mod(maxZ-minZ) > 1000)) {
			return false;
		}*/

		for (Node check : nodes) {
			if (check == newNode) continue;
			if((x == check.getX()) && (z == check.getZ())) {
				//if ((n instanceof Station) && (check instanceof Station)) System.out.println(((Station)n).getName()+" "+((Station)check).getName());
				return false;
			}
		}

		HashSet<Connection> edges = new HashSet<Connection>(); 
		for (Node nod : nodes) {
			for (Connection c : nod.getConnections()) {
				edges.add(c);
			}
		}
		for (Connection c : edges) {
			for (Node nod :nodes) {
				if (nod.equals(c.getNodes()[0]) || nod.equals(c.getNodes()[1])) continue;
				if(nod.equals(n)) continue;
				if (c.isOnEdge(nod)) return false;
			}
		}

		return true;
	}

	public double getHealth() {//--------------------------------------------------------------------------------------------------------------------------------------
		double angleMod = 1;
		double lengthMod = 10;
		double straightMod = 100;
		double balanceMod = 1;
		Future<Double> angleHealthFuture = executor.submit(new AngleHealth(nodes));
		Future<Double> straightHealthFuture = executor.submit(new StraightHealth(nodes));
		Future<Double> balanceHealthFuture = executor.submit(new BalanceHealth(nodes));
		Future<Double> lengthHealthFuture = executor.submit(new LengthHealth(nodes));
		Future<Double> octoHealthFuture = executor.submit(new OctoHealth(nodes));
		//System.out.println("angle: " + String.valueOf(angleMod*angleHealth(nodes)) + " length: " +  String.valueOf(lengthMod*lengthHealth(nodes)) +" straight: " + String.valueOf(straightMod*straightHealth(nodes))+" balance: " +String.valueOf(balanceMod*balanceHealth(nodes)));

		try {
			double angleHealth = angleHealthFuture.get();
			double straightHealth = straightHealthFuture.get();
			double lengthHealth = lengthHealthFuture.get();
			double balanceHealth = balanceHealthFuture.get();
			double octoHealth = octoHealthFuture.get();

			return 	angleMod*angleHealth +
					lengthMod*lengthHealth+
					straightMod*straightHealth+
					balanceMod*balanceHealth+
					100*octoHealth;

		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			executor.shutdown();
			e.printStackTrace();
			return 0;
		}
	}

	public double angleHealth() {
		double x = 0;
		double angle;
		for(Node node : nodes.values()) {
			for (Connection c : node.getConnections()) {
				for (Connection d : node.getConnections()) {
					if (c==d) continue;
					angle = c.calcAngle(d);
					//if (angle < 0) angle = -angle;
					//angle = Math.PI - angle;
					angle = (((2*Math.PI)/node.getConnections().length) - angle);
					if (angle < 0) angle = -angle;
					//System.out.println(angle);
					x += angle;
				}
			}
		}

		return x;
	}

	public static double straightHealth(HashMap<String,Node> nodes) {
		double x = 0;
		double angle;
		for(Node node : nodes.values()) {
			if (node.getConnections().length!=2) continue;
			for (Connection c : node.getConnections()) {
				for (Connection d : node.getConnections()) {
					if (c==d) continue;
					angle = c.calcAngle(d);
					angle = mod(angle%(Math.PI*2));
					if (angle==0) continue;
					angle = mod(Math.PI-angle);
					x+= angle;
				}
			}
		}
		return x;
	}

	public static double lengthHealth(HashMap<String,Node> nodes) {
		final int DESIREDLENGTH = 3;
		double n = 0;
		for(Node node : nodes.values()) {
			for (Connection c : node.getConnections()) {
				double temp = c.length(); 
				temp = mod(DESIREDLENGTH*GRIDSIZE - temp);
				n+= temp;
			}
		}
		return n;
	}
	public static double balanceHealth(HashMap<String,Node> nodes) {
		double x = 0;
		for(Node node : nodes.values()) {
			if (node.getConnections().length!=2) continue;
			for (Connection c : node.getConnections()) {
				for (Connection d : node.getConnections()) {
					if (c==d) continue;
					x += mod(mod(c.length())-mod(d.length()));
				}
			}
		}
		return x;
	}

	public static double octoHealth(HashMap<String,Node> nodes) {
		double x = 0;
		HashSet<Connection> edges = new HashSet<Connection>(); 
		for (Node nod : nodes.values()) {
			for (Connection c : nod.getConnections()) {
				edges.add(c);
			}
		}
		for (Connection c : edges) {
			double temp = new Connection(new Node(0,0),new Node(0,100), new TrainLine("","",Color.BLACK)).calcAngle(c);
			x += temp % (Math.PI/4);
		}
		return x;
	}


	public static double mod(double x) {
		if (x < 0) return -x;
		return x;
	}

}

class AngleHealth implements Callable<Double> {

	HashMap<String,Node> nodes;
	public AngleHealth(HashMap<String,Node> nodes) {
		this.nodes = nodes;
	}
	@Override
	public Double call() throws Exception {
		double x = 0;
		double angle;
		for(Node node : nodes.values()) {
			for (Connection c : node.getConnections()) {
				for (Connection d : node.getConnections()) {
					//System.out.println("PINGAS");
					if (c==d) continue;
					angle = c.calcAngle(d);
					angle = (((2*Math.PI)/node.getConnections().length) - angle);
					if (angle < 0) angle = -angle;
					x += angle;
				}
			}
		}

		return x;
	}
}
class StraightHealth implements Callable<Double> {

	HashMap<String,Node> nodes;
	public StraightHealth(HashMap<String,Node> nodes) {
		this.nodes = nodes;
	}
	@Override
	public Double call() throws Exception {
		double x = 0;
		double angle;
		for(Node node : nodes.values()) {
			if (node.getConnections().length!=2) continue;
			for (Connection c : node.getConnections()) {
				for (Connection d : node.getConnections()) {
					if (c==d) continue;
					angle = c.calcAngle(d);
					angle = LayoutGenerator.mod(angle%(Math.PI*2));
					if (angle==0) continue;
					angle = LayoutGenerator.mod(Math.PI-angle);
					x+= angle;
				}
			}
		}
		return x;
	}
}
class LengthHealth implements Callable<Double> {
	static int GRIDSIZE = LayoutGenerator.GRIDSIZE;
	HashMap<String,Node> nodes;
	public LengthHealth(HashMap<String,Node> nodes) {
		this.nodes = nodes;
	}
	@Override
	public Double call() throws Exception {
		final int DESIREDLENGTH = 3;
		double n = 0;
		for(Node node : nodes.values()) {
			for (Connection c : node.getConnections()) {
				double temp = c.length(); 
				temp = LayoutGenerator.mod(DESIREDLENGTH*GRIDSIZE - temp);
				n+= temp;
			}
		}
		return n;
	}
}
class BalanceHealth implements Callable<Double> {
	static int GRIDSIZE = LayoutGenerator.GRIDSIZE;
	HashMap<String,Node> nodes;
	public BalanceHealth(HashMap<String,Node> nodes) {
		this.nodes = nodes;
	}
	@Override
	public Double call() throws Exception {
		double x = 0;
		for(Node node : nodes.values()) {
			if (node.getConnections().length!=2) continue;
			for (Connection c : node.getConnections()) {
				for (Connection d : node.getConnections()) {
					if (c==d) continue;
					x += LayoutGenerator.mod(LayoutGenerator.mod(c.length())-LayoutGenerator.mod(d.length()));
				}
			}
		}
		return x;
	}
}
class OctoHealth implements Callable<Double> {
	static int GRIDSIZE = LayoutGenerator.GRIDSIZE;
	HashMap<String,Node> nodes;
	public OctoHealth(HashMap<String,Node> nodes) {
		this.nodes = nodes;
	}
	@Override
	public Double call() throws Exception {
		double x = 0;
		HashSet<Connection> edges = new HashSet<Connection>(); 
		for (Node nod : nodes.values()) {
			for (Connection c : nod.getConnections()) {
				edges.add(c);
			}
		}
		for (Connection c : edges) {
			double temp = new Connection(new Node(0,0),new Node(0,100), new TrainLine("","",Color.BLACK)).calcAngle(c);
			x += temp % (Math.PI/4);
		}
		return x;
	}
}
