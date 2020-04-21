package main;

import java.util.ArrayList;

/**
 * A Sample represents a vector of doubles to be used in a clustering algorithm...
 * @author presenting
 *
 */

public class Sample {
	double[] sample;
	double distance=999999999;
	Sample closest;
	public Sample(double[] values) {
		this.sample=new double[values.length];
		for (int i=0; i<values.length; i++) {
			sample[i]=values[i];
		}

	}
	public Sample() {
		
	}
	/**
	 * Find the closest cluster point
	 * @param temp
	 */
	public void closest(ArrayList<Sample> temp)
	{
		for(int i=0;i<temp.size();i++)
		{
			Sample curr=temp.get(i);
			if(distance>getDistance(curr))
			{
				distance=getDistance(curr);
				closest=curr;
			}
		}
	}

	/**
	 * caluculate the distance to given point
	 * @param x
	 * @return
	 */
	public double getDistance(Sample x){
	    double sdistance = 0;
	    double[] a=sample;
	    double[] b=x.sample;
		for(int i=0; i<a.length;i++){
			sdistance+=(a[i]-b[i])*(a[i]-b[i]);
		}
		sdistance=Math.sqrt(sdistance);
		return sdistance;
	}
	
	/**
	 * compare two point
	 * @param x
	 * @return
	 */
	public boolean equalTo(Sample x)
	{
		if(this.sample.equals(x.sample))
		{
			return true;
		}
		else
			return false;
	}


}
