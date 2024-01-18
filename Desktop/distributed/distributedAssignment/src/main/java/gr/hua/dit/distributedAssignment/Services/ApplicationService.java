package gr.hua.dit.distributedAssignment.Services;

import gr.hua.dit.distributedAssignment.entity.Farmer;
import gr.hua.dit.distributedAssignment.DAO.FarmerDAO;
import gr.hua.dit.distributedAssignment.entity.Application;
import gr.hua.dit.distributedAssignment.repository.ApplicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private FarmerDAO farmerDAO;

    @Transactional
    public void saveApplication(Application application, Integer farmer_id){
        Farmer farmer = farmerDAO.getFarmer(farmer_id);
        application.setFarmer(farmer);
        applicationRepository.save(application);
    }

    @Transactional
    public Application getApplication(int applicationId) {
        return applicationRepository.findById(applicationId).get();
    }

    public void deleteApplication(int applicationId){
        applicationRepository.deleteById(applicationId);
    }
}
