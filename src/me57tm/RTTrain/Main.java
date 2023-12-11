package me57tm.RTTrain;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import javafx.application.Application;
//import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Main  extends Application{
	//static final ;
	public final static int GRIDSIZE = 20;
	final static int BUFFER = 50;
	HashMap<String,Node> nodes;
	HashMap<String,TrainLine> lines;
	public static void main(String[] args) {

		Application.launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		int[] allRegion = new int[] {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
		int[] europeRegion = new int[] {870,-1080,-335,-2150};
		int[] wsiberiaRegion = new int[] {2400,-1800,870,-2500};
		int[] esiberiaRegion = new int[] {3450,-1800,2400,-2500};
		int[] westAfricaRegion = new int[] {151,-50,-600,-1122};

		TrainLine WRC = new TrainLine("World Railway Company",null,Color.rgb(127,127,127));
		nodes = new HashMap<String,Node>();
		lines = new HashMap<String,TrainLine>();
		lines.put("wrc",WRC);
		lines.put("byzantine",new TrainLine("Byzantine Metropolitan","United Metropolitan Company",Color.rgb(204,78,219)));
		lines.put("null",new TrainLine("nullrail",null,Color.BLACK));
		lines.put("quartz",new TrainLine("Quartz Line","World Transit Authority",Color.PALETURQUOISE));
		lines.put("stonebrick",new TrainLine("Stone Brick Metro",null,Color.LIGHTGRAY));
		lines.put("german",new TrainLine("German Line","World Transit Authority",new Color[] {Color.BLACK,Color.rgb(221,0,0),Color.rgb(255,206,0)}));
		lines.put("pipeline",new TrainLine("Pipeline",null,Color.LAWNGREEN));
		lines.put("raw",new TrainLine("Railway Around the World",null,Color.DARKGOLDENROD));
		lines.put("pog",new TrainLine("Polish Overground",null,Color.ORANGE));
		lines.put("scotrail",new TrainLine("Scotrail","emerald metro",Color.rgb(6,104,177)));
		lines.put("wbc",new TrainLine("World Brodcasting Coperation Rail","WBC",Color.DARKRED));
		lines.put("luasp",new TrainLine("LUAS Purple Line","LUAS",Color.rgb(157,7,247)));
		lines.put("northern",new TrainLine("Northern Line","World Transit Authority",Color.CYAN));
		lines.put("eurostar",new TrainLine("Eurostar",null,Color.NAVY));
		lines.put("octopus",new TrainLine("Octopus Line",null,Color.PURPLE));
		lines.put("noog",new TrainLine("Nordic Overground",null,Color.DARKSALMON));
		lines.put("funnycornplzlaugh",new TrainLine("Corn Co. Train",null,Color.GOLDENROD));
		lines.put("transduct",new TrainLine("Trans Viaduct",null,new Color[] {Color.rgb(91,206,250),Color.rgb(245,169,184),Color.WHITE,Color.rgb(245,169,184),Color.rgb(91,206,250)}));
		lines.put("deku",new TrainLine("Dekumos' Railway",null,Color.GREEN));
		lines.put("unity",new TrainLine("Unity Tunnel","World Transit Authority",Color.CYAN));
		lines.put("ecml",new TrainLine("East Coast Mainline",null,Color.DARKGREEN));
		lines.put("rustram",new TrainLine("Russian Trams",null,Color.CADETBLUE));
		lines.put("luasy",new TrainLine("LUAS Yellow Line","LUAS",Color.YELLOW));
		lines.put("umc siberian",new TrainLine("Siberian Metropolitan","United Metropolitan Company",Color.RED));
		lines.put("scp line",new TrainLine("SCP Line",null,Color.DARKSLATEGREY));
		lines.put("tetris line",new TrainLine("Tetris Line","Transport for Earth 2",/*Color.PINK*/Color.ORCHID));
		lines.put("peter",new TrainLine("St. Petersburg Line","emerald metro",Color.LIME));
		lines.put("bison",new TrainLine("Flying Bison Metro",null,Color.BROWN));
		lines.put("M",new TrainLine("Horizon Metro",null,Color.rgb(140,55,40)));
		lines.put("shuttle",new TrainLine("Airport Shuttle","World Transit Authority",Color.rgb(162,208,4)));
		lines.put("african overground",new TrainLine("West African Overground","North Gambling House",Color.CORNFLOWERBLUE));
		lines.put("russian",new TrainLine("Russian Tube",null,new Color[] {Color.rgb(222,222,222),Color.rgb(0,57,166),Color.rgb(213,43,30)}));
		lines.put("alexandrian",new TrainLine("Alexandrian Metropolitan","United Metropolitan Company",Color.rgb(13,119,136)));
		lines.put("hat",new TrainLine("Hat Line","World Transit Authority",Color.rgb(142,172,215)));
		lines.put("mosspeter",new TrainLine("Kiev and St Petersburg Line","World Transit Authority",Color.rgb(238,220,62)));
		lines.put("wta alex",new TrainLine("Bafata and Alexandrian Metro line","World Transit Authority",Color.rgb(233,111,71)));
		lines.put("random ukraine line",new TrainLine("Underground Railway to Ukraine",null,Color.rgb(240,15,143)));
		
		setupWRC(nodes,WRC);
		setupByzantine(nodes,lines.get("byzantine"));
		setupNull(nodes,lines.get("null"));
		setupQuartz(nodes,lines.get("quartz"));
		setupStoneBrick(nodes,lines.get("stonebrick"));
		setupGerman(nodes,lines.get("german"));
		setupPipeline(nodes,lines.get("pipeline"));
		setupRAW(nodes,lines.get("raw"));
		setupPOG(nodes,lines.get("pog"));
		setupScotrail(nodes,lines.get("scotrail"));
		setupWBC(nodes,lines.get("wbc"));
		setupLUASP(nodes,lines.get("luasp"));
		setupNorthern(nodes,lines.get("northern"));
		setupEurostar(nodes,lines.get("eurostar"));
		setupPurple(nodes,lines.get("octopus"));
		setupNoog(nodes,lines.get("noog"));
		nodes.put("corncoeu", new Station("Corn Co. EU",260,-1404));
		nodes.get("corncoeu").connect(nodes.get("medspawn"), lines.get("funnycornplzlaugh"));
		nodes.put("trandon", new Station("Trans Lesbian McDonalds 2",279,-1207));
		nodes.get("trandon").connect(nodes.get("pipe"), lines.get("transduct"));
		setupDeku(nodes,lines.get("deku"));
		setupUnity(nodes,lines.get("unity"));
		setupECML(nodes,lines.get("ecml"));
		setupRusTram(nodes,lines.get("rustram"));
		setupLUASY(nodes,lines.get("luasy"));
		setupSiberian(nodes,lines.get("umc siberian"));
		setupSCP(nodes,lines.get("scp line"));
		setupTetris(nodes,lines.get("tetris line"));
		setupPeter(nodes,lines.get("peter"));
		setupBison(nodes,lines.get("bison"));
		setupM(nodes,lines.get("M"));
		setupShuttle(nodes,lines.get("shuttle"));
		setupAfrican(nodes,lines.get("african overground"));
		setupRussian(nodes,lines.get("russian"));
		setupAlexandrian(nodes,lines.get("alexandrian"));
		nodes.get("alexwta").connect(nodes.get("bafata"), lines.get("wta alex"));
		setupHat(nodes,lines.get("hat"));
		setupMossPeter(nodes,lines.get("mosspeter"));
		nodes.put("moskalenka", new Station("Москаленка",1043,-1388));
		nodes.put("kislakoy", new Station("Kışlaköy",973,-1249));
		nodes.get("kislakoy").connect(nodes.get("moskalenka"), lines.get("random ukraine line"));
		/*LayoutGenerator AI = new LayoutGenerator(nodes);
		for (Node n : nodes.values()) {
			AI.snapToGrid(n);	
		}
		AI.layOut();*/


		/*TrainLine testline = new TrainLine("a","b",Color.BLACK);
		nodes.put("a", new Station("  A",0,0));
		nodes.put("b", new Station("  B",0,100));
		nodes.put("c", new Station("  C",100,100));
		nodes.get("a").connect(nodes.get("b"), testline);
		nodes.get("b").connect(nodes.get("c"), testline);
		//nodes.put("d", new Station("  D",200,100));
		nodes.get("d").connect(nodes.get("c"), testline);

		//nodes = layOut(nodes);
		System.out.println(getHealth(nodes));*/

		render(allRegion,primaryStage);
	}

	public void render(int[] region,Stage primaryStage) {
		PannableCanvas fryingPan = new PannableCanvas();
		NodeGestures nodeGestures = new NodeGestures(fryingPan);
		Group mapGroup = new Group();
		final int STATIONSIZE = 5;
		int maxX = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE;
		int maxZ = Integer.MIN_VALUE;
		int minZ = Integer.MAX_VALUE;
		Collection<Node> nodesCollection = new HashSet<Node>();
		nodesCollection.addAll(nodes.values());
		Collection<Node> yeetNodes = new HashSet<Node>();
		for(Node node : nodesCollection) {
			if (node.getX() >= region[0] || node.getX() <= region[2] || node.getZ() >= region[1] || node.getZ() <= region[3]) {
				System.out.println(node);
				yeetNodes.add(node);
				continue;
			}
		}
		nodesCollection.removeAll(yeetNodes);
		for(Node node : nodesCollection) {
			if (node.getX() > maxX) maxX = node.getX();
			if (node.getZ() > maxZ) maxZ = node.getZ();
			if (node.getX() < minX) minX = node.getX();
			if (node.getZ() < minZ) minZ = node.getZ();
		}
		for(Node node : nodesCollection) {
			node.setCoords(node.getX()-minX+BUFFER, node.getZ()-minZ+BUFFER);
		}

		//Render Edges
		for(Node node : nodesCollection) {
			for (Connection c : node.getConnections()) {
				//System.out.println(c.toString());
				Node[] ns = c.getNodes();
				if(!nodesCollection.contains(ns[0]) || !nodesCollection.contains(ns[1])) continue;

				/*Line l = new Line(ns[0].getX(),ns[0].getZ(),ns[1].getX(),ns[1].getZ());
				if (!c.isPowered()) l.getStrokeDashArray().add(6d);
				l.setStroke(c.getLine().getColour());
				l.setStrokeWidth(3);*/
				//Group  = c.getFXLine();
				fryingPan.getChildren().add(c.getFXLine());
			}
		}
		for(Node node : nodesCollection) {
			fryingPan.getChildren().add(node.getDisplay());
			if(node instanceof Station) fryingPan.getChildren().add(((Station)node).getLabel());;
		}
		mapGroup.getChildren().add(fryingPan);
		fryingPan.setPrefSize(maxX-minX + BUFFER*2,maxZ-minZ + BUFFER*2);
		Scene mainScene = new Scene(mapGroup,maxX-minX + BUFFER*2,maxZ-minZ + BUFFER*2);
		SceneGestures sceneGestures = new SceneGestures(fryingPan);
		mainScene.addEventFilter( MouseEvent.MOUSE_PRESSED, sceneGestures.getOnMousePressedEventHandler());
		mainScene.addEventFilter( MouseEvent.MOUSE_DRAGGED, sceneGestures.getOnMouseDraggedEventHandler());
		mainScene.addEventFilter( ScrollEvent.ANY, sceneGestures.getOnScrollEventHandler());
		primaryStage.setScene(mainScene);
		primaryStage.show();


		FileChooser fileChooser = new FileChooser();
		//Set extension filter
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));

		//Prompt user to select a file
		/*File file = fileChooser.showSaveDialog(null);
	    if(file != null){
	        try {
	        	for(javafx.scene.Node i : fryingPan.getChildren()) {
	        		System.out.println(i);
	        	}
	        	SnapshotParameters parameters = new SnapshotParameters();
	            parameters.setFill(Color.TRANSPARENT);
	            //Pad the capture area
	            WritableImage writableImage = new WritableImage(maxX-minX+BUFFER,
	                    maxZ-minZ+BUFFER);
	            writableImage = fryingPan.snapshot(parameters, null);
	            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
	            //Write the snapshot to the chosen file
	            ImageIO.write(renderedImage, "png", file);
	        } catch (IOException ex) { ex.printStackTrace();}*/
		System.out.println(nodes.size());
		//}
	}

	public static HashMap<String,Node> setupWRC(HashMap<String,Node> nodes, TrainLine WRC){
		nodes.put("vilneus", new Station("Vilneus",709,-1657));
		nodes.put("warsaw", new Station("Warsaw/Greenwall",594,-1563));
		nodes.get("warsaw").connect(nodes.get("vilneus"), WRC);

		nodes.put("berlin", new Station("Berlin",408,-1577));
		nodes.get("warsaw").connect(nodes.get("berlin"), WRC);

		nodes.put("copenhagen", new Station("Copenhagen",371,-1680));
		nodes.get("copenhagen").connect(nodes.get("berlin"), WRC);

		nodes.put("wrc stockholm", new Station("Stockholm City Hall",540,-1806));
		nodes.get("copenhagen").connect(nodes.get("wrc stockholm"), WRC,false);

		nodes.put("wrc oslo", new Station("WRC Oslo",300,-1808));
		nodes.get("wrc oslo").connect(nodes.get("wrc stockholm"), WRC,false);

		nodes.put("zurich", new Station("Zürich",300,-1400));
		nodes.get("zurich").connect(nodes.get("berlin"), WRC);

		nodes.put("bratislava", new Station("Bratislava",523,-1433));
		nodes.get("zurich").connect(nodes.get("bratislava"), WRC);

		nodes.put("wrc budapest", new Station("WRC Budapest",549,-1445));
		nodes.get("wrc budapest").connect(nodes.get("bratislava"), WRC);

		nodes.put("belgrade", new Station("Belgrade",590,-1354));
		nodes.get("wrc budapest").connect(nodes.get("belgrade"), WRC);

		nodes.put("sarajevo", new Station("Sarajevo",545,-1298));
		nodes.get("sarajevo").connect(nodes.get("belgrade"), WRC);

		nodes.put("zagreb", new Station("Zagreb",464,-1324));
		nodes.get("sarajevo").connect(nodes.get("zagreb"), WRC);

		nodes.put("ljubljan", new Station("Ljubljan",397,-1404));
		nodes.get("ljubljan").connect(nodes.get("zagreb"), WRC);

		nodes.put("podgorica", new Station("Podgorica",577,-1289));
		nodes.get("podgorica").connect(nodes.get("belgrade"), WRC);

		nodes.put("epirus", new Station("Epirus/Tirana",588,-1229));
		nodes.get("podgorica").connect(nodes.get("epirus"), WRC);

		nodes.put("athens", new Station("Athens",716,-1146));
		nodes.get("athens").connect(nodes.get("epirus"), WRC);

		nodes.put("skopje", new Station("Skopje",688,-1217));
		nodes.get("skopje").connect(nodes.get("epirus"), WRC);
		nodes.get("athens").connect(nodes.get("skopje"), WRC);

		nodes.put("sophia", new Station("Sophia",738,-1251));
		nodes.get("skopje").connect(nodes.get("sophia"), WRC);

		nodes.put("wtaeuhq", new Station("WTA Central HQ Bucharest",774,-1347));
		nodes.get("wtaeuhq").connect(nodes.get("sophia"), WRC);
		//Russia/Ukraine / etc
		nodes.put("petrykivtsi", new Station("Петриківці",845,-1492));
		nodes.put("kiev", new Station("Kiev (Київ)",926,-1530));
		nodes.get("kiev").connect(nodes.get("petrykivtsi"), WRC);
		nodes.put("tver", new Station("Tver (Тверь)",1039,-1713));
		nodes.get("kiev").connect(nodes.get("tver"), WRC,false);
		nodes.put("minsknt", new Station("I know this isn't Minsk",835,-1716));
		nodes.get("minsknt").connect(nodes.get("tver"), WRC);

		nodes.put("ankara", new Station("Ankara",928,-1177));
		nodes.get("kiev").connect(nodes.get("ankara"), WRC,false);
		nodes.put("cyprus", new Station("Cyprus",1008,-1048));
		nodes.get("cyprus").connect(nodes.get("ankara"), WRC,false);
		nodes.put("tiblisi", new Station("Tiblisi",1317,-1259));
		nodes.get("tiblisi").connect(nodes.get("ankara"), WRC,false);
		//nodes.get("vilneus").connect(nodes.get("minsknt"), WRC,false); //: This is just here for testing remove later
		return nodes;
	}
	public static HashMap<String,Node> setupByzantine(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("rhodes", new Station("Rhodes",852,-1104));
		nodes.put("constantinople", new Station("Constantinople",852,-1240));
		nodes.get("rhodes").connect(nodes.get("constantinople"), t);
		nodes.get("wtaeuhq").connect(nodes.get("constantinople"), t);
		nodes.put("morea", new Station("Morea",684,-1115));
		nodes.get("morea").connect(nodes.get("constantinople"), t);
		nodes.get("morea").connect(nodes.get("epirus"), t);
		nodes.put("rome", new Station("Rome / Tiny Pipe",501,-1232));
		nodes.get("rome").connect(nodes.get("epirus"), t);
		nodes.put("medspawn", new Station("Mediterranean Spawn / Grand Féjus",204,-1254));
		nodes.get("rome").connect(nodes.get("medspawn"), t);
		nodes.put("e", new Station("E",530,-1371));
		nodes.get("rome").connect(nodes.get("e"), t);
		nodes.put("vienna", new Station("Vienna",470,-1426));
		nodes.get("e").connect(nodes.get("vienna"), t);
		nodes.put("danzig", new Station("Danzig/Ohio",476,-1631));
		nodes.get("danzig").connect(nodes.get("vienna"), t);
		nodes.put("talin", new Station("Talin",720,-1781));
		nodes.get("danzig").connect(nodes.get("talin"), t);
		nodes.put("helsinki", new Station("Helsinki",786,-1818));
		nodes.get("helsinki").connect(nodes.get("talin"), t);
		nodes.put("stockholm", new Station("Stockholm",519,-1768));
		nodes.get("helsinki").connect(nodes.get("stockholm"), t);
		nodes.get("copenhagen").connect(nodes.get("stockholm"), t);
		nodes.put("oslo", new Station("Oslo Meatballs",306,-1783));
		nodes.get("copenhagen").connect(nodes.get("oslo"), t);


		nodes.put("sevastople", new Station("Sevastople",994,-1368));
		nodes.get("sevastople").connect(nodes.get("constantinople"), t);
		nodes.put("byzeol1", new Node(1260,-1245));
		nodes.get("sevastople").connect(nodes.get("byzeol1"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupNull(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("worm", new Station("Worm's Bahnhof",159,-1480));
		nodes.get("worm").connect(nodes.get("medspawn"), t);
		nodes.put("beethedral", new Station("Beethedral",291,-1584));
		nodes.get("worm").connect(nodes.get("beethedral"), t);

		nodes.put("road to africa", new Node(199,-1130));
		nodes.get("road to africa").connect(nodes.get("medspawn"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupQuartz(HashMap<String,Node> nodes, TrainLine t){
		nodes.put("hat2", new Station("Inside the Hat",845,-1455));
		nodes.put("hat", new Station("The Hat",833,-1480));
		//nodes.get("hat").connect(nodes.get("hat2"), t); - moved ot another part of the program
		nodes.put("unnamedquartz", new Station("Unnamed Intersection",777,-1480));
		nodes.get("hat").connect(nodes.get("unnamedquartz"), t);
		nodes.get("wtaeuhq").connect(nodes.get("unnamedquartz"), t);
		nodes.put("glass", new Station("Glass",700,-1480));
		nodes.get("glass").connect(nodes.get("unnamedquartz"), t);
		nodes.put("hut", new Station("Glass",555,-1480));
		nodes.get("glass").connect(nodes.get("hut"), t);
		nodes.put("wendys", new Station("Wendy's & Co-op",424,-1480));
		nodes.get("wendys").connect(nodes.get("hut"), t);
		nodes.put("german", new Station("Deutscher Bahnhof",402,-1480));
		nodes.get("wendys").connect(nodes.get("german"), t);
		nodes.put("tree", new Station("Tree",360,-1471));
		nodes.get("tree").connect(nodes.get("german"), t);
		nodes.put("rhine", new Station("Rhine",285,-1525));
		nodes.get("tree").connect(nodes.get("rhine"), t);
		nodes.get("beethedral").connect(nodes.get("rhine"), t);
		nodes.put("wtadenmark", new Station("Denmark",264,-1610));
		nodes.get("beethedral").connect(nodes.get("wtadenmark"), t);
		nodes.get("oslo").connect(nodes.get("wtadenmark"), t);
		nodes.put("wtanorth", new Station("WTA Northern HQ",285,-1886));
		nodes.get("wtanorth").connect(nodes.get("oslo"), t);
		nodes.put("wtanorth2", new Station("Inside WTA Northern HQ",301,-1918));
		nodes.get("wtanorth").connect(nodes.get("wtanorth2"), t);
		nodes.put("wtaquartzeol", new Station("yes.",1160,-1461));//TODO: name this and check if that station gets changed so the traisn like, actually stop
		nodes.get("hat").connect(nodes.get("wtaquartzeol"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupStoneBrick(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("transylvania", new Station("Transylvania",730,-1380));
		nodes.put("hexamu", new Station("Hexamu Interchange",402,-1540));
		nodes.get("transylvania").connect(nodes.get("hexamu"), t);
		nodes.put("prismarine", new Station("Prismarine Interchange",364,-1540));
		nodes.get("prismarine").connect(nodes.get("hexamu"), t);
		nodes.put("canal", new Station("Canal Station, Mercedes",223,-1540));
		nodes.get("prismarine").connect(nodes.get("canal"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupGerman(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("tiny town", new Station("Tiny Town",396,-1131));
		nodes.put("fast attack", new Station("Fast Attack",417,-1277));
		nodes.get("tiny town").connect(nodes.get("fast attack"), t);
		nodes.put("luintersection", new Station("LU / Intersection",398,-1450));
		nodes.get("luintersection").connect(nodes.get("fast attack"), t);
		nodes.get("luintersection").connect(nodes.get("german"), t);
		nodes.get("hexamu").connect(nodes.get("german"), t);
		nodes.put("germanEOLstation", new Station("German Terminus",402,-1605));
		nodes.get("hexamu").connect(nodes.get("germanEOLstation"), t);
		nodes.put("germanEOLnode", new Node(402,-1613));
		nodes.get("hexamu").connect(nodes.get("germanEOLnode"), t);
		//nodes.put("germanEOLnodeA", new Node(402,-1107));
		//nodes.get("tiny town").connect(nodes.get("germanEOLnodeA"), t);
		nodes.put("in amguel", new Station("عين أمقل",139,-708));
		nodes.get("tiny town").connect(nodes.get("in amguel"),t);
		nodes.put("oasis bend", new Station("Oasis Bend (no stop)",-162,-676));
		nodes.get("oasis bend").connect(nodes.get("in amguel"), t);
		nodes.put("ngh wta drama", new Station("Minecraft Drama Memorial (No Stop)",-266,-702));
		nodes.get("oasis bend").connect(nodes.get("ngh wta drama"), t);
		nodes.put("wtanan2", new Node(-600,-708));//TODO: EOL
		nodes.put("ger alex", new Node(-413,-708));
		nodes.get("ger alex").connect(nodes.get("ngh wta drama"), t);
		nodes.get("wtanan2").connect(nodes.get("ger alex"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupPipeline(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("pipe", new Station("Pipe",481,-1205));
		nodes.get("pipe").connect(nodes.get("rome"), t);
		nodes.put("churchjo", new Station("Church of Jo",514,-1250));
		nodes.get("churchjo").connect(nodes.get("rome"), t);
		nodes.put("prevesa", new Station("Prevesa",613,-1166));
		nodes.get("churchjo").connect(nodes.get("prevesa"), t);
		nodes.put("greek", new Station("Greek",659,-1193));
		nodes.get("greek").connect(nodes.get("prevesa"), t);
		return nodes;

	}
	public static HashMap<String,Node> setupRAW(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("rawn1", new Node(282,-1480));
		nodes.get("worm").connect(nodes.get("rawn1"), t);
		nodes.put("bielefeld", new Station("Bielefeld",282,-1509));
		nodes.get("bielefeld").connect(nodes.get("rawn1"), t,false);
		nodes.put("berlin memorial", new Station("Berlin Memorial",288,-1560));
		nodes.get("bielefeld").connect(nodes.get("berlin memorial"), t,false);
		nodes.get("beethedral").connect(nodes.get("berlin memorial"), t,false);
		nodes.get("tree").connect(nodes.get("rawn1"), t);
		nodes.put("lsflb", new Station("Local Station for Lazy Boyes",381,-1459));
		nodes.get("tree").connect(nodes.get("lsflb"), t);
		nodes.put("dion0808", new Station("dion0808's house",445,-1468));
		nodes.get("dion0808").connect(nodes.get("lsflb"), t);
		nodes.get("dion0808").connect(nodes.get("vienna"), t);
		nodes.put("coop interchange", new Station("Co-op Interchange",509,-1466));
		nodes.get("vienna").connect(nodes.get("coop interchange"), t);
		nodes.put("pograw", new Node(516,-1537));
		nodes.put("cathness interchange", new Station("Cathness Interchange",544,-1473));
		nodes.get("cathness interchange").connect(nodes.get("coop interchange"), t);
		nodes.put("rawn2", new Node(740,-1424));
		nodes.get("cathness interchange").connect(nodes.get("rawn2"), t);
		nodes.put("rawn3", new Node(870,-1412));//TODO: mark as EOL
		nodes.get("rawn3").connect(nodes.get("rawn2"), t);
		nodes.put("rawn4", new Node(741,-1387));
		nodes.get("rawn4").connect(nodes.get("rawn2"), t);
		nodes.put("dracula", new Station("Dracula's Castle",669,-1339));
		nodes.get("dracula").connect(nodes.get("rawn4"), t);
		nodes.get("transylvania").connect(nodes.get("rawn4"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupPOG(HashMap<String,Node> nodes,TrainLine t) {
		nodes.get("pograw").connect(nodes.get("coop interchange"), t);
		nodes.put("pog1", new Node(510,-1537));
		nodes.get("pograw").connect(nodes.get("pog1"), t);
		nodes.get("warsaw").connect(nodes.get("pog1"), t);
		nodes.put("coop prague", new Station("Co-op Prague",457,-1495));
		nodes.get("coop prague").connect(nodes.get("pog1"), t);
		nodes.put("polish ohio", new Station("Polish Ohian Embassy",508,-1573));
		nodes.get("polish ohio").connect(nodes.get("pograw"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupScotrail(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("sctr1", new Node(622,-1545));
		nodes.get("sctr1").connect(nodes.get("cathness interchange"), t);
		nodes.put("sandomiers", new Station("Sandomiers",634,-1545));
		nodes.get("sandomiers").connect(nodes.get("sctr1"), t);
		nodes.put("sctr2", new Node(634,-1555));
		nodes.get("sctr1").connect(nodes.get("sctr2"), t);
		nodes.put("sctr3", new Node(634,-1588));
		nodes.get("sctr3").connect(nodes.get("sctr2"), t);
		nodes.put("ikea on sea", new Station("Ikea on Sea",604,-1635));
		nodes.get("sctr3").connect(nodes.get("ikea on sea"), t);
		nodes.put("rthouse", new Station("Rumble Tumble's House",637,-1611));
		nodes.get("sctr3").connect(nodes.get("rthouse"), t);
		nodes.put("sctr4", new Node(651,-1533));
		nodes.get("sctr4").connect(nodes.get("sctr2"), t);
		nodes.get("sctr4").connect(nodes.get("sandomiers"), t);
		nodes.put("sctr5", new Node(666,-1516));
		nodes.get("sctr4").connect(nodes.get("sctr5"), t);
		nodes.put("orangefield", new Station("Orange Field",666,-1494));
		nodes.get("sctr5").connect(nodes.get("orangefield"), t);
		nodes.get("sctr5").connect(nodes.get("warsaw"), t);
		return nodes;

	}
	public static HashMap<String,Node> setupWBC(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("wbc transylvania", new Station("WBC Transylvania Facility",624,-1344));
		nodes.put("budapest", new Station("Budapest",579,-1426));
		nodes.get("budapest").connect(nodes.get("wbc transylvania"), t);
		nodes.put("wbceuhq", new Station("WBC Europe HQ",610,-1615));
		nodes.get("budapest").connect(nodes.get("wbceuhq"), t);
		nodes.put("observatory", new Station("Observatory",642,-1675));
		nodes.get("observatory").connect(nodes.get("wbceuhq"), t);
		nodes.put("sign argument", new Station("Sign Argument",632,-1770));
		nodes.get("observatory").connect(nodes.get("sign argument"), t);
		nodes.put("wbc1", new Node(650,-1790));
		nodes.get("observatory").connect(nodes.get("wbc1"), t);
		nodes.get("wbc1").connect(nodes.get("sign argument"), t);
		nodes.put("kattilot", new Station("Kattilot Island",650,-1810));
		nodes.get("kattilot").connect(nodes.get("wbc1"), t);
		nodes.put("unity parkway", new Station("Unity Parkway",650,-1900));
		nodes.get("kattilot").connect(nodes.get("unity parkway"), t);
		return nodes;

	}
	public static HashMap<String,Node> setupLUASP(HashMap<String,Node> nodes,TrainLine t) {
		//TODO: add EOL's you lazy bastard
		nodes.put("luaspeol", new Node(870,-1520));
		nodes.put("companion", new Station("Companion",712,-1416));
		nodes.get("luaspeol").connect(nodes.get("companion"), t);
		nodes.get("budapest").connect(nodes.get("companion"), t);
		nodes.get("luintersection").connect(nodes.get("budapest"), t);
		nodes.put("luaspn1", new Node(364,-1423));
		nodes.get("luintersection").connect(nodes.get("luaspn1"), t);
		nodes.put("austriastop", new Station("Austria Stop",337,-1434));
		nodes.get("austriastop").connect(nodes.get("luaspn1"), t);
		nodes.get("austriastop").connect(nodes.get("medspawn"), t);
		nodes.get("prismarine").connect(nodes.get("luaspn1"), t);
		nodes.get("austriastop").connect(nodes.get("prismarine"), t);
		nodes.put("gustrow", new Station("Güstrow Interchange",364,-1612));
		nodes.get("gustrow").connect(nodes.get("prismarine"), t);
		nodes.put("rmaze", new Station("Random Maze",364,-1834));
		nodes.get("gustrow").connect(nodes.get("rmaze"), t);
		nodes.put("lua unity", new Station("LUAS & Unity Interchange",364,-1902));
		nodes.get("lua unity").connect(nodes.get("rmaze"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupNorthern(HashMap<String,Node> nodes,TrainLine t) {
		nodes.get("gustrow").connect(nodes.get("wtadenmark"), t);
		nodes.get("gustrow").connect(nodes.get("germanEOLnode"), t);
		nodes.get("danzig").connect(nodes.get("germanEOLnode"), t);
		nodes.get("danzig").connect(nodes.get("wbceuhq"), t);
		nodes.put("victory", new Station("Victory Square",864,-1632));
		nodes.get("victory").connect(nodes.get("wbceuhq"), t);
		nodes.put("northerneol", new Node(870,-1613));
		nodes.get("victory").connect(nodes.get("northerneol"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupEurostar(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("essex", new Station("London Dabbington",19,-1549));
		nodes.put("eurn1", new Node(55,-1498));
		nodes.get("essex").connect(nodes.get("eurn1"), t,false);
		nodes.get("worm").connect(nodes.get("eurn1"), t,false);
		nodes.put("eurn2", new Node(55,-1491));
		nodes.get("eurn2").connect(nodes.get("eurn1"), t,false);
		nodes.put("eurn3", new Station("Euopean Space Agencey",76,-1382));
		nodes.put("bourges", new Station("Bourges",81,-1420));
		nodes.get("eurn2").connect(nodes.get("bourges"), t,false);
		nodes.get("eurn3").connect(nodes.get("bourges"), t,false);
		nodes.put("spain", new Station("Spain",-145,-1177));
		nodes.put("spainrest", new Station("Railway Rest Stop",-135,-1238));
		nodes.get("spainrest").connect(nodes.get("spain"), t,false);
		nodes.get("spainrest").connect(nodes.get("eurn3"), t,false);
		nodes.put("rouen", new Station("Rouen",34,-1486));
		nodes.get("eurn2").connect(nodes.get("rouen"), t,false);
		return nodes;
	}
	public static HashMap<String,Node> setupPurple(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("cheese", new Station("Cheese",150,-1443));
		nodes.get("cheese").connect(nodes.get("bourges"), t);
		nodes.put("lourve", new Station("Mini Lourve",36,-1417));
		nodes.get("lourve").connect(nodes.get("bourges"), t);
		nodes.put("invasion", new Station("Alien Invasion",-31,-1417));
		nodes.get("lourve").connect(nodes.get("invasion"), t);
		nodes.put("brittany", new Station("Brittany Sludge",-136,-1417));
		nodes.get("brittany").connect(nodes.get("invasion"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupNoog(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("ikea2", new Station("Ikea 2",522,-1877));
		nodes.put("dekunoog1", new Node(524,-1864));
		nodes.get("ikea2").connect(nodes.get("dekunoog1"), t);
		nodes.put("nooggrandjunction", new Node(502,-1918));
		nodes.get("nooggrandjunction").connect(nodes.get("dekunoog1"), t);
		nodes.put("station", new Station("Station Station",584,-2061));
		nodes.get("nooggrandjunction").connect(nodes.get("station"), t,false);
		nodes.put("noogn1", new Node(467,-1892));
		nodes.get("nooggrandjunction").connect(nodes.get("noogn1"), t);
		nodes.put("world tree", new Station("World Tree",482,-1890));
		nodes.get("world tree").connect(nodes.get("noogn1"), t);
		nodes.put("dekunoog2", new Node(457,-1838));
		nodes.get("dekunoog2").connect(nodes.get("noogn1"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupDeku(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("dutch coast", new Station("The Dutch Coast",198,-1629));
		nodes.get("dutch coast").connect(nodes.get("worm"), t);
		nodes.put("nobel", new Station("Nobel Peace Centre",259,-1809));
		nodes.get("dutch coast").connect(nodes.get("nobel"), t);
		nodes.put("borgund", new Station("Borgund Stave Church Museum",247,-1846));
		nodes.get("borgund").connect(nodes.get("nobel"), t,false);
		nodes.get("dekunoog2").connect(nodes.get("nobel"), t);
		nodes.get("dekunoog2").connect(nodes.get("dekunoog1"), t);
		nodes.put("nordspawn", new Station("Nordic Spawn",581,-1859));
		nodes.get("nordspawn").connect(nodes.get("dekunoog1"), t);
		nodes.put("snom", new Station("Snom Stop",654,-1867));
		nodes.get("nordspawn").connect(nodes.get("snom"), t);
		nodes.put("russfinn", new Station("Russian-Finnish Border",880,-1875));
		nodes.get("russfinn").connect(nodes.get("snom"), t);
		nodes.put("wide putin", new Station("Wide Putin",1128,-1881));
		nodes.get("russfinn").connect(nodes.get("wide putin"), t);
		nodes.put("canary library", new Station("Canary Library",1467,-1873));
		nodes.get("wide putin").connect(nodes.get("canary library"), t);
		nodes.put("tree tunnel", new Node(1543,-1831));
		nodes.get("tree tunnel").connect(nodes.get("canary library"), t);
		nodes.put("wta scberian", new Station("WTA SCBerian",1519,-1900));
		nodes.get("wta scberian").connect(nodes.get("canary library"), t);
		nodes.put("scp siberia", new Station("SCP Siberia",1565,-1908));
		nodes.get("wta scberian").connect(nodes.get("scp siberia"), t);
		nodes.get("tree tunnel").connect(nodes.get("scp siberia"), t);
		nodes.put("wsiberia spawn junction", new Station("Junction",1544,-2054));
		nodes.get("scp siberia").connect(nodes.get("wsiberia spawn junction"), t);
		nodes.put("wsiberia spawn", new Station("West Siberia Spawn",1416,-2103));
		nodes.get("wsiberia spawn").connect(nodes.get("wsiberia spawn junction"), t);
		nodes.put("ice fort stadium", new Station("Ice Fort Stadium",1730,-2259));
		nodes.get("ice fort stadium").connect(nodes.get("wsiberia spawn junction"), t);
		nodes.put("wbc wsiberia", new Station("WBC West Siberia HQ",1710,-1866));
		nodes.get("scp siberia").connect(nodes.get("wbc wsiberia"), t);
		nodes.put("commies", new Station("Commies Co.",2101,-1831));
		nodes.get("commies").connect(nodes.get("wbc wsiberia"), t);
		nodes.put("no dekumos", new Node(2117,-1833));
		nodes.put("whiskie", new Station("Whiskie Intersection",2081,-1902));
		nodes.get("whiskie").connect(nodes.get("no dekumos"), t,false);
		nodes.get("commies").connect(nodes.get("no dekumos"), t);
		nodes.put("siberian mansion", new Station("Siberian Mansion",2174,-1831));
		nodes.get("no dekumos").connect(nodes.get("siberian mansion"), t);
		nodes.put("kremlin shrine", new Station("Kremlin Shrine",2251,-1873));
		nodes.get("siberian mansion").connect(nodes.get("kremlin shrine"), t);
		nodes.put("afk hotel", new Station("AFK Hotel",2295,-1873));
		nodes.get("afk hotel").connect(nodes.get("kremlin shrine"), t);
		nodes.put("nostalgia", new Station("Nostalgia",2338,-1864));
		nodes.get("afk hotel").connect(nodes.get("nostalgia"), t);
		nodes.put("nostalgia 2", new Station("Nostalgia 2",2345,-1873));
		nodes.get("nostalgia 2").connect(nodes.get("nostalgia"), t);
		nodes.put("nostalgia village", new Station("WTA Nostalgia Village",2382,-1902));
		nodes.get("nostalgia village").connect(nodes.get("nostalgia"), t);
		nodes.put("non sus igloo", new Station("Non Suspicious Igloo",2390,-1852));
		nodes.get("non sus igloo").connect(nodes.get("nostalgia 2"), t);
		//TODO: Different line from this point or just keep going?
		nodes.put("siberia boat race", new Station("Boat Race Track",2487,-1852));
		nodes.get("non sus igloo").connect(nodes.get("siberia boat race"), t);
		nodes.put("neo plaza", new Station("[A] Neo Plaza",2535,-1852));
		nodes.get("neo plaza").connect(nodes.get("siberia boat race"), t);
		nodes.put("milk home", new Station("Milk Home",2700,-1852));
		nodes.get("neo plaza").connect(nodes.get("milk home"),t);
		nodes.put("hot springs", new Station("Hot Springs",2764,-1852));
		nodes.get("hot springs").connect(nodes.get("milk home"),t);
		nodes.put("ngh mines", new Station("NGH Mines",2854,-1852));
		nodes.get("hot springs").connect(nodes.get("ngh mines"),t);
		nodes.put("allerdale", new Station("Allerdale / Charro Metacentre",2854,-1930));
		nodes.get("allerdale").connect(nodes.get("ngh mines"),t);
		nodes.put("snowy", new Station("Snowy",2854,-2067));
		nodes.get("allerdale").connect(nodes.get("snowy"),t);
		nodes.put("international mall", new Station("International Mall",2854,-2138));
		nodes.get("international mall").connect(nodes.get("snowy"),t);
		nodes.put("friendlypug airport", new Station("Friendlypug73's Airport",2850,-2231));
		nodes.get("international mall").connect(nodes.get("friendlypug airport"),t);
		nodes.put("smol pier", new Station("Smol Pier",2845,-2265));
		nodes.get("smol pier").connect(nodes.get("friendlypug airport"),t);
		nodes.put("komsomolet", new Station("остров Комсомолец",2845,-2433));
		nodes.get("komsomolet").connect(nodes.get("smol pier"),t);
		nodes.put("kanson", new Station("kanson_'s terminus",2845,-2450));
		nodes.get("komsomolet").connect(nodes.get("kanson"),t);
		nodes.put("little airstrip", new Station("Little Airstrip",2794,-2433));//TODO this place is unnamed
		nodes.get("komsomolet").connect(nodes.get("little airstrip"),t);
		nodes.put("nsiberia spawn", new Station("North Siberia Spawn",2765,-2472));
		nodes.get("nsiberia spawn").connect(nodes.get("little airstrip"),t);
		nodes.put("taymyr", new Station("Lake Таймы́р",3019,-2242));
		nodes.get("taymyr").connect(nodes.get("friendlypug airport"),t);
		nodes.put("deku wsiberian1", new Node(3265,-2277));
		nodes.get("taymyr").connect(nodes.get("deku wsiberian1"),t);
		nodes.put("east germany consulate", new Station("Consulate of East Germany",3258,-2329));
		nodes.get("east germany consulate").connect(nodes.get("deku wsiberian1"),t);
		nodes.put("nwo hq", new Station("NWO Head Quarters",3335,-2277));
		nodes.get("nwo hq").connect(nodes.get("deku wsiberian1"),t);
		nodes.put("inner planets", new Station("The Inner Plannets",3448,-2064));
		nodes.get("nwo hq").connect(nodes.get("inner planets"),t);
		nodes.put("wta castle 2", new Station("WTA Castle Side Entrance",3448,-1907));
		nodes.get("wta castle 2").connect(nodes.get("inner planets"),t);
		nodes.put("wemlk", new Station("Wemlk's well made hut",3431,-1852));
		nodes.get("wemlk").connect(nodes.get("wta castle 2"),t);
		nodes.put("mirny", new Station("Mirny Regional Airport",3257,-1852));
		nodes.get("wemlk").connect(nodes.get("mirny"),t);//TODO: Railway somewhere here to map
		nodes.put("sprucewood", new Station("Spruce Wood",3206,-1852));
		nodes.get("sprucewood").connect(nodes.get("mirny"),t);
		nodes.put("abandoned village", new Station("Abandoned Village",3028,-1852));
		nodes.get("sprucewood").connect(nodes.get("abandoned village"),t);
		nodes.put("cizlen", new Station("Cizlen's Home",2978,-1852));
		nodes.get("cizlen").connect(nodes.get("abandoned village"),t);
		nodes.put("smokey bear", new Station("Smokey the Bear",2920,-1852));
		nodes.get("cizlen").connect(nodes.get("smokey bear"),t);
		nodes.get("ngh mines").connect(nodes.get("smokey bear"),t);
		//Yet another new region
		nodes.put("ac village", new Station("Animal Crossing Village",3521,-1852));
		nodes.get("wemlk").connect(nodes.get("ac village"),t);
		nodes.put("army siberia", new Station("Army Base",3561,-1852));
		nodes.get("army siberia").connect(nodes.get("ac village"),t);
		nodes.put("metro mall", new Station("Underground Metro Mall",3652,-1852));
		nodes.get("army siberia").connect(nodes.get("metro mall"),t);
		nodes.put("jasminemastertea", new Station("JasmineMasterTea...",3693,-1869));
		nodes.get("jasminemastertea").connect(nodes.get("metro mall"),t);
		nodes.put("mole central", new Station("Mole Central",3843,-1869));
		nodes.get("jasminemastertea").connect(nodes.get("mole central"),t);
		nodes.put("mmm energy", new Station("MMM Energy Warehouse",3887,-1844));
		nodes.get("mmm energy").connect(nodes.get("mole central"),t);
		nodes.put("artificial beach", new Station("Artificial Beach",4115,-1834));
		nodes.get("mmm energy").connect(nodes.get("artificial beach"),t);
		nodes.put("eskapon", new Station("Eskapon's shack",4205,-1834));
		nodes.get("eskapon").connect(nodes.get("artificial beach"),t);
		//TODO: Should this be another line?
		nodes.put("2033", new Station("NWO Metro 2033 / New Senna Ave.",4211,-1968));
		nodes.get("eskapon").connect(nodes.get("2033"),t);
		nodes.put("intepesting", new Station("Vepy Intepesting",4218,-2110));
		nodes.get("2033").connect(nodes.get("intepesting"),t);
		nodes.put("port land", new Station("NGH Port Land",4340,-2173));
		nodes.get("port land").connect(nodes.get("intepesting"),t);

		nodes.put("tarry", new Station("Tarry Town 2.0",4249,-1834));
		nodes.get("eskapon").connect(nodes.get("tarry"),t);
		nodes.put("esib market", new Station("East Siberian Market",4270,-1834));
		nodes.get("esib market").connect(nodes.get("tarry"),t);//TODO: EOL
		nodes.put("illium", new Station("Illium",4512,-1834));
		nodes.get("esib market").connect(nodes.get("illium"),t);
		nodes.put("kamchatka", new Station("Камча́тка",4782,-1834));
		nodes.get("kamchatka").connect(nodes.get("illium"),t);
		nodes.put("JWC5", new Station("JWCFive Village",4872,-1834));
		nodes.get("kamchatka").connect(nodes.get("JWC5"),t);
		nodes.put("rt gorod", new Station("RT Gorod",4951,-1834));
		nodes.get("rt gorod").connect(nodes.get("JWC5"),t);
		nodes.put("subnautica gun", new Station("Quarantine Enforcement Platform",5034,-1834));
		nodes.get("rt gorod").connect(nodes.get("subnautica gun"),t);
		nodes.put("gongaga", new Station("Gongaga Port",5071,-1834));
		nodes.get("gongaga").connect(nodes.get("subnautica gun"),t);
		nodes.put("russian oil", new Station("Russian Oil",5281,-1897));
		nodes.get("gongaga").connect(nodes.get("russian oil"),t);
		nodes.put("worlds edge", new Station("World's Edge",5372,-1914));
		nodes.get("russian oil").connect(nodes.get("worlds edge"),t);

		nodes.put("spawn town", new Station("Spawn Town",4822,-2042));
		nodes.get("kamchatka").connect(nodes.get("spawn town"),t);
		nodes.put("chucke", new Station("Chuck E Cheese",4778,-1646));
		nodes.get("kamchatka").connect(nodes.get("chucke"),t);

		return nodes;
	}
	public static HashMap<String,Node> setupUnity(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("unityeolwest", new Node(169,-1902));
		nodes.get("unityeolwest").connect(nodes.get("wtanorth"), t);
		nodes.get("lua unity").connect(nodes.get("wtanorth"), t);
		nodes.put("wtasweden", new Station("Sweden",459,-1902));
		nodes.get("wtasweden").connect(nodes.get("lua unity"), t);
		nodes.get("wtasweden").connect(nodes.get("unity parkway"), t);
		nodes.put("petersburg", new Station("St. Petersburg",929,-1850));
		nodes.get("petersburg").connect(nodes.get("unity parkway"), t);
		nodes.put("raider king", new Station("Raider King's Interchange",1222,-1902));
		nodes.get("petersburg").connect(nodes.get("raider king"), t);
		nodes.put("luasy unity1", new Station("Souubway Interchange",1222,-1803));//TODO: name this mess, also EOL
		nodes.get("luasy unity1").connect(nodes.get("raider king"), t);
		nodes.put("tsar tank", new Station("Czar Tank",1286,-1929));
		nodes.get("tsar tank").connect(nodes.get("raider king"), t);
		nodes.get("tsar tank").connect(nodes.get("wta scberian"), t);
		//TODO: station here/ Node?
		nodes.put("bamboo rest", new Station("Bamboo Rest Stop",1657,-1902));
		nodes.get("bamboo rest").connect(nodes.get("wta scberian"), t);
		nodes.put("wta siberiahq", new Station("WTA Siberia HQ",1812,-1902));
		nodes.get("bamboo rest").connect(nodes.get("wta siberiahq"), t);
		nodes.put("space station", new Station("Space Station",1916,-1902));
		nodes.get("space station").connect(nodes.get("wta siberiahq"), t);
		//Line changes to be red
		nodes.get("space station").connect(nodes.get("whiskie"), t);
		nodes.put("tetrimino", new Station("Tetrimino City",2121,-1902));
		nodes.get("tetrimino").connect(nodes.get("whiskie"), t);
		nodes.put("between worlds", new Station("Between Worlds Rest Stop",2289,-1902));
		nodes.get("tetrimino").connect(nodes.get("between worlds"), t);
		nodes.get("afk hotel").connect(nodes.get("between worlds"), t);
		nodes.put("TODO UNITY EOL1", new Station("TODO EOL",2335,-1902));//TODO
		nodes.get("TODO UNITY EOL1").connect(nodes.get("between worlds"), t);
		nodes.get("TODO UNITY EOL1").connect(nodes.get("nostalgia village"), t);
		nodes.put("ct3hq", new Station("Channel 3 HQ",2476,-1902));
		nodes.get("ct3hq").connect(nodes.get("nostalgia village"), t);
		nodes.put("suger hill", new Station("Sugar Hill",2764,-1902));
		nodes.get("ct3hq").connect(nodes.get("suger hill"), t);
		nodes.get("allerdale").connect(nodes.get("suger hill"), t);//no stop for some reason
		nodes.put("hat mountain", new Station("Hat Mountain",2932,-1902));
		nodes.get("allerdale").connect(nodes.get("hat mountain"), t);
		nodes.put("unityn0", new Node(2983,-1902));
		nodes.get("unityn0").connect(nodes.get("hat mountain"), t);
		nodes.put("wta international mall", new Station("WTA International Mall",2924,-2128));
		nodes.get("wta international mall").connect(nodes.get("unityn0"), t);
		nodes.put("emerald city", new Station("Emerald City",3048,-1902));
		nodes.get("emerald city").connect(nodes.get("unityn0"), t);
		nodes.put("gregalopolis", new Station("Gregalopolis",3191,-1902));
		nodes.get("emerald city").connect(nodes.get("gregalopolis"), t);
		// many A stop with no stop here - actually probably just decorations
		// TODO: Node & EOL
		nodes.put("wta castle", new Station("WTA Castle",3408,-1902));
		nodes.get("wta castle").connect(nodes.get("gregalopolis"), t);
		nodes.get("wta castle").connect(nodes.get("ac village"),t);
		nodes.put("wta ice inter", new Station("Ice Interchange",3609,-1902));//TODO
		nodes.get("wta ice inter").connect(nodes.get("ac village"),t);
		nodes.put("unityn1", new Node(3885,-1902));
		nodes.get("wta ice inter").connect(nodes.get("unityn1"),t);
		nodes.put("east library", new Station("EAST LIBRARY OF THE RUSSIAN FEDERATION",3885,-1970));
		nodes.get("east library").connect(nodes.get("unityn1"),t);
		nodes.put("wsa", new Station("WSA Space Port",3936,-1902));
		nodes.get("wsa").connect(nodes.get("unityn1"),t);
		nodes.get("wsa").connect(nodes.get("2033"),t);
		nodes.get("intepesting").connect(nodes.get("2033"),t);
		nodes.put("unityn3", new Node(4322,-1902));//TODO: Train now stops here, work something out innit
		nodes.get("unityn3").connect(nodes.get("2033"),t);
		nodes.put("unityn3EOL", new Node(4322,-1800));
		nodes.get("unityn3").connect(nodes.get("unityn3EOL"),t);//TODO: EOL
		nodes.put("onion church", new Station("Onion Church",4539,-1902));
		nodes.get("onion church").connect(nodes.get("unityn3"),t);
		nodes.put("evensk", new Station("Evensk",4660,-1902));
		nodes.get("onion church").connect(nodes.get("evensk"),t);
		nodes.put("unityn4", new Station("Another Unnamed Unity Stop",4723,-1902));
		nodes.get("unityn4").connect(nodes.get("evensk"),t);
		nodes.put("ngh city", new Station("NGH City",4723,-1579));
		nodes.get("unityn4").connect(nodes.get("ngh city"),t);
		nodes.put("unityn5", new Node(4806,-1902));
		nodes.get("unityn5").connect(nodes.get("unityn4"),t);
		nodes.put("wta spawn village", new Station("WTA Spawn Town",4806,-2056));
		nodes.get("wta spawn village").connect(nodes.get("unityn5"),t);
		nodes.put("unityn6", new Node(4969,-1902));
		nodes.get("unityn5").connect(nodes.get("unityn6"),t);
		nodes.get("unityn6").connect(nodes.get("rt gorod"),t);
		nodes.put("tfthiscalled", new Station("WTA name your stations ffs",5033,-1969));//TODO
		nodes.get("unityn6").connect(nodes.get("tfthiscalled"),t);
		nodes.get("russian oil").connect(nodes.get("tfthiscalled"),t);
		nodes.get("russian oil").connect(nodes.get("worlds edge"),t);
		return nodes;
	}
	public static HashMap<String,Node> setupECML(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("aberdeen", new Station("Aberdeen",-70,-1712));
		nodes.put("ecmln1", new Node(-106,-1677));
		nodes.get("aberdeen").connect(nodes.get("ecmln1"), t);
		nodes.put("glasgow", new Station("Glasgow Queen Street",-126,-1672));
		nodes.get("glasgow").connect(nodes.get("ecmln1"), t);
		nodes.put("pub", new Station("Official Pub Stop",-42,-1633));
		nodes.get("ecmln1").connect(nodes.get("pub"), t);
		nodes.get("essex").connect(nodes.get("pub"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupRusTram(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("rustram1", new Station("[B]",2546,-1875));
		nodes.get("rustram1").connect(nodes.get("neo plaza"), t);
		nodes.put("rustram2", new Station("[C]",2546,-1931));
		nodes.get("rustram1").connect(nodes.get("rustram2"), t);
		nodes.put("rustram3", new Station("[D] Commerce Valley",2514,-1942));
		nodes.get("rustram3").connect(nodes.get("rustram2"), t);
		nodes.put("rustram4", new Station("[E] WW2 Tank Museum",2514,-1990));
		nodes.get("rustram3").connect(nodes.get("rustram4"), t);
		nodes.put("rustram5", new Station("[F]",2525,-2048));
		nodes.get("rustram5").connect(nodes.get("rustram4"), t);
		nodes.put("rustram6", new Station("[G]",2557,-2048));
		nodes.get("rustram5").connect(nodes.get("rustram6"), t);
		nodes.put("rustram7", new Station("[H] Terminus Rift",2596,-2048));
		nodes.get("rustram7").connect(nodes.get("rustram6"), t);
		nodes.put("rustram8", new Station("[I]",2648,-2055));
		nodes.get("rustram7").connect(nodes.get("rustram8"), t);
		nodes.put("rustram9", new Station("[J] Igloo",2733,-2199));
		nodes.get("rustram9").connect(nodes.get("rustram8"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupLUASY(HashMap<String,Node> nodes,TrainLine t) {
		//TODO: EOL
		nodes.get("luasy unity1").connect(nodes.get("tree tunnel"), t);
		nodes.get("tree tunnel").connect(nodes.get("luasy unity1"), t);
		nodes.put("vault", new Station("Vault",1657,-1803));
		nodes.get("luasy unity1").connect(nodes.get("vault"), t);
		nodes.get("tree tunnel").connect(nodes.get("vault"), t);
		nodes.get("bamboo rest").connect(nodes.get("vault"), t);
		nodes.put("old russia", new Station("Old Russia",1914,-1823));
		nodes.get("old russia").connect(nodes.get("vault"), t);
		nodes.get("old russia").connect(nodes.get("whiskie"), t);
		nodes.put("vladovistok", new Station("Vladovistok",2081,-2038));
		nodes.get("vladovistok").connect(nodes.get("whiskie"), t);
		nodes.put("den dural", new Station("Den Dural",2041,-2082));
		nodes.get("vladovistok").connect(nodes.get("den dural"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupSiberian(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("umc siberia interchange1", new Station("Siberian Line Interchange",860,-1525));
		nodes.get("umc siberia interchange1").connect(nodes.get("constantinople"), t);
		nodes.get("umc siberia interchange1").connect(nodes.get("vienna"), t);
		nodes.put("googlehq", new Station("Google HQ",868,-1577));
		nodes.get("umc siberia interchange1").connect(nodes.get("googlehq"), t);
		nodes.get("petersburg").connect(nodes.get("googlehq"), t);
		nodes.get("helsinki").connect(nodes.get("petersburg"), t);
		//Insert node for wierd iceway railway thing here?
		nodes.put("kola", new Station("Kola",1022,-2078));
		nodes.get("kola").connect(nodes.get("petersburg"), t);
		nodes.get("kola").connect(nodes.get("wsiberia spawn"), t);
		nodes.put("ukhta", new Station("Ukhta",1492,-2012));
		nodes.get("ukhta").connect(nodes.get("wsiberia spawn"), t);

		nodes.put("moskow", new Station("Moskov",1146,-1660));
		nodes.get("petersburg").connect(nodes.get("moskow"), t);
		nodes.put("umcsibeol1", new Node(1679,-1672));
		nodes.get("umcsibeol1").connect(nodes.get("moskow"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupSCP(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("inside scp sib", new Station("Inside SCP Siberia",1541,-1899));
		nodes.get("inside scp sib").connect(nodes.get("wta scberian"), t);
		nodes.put("scp interchange1", new Station("SCP Interchange",1528,-1933));
		nodes.get("scp interchange1").connect(nodes.get("wta scberian"), t);
		nodes.put("music stop", new Station("Music Stop",1557,-1933));
		nodes.get("music stop").connect(nodes.get("scp interchange1"), t);
		nodes.put("secret shack", new Station("Secret shack",1498,-1961));
		nodes.get("scp interchange1").connect(nodes.get("secret shack"), t);
		nodes.put("senate square node", new Node(1217,-1969));
		nodes.get("senate square node").connect(nodes.get("secret shack"), t);
		nodes.put("kiwi house", new Station("Kiwi's House",1231,-2043));
		nodes.get("senate square node").connect(nodes.get("kiwi house"), t);
		nodes.put("the gay tunnel stop", new Station("The gay tunnel stop",1448,-2043));
		nodes.get("the gay tunnel stop").connect(nodes.get("kiwi house"), t);
		nodes.put("red alert", new Station("Command & Conquer: Red Alert",1723,-2043));
		nodes.get("the gay tunnel stop").connect(nodes.get("red alert"), t);
		nodes.put("senate square", new Station("Senate Square",1217,-1934));
		nodes.get("senate square node").connect(nodes.get("senate square"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupTetris(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("tetris hq", new Station("Tetris HQ",1049,-1820));
		nodes.put("tetristopia", new Station("Tetristopia",1026,-1831));
		nodes.get("tetris hq").connect(nodes.get("tetristopia"), t);
		nodes.put("statues", new Station("Ice Statues",946,-1963));
		nodes.get("statues").connect(nodes.get("tetristopia"), t);
		nodes.put("lada", new Station("Lada Dealership",977,-1968));
		nodes.get("statues").connect(nodes.get("lada"), t);
		nodes.put("corruption", new Station("Corruption",1105,-1968));
		nodes.get("corruption").connect(nodes.get("lada"), t);
		nodes.get("corruption").connect(nodes.get("wide putin"), t);
		nodes.put("tetris boat", new Station("Tetris Boat",1357,-2017));
		nodes.get("corruption").connect(nodes.get("tetris boat"), t);
		nodes.put("tetris towers", new Station("Tetris Towers",1394,-1993));
		nodes.get("tetris towers").connect(nodes.get("tetris boat"), t);
		nodes.put("invention", new Station("Invention",1461,-1983));
		nodes.get("tetris towers").connect(nodes.get("invention"), t);
		nodes.put("tetris tower", new Station("Tetris Tower",1488,-1906));
		nodes.get("tetris tower").connect(nodes.get("invention"), t);
		nodes.get("tetris tower").connect(nodes.get("vault"), t);
		nodes.put("heritage russia", new Station("Heritage Museum",1461,-1826));
		nodes.get("tetris tower").connect(nodes.get("heritage russia"), t);
		nodes.get("ukhta").connect(nodes.get("invention"), t);
		nodes.get("tetris towers").connect(nodes.get("invention"), t);
		nodes.put("beef hut", new Station("Beef Hut",1499,-2120));
		nodes.get("ukhta").connect(nodes.get("beef hut"), t);
		nodes.put("tetris cuboid", new Station("Tetris Cuboid",1850,-2090));//TODO: another metro
		nodes.get("ukhta").connect(nodes.get("tetris cuboid"), t);
		nodes.put("tetris fountain", new Station("Tetris Fountain",1880,-2048));
		nodes.get("tetris fountain").connect(nodes.get("tetris cuboid"), t);
		nodes.get("tetris fountain").connect(nodes.get("tetrimino"), t);
		nodes.put("game boy", new Station("Game Boy",2260,-1823));
		nodes.get("game boy").connect(nodes.get("tetrimino"), t);
		nodes.put("tetromino plaza", new Station("Tetromino Plaza",2349,-1847));
		nodes.get("game boy").connect(nodes.get("tetromino plaza"), t);
		nodes.get("non sus igloo").connect(nodes.get("tetromino plaza"), t);
		nodes.put("tetris accident", new Station("Tetris Accident",3029,-1971));
		nodes.get("tetris accident").connect(nodes.get("non sus igloo"), t);
		nodes.put("water tribe", new Station("Northern Water Tribe",4367,-2272));
		nodes.get("tetris accident").connect(nodes.get("water tribe"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupPeter(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("st petersburg", new Station("St. Petersburg",906,-1812));
		nodes.get("st petersburg").connect(nodes.get("tetris hq"), t);
		nodes.put("lowervillage2", new Station("Lower Village.2",889,-1881));
		nodes.get("st petersburg").connect(nodes.get("lowervillage2"), t);
		nodes.put("uppervillage2", new Station("Upper Village.2",889,-1930));
		nodes.get("uppervillage2").connect(nodes.get("lowervillage2"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupBison(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("earth kingdom", new Station("Earth Kingdom Market Square",4367,-1808));//TODO: Connection here
		nodes.get("earth kingdom").connect(nodes.get("water tribe"), t);
		nodes.put("air tribe", new Station("Eastern Air Tribe",4788,-1703));
		nodes.get("earth kingdom").connect(nodes.get("air tribe"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupM(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("roscosmos", new Station("Roscosmos",1889,-2030));
		nodes.get("roscosmos").connect(nodes.get("tetris cuboid"), t);
		nodes.put("wtv", new Station("WTV",1850,-1908));
		nodes.get("wtv").connect(nodes.get("tetris cuboid"), t);
		return nodes;
	}
	
	//UKRAINE / TURKEY
	public static HashMap<String,Node> setupRussian(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("volgograd", new Station("Volgograd",1347,-1409));
		//TODO WRC?
		nodes.put("russiann1", new Node(1230,-1409));
		nodes.get("volgograd").connect(nodes.get("russiann1"), t,false);
		nodes.put("east georgia", new Station("Eastern Georgia",1230,-1297));
		nodes.put("hell surface", new Station("Hell's Surface",1230,-1363));
		nodes.get("hell surface").connect(nodes.get("russiann1"), t,false);
		nodes.get("hell surface").connect(nodes.get("east georgia"), t,false);
		nodes.put("fairy", new Station("Fairy Fountain",1179,-1386));
		nodes.get("fairy").connect(nodes.get("russiann1"), t,false);
		nodes.put("duckington", new Station("Duckington Cross",1154,-1292));
		nodes.get("fairy").connect(nodes.get("duckington"), t,false);
		nodes.put("russiann2", new Node(1124,-1231));
		nodes.get("russiann2").connect(nodes.get("duckington"), t,false);//TODO: EOL
		return nodes;
	}
	public static HashMap<String,Node> setupHat(HashMap<String,Node> nodes,TrainLine t) {
		nodes.get("hat").connect(nodes.get("hat2"), t);
		nodes.put("wtakiev", new Station("WTA Kiev",1013,-1462));
		nodes.get("wtakiev").connect(nodes.get("hat2"), t);
		nodes.get("wtakiev").connect(nodes.get("wtaquartzeol"), t);
		nodes.put("hatinter1", new Station("Interchange",1222,-1462));
		nodes.get("hatinter1").connect(nodes.get("wtaquartzeol"), t);
		nodes.get("hatinter1").connect(nodes.get("luasy unity1"), t);
		nodes.put("wta volgograd", new Station("WTA Volgograd",1239,-1462));
		nodes.get("hatinter1").connect(nodes.get("wta volgograd"), t);
		nodes.put("hat eol", new Station("Hat EOL",1671,-1462));//TODO: EOL
		nodes.get("hat eol").connect(nodes.get("wta volgograd"), t);
		return nodes;
		
	}
	public static HashMap<String,Node> setupMossPeter(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("moscow", new Station("Moscow",1128,-1628));
		nodes.get("moscow").connect(nodes.get("petersburg"), t);
		nodes.get("moscow").connect(nodes.get("wtakiev"), t);
		return nodes;
	}
	//AFRICA
	public static HashMap<String,Node> setupShuttle(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("canary spawn", new Station("Canaries Spawn",-388,-785));
		nodes.put("vine hill", new Station("Vine Hill",-322,-682));
		nodes.get("vine hill").connect(nodes.get("canary spawn"), t);
		nodes.put("bafata", new Station("Bafatá",-437,-366));
		nodes.get("vine hill").connect(nodes.get("bafata"), t, false);//TODO: plz fix this cheers
		return nodes;
	}
	public static HashMap<String,Node> setupAfrican(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("ngh oasis", new Station("NGH Oasis",-238,-785));
		nodes.get("ngh oasis").connect(nodes.get("canary spawn"), t);
		nodes.put("just train",new Station("Train (No Stop)",463,-813));
		nodes.get("ngh oasis").connect(nodes.get("just train"), t, false);
		nodes.put("scp1437",new Station("SCP-1437",651,-807));
		nodes.get("scp1437").connect(nodes.get("just train"), t);
		nodes.put("egyptb",new Station("Egyptian Border",748,-813));
		nodes.get("scp1437").connect(nodes.get("egyptb"), t);
		return nodes;
	}
	public static HashMap<String,Node> setupAlexandrian(HashMap<String,Node> nodes,TrainLine t) {
		nodes.put("alexn1", new Node(-268,-953));
		nodes.put("vault ngh", new Station("Vault NGH",-289,-787));
		nodes.get("alexn1").connect(nodes.get("vault ngh"), t);//TODO: EOL
		nodes.put("alexwta", new Station("WTA <> Alexandrian Interchange",-413,-471));
		nodes.get("ger alex").connect(nodes.get("alexwta"), t);
		nodes.get("ger alex").connect(nodes.get("vault ngh"), t);
		nodes.put("dakar", new Station("Dakar",-495,-443));
		nodes.get("dakar").connect(nodes.get("alexwta"), t);
		nodes.put("grain coast", new Station("Grain Coast",87,-173));
		nodes.get("dakar").connect(nodes.get("grain coast"), t);
		nodes.put("alexn2", new Node(150,-162));
		nodes.get("alexn2").connect(nodes.get("grain coast"), t);//TODO:EOL;
		return nodes;
	}
}
