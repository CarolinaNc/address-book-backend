package carolina.nichita.addressbook.model;

import java.util.Objects;

public class User {
    private String id;
    private String fullName;
    private String address;
    private String city;
    private String zip;
    private String email;

    public User() {}

    public User(String id, String fullName, String address, String city, String zip, String email) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(fullName, user.fullName) && Objects.equals(address, user.address) && Objects.equals(city, user.city) && Objects.equals(zip, user.zip) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, address, city, zip, email);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
