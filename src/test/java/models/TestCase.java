package models;

import java.util.Objects;

public class TestCase {
    private String title;
    private String preconditions;
    private String steps;
    private String expectedResult;
    private int templateValueNumber;
    private String templateName;
    private int typeValueNumber;
    private String typeName;
    private int priorityValueNumber;
    private String priorityName;
    private int automationTypeValueNumber;
    private String automationTypeName;

    public static class Builder {
        private TestCase newTestCase;

        public Builder() {
            newTestCase = new TestCase();
        }

        public Builder withTitle(String value) {
            newTestCase.title = value;
            return this;
        }

        public Builder withPreconditions(String value) {
            newTestCase.preconditions = value;
            return this;
        }

        public Builder withSteps(String value) {
            newTestCase.steps = value;
            return this;
        }

        public Builder withExpectedResult(String value) {
            newTestCase.expectedResult = value;
            return this;
        }

        public Builder withTemplate(String value) {
            newTestCase.templateName = value;
            return this;
        }

        public Builder withTemplate(int value) {
            newTestCase.templateValueNumber = value;
            return this;
        }

        public Builder withType(String value) {
            newTestCase.typeName = value;
            return this;
        }

        public Builder withType(int value) {
            newTestCase.typeValueNumber = value;
            return this;
        }

        public Builder withPriority(String value) {
            newTestCase.priorityName = value;
            return this;
        }

        public Builder withPriority(int value) {
            newTestCase.priorityValueNumber = value;
            return this;
        }

        public Builder withAutomationType(String value) {
            newTestCase.automationTypeName = value;
            return this;
        }

        public Builder withAutomationType(int value) {
            newTestCase.automationTypeValueNumber = value;
            return this;
        }

        public TestCase build() {
            return newTestCase;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getPreconditions() {
        return preconditions;
    }

    public String getSteps() {
        return steps;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public int getTemplateValueNumber() {
        return templateValueNumber;
    }

    public String getTemplateName() {
        return templateName;
    }

    public int getTypeValueNumber() {
        return typeValueNumber;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getPriorityValueNumber() {
        return priorityValueNumber;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public int getAutomationTypeValueNumber() {
        return automationTypeValueNumber;
    }

    public String getAutomationTypeName() {
        return automationTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return templateValueNumber == testCase.templateValueNumber && typeValueNumber == testCase.typeValueNumber && priorityValueNumber == testCase.priorityValueNumber && automationTypeValueNumber == testCase.automationTypeValueNumber && Objects.equals(title, testCase.title) && Objects.equals(preconditions, testCase.preconditions) && Objects.equals(steps, testCase.steps) && Objects.equals(expectedResult, testCase.expectedResult) && Objects.equals(templateName, testCase.templateName) && Objects.equals(typeName, testCase.typeName) && Objects.equals(priorityName, testCase.priorityName) && Objects.equals(automationTypeName, testCase.automationTypeName);
    }

}
