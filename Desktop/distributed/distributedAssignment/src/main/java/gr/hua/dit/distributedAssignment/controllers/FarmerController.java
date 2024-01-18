package gr.hua.dit.distributedAssignment.controllers;

import gr.hua.dit.distributedAssignment.DAO.FarmerDAO;
import gr.hua.dit.distributedAssignment.entity.Farmer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("farmer")
public class FarmerController {

    @Autowired
    private FarmerDAO farmerDao;

    @GetMapping("")
    public String showFarmers(Model model){


        model.addAttribute("farmers", farmerDao.getFarmers());
        return "farmers";
    }

    @GetMapping("/new")
    public String addFarmer(Model model){
        Farmer farmer = new Farmer();
        model.addAttribute("farmer", farmer);

        return "add_farmer";

    }

    @GetMapping("{farmer_id}")
    public String editFarmer(@PathVariable Integer farmer_id, Model model){
        Farmer farmer = farmerDao.getFarmer(farmer_id);
        model.addAttribute("farmer", farmer);
        return "add_farmer";

    }

    @PostMapping("/new")
    public String saveFarmer(@ModelAttribute("farmer") Farmer farmer, Model model) {
        farmerDao.saveFarmer(farmer);
        model.addAttribute("farmers", farmerDao.getFarmers());
        return "farmers";
    }

    @DeleteMapping("{farmer_id}")
    public String deleteFarmer(@PathVariable Integer farmer_id){
        farmerDao.deleteFarmer(farmer_id);
        return "farmers";
    }
}