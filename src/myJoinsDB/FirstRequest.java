package myJoinsDB;

public class FirstRequest {
    String place;
    String phone;

    public FirstRequest(String place, String phone) {
        this.place = place;
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "FirstRequest{" +
                "place='" + place + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
