package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.WebConfig;
import web.dao.CarsDao;
import web.model.Car;

import java.util.List;

@Controller
public class CarsController {

    @Autowired
    private CarsDao carsDao;

    @GetMapping("/cars")
    public String allCars (@RequestParam(value = "count",required = false,defaultValue = "5") int count,  Model model) {
        if(count < 5) {
            model.addAttribute("cars",carsDao.getCars().subList(0,count));
        }else {
            model.addAttribute("cars",carsDao.getCars());
        }
        return "cars";
    }
}
