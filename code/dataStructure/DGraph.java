package dataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class DGraph implements graph
{
	HashMap<Integer,nodeData> DNodes=new HashMap<>();
	HashMap<Integer,edge_data> DEdges=new HashMap<>();
	HashSet<Integer> h=new HashSet<>();
	@Override
	public node_data getNode(int key) 
	{
		if(DNodes.containsKey(key))
			return (node_data)DNodes.get(key);
		return null;
	}

	@Override
	public edge_data getEdge(int src, int dest) 
	{
		if(DNodes.containsKey(src) && DNodes.containsKey(dest))
		{
			return DEdges.get(DNodes.get(src).hashCode()+DNodes.get(dest).hashCode());
		}
		return null;
	}

	@Override
	public void addNode(node_data n) 
	{
		DNodes.put(n.getKey(), (nodeData)n);
	}

	/**
	 * This method creates new edge between src vertex and dest vertex.
	 * @param key-we chose blindly the key for each edge
	 */
	@Override
	public void connect(int src, int dest, double w) 
	{
		if(DNodes.containsKey(src) && DNodes.containsKey(dest))
		{
			edgeData value= new edgeData(DNodes.get(src),DNodes.get(dest),w,1,"");
			int key=DNodes.get(src).hashCode()+DNodes.get(dest).hashCode();
			DEdges.put(key, value);
		}
		else
			System.out.println("invalid inserted vertices");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<node_data> getV() 
	{
		return (Collection<node_data>) DNodes.clone();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<edge_data> getE(int node_id) 
	{
		return (Collection<edge_data>) DEdges.clone();
	}

	@Override
	public node_data removeNode(int key) 
	{
		if(DNodes.containsKey(key))
			return DNodes.remove(key);
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) 
	{
		int key=DNodes.get(src).hashCode()+DNodes.get(dest).hashCode();
		if(DEdges.containsKey(key))
			return DEdges.remove(key);
		return null;
	}

	@Override
	public int nodeSize() 
	{
		return DNodes.size();
	}

	@Override
	public int edgeSize() 
	{
		return DEdges.size(); 
	}

	@Override
	public int getMC() 
	{
		return 0;
	}

}
