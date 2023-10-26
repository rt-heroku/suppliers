package mx.towers.suppliers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.towers.suppliers.model.Account;
import mx.towers.suppliers.model.dto.AccountDTO;
import mx.towers.suppliers.repostiories.TypesRepository;
import mx.towers.suppliers.services.AccountService;
import mx.towers.suppliers.theme.libs.KTTheme;
import mx.towers.suppliers.theme.libs.config.KTThemeBaseConfig;

@Controller
@RequestMapping("/suppliers")
public class SuppliersController {
    private static final Integer ACCOUNT_TYPE = 1;

	private static final String CUSTOMERS = "customers";
	private static final String SUPPLIERS = "suppliers";

	@Autowired
    private KTTheme theme;

    @Autowired
    private KTThemeBaseConfig settings;

    @Autowired
    private AccountService accountService;
    
    @Autowired
	private TypesRepository typesRepository;

    private String getFolderName(int accountType, String resource) {
    	String path ="";
    	if (accountType == 1)
    		path += theme.getPageView(SUPPLIERS , resource);
    	else
    		path += theme.getPageView(CUSTOMERS, resource);
    	
    	return path;
    	
    }

    private String getFolderName(int accountType, String resource, int accountId) {
    	String path ="/";
    	if (accountType == 1)
    		path += SUPPLIERS + "/" + resource;
    	else
    		path += CUSTOMERS + "/" + resource;
    	
    	if (accountType != ACCOUNT_TYPE)
    		path = "redirect:" + path + "/" + accountId;
    	else
    		path = getFolderName(accountType, resource);
    	
    	System.out.println("PATH=" + path);
    	return path;
    	
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

    @GetMapping("/list")
    public String listCustomers(Model model) {
    	List<Account> accounts = accountService.getAccountsByAccountType(ACCOUNT_TYPE);
        model.addAttribute("accounts", accounts);
        model.addAttribute("theme", theme);
        model.addAttribute("settings", settings);
        return getFolderName(ACCOUNT_TYPE, "list");
    }

    @GetMapping("/view/{id}")
    public String viewCustomers(@PathVariable Integer id, Model model) {
    	
    	System.out.println(CUSTOMERS + " --- " + accountService.getAccountById(id).get().getName());
    	Account account = accountService.getAccountById(id).get();
    	
    	System.out.println("Number of payments: " + account.getPayments().size() );
    	System.out.println("Number of BankInfo: " + account.getBankinfo().size() );
    	
        model.addAttribute("account", account);
        model.addAttribute("theme", theme);
        model.addAttribute("settings", settings);
        return getFolderName(account.getAccountType(), "view", id);
    }
    
    @GetMapping("/getting-started")
    public String gettingStarted(Model model) {
        model.addAttribute("theme", theme);
        model.addAttribute("settings", settings);
        return getFolderName(ACCOUNT_TYPE, "getting-started");
        
    }
    
    @PostMapping(path = "/save", consumes = { "multipart/form-data" })
    public ModelAndView save(@ModelAttribute AccountDTO account) throws Exception {
    	
    	System.out.println("Saving account " + account.getName());
    	account.setAccountType("" + ACCOUNT_TYPE);
    	
    	Account saved = accountService.saveAccount(account.toAcccount(typesRepository.findById(5).get()));
    	
    	return new ModelAndView(getFolderName(saved.getAccountType(), "/list", saved.getId()));
    }
    
}
