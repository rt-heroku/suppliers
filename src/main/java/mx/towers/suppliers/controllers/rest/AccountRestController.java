package mx.towers.suppliers.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.towers.suppliers.model.Account;
import mx.towers.suppliers.model.dto.AccountDTO;
import mx.towers.suppliers.repostiories.TypesRepository;
import mx.towers.suppliers.services.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @Autowired
	private TypesRepository typesRepository;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Other CRUD mappings for RESTful operations can be added here...
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Account save(@RequestBody AccountDTO account) {
    	
    	System.out.println("Saving account " + account.getName());
    	account.setAccountType("2");
    	
    	return accountService.saveAccount(account.toAcccount(typesRepository.findById(5).get()));
    	
    }
}
