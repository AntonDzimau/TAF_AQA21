package entities;

import models.TestCase;


public class TestCasesEntities {
    public TestCase testCase1 = new TestCase.Builder()
            .withTitle("Czechau's Auto Test Case 1")
            .withPreconditions("Preconditions of Auto Test Case 1")
            .withPriority(1)
            .withType(0)
            .build();

    public TestCase testCase2 = new TestCase.Builder()
            .withTitle("Czechau's Auto Test Case 2")
            .withPreconditions("Preconditions of Auto Test Case 2")
            .withPriority("Low")
            .withType("Security")
            .build();

    public TestCase testCase3 = new TestCase.Builder()
            .withTitle("Czechau's Auto Test Case 3")
            .withPreconditions("Preconditions of Auto Test Case 3")
            .withPriority("crit")
            .withType("au")
            .build();

}
