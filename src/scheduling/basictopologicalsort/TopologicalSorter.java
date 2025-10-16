package scheduling.basictopologicalsort;

import scheduling.activities.Activity;
import scheduling.basicconstraints.PrecedenceConstraint;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;

public class TopologicalSorter {
    
    public TopologicalSorter() {
    }
    
    public ArrayList<Activity> bruteForceSort(HashSet<Activity> activities , HashSet<PrecedenceConstraint> constraints){
        HashSet<Activity> copyActivity = new HashSet<>(activities);
        ArrayList<Activity> res = new ArrayList<>();

        while(!copyActivity.isEmpty()){
            Activity available = findActivity(copyActivity, res, constraints);

            if(available == null){
                return null;
            }else {
                res.add(available);
                copyActivity.remove(available);
            }
        }
        return res;
    }
    public Activity findActivity(HashSet<Activity> copyAcctivity, ArrayList<Activity> res , HashSet<PrecedenceConstraint> constraints){
        for (Activity a : copyAcctivity){
            boolean found = true;

            for (PrecedenceConstraint constraint : constraints){
                if(constraint.getSecond() == a && !res.contains(constraint.getFirst())){
                    found = false;
                    break;
                }
            }
            if(found){
                return a;
            }
        }
        return null;
    }

    public HashMap<Activity,Integer> schedule(HashSet<Activity> activities, HashSet<PrecedenceConstraint> constraints, int startDate){

        ArrayList<Activity> orderActivities = bruteForceSort(activities, constraints);

        HashMap<Activity,Integer> time = new HashMap<>();
        int currentTime = startDate;

        for(Activity a : orderActivities){
            int earliestStart = startDate;

            for(PrecedenceConstraint constraint : constraints){
                if(constraint.getSecond() == a){
                    Activity first = constraint.getFirst();
                    int endtime = time.get(first) + first.getDuration();
                    earliestStart = Math.max(earliestStart, endtime);
                }
            }
            time.put(a, earliestStart);
        }
        return time;
    }

}