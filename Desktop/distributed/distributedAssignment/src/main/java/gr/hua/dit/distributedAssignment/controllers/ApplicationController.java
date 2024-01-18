package gr.hua.dit.distributedAssignment.controllers;

import gr.hua.dit.distributedAssignment.entity.Application;
import gr.hua.dit.distributedAssignment.DAO.FarmerDAO;
import gr.hua.dit.distributedAssignment.entity.Farmer;
import gr.hua.dit.distributedAssignment.repository.ApplicationRepository;
import gr.hua.dit.distributedAssignment.Services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/application")
public class ApplicationController  {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    FarmerDAO farmerDao;

    @PostMapping("{farmer_id}")
    public String saveApplication(@PathVariable int farmer_id, @ModelAttribute("application") Application application){
        System.out.println("farmer_id: (reg)"+farmer_id);
        System.out.println("application: (reg)"+application.getTitle());
        applicationService.saveApplication(application,farmer_id);
        return "redirect:/application/"+farmer_id;
    }

    @GetMapping("{farmer_id}")
    public String showApplication(@PathVariable int farmer_id, Model model){
        Farmer farmer = farmerDao.getFarmer(farmer_id);
        List<Application> applications = farmer.getApplications();
        System.out.println(applications);
        model.addAttribute("farmer", farmer);
        model.addAttribute("applications", applications);
        return "applications";
    }

    @GetMapping("{farmer_id}/{application_id}")
    public String editApplication(@PathVariable int farmer_id, @PathVariable int application_id, Model model){
        Application application = applicationService.getApplication(application_id);
        model.addAttribute("application", application);
        model.addAttribute("farmer_id", farmer_id);
        return "add_application";
    }

    @PostMapping("{farmer_id}/{application_id}")
    public String updateApplication(@PathVariable int farmer_id, @PathVariable int application_id){
        System.out.println("farmer_id: (2 ids)"+farmer_id);

        Application application = applicationService.getApplication(application_id);
        Farmer farmer = farmerDao.getFarmer(farmer_id);
        applicationService.saveApplication(application,farmer_id);
        return "redirect:/application/"+farmer_id;
    }

    @GetMapping("{farmer_id}/new")
    public String addApplication(@PathVariable int farmer_id, Model model){
        Application application = new Application();
        model.addAttribute("application", application);
        model.addAttribute("farmer_id", farmer_id);
        return "add_application";
    }

    @DeleteMapping("{farmer_id}/{application_id}")
    public String deleteApplication(@PathVariable int farmer_id, @PathVariable int application_id, Model model){
        applicationService.deleteApplication(application_id);
        return "home";
    }
}