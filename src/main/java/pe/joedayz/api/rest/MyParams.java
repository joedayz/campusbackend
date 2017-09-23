package pe.joedayz.api.rest;

public class MyParams {
    private String param1;
    private String param2;

    public MyParams() {
    }

    public MyParams(String param1, String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyParams myParams = (MyParams) o;

        if (!param1.equals(myParams.param1)) return false;
        return param2.equals(myParams.param2);

    }

    @Override
    public int hashCode() {
        int result = param1.hashCode();
        result = 31 * result + param2.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MyParams{" +
                "param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                '}';
    }
}
