/*
	 *
	 * 0=bottom right angle
	 * 1=top left angle
	 * 2=hypotenuse
	 * 3=bottom side
	 * 4=left side
	 *
	 *SOH CAH TOA
*/
public class TriangleSolver {
	double[] numbs = new double[5];
	TriangleSolver(double[] sent)
	{
		numbs=sent;
		if (numbs[0]==0)
		{
			get0();
		}
		if (numbs[1]==0)
		{
			get1();
		}
		if (numbs[2]==0)
		{
			get2();
		}
		if (numbs[3]==0)
		{
			get3();
		}
		if (numbs[4]==0)
		{
			get4();
		}
		round();
		
	}
	public void get0()
	{
		if (numbs[1]!=0)
		{
			numbs[0]=90-numbs[1];
		}
		else
		{
			if(numbs[2]!=0&& numbs[3]!=0)
			{
				numbs[0]=Math.toDegrees(Math.acos(numbs[3]/numbs[2]));
			}
			else
			{
				if(numbs[3]!=0&& numbs[4]!=0)
				{
					numbs[0]=Math.toDegrees(Math.atan(numbs[4]/numbs[3]));
				}
				else
				{
					if(numbs[2]!=0&& numbs[4]!=0)
					{
						numbs[0]=Math.toDegrees(Math.asin((numbs[4]/numbs[2])));
					}
				}
			}
		}
	}
	public void get1()
	{
		if (numbs[0]!=0)
		{
			numbs[1]=90-numbs[0];
		}
		else
		{
			if(numbs[2]!=0&& numbs[3]!=0)
			{
				numbs[0]=Math.toDegrees(Math.asin((numbs[3]/numbs[2])));
			}
			else
			{
				if(numbs[3]!=0&& numbs[4]!=0)
				{
					numbs[0]=Math.toDegrees(Math.atan((numbs[3]/numbs[4])));
				}
				else
				{
					if(numbs[2]!=0&& numbs[4]!=0)
					{
						numbs[0]=Math.toDegrees(Math.acos((numbs[4]/numbs[2])));
					}
				}
			}
		}
	}
	public void get2()
	{
		if (numbs[4]!=0&&numbs[3]!=0)
		{
			numbs[2]=Math.sqrt(numbs[4]*numbs[4]+numbs[3]*numbs[3]);
		}
		else
		{
			if(numbs[1]!=0)
			{
				if(numbs[4]!=0)
				{
					numbs[2]=numbs[4]/Math.cos(Math.toRadians(numbs[1]));
				}
				else
				{
					if(numbs[3]!=0)
					{

						numbs[2]=numbs[3]/Math.sin(Math.toRadians(numbs[1]));
					}
				}	
			}
			else
			{

				if(numbs[0]!=0)
				{
					if(numbs[4]!=0)
					{
						numbs[2]=numbs[4]/Math.sin(Math.toRadians(numbs[0]));
					}
					else
					{
						if(numbs[3]!=0)
						{
							numbs[2]=numbs[3]/Math.cos(Math.toRadians(numbs[0]));
						}
					}
					
				}
			}
		}
	}
	public void get3()
	{
		if(numbs[2]!=0&&numbs[4]!=0)
		{
			numbs[3]=Math.sqrt((numbs[2]*numbs[2])-(numbs[4]*numbs[4]));
		}
		else
		{
			if(numbs[1]!=0)
			{
				if(numbs[4]!=0)
				{
					numbs[3]=numbs[4]*Math.tan(Math.toRadians(numbs[1]));
				}
				else
				{
					if(numbs[2]!=0)
					{
						numbs[3]=numbs[2]*Math.sin(Math.toRadians(numbs[1]));
					}
				}	
			}
			else
			{
				if(numbs[0]!=0)
				{
					if(numbs[4]!=0)
					{
						numbs[3]=numbs[4]/Math.tan(Math.toRadians(numbs[0]));
					}
					else
					{
						if(numbs[2]!=0)
						{
							numbs[3]=numbs[2]*Math.cos(Math.toRadians(numbs[0]));
						}
					}
					
				}
			}
		}
	}
	public void get4()
	{
		if (numbs[2]!=0&&numbs[3]!=0)
		{
			numbs[4]=Math.sqrt(numbs[2]*numbs[2]-numbs[3]*numbs[3]);
		}
		else 
		{
			if(numbs[0]!=0)
			{
				if(numbs[3]!=0)
				{
					numbs[4]=numbs[3]*Math.tan(Math.toRadians(numbs[0]));
				}
				else
				{
					if(numbs[2]!=0)
					{
						numbs[4]=numbs[2]*Math.sin(Math.toRadians(numbs[0]));
					}
				}
			}
			else
			{
				if(numbs[1]!=0)
				{
					if(numbs[3]!=0)
					{
						numbs[4]=numbs[3]/Math.tan(Math.toRadians(numbs[1]));
					}
					else
					{
						if(numbs[2]!=0)
						{
							numbs[4]=numbs[2]*Math.cos(Math.toRadians(numbs[1]));
						}
					}
				}
			}
		}
	}
	public void round()
	{
		for (int i =0; i<5; i++)
		{
			numbs[i]=(double)Math.round(numbs[i] * 1000000000) / 1000000000;	
		}
	}
	public double[] getResults()
	{
		return numbs;
	}
}
