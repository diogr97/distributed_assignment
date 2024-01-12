package gr.hua.dit.distributedAssignment.entity;

public class Farmer {
    private Integer id;
    private String firstname;
    private String lastname;
    private Long contactnumber;
    private String email;
    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Long getContactnumber() {
        return contactnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setContactnumber(Long contactnumber) {
        this.contactnumber = contactnumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Farmer(Integer id, String firstname, String lastname, Long contactnumber, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.contactnumber = contactnumber;
        this.email = email;
    }

    public Farmer() {
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", contactnumber=" + contactnumber +
                ", email='" + email + '\'' +
                '}';
    }
}
