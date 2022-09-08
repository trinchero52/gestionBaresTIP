package com.tip.gestionBares.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tip.gestionBares.model.Mesa;
import com.tip.gestionBares.model.Mozo;
import com.tip.gestionBares.model.Ticket;

public class TicketDto {

	private Long id;
	
	private Mesa mesa;
	
	private Mozo mozo;
	
	private LocalDate fecha;
	
	private LocalTime horaFecha;
	
	private String nombreBar;
	
	private String direccionBar;
	
	private Integer nroTicket;
	
	private Double importeTotal;

	private String metodoDePago;
	
	private List<TicketProductoDto> ticketProductosDto;

	private Integer descuento;

	public TicketDto(Mesa mesa, Mozo mozo, String nombreBar, String direccionBar) {
		super();
		this.mesa = mesa;
		this.mozo = mozo;
		this.nombreBar = nombreBar;
		this.direccionBar = direccionBar;
		this.ticketProductosDto = new ArrayList<TicketProductoDto>();
	}
	
	public TicketDto(Ticket ticket) {
		this(ticket.getMesa(),
			 ticket.getMozo(),
			 ticket.getNombreBar(),
			 ticket.getDireccionBar());
			this.id = ticket.getId();
			this.nroTicket = ticket.getNroTicket();
			this.metodoDePago = ticket.getMetodoDePago();
			this.fecha = ticket.getFecha();
			this.horaFecha = ticket.getHoraFecha();
			this.ticketProductosDto = ticket.getTicketProductos().stream().map(t -> new TicketProductoDto(t)).collect(Collectors.toList());
			this.importeTotal = ticket.getImporteTotal();
			this.descuento = ticket.getDescuento();
	}
	
	public List<TicketProductoDto> getTicketProductosDto() {
		return ticketProductosDto;
	}

	public void setTicketProductosDto(List<TicketProductoDto> ticketProductosDto) {
		this.ticketProductosDto = ticketProductosDto;
	}

	public LocalTime getHoraFecha() {
		return horaFecha;
	}

	public void setHoraFecha(LocalTime horaFecha) {
		this.horaFecha = horaFecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNombreBar() {
		return nombreBar;
	}

	public void setNombreBar(String nombreBar) {
		this.nombreBar = nombreBar;
	}

	public String getDireccionBar() {
		return direccionBar;
	}

	public void setDireccionBar(String direccionBar) {
		this.direccionBar = direccionBar;
	}

	public Integer getNroTicket() {
		return nroTicket;
	}

	public void setNroTicket(Integer nroTicket) {
		this.nroTicket = nroTicket;
	}

	public Double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public String getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	
}
