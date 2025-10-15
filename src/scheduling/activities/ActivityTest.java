package scheduling.activities;

import schedulingtests.activities.ActivityTests;

public class ActivityTest {
    public static void main(String[] args) {
        boolean ok = true;
        ActivityTests activityTester = new ActivityTests();
        ok = ok && activityTester.testGetDescription();
        ok = ok && activityTester.testGetDuration();
        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }
}
