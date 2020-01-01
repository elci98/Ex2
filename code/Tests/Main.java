package Tests;

import java.util.ArrayList;
import java.util.List;
import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.graph;
import elements.nodeData;
import utils.Point3D;

public class Main {

	public static void main(String[] args) 
	{
		graph g=new DGraph();
		Graph_Algo ga=new Graph_Algo();
		nodeData [] nodes = new nodeData[10];
		Point3D [] points=new Point3D[10];


		for(int i=0;i<10;i++)
		{
			points[i]=new Point3D(1,2);
			nodes[i]= new nodeData(points[i],i+1,0);
			g.addNode(nodes[i]);
		}
		g.connect(1, 2, 8);
		g.connect(1, 10, 30);
		g.connect(2, 1, 10);
		g.connect(2, 6,20);
		g.connect(2, 3, 1);
		g.connect(2, 5, 21);
		g.connect(3, 2, 2);
		g.connect(3,4,2);
		g.connect(4,5,2);
		g.connect(5,3,15);
		g.connect(6, 7, 22);
		g.connect(6,8,60);
		g.connect(7,3,7);
		g.connect(8,9,7);
		g.connect(9,8,8);
		g.connect(9,2,19);
		g.connect(9,5,3);
		g.connect(10,6,2);
		g.connect(10,8,7);

		List<Integer> list=new ArrayList<>();
		ga.init(g);
//		Iterator<node_data>it=g.getV().iterator();
//		for(int i=1;i<6;i++)
//		{
//			list.add(g.getNode(i).getKey());
//		}
		list.add(g.getNode(1).getKey());
		list.add(g.getNode(2).getKey());
		list.add(g.getNode(10).getKey());
		list.add(g.getNode(9).getKey());
		list.add(g.getNode(8).getKey());
		list.add(g.getNode(6).getKey());
		
		
		
		//		g.save("graph.txt");

		//		System.out.println(g+"\n-------------\n"+x);
		//		System.out.println(ga.shortestPath(7,2));
		//		System.out.println(g.TSP(list).toString());

		//		g.save("graph.txt");
		//		System.out.println(g+"\n-------------\n"+x);
		System.out.println(list);
		System.out.println(ga.TSP(list));
	}

}
