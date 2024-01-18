package gr.hua.dit.distributedAssignment.repository;

import gr.hua.dit.distributedAssignment.entity.FarmerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path= "farmerprofile")
public interface FarmerProfileRepository extends JpaRepository<FarmerProfile, Integer> {

}
