package gr.hua.dit.distributedAssignment.DAO;

import gr.hua.dit.distributedAssignment.entity.Farmer;
import gr.hua.dit.distributedAssignment.entity.Application;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class FarmerDAOImpl implements FarmerDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Farmer> getFarmers() {
        TypedQuery<Farmer> query = entityManager.createQuery("from Farmer", Farmer.class);
        return query.getResultList();
    }

    @Override
    public Farmer getFarmer(Integer farmer_id) {
        return entityManager.find(Farmer.class, farmer_id);
    }

    @Override
    @Transactional
    public void saveFarmer(Farmer farmer) {
        System.out.println("farmer "+ farmer.getId());
        if (farmer.getId() == null) {
            entityManager.persist(farmer);
        } else {
            entityManager.merge(farmer);
        }
    }

    @Override
    @Transactional
    public void deleteFarmer(Integer farmer_id) {
        System.out.println("Deleting farmer with id: " + farmer_id);
        entityManager.remove(entityManager.find(Farmer.class, farmer_id));
    }

    @Override
    @Transactional
    public List<Application> getApplications(Integer farmer_id) {
        Farmer farmer = entityManager.find(Farmer.class, farmer_id);
        return farmer.getApplications();
    }
}