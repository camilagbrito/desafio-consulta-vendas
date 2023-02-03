package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleSumDTO;
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

		LocalDate minDate = validateMinDate(min);
		LocalDate maxDate =validateMaxDate(max);

		Page<SaleMinDTO> result = repository.searchReport(minDate, maxDate, name, pageable);
		return result;
	}

	public List<SaleSumDTO> getSummary(String min, String max){

		LocalDate minDate = validateMinDate(min);
		LocalDate maxDate =validateMaxDate(max);

		List<SaleSumDTO> result = repository.searchSumarry(minDate, maxDate);
		return result;
	}

	public LocalDate validateMinDate(String date){
		LocalDate min;

		if(date.equals("")){
			min = today.minusYears(1L);
		} else {
			min = LocalDate.parse(date);
		}
		return min;
	}

	public LocalDate validateMaxDate(String date){
		LocalDate max;

		if(date.equals("")){
			max = today;
		} else {
			max = LocalDate.parse(date);
		}
		return max;
	}


}
