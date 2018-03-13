package ru.job4j.banktransfer;

public class User {

    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getName().equals(user.getName())) return false;
        return getPassport().equals(user.getPassport());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getPassport().hashCode();
        return result;
    }

}
