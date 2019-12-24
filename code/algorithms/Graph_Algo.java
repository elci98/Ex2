package algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import dataStructure.*;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author nuni hagever
 *
 */
public class Graph_Algo implements graph_algorithms
{
	HashMap<Integer,node_data> Nodes=new HashMap<>();
	int EdgesSize=0;
	HashMap<Integer,HashMap<Integer,edge_data>> srcMap=new HashMap<>();
	graph dGraph;

	public Graph_Algo()
	{

	}
	@Override
	public void init(graph g) //θ(n*m)n=num of vertices,m=num of edges
	{
		for(node_data vertex :g.getV()) //iterate over all vertices
		{
			HashMap<Integer,edge_data> map=new HashMap<>();
			int key = vertex.getKey();
			Nodes.put(key, vertex); // input current vertex to Nodes HashMap
			Collection<edge_data> edges=g.getE(key);
			if(edges!=null)
			{
				for(edge_data edge : edges) //iterate over all edges related to vertex 
				{
					map.put(edge.getDest(), edge);
					EdgesSize++;
				}
				srcMap.put(key, map);//input current vertex to srcMap ,i.e current vertex is source
			}
		}
		dGraph=new DGraph(Nodes,EdgesSize,srcMap);
	}

	@Override
	public void init(String file_name) 
	{
		try 
		{
			FileInputStream f=new FileInputStream(file_name);
			ObjectInputStream obj= new ObjectInputStream(f);
			dGraph=(graph) obj.readObject();
			obj.close();
		} 
		catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}


	}

	@Override
	public void save(String file_name) 
	{
		try 
		{
			FileOutputStream f=new FileOutputStream(file_name);
			ObjectOutputStream obj=new ObjectOutputStream(f);
			obj.writeObject(dGraph);
			obj.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public boolean isConnected() 
	{
		if(srcMap.size()<Nodes.size())return false;//i.e this graph has vertex with no edges coming out from
		//		for(Entry<Integer, HashMap<Integer, edge_data>> edges: srcMap.entrySet())
		//		{
		//
		//
		//		}

		return true;
	}
	private void initGraph(int src)
	{
		for(Entry<Integer, node_data> entry : Nodes.entrySet()) 
		{
			entry.getValue().setTag(-1);//Tag contains the predecessor`s id
			entry.getValue().setInfo("FALSE");//info contains boolean visited or not
			if(entry.getValue().getKey()==src)
				entry.getValue().setWeight(0);//set src vertex`s weight to 0
			else
				entry.getValue().setWeight(Double.MAX_VALUE);//setting all Nodes weight to infinity
		}
	}
	//		private boolean connected(int id, Collection<edge_data> edges)
	//		{
	//			
	//			return false;
	//		}
	//
	//	private boolean tagCheck() 
	//	{
	//		for(Entry<Integer, node_data> entry : Nodes.entrySet()) 
	//		{
	//			if(entry.getValue().getTag()!=1)
	//				return false;
	//		}
	//		return true;
	//	}
	@Override
	public double shortestPathDist(int src, int dest)//dijkstra algorithm O(V*E)
	{
		node_data current;
		PriorityQueue<node_data> q=new PriorityQueue<>(Nodes.size(),new Vertex_Comperator());
		initGraph(src);
		q.addAll(Nodes.values());
		while(!q.isEmpty())
		{
			current=q.remove();
			if(srcMap.containsKey(current.getKey()))
			{
				HashMap<Integer,edge_data> map=srcMap.get(current.getKey());
				for(edge_data edge:map.values())//iterate over all edges going out from current vertex
				{
					node_data dst=Nodes.get(edge.getDest());
					if(dst.getInfo().equals("FALSE")) //we skip dst vertex if visited already 
					{
						if(current.getWeight()+edge.getWeight()<dst.getWeight())
						{
							dst.setWeight(current.getWeight()+edge.getWeight());
							dst.setTag(current.getKey());//set dst predcessor to be current vertex
						}
					}
				}
			}
			current.setInfo("TRUE");
		}
		return Nodes.get(dest).getWeight();
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) 
	{
		if(shortestPathDist(src,dest)==Double.MAX_VALUE)
		{
			System.out.println("there are no edges going out from vertex src");
			return null;
		}
		List<node_data> ans=new ArrayList<>();
		node_data runner=Nodes.get(dest);
		while(runner.getKey()!=src)//make us stop after adding drc vertex to the List
		{
			ans.add(new nodeData(runner.getLocation(),runner.getKey(),runner.getWeight()));
			runner=Nodes.get(runner.getTag());
		}
		ans.add(Nodes.get(src));
		return ans;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) 
	{
		return null;
	}

	@Override
	public graph copy() 
	{
		graph g=new DGraph(Nodes,EdgesSize,srcMap);
		return g;
	}
	public String toString()
	{
		return dGraph.toString();
	}


	private class Vertex_Comperator implements Comparator<node_data> 
	{
		public Vertex_Comperator()
		{

		}

		@Override
		public int compare(node_data v2,node_data v1)
		{
			if(v1.getWeight()-v2.getWeight()>0)
				return -1;
			else return 1;
		}
	}
}
