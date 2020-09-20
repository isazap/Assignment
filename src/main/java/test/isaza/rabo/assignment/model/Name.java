package nl.isaza.rabo.model;

public class Name {
    private String title;
    private String first;
    private String surname;

    public Name(String title, String first, String surname) {
        this.title = title;
        this.first = first;
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
