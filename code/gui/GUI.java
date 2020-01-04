package gui;

import algorithms.Graph_Algo;
import dataStructure.graph;
import utils.StdDraw;

public class GUI 
{
	graph G=null;
	Graph_Algo ga=null;
	
	public GUI()//constructor for opening empty window
	{
		StdDraw.init();
	}
	public GUI(graph g)
	{
		G=g;
		ga=new Graph_Algo(g);
		StdDraw.initGraph(g);
		drawGraph(g);
	}
	public void drawGraph(graph G) 
	{
		StdDraw.drawGraph(G);
	}
}
//	public static void main(String[] args) 
//	{
//		
//		graph g=new DGraph();
//		nodeData [] nodes = new nodeData[10];
//		Point3D [] points=new Point3D[10];
//
//
//		for(int i=0;i<10;i++)
//		{
//			points[i]=new Point3D(Math.random()*20*Math.pow(-1, i),Math.random()*20);
//			nodes[i]= new nodeData(points[i],i+1,0);
//			g.addNode(nodes[i]);
//		}
//		g.connect(1, 2, 8);
//		g.connect(1, 10, 30);
//		g.connect(2, 1, 10);
//		g.connect(2, 6,20);
//		g.connect(2, 3, 1);
//		g.connect(2, 5, 21);
//		g.connect(3, 2, 2);
//		g.connect(3,4,2);
//		g.connect(4,5,2);
//		g.connect(5,3,15);
//		g.connect(6, 7, 22);
//		g.connect(6,8,60);
//		g.connect(7,3,7);
//		g.connect(8,9,7);
//		g.connect(9,8,8);
//		g.connect(9,2,19);
//		g.connect(9,5,3);
//		g.connect(10,6,2);
//		g.connect(10,8,7);
//		GUI app=new GUI(g);
//	}
