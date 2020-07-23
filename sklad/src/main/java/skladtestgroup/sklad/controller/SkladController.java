package skladtestgroup.sklad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import skladtestgroup.sklad.model.Stuff;
import skladtestgroup.sklad.service.StuffService;

import java.util.List;

@Controller
public class SkladController {

    private int page;

    private StuffService stuffService;

    @Autowired
    public void setFilmService(StuffService stuffService) {
        this.stuffService = stuffService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allStaff(@RequestParam(defaultValue = "1") int page) {
        List<Stuff> stuff = stuffService.allStuff(page);
        int stuffCount = stuffService.stuffCount();
        int pagesCount = (stuffCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list_of_stuff");
        modelAndView.addObject("page", page);
        modelAndView.addObject("stuffList", stuff);
        modelAndView.addObject("stuffCount", stuffCount);
        modelAndView.addObject("pagesCount", pagesCount);
        this.page = page;
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id,
                                 @ModelAttribute("message") String message) {
        Stuff stuff = stuffService.getById( id );
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit_page");
        modelAndView.addObject( "stuff", stuff);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editStaff(@ModelAttribute("stuff") Stuff stuff){
        ModelAndView modelAndView = new ModelAndView();
        if (stuffService.checkTitle(stuff.getTitle()) || stuffService.getById(stuff.getId()).getTitle().equals(stuff.getTitle())) {
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("page", page);
            stuffService.edit(stuff);
        } else {
            modelAndView.addObject("message","part with title \"" + stuff.getTitle() + "\" already exists");
            modelAndView.setViewName("redirect:/edit/" +  + stuff.getId());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit_page");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addStaff(@ModelAttribute("stuff") Stuff stuff) {
        ModelAndView modelAndView = new ModelAndView();
        if (stuffService.checkTitle(stuff.getTitle())) {
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("page", page);
            stuffService.add(stuff);
        } else {
            modelAndView.addObject("message","part with title \"" + stuff.getTitle() + "\" already exists");
            modelAndView.setViewName("redirect:/add");
        }
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        int filmsCount = stuffService.stuffCount();
        int page = ((filmsCount - 1) % 10 == 0 && filmsCount > 10 && this.page == (filmsCount + 9)/10) ?
                this.page - 1 : this.page;
        modelAndView.setViewName("redirect:/");
        modelAndView.addObject("page", page);
        Stuff stuff = stuffService.getById(id);
        stuffService.delete(stuff);
        return modelAndView;
    }



}