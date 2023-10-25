package mx.towers.suppliers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.towers.suppliers.services.AccountService;
import mx.towers.suppliers.theme.libs.KTTheme;
import mx.towers.suppliers.theme.libs.config.KTThemeBaseConfig;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private KTTheme theme;

    @Autowired
    private KTThemeBaseConfig settings;

    @Autowired
    private AccountService accountService;

	@ModelAttribute("theme")
	KTTheme themelModelAttribute() {
	    return theme;
	}

	@ModelAttribute("settings")
	KTThemeBaseConfig settingslModelAttribute() {
	    return settings;
	}
    
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

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        model.addAttribute("theme", theme);
        model.addAttribute("settings", settings);
        return theme.getPageView("customers", "list");
    }

    @GetMapping("/view/{id}")
    public String viewCustomers(@PathVariable Integer id, Model model) {
        model.addAttribute("accounts", accountService.getAccountById(id));
        model.addAttribute("theme", theme);
        model.addAttribute("settings", settings);
        return theme.getPageView("customers", "view");
    }
    
    @GetMapping("/getting-started")
    public String gettingStarted(Model model) {
        model.addAttribute("theme", theme);
        model.addAttribute("settings", settings);
        return theme.getPageView("customers", "getting-started");
    }
    
    
}
