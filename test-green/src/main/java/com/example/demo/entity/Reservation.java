package com.example.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservation_tbl") // 실제 테이블 이름
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no;
	
	@Column(nullable = true)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	LocalDate checkIn;
	
	@Column
	int room;

	@Column(length=10, nullable = true)
	String guest;
	
	@Column(length=15, nullable = true)
	String tel;
}
