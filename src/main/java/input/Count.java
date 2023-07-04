package input;

public class Count {

    private int tryCount;

    private String st;
    public Count (String count) {
        this.tryCount = toInt(count);
    }

    private int toInt (String count) {
        int num = Integer.parseInt(count);
        if (num < 0) throw new RuntimeException();
        return num;
    }

    public int getTryCount() {
        return this.tryCount;
    }

}
