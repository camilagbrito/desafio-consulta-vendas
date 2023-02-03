package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;


@Service
public class SaleService {
	LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
	@Autowired
	private SaleRepository repository;


	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleMinDTO> getReport(String min, String max, String name, Pageable pageable){
		LocalDate minDate;
		LocalDate maxDate;

		if(min.equals("")){
			minDate = today.minusYears(1L);
		} else {
			minDate = LocalDate.parse(min);
		}
		if(max.equals("")){
			maxDate = today;
		} else {
			maxDate = LocalDate.parse(max);
		}

		Page<SaleMinDTO> result = repository.searchReport(minDate, maxDate, name, pageable);
		return result;
	}


}
