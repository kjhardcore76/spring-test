package com.example.demo.crudTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepo;


@SpringBootTest
public class CRUDTest {
	@Autowired
	ReservationRepo repo;
	
	@Test
	public void create() {
		Reservation reservation = Reservation.builder()
					.checkIn(LocalDate.parse("2024-02-02"))
					.room(101)
					.guest("또치")
					.tel("010-2222-2222")
					.build();
		repo.save(reservation);
	}
	@Test
    public void read(){
        Optional<Reservation> opt = repo.findById(1);
        if(opt.isPresent()){
        	Reservation reservation = opt.get();
          System.out.println(reservation);
        }
	}
	@Test
    public void readAll(){
        Optional<Reservation> opt = repo.findById(1);
        List<Reservation> list = repo.findAll();
        System.out.println(list);
	}
	@Test
    public void update(){
		Reservation reservation = Reservation.builder().no(1).guest("고길동").build();//primary key값이 존재하면 update, 없으면
		repo.save(reservation);
	}
	@Test
    public void delteOne(){
		repo.deleteAll();
	}	
	@Test
	public void delteAll(){
		Reservation reservation = Reservation.builder().no(1).guest("고길동").build();//primary key값이 존재하면 update, 없으면
		repo.deleteById(1);
	}
}
