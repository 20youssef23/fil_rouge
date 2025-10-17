package scheduling.basictopologicalsort;

import scheduling.activities.Activity;
import scheduling.basicconstraints.PrecedenceConstraint;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;

public class TopologicalSorterTest {
    public static void main(String[] args) {
        TopologicalSorter topologicalSorter = new TopologicalSorter();

        Activity getUp = new Activity("get up", 1);
        Activity goToWork = new Activity("go to work", 15);
        Activity shower = new Activity("take a shower", 10);
        Activity brushTeeth = new Activity("brush teeth", 3);
        Activity getDressed = new Activity("get dressed", 2);
        Activity breakfast = new Activity("have breakfast", 15);


        HashSet<Activity> activities = new HashSet<>();
        activities.add(getUp);
        activities.add(goToWork);
        activities.add(shower);
        activities.add (brushTeeth);
        activities.add(getDressed);
        activities.add(breakfast);

        HashSet<PrecedenceConstraint> constraints = new HashSet<>();
        constraints.add(new PrecedenceConstraint(getUp,breakfast));
        constraints.add(new PrecedenceConstraint(getUp, getDressed));
        constraints.add(new PrecedenceConstraint(breakfast, brushTeeth));
        constraints.add(new PrecedenceConstraint(shower, getDressed));
        constraints.add(new PrecedenceConstraint(brushTeeth, goToWork));
        constraints.add(new PrecedenceConstraint(getDressed, goToWork));
        constraints.add(new PrecedenceConstraint(getUp, shower));
        constraints.add(new PrecedenceConstraint(breakfast, goToWork));

        ArrayList<Activity> order = topologicalSorter.bruteForceSort(activities,constraints);
        HashMap<Activity, Integer> schedule = topologicalSorter.schedule(activities,constraints,500);

        System.out.println("order et horaires");
        for (activities a : order){
            System.out.println(" " + a.getDescription() + ":" + schedule.get(a));
        }



    }
}
