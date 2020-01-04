package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import elements.*;
import utils.Point3D;

class edgeDataTest 
{
	static edgeData []edge=new edgeData[10];
	static Point3D p,p1;
	static nodeData src,dst;
	@BeforeAll
	static void init()
	{
		for(int i=0;i<10;i++)
		{
			p=new Point3D(i,i+1,i+2);
			src = new nodeData(p,i+1,1);
			p1=new Point3D(3*1,i+1,1+2.5);
			dst = new nodeData(p1,2*i+1,0);
			edge[i]=new edgeData(src,dst,3*i);
		}
	}


	@Test
	void testEdgeData() 
	{
		for(int i=0;i<10;i++)
		{
			assertTrue(edge[i]!=null);
		}
	}

	@Test
	void testGetSrc() 
	{
		for(int i=0;i<10;i++)
		{
			int actual=edge[i].getSrc();
			int expected=i+1;
			assertEquals(expected,actual);
		}
	}

	@Test
	void testGetDest() 
	{
		for(int i=0;i<10;i++)
		{
			int actual=edge[i].getDest();
			int expected=2*i+1;
			assertEquals(expected,actual);
		}
	}

	@Test
	void testGetWeight() 
	{
		for(int i=0;i<10;i++)
		{
			double actual=edge[i].getWeight();
			double expected=3*i;
			assertEquals(expected,actual);
		}
	}



}
