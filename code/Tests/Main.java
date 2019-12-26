package Tests;

import java.util.ArrayList;
import java.util.List;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.node_data;
import elements.nodeData;
import utils.Point3D;

public class Main {

	public static void main(String[] args) 
	{
		DGraph x=new DGraph();
		Point3D p=new Point3D(1,2,3);
		nodeData n=new nodeData(p,1, 0);
		x.addNode(n);
		p=new Point3D(3,2,1);
		nodeData m=new nodeData(p,2, 0);
		x.addNode(m);
		p=new Point3D(3,2,1);
		nodeData v=new nodeData(p,3,0);
		x.addNode(v);
		x.connect(n.getKey(), m.getKey(), 10);
		x.connect(m.getKey(), n.getKey(), 8);
		x.connect(n.getKey(), v.getKey(), 100);
		x.connect(m.getKey(), v.getKey(), 1);
		Graph_Algo g = new Graph_Algo();
		g.init(x);
		List<Integer> list=new ArrayList<>();
		for(node_data node :x.getV())
			list.add(node.getKey());
		//		g.save("graph.txt");

//		System.out.println(g+"\n-------------\n"+x);
		System.out.println(g.shortestPath(1, 2));
//		System.out.println(g.TSP(list).toString());
	
//		g.save("graph.txt");
//		System.out.println(g+"\n-------------\n"+x);
		System.out.println(g.TSP(list));
	}

}
