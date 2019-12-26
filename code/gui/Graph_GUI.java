package gui;
import java.awt.Color;
import java.awt.Font;

import algorithms.Graph_Algo;
import dataStructure.*;
import elements.nodeData;
import utils.Point3D;
import utils.Range;
import utils.StdDraw;
public class Graph_GUI 
{

	public Graph_GUI()
	{
	}
	public void drawGraph(int width, int height, Range rx, Range ry, graph g) 
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
					StdDraw.text(x0+x0/10, y0+y0, (int)vertex.getWeight()+"");
					
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
		Range rx=new Range(-20,20);
		Range ry=new Range(-22,6);
		DGraph x=new DGraph();
		Point3D p=new Point3D(1,4,3);
		nodeData n=new nodeData(p,1, 0);//num 1
		x.addNode(n);
		p=new Point3D(3,-2,1);
		nodeData m=new nodeData(p,2, 0);//num 2
		x.addNode(m);
		p=new Point3D(9,-10,1);
		nodeData v=new nodeData(p,3,0);//num 3
		x.addNode(v);
		p=new Point3D(14,-20,1);
		nodeData z=new nodeData(p,4,0);//num 4
		x.addNode(z);
		x.connect(1, 2, 10);
		x.connect(2, 1, 8);
		x.connect(1, 3, 100);
		x.connect(2, 3, 1);
		x.connect(4, 3, 11.3);
		x.connect(2, 4, 9);
		Graph_Algo g = new Graph_Algo();
		g.init(x);	
		Graph_GUI p1 = new Graph_GUI();
		p1.drawGraph(750,750,rx,ry,x);
	}
}
