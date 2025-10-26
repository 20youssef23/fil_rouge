package scheduling.factoredconstraints;

import scheduling.activities.Activity;

public class BinaryConstraint{
    protected Activity firstActivity;
    protected Activity secondActivity;

    public BinaryConstraint(Activity firstActivity, Activity secondActivity){
        this.firstActivity = firstActivity;
        this.secondActivity = secondActivity;
    }
    public Activity getFirst(){
        return firstActivity;
    }
    public Activity getSecond(){
        return secondActivity;
    }
    public abstract boolean isSatisfied(int start1, int start2);
}