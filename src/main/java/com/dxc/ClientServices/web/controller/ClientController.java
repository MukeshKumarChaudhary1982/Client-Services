package com.dxc.ClientServices.web.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dxc.ClientServices.entity.Client;
import com.dxc.ClientServices.service.ClientService;

@RestController
@RequestMapping("/v1/clients")
public class ClientController {
	
	Logger LOGGER=LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Value("${application.name}")
	private String appName;
	
	@GetMapping("/i18")
	public String internatioanlization() {
		
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}
	
	@GetMapping
	public List<Client> findAll(){
		
		return clientService.findAll();
		
	}

	
	@GetMapping("/{clientId}")
	public Resource<Client> getClient(@PathVariable int clientId) {
		
		Client client=clientService.findById(clientId);
		Resource<Client> resource=new Resource<Client>(client);
		ControllerLinkBuilder linkTo=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll());
		resource.add(linkTo.withRel("All Clients"));
		return resource;
		
	}
	
	
	@PostMapping
	public Client addClient(@Valid @RequestBody Client theClient) {
		
		theClient.setId(0);
		clientService.save(theClient);	
		return theClient;
		
	}
	
	@PutMapping
	public Client updateClient(@RequestBody Client theClient) {
		
		clientService.save(theClient);
		return theClient;
		
	}
	
	
	@DeleteMapping("/{clientId}")
	public String deleteClient(@PathVariable int clientId) {
		
		clientService.findById(clientId);	
		clientService.deletebyId(clientId);
		return "Deleted Client "+clientId;
		
	}

}
