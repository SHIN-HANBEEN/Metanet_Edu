package kr.or.kosa;

public class Tv {
    public int channel;
    public String brand;

    void channelUp() {
        this.channel += 1;
    }
    void channelDwn() {
        this.channel -= 1;
    }

    @Override
    public String toString() {
        return "Tv{" +
                "channel=" + channel +
                ", brand='" + brand + '\'' +
                '}';
    }
}
