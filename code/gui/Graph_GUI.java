package gui;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import algorithms.Graph_Algo;
import dataStructure.*;
import elements.nodeData;
import utils.*;

public class Graph_GUI extends Graph_Algo
{
	private Graph_Algo Graph=new Graph_Algo();
	private graph g;
	public Graph_GUI()
	{
	}
	public Graph_GUI(graph gr)
	{
		Graph.init(gr);
		g = gr;
	}
	public void save(String file_name) 
	{
		Graph.save(file_name);
	}
	public boolean isConnected() 
	{
		return Graph.isConnected();
	}
	public double shortestPathDist(int src, int dest)
	{
		return Graph.shortestPathDist(src, dest);
	}
	public List<node_data> shortestPath(int src, int dest) 
	{
		return Graph.shortestPath(src, dest);
	}
	public List<node_data> TSP(List<Integer> targets) 
	{
		return Graph.TSP(targets);
	}
	
	
	
//========================================================
	
	
	public void drawGraph(int width, int height, Range rx, Range ry) 
	{
		StdDraw.setCanvasSize(width,height);
		StdDraw.setXscale(rx.get_min(),rx.get_max());
		StdDraw.setYscale(ry.get_min(),ry.get_max());
		StdDraw.text((rx.get_min()+rx.get_max())/2, ry.get_min()+0.5, "© Max Raycher & Elchanan Mahatsri");
		for(node_data vertex:g.getV())
		{

			double x0=vertex.getLocation().x();
			double y0=vertex.getLocation().y();
			if(g.getE(vertex.getKey())!=null)
			{
				for(edge_data edge:g.getE(vertex.getKey()))
				{
					StdDraw.setPenRadius(0.005);
					StdDraw.setPenColor(Color.BLUE);
					Font f=new Font("BOLD", Font.BOLD, 20);
					StdDraw.setFont(f);
					double x1=g.getNode(edge.getDest()).getLocation().x();
					double y1=g.getNode(edge.getDest()).getLocation().y();
					
					//draw edges
					StdDraw.line(x0, y0, x1, y1);
					StdDraw.setPenRadius(0.025);
					
					//draw direction points
					StdDraw.setPenColor(Color.GREEN);
					StdDraw.point(x0*0.1+x1*0.9, y0*0.1+y1*0.9);
					
					//draw dst vertex
					StdDraw.setPenColor(Color.RED);
					StdDraw.point(x1, y1);
					
					//draw vertices weights
					StdDraw.setPenColor(Color.cyan);
					StdDraw.text(x0+x0/10, y0+y0/10, (int)vertex.getKey()+"");
					
					//draw edges weight
					StdDraw.setPenColor(Color.darkGray);
					StdDraw.text((x0+x1)/2, (y0+y1)/2,edge.getWeight()+"");
				}
			}
			StdDraw.setPenRadius(0.025);
			StdDraw.setPenColor(Color.RED);
			StdDraw.point(x0, y0);
		}




	}


	public static void main(String[] args)
	{
//		Range rx=new Range(-20,20);
//		Range ry=new Range(-22,6);
//		DGraph x=new DGraph();
//		Point3D p=new Point3D(-10,4,3);
//		nodeData n=new nodeData(p,1, 0);//num 1
//		x.addNode(n);
//		p=new Point3D(3,-2,1);
//		nodeData m=new nodeData(p,2, 0);//num 2
//		x.addNode(m);
//		p=new Point3D(9,-10,1);
//		nodeData v=new nodeData(p,3,0);//num 3
//		x.addNode(v);
//		p=new Point3D(14,-20,1);
//		nodeData z=new nodeData(p,4,0);//num 4
//		x.addNode(z);
//		x.connect(1, 2, 10);
//		x.connect(2, 1, 8);
//		x.connect(1, 3, 100);
//		x.connect(2, 3, 1);
//		x.connect(4, 3, 11.3);
//		x.connect(2, 4, 9);
//		Graph_Algo g = new Graph_Algo();
//		g.init(x);	
//		Graph_GUI p1 = new Graph_GUI();
//		p1.drawGraph(750,750,rx,ry,x);
//		System.out.println(g.isConnected());
		
		Point3D p1=new Point3D (1,1);
		Point3D p2=new Point3D (3,2);
		Point3D p3=new Point3D (4,5);
		Point3D p4=new Point3D (6,2);
		Point3D p5=new Point3D (7,-1);
		Point3D p6=new Point3D (5,-3);
		Point3D p7=new Point3D (2,-2);
		Point3D p8=new Point3D (-1,-4);
		Point3D p9=new Point3D (-4,-2);
		Point3D p10=new Point3D (-5,-1);
		Point3D p11=new Point3D (-6,2);
		Point3D p12=new Point3D (-5,4);
		Point3D p13=new Point3D (-3,6);
		Point3D p14=new Point3D (-1,3);
		
		nodeData n1=new nodeData(p1,1,3);
		nodeData n2=new nodeData(p2,2,3);
		nodeData n3=new nodeData(p3,3,3);
		nodeData n4=new nodeData(p4,4,3);
		nodeData n5=new nodeData(p5,5,3);
		nodeData n6=new nodeData(p6,6,3);
		nodeData n7=new nodeData(p7,7,3);
		nodeData n8=new nodeData(p8,8,3);
		nodeData n9=new nodeData(p9,9,3);
		nodeData n10=new nodeData(p10,10,3);
		nodeData n11=new nodeData(p11,11,3);
		nodeData n12=new nodeData(p12,12,3);
		nodeData n13=new nodeData(p13,13,3);
		nodeData n14=new nodeData(p14,14,3);
		
		graph g=new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		g.addNode(n8);
		g.addNode(n9);
		g.addNode(n10);
		g.addNode(n11);
		g.addNode(n12);
		g.addNode(n13);
		g.addNode(n14);
		
		g.connect(3, 9, 3);
		g.connect(7, 11, 3);
		g.connect(1, 3, 3);
		g.connect(1, 12, 3);
		g.connect(1, 2, 3);
		g.connect(2, 1, 4);
		g.connect(3, 4, 5);
		g.connect(4, 5, 6);
		g.connect(4, 7, 32);
		g.connect(5, 6, 13);
		g.connect(6, 7, 63);
		g.connect(7, 8, 44);
		g.connect(8, 9, 34.6);
		g.connect(9, 10, 31.2);
		g.connect(9, 14, 10.3);
		g.connect(10, 11, 12.5);
		g.connect(11, 12, 18);
		g.connect(1, 8, 23.6);
		g.connect(12, 13, 39);
		g.connect(5, 14, 55.6);
		g.connect(14, 3, 43.2);
		g.connect(14, 7, 98.6);
		g.connect(10, 9, 98.6);
		g.connect(13, 2, 98.6);
	
		Graph_GUI gu=new Graph_GUI(g);
		Range rx=new Range(-8,9);
		Range ry=new Range(-6,10);
//		gu.drawGraph(750,750,rx,ry);
		
		System.out.println(gu.isConnected());
//		g.removeEdge(13, 2);
		gu.drawGraph(750,750,rx,ry);
		System.out.println(gu.isConnected());
		System.out.println(gu.shortestPathDist(1, 11));
		System.out.println(gu.shortestPath(1, 11));
		

		
	}
}
