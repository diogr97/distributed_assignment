package gr.hua.dit.distributedAssignment.repository;

import gr.hua.dit.distributedAssignment.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}