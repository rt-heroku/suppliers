package mx.towers.suppliers.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.towers.suppliers.sales.Salesman;
import mx.towers.suppliers.services.SalesmanService;
import mx.towers.suppliers.theme.libs.KTTheme;
import mx.towers.suppliers.theme.libs.config.KTThemeBaseConfig;

@Controller
@RequestMapping("/users")
public class SalesmanController {

	@Autowired
    private KTTheme theme;

    @Autowired
    private KTThemeBaseConfig settings;
    
    @Autowired
    private final SalesmanService salesmanService;

    @Autowired
    public SalesmanController(SalesmanService salesmanService) {
        this.salesmanService = salesmanService;
    }

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
// Display all salesmen
    @GetMapping
    public String listSalesmen(Model model) {
        model.addAttribute("users", salesmanService.getAllSalesmen());
        model.addAttribute("theme", theme);
        model.addAttribute("settings", settings);
        return theme.getPageView("users","list"); // refers to `src/main/resources/templates/salesmen/list.html`
    }

    // Display form for a new salesman
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("salesman", new Salesman());
        return "salesmen/create"; // refers to `src/main/resources/templates/salesmen/create.html`
    }

    // Handle form submission for creating a new salesman
    @PostMapping("/create")
    public String createSalesman(@ModelAttribute Salesman salesman) {
        salesmanService.saveSalesman(salesman);
        return "redirect:/salesmen";
    }

    // Display form for editing a salesman
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Salesman> salesmanOptional = salesmanService.getSalesmanById(id);
        if (salesmanOptional.isPresent()) {
            model.addAttribute("salesman", salesmanOptional.get());
            return "salesmen/edit"; // refers to `src/main/resources/templates/salesmen/edit.html`
        } else {
            // Handle the scenario where the salesman doesn't exist
            return "redirect:/salesmen";
        }
    }

    // Handle form submission for editing a salesman
    @PostMapping("/{id}/edit")
    public String updateSalesman(@PathVariable int id, @ModelAttribute Salesman salesman) {
        salesman.setId(id);
        salesmanService.saveSalesman(salesman);
        return "redirect:/salesmen";
    }

    // Handle deleting a salesman
    @GetMapping("/{id}/delete")
    public String deleteSalesman(@PathVariable int id) {
        salesmanService.deleteSalesman(id);
        return "redirect:/salesmen";
    }
}