package myJoinsDB;

public class SecondRequest {
    String birthday;
    String phone;

    public SecondRequest(String birthday, String phone) {
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
        return "SecondRequest{" +
                "birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
