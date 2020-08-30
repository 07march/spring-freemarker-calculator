package by.learn.entity;

public class Operation {

    private int num1;
    private int num2;
    private String operationType;
    private int result;

    public Operation(int num1, int num2, String operationType, int result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operationType = operationType;
        this.result = result;
    }

    public Operation() {
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operationType='" + operationType + '\'' +
                ", result=" + result +
                '}';
    }
}
