package scheduling.activities;

import schedulingtests.activities.ActivityTests; // Import du fichier de tests fourni dans le .jar

public class ActivityTest {

    public static void main(String[] args) {

        testActivityManual("Aller à l'université", 15);
        testActivityManual("Attacher le vélo", 1);

        boolean ok = true;
        ActivityTests activityTester = new ActivityTests();
        ok = ok && activityTester.testGetDescription();
        ok = ok && activityTester.testGetDuration();
        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }


    public static void testActivityManual(String description, int duration) {
        Activity activity = new Activity(description, duration);
        System.out.println("Description : " + activity.getDescription());
        System.out.println("Durée : " + activity.getDuration() + " minutes");
    }
}
