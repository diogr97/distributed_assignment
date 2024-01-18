package gr.hua.dit.distributedAssignment.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private Long contactNum;

    public Long getContactNum() {
        return contactNum;
    }

    public void setContactNum(Long contactNum) {
        this.contactNum = contactNum;
    }

    public Farmer(Long contactNum) {
        this.contactNum = contactNum;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "farmer_profile_id")
    private FarmerProfile farmerProfile;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "application_farmer",
            joinColumns = @JoinColumn(name = "farmer_id"),
            inverseJoinColumns = @JoinColumn(name = "application_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"farmer_id", "application_id"})}
    )
    private List<Application> applications;

    public List<Application> getApplications() {
        return applications;
    }

    public void setCourses(List<Application> applications) {
        this.applications = applications;
    }

    public Farmer(String firstName, String lastName, String email, Long contactNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNum = contactNum;
    }

    public Farmer() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public FarmerProfile getFarmerProfile() {
        return farmerProfile;
    }

    public void setFarmerProfile(FarmerProfile farmerProfile) {
        this.farmerProfile = farmerProfile;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNum=" + contactNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
