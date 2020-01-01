package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import algorithms.Graph_Algo;
import dataStructure.*;
import elements.nodeData;
import utils.Point3D;

@TestInstance(Lifecycle.PER_CLASS)// allows to declare BeforeAll params as non-static
class Graph_AlgoTest 
{
	graph g=new DGraph();
	Graph_Algo ga=new Graph_Algo();
	nodeData [] nodes = new nodeData[10];
	Point3D [] points=new Point3D[10];
	
	@BeforeAll
	void init()
	{
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
	}
	
	@Test
	void initGraphTest() 
	{
		ga.init(g);
		assertNotEquals(null,ga);
	}

	@Test
	void testInitSave() 
	{
		ga.init(g);
		ga.save("Graph_Algo.txt");
		Graph_Algo temp=new Graph_Algo();
		temp.init("Graph_Algo.txt");
		assertEquals(ga.toString(),temp.toString());
	}

	@Test
	void testIsConnected() 
	{
		Graph_Algo g1=new Graph_Algo();
		ga.init(g);
		graph f=ga.copy();
		g1.init(f);
		assertTrue(g1.isConnected());
		f.removeEdge(1, 10);
		assertFalse(g1.isConnected());
	}

	@Test
	void testShortestPathDist() 
	{
		ga.init(g);
		double []expected= {30.0, 54.0, 49.0, 61.0, 37.0};
		double []actual=new double[5];
		for(int i=0;i<5;i++)
		{
			actual[i]=ga.shortestPathDist(i+1, 10-i);
			assertEquals(expected[i], actual[i]);
		}
	}

	@Test
	void testShortestPath() 
	{
		ga.init(g);
		String []expected= {"[ 1,  10]","[ 2,  1,  10,  8,  9]",
				"[ 3,  2,  1,  10,  8]","[ 4,  5,  3,  2,  6,  7]","[ 5,  3,  2,  6]"};
		ArrayList<List<node_data>> actual=new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			actual.add(ga.shortestPath(i+1, 10-i));
			assertEquals(expected[i], actual.get(i).toString());
		}
	}

	@Test
	void testTSP() 
	{
		List<Integer> list=new ArrayList<>();
		ga.init(g);
		for(int i=4;i<11;i++)
		{
		//creates targets list --->[4,5,6,7,8,9,10] which as sub graph is NOT strongly connected
			list.add(g.getNode(i).getKey());
		}
		Object expected=null;
		Object actual=ga.TSP(list);
		assertEquals(expected,actual);
		//create targets list --->[1,2,10,9,8,6] which as sub graph is strongly connected.
		list=new ArrayList<>();
		list.add(g.getNode(1).getKey());
		list.add(g.getNode(2).getKey());
		list.add(g.getNode(10).getKey());
		list.add(g.getNode(9).getKey());
		list.add(g.getNode(8).getKey());
		list.add(g.getNode(6).getKey());
		expected= "[ 1,  2,  1,  10,  8,  9,  2,  6]";
		actual=ga.TSP(list).toString();
		assertEquals(expected,actual);	
	}

	@Test
	void testCopy() 
	{
		ga.init(g);
		graph f=ga.copy();
		Graph_Algo temp= new Graph_Algo(f);
	/*comparing objects addresses, if returns true i.e g and temp are two different objects*/
		assertNotEquals(g, f); 
	/*comparing objects toString which actually comparing the content of both objects */
		assertEquals(ga, temp);
	}
}
