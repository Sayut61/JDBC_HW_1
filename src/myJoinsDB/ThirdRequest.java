package myJoinsDB;

public class ThirdRequest {
    String birthday;
    String phone;

    public ThirdRequest(String birthday, String phone) {
        this.birthday = birthday;
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "ThirdRequest{" +
                "birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
