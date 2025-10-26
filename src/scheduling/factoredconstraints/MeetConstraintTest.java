package scheduling.factoredconstraints;

import scheduling.activities.Activity;
import schedulingtests.basicconstraints.MeetConstraintTests;

public class MeetConstraintTest {
    public static void main(String[] args) {
        Activity a1 = new Activity("S'échauffer", 10);
        Activity a2 = new Activity("Faire du sport", 60);

        MeetConstraint mc = new MeetConstraint(a1, a2);

        System.out.println("Test 1 (100, 110) : " + mc.isSatisfied(100, 110)); 
        System.out.println("Test 2 (100, 111) : " + mc.isSatisfied(100, 111)); 
        System.out.println("Test 3 (100, 100) : " + mc.isSatisfied(100, 100));

        boolean ok = true;
        MeetConstraintTests tester = new MeetConstraintTests();
        ok = ok && tester.testGetFirst();
        ok = ok && tester.testGetSecond();
        ok = ok && tester.testIsSatisfiedBy();
        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }
}
