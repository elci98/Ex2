package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
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
		ga.init(g);
		assertTrue(ga.isConnected());
	}

	@Test
	void testShortestPathDist() 
	{
		ga.init(g);
		double []expected=new double[5] ;
		double []actual=new double[5];
		for(int i=0;i<5;i++)
		{
			actual[i]=ga.shortestPathDist(i+1, 10-i);
			System.out.println(i+1+"------->"+(10-i)+" = "+actual[i]);
		}
		
	}

	@Test
	void testShortestPath() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testTSP() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testCopy() 
	{
		fail("Not yet implemented");
	}


}
