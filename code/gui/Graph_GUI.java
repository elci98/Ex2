package gui;
import java.awt.Color;

import dataStructure.*;
import utils.Point3D;
import utils.Range;
import utils.StdDraw;
public class Graph_GUI 
{
	graph g;
	public Graph_GUI(graph _g)
	{
		g=_g;	
	}
	public void drawGraph(int width, int height, Range rx, Range ry) 
	{

		StdDraw.setXscale(rx.get_min(),rx.get_max());
		StdDraw.setYscale(ry.get_min(),ry.get_max());
		StdDraw.setCanvasSize(width,height);
		StdDraw.setPenRadius(0.5);
		StdDraw.setPenColor(Color.BLACK);
		for(node_data vertex:g.getV())
		{
			double x=vertex.getLocation().x();
			double y=vertex.getLocation().y();
			StdDraw.point(x, y);
			
		}





	}


	public static void main(String[] args)
	{
		Range rx=new Range(-10,10);
		Range ry=new Range(-5,15);
		Point3D p=new Point3D(1,2,3);
		graph x=new DGraph();
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
		Graph_GUI p1=new Graph_GUI(x);
		p1.drawGraph(750,750,rx,ry);
	}
}
