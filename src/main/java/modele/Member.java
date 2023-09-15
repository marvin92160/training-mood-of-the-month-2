package modele;

import java.time.LocalDate;

public class Member {

    private long id;
    private String lastName;
    private String firstName;
    private String email;
    private LocalDate birthdate;


    public Member(long id, String lastName, String firstName, String email, LocalDate birthdate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.birthdate = birthdate;
    }

    public Member(String lastName, String firstName, String email, LocalDate birthdate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.birthdate = birthdate;
    }

    public Member(Member member) {
        setId(member.getId());
        setLastName(member.getLastName());
        setFirstName(member.getFirstName());
        setEmail(member.getEmail());
        setBirthdate(member.getBirthdate());
    }

    public Member() {

    }

    @Override
    public String toString() {
        return "ID : " + id +
                " | Nom : " + lastName +
                " | Prénom : " + firstName +
                " | Email : " + email +
                " | Naissance : " + birthdate + "\n";
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}