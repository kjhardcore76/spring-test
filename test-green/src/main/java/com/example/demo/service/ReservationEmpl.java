package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ReservationDto;
import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepo;

@Service
public class ReservationEmpl implements ReservationService {
	@Autowired
	ReservationRepo repo;
	
	@Override
	public int register(ReservationDto dto) {
		Reservation reservation = dtoToEntity(dto);
		repo.save(reservation);
		int newNo = reservation.getNo();
		return newNo;
	}
	
	@Override
	public List<ReservationDto> getList() {
        List<Reservation> entityList = repo.findAll();
        List<ReservationDto> dtoList = entityList.stream()
                .map(entity -> entityToDto(entity))
                .collect(Collectors.toList());
		return dtoList;
	}
	
	@Override
	public ReservationDto readOne(int no) {
        Optional<Reservation> result = repo.findById(no);
        if (result.isPresent()) {
          Reservation reservation = result.get();
          ReservationDto dto = entityToDto(reservation); 
          return dto;
        } else {
          return null;
        }
	}
}
