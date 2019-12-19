package dataStructure;

public class edgeData implements edge_data 
{
	private nodeData _src,_dest;
	private int _tag;
	private double _weight;
	private String _info;
	public edgeData(nodeData src, nodeData dest, double weight, int tag, String info)
	{
		_src=src;
		_dest=dest;
		_weight=weight;
		_tag=tag;
		_info=info;
	}
	@Override
	public int getSrc() 
	{
		return _src.getKey();
	}

	@Override
	public int getDest() 
	{
		return _dest.getKey();
	}

	@Override
	public double getWeight() 
	{
		return _weight;
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
		if(t>0)
			_tag=t;
		else
			System.out.println("invalid inserted tag");
	}

}
