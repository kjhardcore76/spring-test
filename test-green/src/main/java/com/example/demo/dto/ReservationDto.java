package com.example.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDto {
	int no;
	LocalDate checkIn;
	int room;
	String guest;
	String tel;
}