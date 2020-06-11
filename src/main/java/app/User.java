package app;

public class User{

   private String address;
   private String ip;

   User(String address,String ip)
   {
       this.address=address;
       this.ip = ip;
   }

    public String getAddress() {
        return address;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return " "+ip+ " :: " + address + " ";
    }
}
