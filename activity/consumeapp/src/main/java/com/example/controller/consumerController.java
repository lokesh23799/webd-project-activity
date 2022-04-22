package com.example.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import reactor.core.publisher.Flux;

@RestController

public class consumerController {
/*
@RequestMapping("players")
	public String m1()
	{
		RestTemplate rt=new RestTemplate();
		return rt.getForObject("http://localhost:8002/ex_players",String.class);
		
	}
	*/
	
	@RequestMapping("player/{id}")
	public Flux<String> m2(@PathVariable("id") int id) {
		/*
		 * 
		 */
		
		//Strp1
		WebClient wc=WebClient.create();
		// step 2
	return (Flux<String>) wc.get()
		.uri("http://localhost:8080/ext_player/"+id)
		.retrieve()
		.bodyToFlux(String.class);
		
		
		
		//return "";
	}
	@GetMapping("player/")
	public Flux<String> m3(@PathVariable("id") int id){
		WebClient wc=WebClient.create();
		return (Flux<String>) wc.get()
				.uri("http://localhost:8080/ext_player/")
				.retrieve()
				.bodyToFlux(String.class);
				
	}
	@PutMapping("player/")
	public Flux<String> m4(@PathVariable("id") int id){
		WebClient wc=WebClient.create();
		return (Flux<String>) wc.get()
				.uri("http://localhost:8080/ext_player/")
				.retrieve()
				.bodyToFlux(String.class);
	}
	@DeleteMapping("player/")
	public Flux<String> m5(@PathVariable("id") int id){
		WebClient wc=WebClient.create();
		return (Flux<String>) wc.get()
				.uri("http://localhost:8080/ext_player/"+id)
				.retrieve()
				.bodyToFlux(String.class);
	}
	
}
