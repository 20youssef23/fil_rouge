package scheduling.factoredconstraints;

import scheduling.activities.Activity;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint{
    private int minGap;
    private int maxGap;

    public PrecedenceConstraintWithGap(Activity firstActivity, Activity secondActivity,int minGap,int maxGap){
        super(firstActivity, secondActivity);
        this.minGap = minGap;
        this.maxGap = maxGap;
    }
    @Override
    public boolean isSatisfied(int start1, int start2){
        int duration1 = start1 + firstActivity.getDuration();
        int gap = start2 -duration1;

        return gap >= minGap && gap <= maxGap;
    }
}