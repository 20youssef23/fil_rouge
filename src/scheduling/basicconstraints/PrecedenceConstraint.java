package scheduling.basicconstraints;

import scheduling.activities.Activity;

public class PrecedenceConstraint{
	private Activity firstActivity;
	private Activity secondActivity;
	
	public PrecedenceConstraint(Activity firstActivity, Activity secondActivity){
		this.firstActivity = firstActivity;
		this.secondActivity = secondActivity;
	}
	
	public Activity getFirst(){
		return firstActivity;
	}
	
	public Activity getSecond(){
		return secondActivity;
	}
	
	public boolean isSatisfied(int start1, int start2){
		int fin1 = start1 + firstActivity.getDuration();
		return start2 >= fin1;
	} 
	
}
