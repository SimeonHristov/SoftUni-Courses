package phonebook.entity;

public class Contact {

    private String name;

    private String number;

    public Contact(String name, String number) {
      setName(name);
     //   this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 6) {
            throw new IllegalArgumentException("Name should be at least 6 characters long");
        }

        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Contact() {

    }

}
