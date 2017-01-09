package com.wuxy13.prime.utils;

public class PrimeGenerator {
	private boolean[] crossedOut;
	private int[] result;
	
	public boolean[] getCrossedOut(){
		return crossedOut;
	}
	
	public int[] getResult(){
		return result;
	}
	
	public int[] generatePrimes(int maxValue){
		if(maxValue<2){
			result=null;
		}
		else{
			uncrossIntergerUpTo(maxValue);
			crossOutMultiples();
			putUncrossedIntergerIntoResult();
		}
		
		return result;
	}
	
	public void uncrossIntergerUpTo(int maxValue){
		crossedOut=new boolean[maxValue+1];
		for(int i=0;i<crossedOut.length;i++){
			crossedOut[i]=false;
		}
		crossedOut[0]=crossedOut[1]=true;
	}
	
	public void crossOutMultiples(){
		for(int i=2;i<determineIteratorLimit();i++){
			if(notCrossed(i)){
				crossOutMultiplesOf(i);
			}
		}
	}
	
	public int determineIteratorLimit(){return (int)Math.sqrt(crossedOut.length)+1;}
	
	public void crossOutMultiplesOf(int index){
		for(int i=2*index;i<crossedOut.length;i+=index){
			crossedOut[i]=true;
		}
	} 
	
	public boolean notCrossed(int index){return crossedOut[index]==false;}
	
	public void putUncrossedIntergerIntoResult(){
		result=new int[NumberOfUncrossedIntergers()];
		int index=0;
		for(int i=0;i<crossedOut.length;i++){
			if(notCrossed(i)){
				result[index++]=i;
			}
		}
	} 
	public int NumberOfUncrossedIntergers(){
		int count=0;
		for(int i=0;i<crossedOut.length;i++){
			if(notCrossed(i)){
				count++;
			}
		}
		return count;}

}
