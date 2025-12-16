package streams;

public class Address {
    public String plotNo;

    public Address(String plotNo) {
        this.plotNo = plotNo;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "plotNo='" + plotNo + '\'' +
                '}';
    }
}
