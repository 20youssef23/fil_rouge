package scheduling.basicconstraints;

import scheduling.activities.Activity;
import schedulingtests.basicconstraints.PrecedenceConstraintTests;

public class PrecedenceConstraintTest {
    public static void main(String[] args) {
        Activity a1 = new Activity("Aller à l'université", 15);
        Activity a2 = new Activity("Attacher le vélo", 1);

        PrecedenceConstraint pc = new PrecedenceConstraint(a1, a2);

        System.out.println("Test 1 (500, 515) : " + pc.isSatisfied(500, 515)); 
        System.out.println("Test 2 (500, 510) : " + pc.isSatisfied(500, 510)); 
        System.out.println("Test 3 (500, 518) : " + pc.isSatisfied(500, 518));

        boolean ok = true;
        PrecedenceConstraintTests precedenceTester = new PrecedenceConstraintTests();
        ok = ok && precedenceTester.testGetFirst();
        ok = ok && precedenceTester.testGetSecond();
        ok = ok && precedenceTester.testIsSatisfiedBy();
        System.out.println(ok ? "All tests passed" : "At least one test failed");

    }
}
