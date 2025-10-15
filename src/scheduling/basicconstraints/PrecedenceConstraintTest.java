package scheduling.basicconstraints;

import scheduling.activities.Activity;

public class PrecedenceConstraintTest {
    public static void main(String[] args) {
        Activity a1 = new Activity("Aller à l'université", 15);
        Activity a2 = new Activity("Attacher le vélo", 1);

        PrecedenceConstraint pc = new PrecedenceConstraint(a1, a2);

        System.out.println("Test 1 (500, 515) : " + pc.isSatisfied(500, 515)); // true
        System.out.println("Test 2 (500, 510) : " + pc.isSatisfied(500, 510)); // false
        System.out.println("Test 3 (500, 518) : " + pc.isSatisfied(500, 518)); // true
    }
}
