package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.node_data;
import elements.nodeData;
import utils.Point3D;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class DGraphTest 
{
	static DGraph dg=new DGraph();
	static Point3D [] points=new Point3D[10];
	static nodeData []vertices=new nodeData[10];

	@BeforeAll
	static void init()
	{
		for(int i=0;i<10;i++)
		{
			points[i]=new Point3D (i,i+1);
			vertices[i]=new nodeData(points[i],i,0);
			dg.addNode(vertices[i]);
		}
		for(int i=1;i<5;i++)
		{
			dg.connect(i+1, 2*i, 2*i);
			dg.connect(2*i-1, i+1, 4*i);
		}
	}


	@Test
	void getNodeTest()
	{
		for(int i= 0;i<10;i++)
		{
			node_data n=vertices[i];
			assertTrue(n!=null);
		}
	}

	@Test
	void connectTest()
	{
		for(int i=1;i<5;i++)
		{
			assertNotEquals(null, dg.getEdge(i+1, 2*i));
			assertNotEquals(null, dg.getEdge(2*i-1, i+1));
		}


	}
	@Test
	void getEdge()
	{
		for(int i=1;i<5;i++)
		{
			edge_data edge1 =dg.getEdge(i+1, 2*i);
			edge_data edge2 =dg.getEdge(2*i-1, i+1);
			assertTrue(edge1!=null);
			assertTrue(edge2!=null);
		}

	}

	@Test
	void addNodeTest()
	{
		for(int i=0;i<10;i++)
		{
			assertNotEquals(null, dg.getNode(i));
		}
	}


	@Test
	void getVTest()
	{
		Collection<node_data> vrtx=dg.getV();
		for(int i=0;i<1;i++)
		{
			assertTrue(vrtx.contains(vertices[i]));
		}
	}

	@Test
	void getETest()
	{
		for(node_data node : dg.getV())
		{
			if(dg.getE(node.getKey())!=null)
			{
				for(edge_data edge: dg.getE(node.getKey()))
				{
					int expected = node.getKey();
					int actual = edge.getSrc();
					assertEquals(expected, actual);
				}
			}
		}
	}
	@Test
	void nodeSizeTest()
	{
		assertEquals(10, dg.nodeSize());
	}

	@Test
	void edgeSizeTest()
	{
		assertEquals(8, dg.edgeSize());
	}
	@Test
	void testRemoveNode()
	{
		for(int i=0;i<10;i++) 
		{
			dg.removeNode(i);
			assertEquals(null, dg.getNode(i));
		}
	}

	@Test
	void testRemoveEdge()
	{
		for(int i=1;i<5;i++)
		{
			dg.removeEdge(i, 2*i);
			dg.removeEdge(2*i-1, i+1);
			assertEquals(null,dg.getEdge(i, 2*i));
			assertEquals(null,dg.getEdge(2*i-1, i+1));
		}
	}



	@Test
	void testGetMC()
	{
		assertEquals(18,dg.getMC());
	}


}