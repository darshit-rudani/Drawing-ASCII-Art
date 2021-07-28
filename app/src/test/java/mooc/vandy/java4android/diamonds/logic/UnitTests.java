package mooc.vandy.java4android.diamonds.logic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import io.magnum.autograder.junit.Rubric;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UnitTests {
    // The variables that are used in each test.
    TestingOutputInterface mOutput = new TestingOutputInterface();
    Logic mLogic = new Logic(mOutput);

    @Rubric(
            value = "randomTest",
            goal = "The goal of this evaluation is to test that your Diamonds are independent",
            points = 10.0,
            reference = "This Test fails when: your code is dependent on the order in which the tests are run"
    )
    @Test(timeout = 2000)
    public void randomTest() {
        ArrayList<Runnable> tests = new ArrayList<>();
        tests.add(this::testDiamond1);
        tests.add(this::testDiamond2);
        tests.add(this::testDiamond3);
        tests.add(this::testDiamond4);
        tests.add(this::testDiamond5);
        tests.add(this::testDiamond6);
        tests.add(this::testDiamond7);
        tests.add(this::testDiamond8);
        Collections.shuffle(tests);
        for (Runnable test : tests) {
            test.run();
        }
    }

    @Rubric(
            value = "testDiamond1",
            goal = "The goal of this evaluation is to test Diamond 1",
            points = 10.0,
            reference = "This Test fails when: The Diamond size 1 is wrong"
    )
    @Test(timeout = 100)
    public void testDiamond1() {
        ArrayList<String> actual = new ArrayList<>();

        String[] expected = {
                "+--+",
                "|<>|",
                "+--+"};

        mOutput.resetText();
        mLogic.process(1);

        try {
            String output = mOutput.getString();
            Scanner scanner = new Scanner(output);
            while (scanner.hasNext()) {
                actual.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assertEquals("Failed to produce the expected number of lines of output",
                expected.length, actual.size());
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual.get(i));
        }
    }

    @Rubric(
            value = "testDiamond2",
            goal = "The goal of this evaluation is to test Diamond 2",
            points = 10.0,
            reference = "This Test fails when: The Diamond size 2 is wrong"
    )
    @Test(timeout = 100)
    public void testDiamond2() {
        ArrayList<String> actual = new ArrayList<>();

        String[] expected = {
                "+----+",
                "| /\\ |",
                "|<-->|",
                "| \\/ |",
                "+----+"};

        String output;

        mOutput.resetText();
        mLogic.process(2);

        try {
            output = mOutput.getString();
            Scanner scanner = new Scanner(output);
            while (scanner.hasNext()) {
                actual.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assertEquals("Failed to produce the expected number of lines of output",
                expected.length, actual.size());
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual.get(i));
        }
    }

    @Rubric(
            value = "testDiamond4",
            goal = "The goal of this evaluation is to test Diamond 4",
            points = 10.0,
            reference = "This Test fails when: The Diamond size 4 is wrong"
    )
    @Test(timeout = 100)
    public void testDiamond4() {
        ArrayList<String> actual = new ArrayList<>();

        String[] expected = {
                "+--------+",
                "|   /\\   |",
                "|  /--\\  |",
                "| /====\\ |",
                "|<------>|",
                "| \\====/ |",
                "|  \\--/  |",
                "|   \\/   |",
                "+--------+"};

        String output;

        mOutput.resetText();
        mLogic.process(4);

        try {
            output = mOutput.getString();
            Scanner scanner = new Scanner(output);
            while (scanner.hasNext()) {
                actual.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assertEquals("Failed to produce the expected number of lines of output",
                expected.length, actual.size());
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual.get(i));
        }
    }

    @Rubric(
            value = "testDiamond5",
            goal = "The goal of this evaluation is to test Diamond 5",
            points = 10.0,
            reference = "This Test fails when: The Diamond size 5 is wrong"
    )
    @Test(timeout = 100)
    public void testDiamond5() {
        ArrayList<String> actual = new ArrayList<>();

        String[] expected = {
                "+----------+",
                "|    /\\    |",
                "|   /--\\   |",
                "|  /====\\  |",
                "| /------\\ |",
                "|<========>|",
                "| \\------/ |",
                "|  \\====/  |",
                "|   \\--/   |",
                "|    \\/    |",
                "+----------+"};

        String output;

        mOutput.resetText();
        mLogic.process(5);

        try {
            output = mOutput.getString();
            Scanner scanner = new Scanner(output);
            while (scanner.hasNext()) {
                actual.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assertEquals("Failed to produce the expected number of lines of output",
                expected.length, actual.size());
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual.get(i));
        }
    }

    @Rubric(
            value = "testDiamond3",
            goal = "The goal of this evaluation is to test Diamond 3",
            points = 10.0,
            reference = "This Test fails when: The Diamond size 3 is wrong"
    )
    @Test(timeout = 100)
    public void testDiamond3() {
        ArrayList<String> actual = new ArrayList<>();

        String[] expected = {
                "+------+",
                "|  /\\  |",
                "| /--\\ |",
                "|<====>|",
                "| \\--/ |",
                "|  \\/  |",
                "+------+"};

        String output;

        mOutput.resetText();
        mLogic.process(3);

        try {
            output = mOutput.getString();
            Scanner scanner = new Scanner(output);
            while (scanner.hasNext()) {
                actual.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assertEquals("Failed to produce the expected number of lines of output",
                expected.length, actual.size());
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual.get(i));
        }
    }

    @Rubric(
            value = "testDiamond6",
            goal = "The goal of this evaluation is to test Diamond 6",
            points = 10.0,
            reference = "This Test fails when: The Diamond size 6 is wrong"
    )
    @Test(timeout = 100)
    public void testDiamond6() {
        ArrayList<String> actual = new ArrayList<>();

        String[] expected = {
                "+------------+",
                "|     /\\     |",
                "|    /--\\    |",
                "|   /====\\   |",
                "|  /------\\  |",
                "| /========\\ |",
                "|<---------->|",
                "| \\========/ |",
                "|  \\------/  |",
                "|   \\====/   |",
                "|    \\--/    |",
                "|     \\/     |",
                "+------------+"};

        String output;

        mOutput.resetText();
        mLogic.process(6);

        try {
            output = mOutput.getString();
            Scanner scanner = new Scanner(output);
            while (scanner.hasNext()) {
                actual.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assertEquals("Failed to produce the expected number of lines of output",
                expected.length, actual.size());
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual.get(i));
        }
    }

    @Rubric(
            value = "testDiamond7",
            goal = "The goal of this evaluation is to test Diamond 7",
            points = 10.0,
            reference = "This Test fails when: The Diamond size 7 is wrong"
    )
    @Test(timeout = 100)
    public void testDiamond7() {
        ArrayList<String> actual = new ArrayList<>();

        String[] expected = {
                "+--------------+",
                "|      /\\      |",
                "|     /--\\     |",
                "|    /====\\    |",
                "|   /------\\   |",
                "|  /========\\  |",
                "| /----------\\ |",
                "|<============>|",
                "| \\----------/ |",
                "|  \\========/  |",
                "|   \\------/   |",
                "|    \\====/    |",
                "|     \\--/     |",
                "|      \\/      |",
                "+--------------+"};

        String output;

        mOutput.resetText();
        mLogic.process(7);

        try {
            output = mOutput.getString();
            Scanner scanner = new Scanner(output);
            while (scanner.hasNext()) {
                actual.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assertEquals("Failed to produce the expected number of lines of output",
                expected.length, actual.size());
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual.get(i));
        }
    }

    @Rubric(
            value = "testDiamond8",
            goal = "The goal of this evaluation is to test Diamond 8",
            points = 10.0,
            reference = "This Test fails when: The Diamond size 8 is wrong"
    )
    @Test(timeout = 100)
    public void testDiamond8() {
        ArrayList<String> actual = new ArrayList<>();

        String[] expected = {
                "+----------------+",
                "|       /\\       |",
                "|      /--\\      |",
                "|     /====\\     |",
                "|    /------\\    |",
                "|   /========\\   |",
                "|  /----------\\  |",
                "| /============\\ |",
                "|<-------------->|",
                "| \\============/ |",
                "|  \\----------/  |",
                "|   \\========/   |",
                "|    \\------/    |",
                "|     \\====/     |",
                "|      \\--/      |",
                "|       \\/       |",
                "+----------------+"};

        String output;

        mOutput.resetText();
        mLogic.process(8);

        try {
            output = mOutput.getString();
            Scanner scanner = new Scanner(output);
            while (scanner.hasNext()) {
                actual.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        assertEquals("Failed to produce the expected number of lines of output",
                expected.length, actual.size());
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual.get(i));
        }
    }

    private static class TestingOutputInterface implements OutputInterface {
        String output = "";

        public String getString() {
            return output;
        }

        //@Override
        public void resetText() {
            output = "";
        }

        //@Override
        public void print(Object obj) {
            output += (obj != null ? obj.toString() : "null");
        }
    }
}
