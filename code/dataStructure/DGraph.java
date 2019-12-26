package dataStructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import elements.edgeData;
import elements.nodeData;


public class DGraph implements graph,Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param Nodes-hashMap that stores all nodes in this graph
	 * @param srcMap- 
	 * 
	 * */
	private int changes=0;
	HashMap<Integer,node_data> Nodes=new HashMap<>(); // list of all nodes
	int EdgesSize=0;// number of all edges
	HashMap<Integer,HashMap<Integer,edge_data>> srcMap=new HashMap<>();//list of all source vertices contains a list of their edges and destination
	public DGraph()
	{

	}
	@SuppressWarnings("unchecked")
	public DGraph(HashMap<Integer,node_data> _Nodes, int EdgesSize,HashMap<Integer,HashMap<Integer,edge_data>> _srcMap)
	{
		Nodes=(HashMap<Integer, node_data>) _Nodes.clone();
		this.EdgesSize=EdgesSize;
		srcMap=(HashMap<Integer, HashMap<Integer,edge_data>>) _srcMap.clone();
	}
	@Override
	public node_data getNode(int key) 
	{
		return Nodes.get(key);
	}


	@Override
	public edge_data getEdge(int src, int dest) 
	{
		return srcMap.get(src).get(dest);
	}

	@Override
	public void addNode(node_data n) 
	{
		if(!Nodes.containsKey(n.getKey()))
		{
			Nodes.put(n.getKey(), (nodeData)n);
			changes++;
		}
		else
			System.out.println("id number occupied");
	}

	/**
	 * This method creates new edge between src vertex and dest vertex.
	 * @param key-we chose blindly the key for each edge
	 */
	@Override
	public void connect(int src, int dest, double w) 
	{
		if(w<0)
			throw new RuntimeException("invalid weight: should be a non negative number");
		node_data dst=Nodes.get(dest);
		node_data source=Nodes.get(src);

		edgeData value=new edgeData(source, dst, w);
		if(source!=null && dst!=null && srcMap.containsKey(src))
		{
			if(!srcMap.get(src).containsKey(dest))
			{
				srcMap.get(src).put(dest,value);
				changes++;
				EdgesSize++;
			}
			else
				System.out.println("This edge already exist");
		}
		else if (!srcMap.containsKey(src))
		{
			HashMap<Integer,edge_data> map=new HashMap<>();
			map.put(dest,value);
			srcMap.put(src, map);
			changes++;
			EdgesSize++;
		}
		else
			System.out.println("invalid inserted vertices");

	}

	@Override
	public Collection<node_data> getV() 
	{
		return Nodes.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) 
	{
		if(srcMap.containsKey(node_id))
			return srcMap.get(node_id).values();
		return null;
	}

	@Override
	public node_data removeNode(int key) 
	{
		if(Nodes.containsKey(key))
		{
			srcMap.remove(key);
			for(Entry<Integer, HashMap<Integer, edge_data>> entry : srcMap.entrySet()) 
			{
				if(entry.getValue().containsKey(key))
					entry.getValue().remove(key);
			}
			changes++;
			return Nodes.remove(key);
		}
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) 
	{
		node_data dst=Nodes.get(dest);
		node_data source=Nodes.get(src);
		if(source!=null && dst!=null)
		{
			edge_data edge=srcMap.get(src).get(dest);
			if(edge!=null)
			{
				changes++;
				EdgesSize--;
				return srcMap.get(src).remove(dest);
			}
		}
		return null;
	}

	@Override
	public int nodeSize() 
	{
		return Nodes.size();
	}

	@Override
	public int edgeSize() 
	{
		return EdgesSize; 
	}

	@Override
	public int getMC() 
	{
		return changes;
	}
	public String toString()
	{
		String ans="";
		for(Entry<Integer, HashMap<Integer, edge_data>> e: srcMap.entrySet())
		{
			ans+=e.getValue().toString();
		}
		return "Edges"+ans+"\n"+"Nodes:\n"+Nodes.toString();
	}

}
