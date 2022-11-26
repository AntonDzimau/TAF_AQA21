package entities;


import models.TestCase;

public class TestCasesEntities {
    public TestCase testCaseType6 = TestCase.builder()
            .title("Login successful")
            .type(6)
            .priority(1)
            .references("RFC-1, RFC-2")
            .build();

    public TestCase testCaseType3 = TestCase.builder()
            .title("Add project")
            .type(3)
            .priority(2)
            .references("RFC-3, RFC-4")
            .build();
}
