package gui;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import algorithms.Graph_Algo;
import dataStructure.*;
import elements.nodeData;
import utils.*;

public class Graph_GUI 
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
	
	@Override
	public String toString() {
		return  Graph.toString();
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
}
