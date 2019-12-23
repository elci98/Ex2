package Tests;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.nodeData;
import utils.Point3D;

public class Main {

	public static void main(String[] args) 
	{
		DGraph x=new DGraph();
		Point3D p=new Point3D(1,2,3);
		nodeData n=new nodeData(p,2, 0, 3, "");
		x.addNode(n);
		p=new Point3D(3,2,1);
		nodeData m=new nodeData(p,4, 0, 9, "");
		x.addNode(m);
		x.connect(n.getKey(), m.getKey(), 10);
		x.connect(m.getKey(), n.getKey(), 10);
		p=new Point3D(3,2,1);
		nodeData v=new nodeData(p,5,0,19,"");
		x.addNode(v);
		x.connect(v.getKey(), m.getKey(), 10);
		x.connect(m.getKey(), v.getKey(), 10);
		Graph_Algo g = new Graph_Algo();
		g.init(x);
		g.save("graph.txt");
		System.out.println(g+"\n-------------\n"+x);
		System.out.println(g.shortestPathDist(5, 2));
	}

}
