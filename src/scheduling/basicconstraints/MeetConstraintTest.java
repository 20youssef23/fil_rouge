package scheduling.basicconstraints;

import scheduling.activities.Activity;

public class MeetConstraintTest {
    public static void main(String[] args) {
        Activity a1 = new Activity("S'échauffer", 10);
        Activity a2 = new Activity("Faire du sport", 60);

        MeetConstraint mc = new MeetConstraint(a1, a2);

        System.out.println("Test 1 (100, 110) : " + mc.isSatisfied(100, 110)); // true
        System.out.println("Test 2 (100, 111) : " + mc.isSatisfied(100, 111)); // false
        System.out.println("Test 3 (100, 100) : " + mc.isSatisfied(100, 100)); // false
    }
}
