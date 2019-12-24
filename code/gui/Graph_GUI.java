package gui;
import java.awt.Color;
import java.awt.Font;

import dataStructure.*;
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
		for(node_data vertex:g.getV())//draw vertices points
		{

			double x0=vertex.getLocation().x();
			double y0=vertex.getLocation().y();

			for(edge_data edge:g.getE(vertex.getKey()))
			{
				StdDraw.setPenRadius(0.005);
				StdDraw.setPenColor(Color.BLUE);
				Font f=new Font("BOLD", Font.BOLD, 20);
				StdDraw.setFont(f);
				double x1=g.getNode(edge.getDest()).getLocation().x();
				double y1=g.getNode(edge.getDest()).getLocation().y();
				StdDraw.line(x0, y0, x1, y1);//draw edges
				StdDraw.setPenRadius(0.025);
				StdDraw.setPenColor(Color.GREEN);
				StdDraw.point(x0*0.1+x1*0.9, y0*0.1+y1*0.9);//draw direction points
				
				
				
				
				
				StdDraw.setPenColor(Color.RED);
				StdDraw.point(x1, y1);//draw vertices 
				StdDraw.setPenColor(Color.cyan);
				StdDraw.textRight(x0+3, y0+3, (int)vertex.getWeight()+"");//draw vertices weights
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.textLeft((x0+x1)/2, (y0+y1)/2, (int)edge.getWeight()+"");//draw edges weight
			}
			StdDraw.setPenRadius(0.025);
			StdDraw.setPenColor(Color.RED);
			StdDraw.point(x0, y0);
		}




	}


	public static void main(String[] args)
	{
		Range rx=new Range(-100,100);
		Range ry=new Range(-50,150);
		Point3D p=new Point3D(0,0,3);
		graph x=new DGraph();
		nodeData n=new nodeData(p,2, 0);
		x.addNode(n);
		p=new Point3D(-12,70,1);
		nodeData m=new nodeData(p,4, 0);
		x.addNode(m);
		x.connect(n.getKey(), m.getKey(), 10);
		x.connect(m.getKey(), n.getKey(), 10);
		p=new Point3D(-20,140,1);
		nodeData v=new nodeData(p,5,10);
		x.addNode(v);
		x.connect(5, 4, 1);
		Point3D p2=new Point3D(-70,-20);
		nodeData m1=new nodeData(p2,1,0);
		x.addNode(m1);
		x.connect(1, 4, 10);
		Graph_GUI p1=new Graph_GUI();
		p1.drawGraph(750,750,rx,ry,x);
	}
}
