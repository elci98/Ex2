package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import elements.nodeData;
import utils.Point3D;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class nodeDataTest 
{

	static Point3D p;
	static nodeData[] node =new nodeData[10];
	@BeforeAll
	static void init()
	{
		for(int i=0;i<10;i++)
		{
			p=new Point3D(i,2*i,3*i);
			node[i]=new nodeData(p,i,0);
		}
	}
	@Test
	void testNodeData() 
	{
		for(int i=0;i<10;i++)
		{
			assertTrue(node[i]!=null);
		}
	}

	@Test
	void testGetKey() 
	{
		for(int i=0;i<10;i++)
		{
			int actual=node[i].getKey();
			int expected=i;
			assertEquals(expected,actual);
		}
	}

	@Test
	void getLocationTest() 
	{
		for(int i=0;i<10;i++)
		{
			int actual=node[i].getLocation().ix();
			int expected=i;
			assertEquals(expected,actual);
			actual=node[i].getLocation().iy();
			expected=2*i;
			assertEquals(expected,actual);
			actual=node[i].getLocation().iz();
			expected=3*i;
			assertEquals(expected,actual);
		}
	}

	@Test
	void testSetLocation() 
	{
		Point3D p1;
		for(int i=0;i<10;i++)
		{
			p1=new Point3D(4*i,5*i,6*i);
			node[i].setLocation(p1);
		}
		for(int i=0;i<10;i++)
		{
			int actual=node[i].getLocation().ix();
			int expected=4*i;
			assertEquals(expected,actual);
			actual=node[i].getLocation().iy();
			expected=5*i;
			assertEquals(expected,actual);
			actual=node[i].getLocation().iz();
			expected=6*i;
			assertEquals(expected,actual);
		}
	}

	@Test
	void getWeightTest() 
	{
		for(int i=0;i<10;i++)
		{
			double actual=node[i].getWeight();
			double expected=0;
			assertEquals(expected,actual);	
		}
		
	}

	@Test
	void testSetWeight() 
	{
		for(int i=0;i<10;i++)
		{
			node[i].setWeight(i*0.5);
		}
		for(int i=0;i<10;i++)
		{
			double actual=node[i].getWeight();
			double expected=i*0.5;
			assertEquals(expected,actual);	
		}
	}

}
