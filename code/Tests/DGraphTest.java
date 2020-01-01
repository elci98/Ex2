package Tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.node_data;
import elements.nodeData;
import utils.Point3D;

@TestInstance(Lifecycle.PER_CLASS) // allows to declare BeforeAll params as non-static
class DGraphTest 
{
	DGraph dg=new DGraph();
	Point3D [] points=new Point3D[10];
	nodeData []vertices=new nodeData[10];

	@BeforeAll
	void init()
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
		for(int i=0;i<10;i++)
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
		for(int i=0;i<vrtx.size();i++)
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
	
	/**
	 * those two tests (RemoveEdge,RemoveNode) are independent,
	 * since the removal of edges or vertices from the global graph causes bugs.
	 * 
	 * */
	
	@Test
	void testRemoveNode()
	{
		DGraph d=new DGraph();
		Point3D [] p=new Point3D[10];
		nodeData []v=new nodeData[10];
		for(int i=0;i<10;i++)
		{
			p[i]=new Point3D (i,i+1);
			v[i]=new nodeData(p[i],i,0);
			d.addNode(v[i]);
		}
		for(int i=0;i<10;i++) 
		{
			d.removeNode(i);
			assertEquals(null, d.getNode(i));
		}
	}

	@Test
	void testRemoveEdge()  
	{
		DGraph d=new DGraph();
		Point3D [] p=new Point3D[10];
		nodeData []v=new nodeData[10];
		for(int i=0;i<10;i++)
		{
			p[i]=new Point3D (i,i+1);
			v[i]=new nodeData(p[i],i,0);
			d.addNode(v[i]);
		}
		for(int i=1;i<5;i++)
		{
			d.connect(i+1, 2*i, 2*i);
			d.connect(2*i-1, i+1, 4*i);
		}
		for(int i=1;i<5;i++)
		{
			d.removeEdge(i, 2*i);
			d.removeEdge(2*i-1, i+1);
			assertEquals(null,d.getEdge(i, 2*i));
			assertEquals(null,d.getEdge(2*i-1, i+1));
		}
	}

	@Test
	void testGetMC()
	{
		assertEquals(18,dg.getMC());
	}
}