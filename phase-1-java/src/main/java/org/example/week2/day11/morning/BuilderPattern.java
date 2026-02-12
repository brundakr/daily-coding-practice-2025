package org.example.week2.day11.morning;

public class BuilderPattern {
    private String userName;
    private String email;

    //Optional fields
    private String address;
    private long phone;

    //private constructor
    private BuilderPattern(UserBuilder userBuilder) {
        this.userName = userBuilder.userName;
        this.email = userBuilder.email;
        this.address = userBuilder.address;
        this.phone = userBuilder.phone;
    }

    public static class UserBuilder {
        private String userName;
        private String email;

        //optional fields
        private String address;
        private long phone;

        public UserBuilder(String userName, String email) {
            this.userName = userName;
            this.email = email;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder phone(long phone) {
            this.phone = phone;
            return this;
        }

        public BuilderPattern build() {
            return new BuilderPattern(this);
        }

    }

    @Override
    public String toString() {
        return "User { username: " + userName +",  email: " + email + ", address: " + address + ", phone: " + phone + " }";
    }

}


class mainBPClass {
    public static void main(String[] args) {
        BuilderPattern user1 = new BuilderPattern.UserBuilder("Brunda", "brunda@gmail.com")
                .phone(9083)
                .build();

        BuilderPattern user2 = new BuilderPattern.UserBuilder("User", "user@gmail.com")
                .build();

        System.out.println(user1);
        System.out.println(user2);
    }
}