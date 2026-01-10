package interviewRound;


public class CoforgeTestExecution {

    private String testId;
    private String status;

    CoforgeTestExecution(String testId, String status) {
        this.testId = testId;
        this.status = status;
    }

    public String getTestId() {
        return testId;
    }

    public String getStatus() {
        return status;
    }
}
