package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ReservationDto;
import com.example.demo.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService service;
	
	@GetMapping("/register")
    public void register() {
    }
	
    @PostMapping("/register")
    public String registerReservation(ReservationDto dto, RedirectAttributes redirectAttributes) {
        int no = service.register(dto);
        redirectAttributes.addFlashAttribute("msg", "예약이 등록되었습니다");
        return "redirect:/reservation/list";
    }
    
	@GetMapping("/list")
	public void list(Model model) {
		List<ReservationDto> list = service.getList();
		System.out.println(list);
		model.addAttribute("list", list);
	}
	
	@GetMapping("/read")
    public void read(@RequestParam(name = "no") int no, Model model) {
        ReservationDto dto = service.readOne(no);
        model.addAttribute("dto", dto);
    }
}
