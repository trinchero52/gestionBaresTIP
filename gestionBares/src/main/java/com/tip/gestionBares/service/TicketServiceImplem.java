package com.tip.gestionBares.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tip.gestionBares.dto.TicketDto;
import com.tip.gestionBares.model.Ticket;
import com.tip.gestionBares.repositories.TicketRepository;

@Service
public class TicketServiceImplem implements TicketService{

	@Autowired
	private TicketRepository ticketRepository;
	
	public TicketServiceImplem() {
		
	}

	@Override
	public TicketDto create(TicketDto ticketDto) {
		Ticket ticket = new Ticket(ticketDto.getMesa(), ticketDto.getMozo(), ticketDto.getFecha(), 
							ticketDto.getNombreBar(), ticketDto.getDireccionBar()
							);
		this.ticketRepository.save(ticket);
		return new TicketDto(ticket);
	}
	
	@Override
	public List<TicketDto> delete(Long id) {
		List<Ticket> tickets = (List<Ticket>) this.ticketRepository.findAll();
		Ticket ticket = tickets.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
		tickets.removeIf(c -> c.getId().equals(id));
		List<TicketDto> ticketsDto = new ArrayList<TicketDto>();
		if(tickets != null) {
			tickets.forEach(p -> ticketsDto.add(new TicketDto(p)));
		}
		this.ticketRepository.delete(ticket);
		
		return ticketsDto;
	}

	@Override
	public List<TicketDto> findAll() {
		List<Ticket> tickets = (List<Ticket>) this.ticketRepository.findAll();
		List<TicketDto> ticketsDto = new ArrayList<>();
		
		if(tickets != null) {
			tickets.forEach(t -> ticketsDto.add(new TicketDto(t)));
		}
		return ticketsDto;
	}

	@Override
	public TicketDto applyDiscount(Long id, Integer porcentaje) {
		
		Ticket ticket = this.ticketRepository.findById(id).orElse(null);
		
		Double importeTotal = (Double) (ticket.getImporteTotal() - (ticket.getImporteTotal() * porcentaje / 100));
		
		ticket.setDescuento(porcentaje);
		
		ticket.setImporteTotal(importeTotal);
		
		this.ticketRepository.save(ticket);
		
		TicketDto ticketDto = new TicketDto(ticket);
		return ticketDto;
		
	}
	
	
	
}
