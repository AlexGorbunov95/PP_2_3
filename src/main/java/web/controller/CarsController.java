package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ServiceCarImp;



@Controller
public class CarsController {
//    @Autowired
//    private ServiceCarImp serviceCarImp;
//
//    public CarsController(ServiceCarImp serviceCarImp) {
//        this.serviceCarImp = serviceCarImp;
//    }
//
//    @GetMapping(value = "/cars")
//    public String printCars(@RequestParam(required = false) Integer count, Model model) {
//        if (count == null) {
//            model.addAttribute("cars", serviceCarImp.addCar());
//        } else {
//            model.addAttribute("cars", serviceCarImp.getCarCount(count));
//        }
//        return "Car";
//    }
}
