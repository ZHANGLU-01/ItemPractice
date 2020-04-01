package com.springboot.Controller;

import com.springboot.pojo.Hero;
import com.springboot.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private HeroService heroService;

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/main")
    public String main(Model model) {
        //取数据
        List<Hero> allHero = heroService.getAllHero();
        System.out.println(allHero);
        model.addAttribute("heroList", allHero);
        return "main";
    }

    @PostMapping("/addHero")
    public String addHero(Hero hero) {
        heroService.InsertHero(hero);
        return "redirect:/main";
    }
    @PutMapping("/addHero")
    public String editHero(Hero hero) {
        heroService.updateHero(hero);
        return "redirect:/main";
    }
    //    @InitBinder
//    public void  InitBinder(WebDataBinder dataBinder){
//        dataBinder.registerCustomEditor(Date.class,new PropertyEditorSupport(){
//            public void SetAsText(String value){
//                try {
//                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
//                } catch (ParseException e) {
//                    setValue(null);
//                }
//            }
//            public String getAsText(){
//                return new SimpleDateFormat("yyyy-MM-dd").format((Date) getValue());
//            }
//        });
//    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        //根据当前id获取记录
        Hero hero = heroService.getOneHero(id);
        model.addAttribute("hero", hero);
        return "add";
    }

}
