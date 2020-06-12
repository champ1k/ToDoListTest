package app;

public class User {

    private String address;
    private String ip;

    User(String ip, String address) {
        this.address = address;
        this.ip = ip;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return this.address;
    }

    public String getIp() {
        return this.ip;
    }

    @Override
    public String toString() {
        return " " + this.ip + " :: " + this.address + " ";
    }
}
