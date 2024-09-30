package com.example.demo.serviceTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ReservationDto;
import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;

@SpringBootTest
public class ServiceTest {
	
	@Autowired
	ReservationService service;
	
	@Test
	public void 예약정보등록() {
		ReservationDto dto = ReservationDto.builder()
				.checkIn(LocalDate.parse("2024-01-02"))
				.room(101)
				.guest("또치")
				.build();
		int no = service.register(dto);
		System.out.println("새로운 게시물 번호: " + no);
	}
	
	@Test
	public void 예약정보목록조회() {
		List<ReservationDto> list  = service.getList();
		for(ReservationDto dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 예약정보단건조회() {
		ReservationDto dto = service.readOne(1);
		System.out.println(dto);
	}
}
