package basics.pojo;


/*
* Create POJO: TestResult

    * Fields:
    String id
    String status (pass / fail)
    String module (example: Login, Payments)

* Must include:
    constructor
    getters
    toString() optional
*
* */
public class TestResult {
    // fields
    private final String id;
    private final String status;
    private final String module;


    // initialize objects
    public TestResult(String id, String status, String module) {
        this.id = id;
        this.status = status;
        this.module = module;
    }

    // getter methods
    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getModule() {
        return module;
    }
}
