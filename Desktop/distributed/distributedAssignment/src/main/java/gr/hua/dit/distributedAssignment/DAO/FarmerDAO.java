package gr.hua.dit.distributedAssignment.DAO;

import gr.hua.dit.distributedAssignment.entity.Application;
import gr.hua.dit.distributedAssignment.entity.Farmer;
import java.util.List;

public interface FarmerDAO {

    public List<Farmer> getFarmers();
    public Farmer getFarmer(Integer farmer_id);
    public void saveFarmer(Farmer farmer);
    public void deleteFarmer(Integer farmer_id);

    public List<Application> getApplications(Integer farmer_id);

}