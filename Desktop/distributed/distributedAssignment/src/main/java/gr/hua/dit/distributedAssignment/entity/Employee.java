package gr.hua.dit.distributedAssignment.entity;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private Long contactNum;
    private String email;
    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public Long getContactNum() {
        return contactNum;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContactNum(Long contactNum) {
        this.contactNum = contactNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(Integer id, String firstName, String lastName, Long contactNum, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNum = contactNum;
        this.email = email;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNum=" + contactNum +
                ", email='" + email + '\'' +
                '}';
    }
}