package mx.towers.suppliers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import mx.towers.suppliers.theme.libs.KTTheme;
import mx.towers.suppliers.theme.libs.config.KTThemeBaseConfig;

@Controller
public class MainController {
    @Autowired
    private KTTheme theme;

    @Autowired
    private KTThemeBaseConfig settings;

    @ModelAttribute
    public void init(@CookieValue(name="sidebar_minimize_state", required=false, defaultValue="off") String sidebarMinimizeState) {
        //keep sidebar minimize state for sidebar layouts
        if(settings.getDefaultLayout().contains("sidebar") && sidebarMinimizeState.equals("on")){
            theme.addHtmlAttribute("body", "data-kt-app-sidebar-minimize", "on");
            theme.addHtmlAttribute("sidebar-toggle", "data-kt-toggle-state", "active");
            theme.addHtmlClass("sidebar-toggle", "active");
        }
        theme.setLayout(settings.getDefaultLayout());
        theme.initLayout();
    }

//    @ModelAttribute("theme")
//    KTTheme emailModelAttribute() {
//        return theme;
//    }

    
    @GetMapping("/home")
    public String viewHomePage(@RequestParam(required = false) String page, Model model) {

        System.out.println("RT-theme.printHtmlAttributes('body')=" + theme.printHtmlAttributes("body"));

        model.addAttribute("tema", theme);
    	
    	if (page == null || page.equals("index"))
    		return "index";
    	else
    		return page;
    }
    @GetMapping("/")
    public String index(@RequestParam(required = false) String page, Model model){
        String[] vendors = {"amcharts", "amcharts-maps", "amcharts-stock"};
        theme.addVendors(vendors);
        
        System.out.println("RT-theme.printHtmlAttributes('body')=" + theme.printHtmlAttributes("body"));
        
        model.addAttribute("theme", theme);
        
        if (page ==null || page.trim().equals(""))
        	return theme.getPageView("dashboards", "index");
        
        System.out.println("Page to call :" + page);
        int indexOf = page.lastIndexOf("/");
        String folder = page.substring(0, indexOf);
        
        return theme.getPageView(folder, page.substring(indexOf +1));
        
    }

}
