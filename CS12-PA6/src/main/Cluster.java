package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of Samples (the one's closest to that sample point, ideally).
 * @author presenting
 *
 */
public class Cluster {
	 Sample s;
	 ArrayList<Sample> c;
	 ArrayList<Sample> temp;
public Cluster()
{
	this.s=new Sample();
	this.c=new ArrayList<Sample>();
	this.temp=new ArrayList<Sample>();
}

public Cluster(Sample x)
{
	this.s=x;
	this.c=new ArrayList<Sample>();
	this.temp=new ArrayList<Sample>();
	add(x);
}
/**
 * add sample in the cluster
 * @param x
 */
public void add(Sample x)
{
	c.add(x);
}

/**
 * Caluculate the average point
 * @return
 */
public Sample average()
{
	double x=0;
	double y=0;
	for(int i=0;i<c.size();i++)
	{
		x=x+c.get(i).sample[0];
		y=y+c.get(i).sample[1];
	}
	x=x/c.size();
	y=y/c.size();
	double[] a= {x,y};
	Sample s=new Sample(a);
	return s;
}

/**
 * find the closest cluster point
 */
public void findClosest()
{
	for(int i=0;i<c.size();i++)
	{
		if(temp.contains(c.get(i))!=true)
		{
			c.get(i).closest(temp);
		}
		
	}
}

/**
 * Random choose k cluster points
 * @param k
 */
public void randomPick(int k){
 Random r=new Random();
  for (int i=0;i<k;i++) {
	  int x=r.nextInt(c.size());
	  if(temp==null)
	  {
		  temp.add(c.get(x));
	  }
	  else
	  {
		  while(temp.contains(c.get(x)))
		  {
			 x=r.nextInt(c.size());
		  }
		  temp.add(c.get(x));
	  }
	 
  }
}

/**
 * print out the cluster
 */
public String toString()
{
	return c.toString();
}
}
