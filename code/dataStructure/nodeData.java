package dataStructure;

import java.io.Serializable;

import utils.Point3D;

public class nodeData implements node_data,Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point3D _location;
	private int _key,_tag;
	private double _weight;
	private String _info;
	
	
	public nodeData(Point3D location, int key, int tag, double weight, String info)
	{
		_location=location;
		_key=key;
		_tag=tag;
		_weight=weight;
		_info=info;
	}
	@Override
	public int getKey() 
	{
		return _key;
	}

	@Override
	public Point3D getLocation() 
	{
		return _location;
	}

	@Override
	public void setLocation(Point3D p) 
	{
		_location=p;
	}

	@Override
	public double getWeight() 
	{
		return _weight;
	}

	@Override
	public void setWeight(double w) 
	{
		if(w>0)
			_weight=w;
		else
			System.out.println("invalid inserted weight");
	}

	@Override
	public String getInfo() 
	{
		return _info;
	}

	@Override
	public void setInfo(String s) 
	{
		_info=s;
	}

	@Override
	public int getTag() 
	{
		return _tag;
	}

	@Override
	public void setTag(int t) 
	{
		if(t>=0)
			_tag=t;
		else
			System.out.println("invalid inserted tag");
	}
	public String toString()
	{
		return " "+ _key+"";
	}

}
