package com.devsuperior.dsmeta;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.devsuperior.dsmeta.services.SaleService;
import org.aspectj.apache.bcel.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

@SpringBootApplication
public class DsmetaApplication{

	private SaleRepository repository;
	private SaleService service;

	public static void main(String[] args){
		SpringApplication.run(DsmetaApplication.class, args);
	}


}
