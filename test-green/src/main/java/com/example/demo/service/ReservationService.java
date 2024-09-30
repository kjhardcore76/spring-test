package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReservationDto;
import com.example.demo.entity.Reservation;

public interface ReservationService {
    
    int register(ReservationDto dto);
    
    List<ReservationDto> getList();
    
    ReservationDto readOne(int no);
    
    default Reservation dtoToEntity(ReservationDto dto) {
      Reservation reservation = Reservation.builder()
    		  .no(dto.getNo())
    		  .checkIn(dto.getCheckIn())
    		  .room(dto.getRoom())
    		  .guest(dto.getGuest())
    		  .tel(dto.getTel())
    		  .build();
      return reservation;
    }
    
    default ReservationDto entityToDto(Reservation reservation) {
      ReservationDto dto = ReservationDto.builder()
    		  .no(reservation.getNo())
    		  .checkIn(reservation.getCheckIn())
    		  .room(reservation.getRoom())
    		  .guest(reservation.getGuest())
    		  .tel(reservation.getTel())
    		  .build();
      return dto;
	}
}