package com.ISA2020.back.model;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ISA2020.back.enumerations.StanjePregleda;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Table(name = "pregled")
@Entity
@AllArgsConstructor
public class Pregled {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private ZonedDateTime datumVreme;
	@Column
	private ZonedDateTime krajPregleda;
	@Column
	private Long tipPRegleda;
	@Column
	private Long doktorKojiVrsi;
	@Column
	private Long brojSale; 
	@Column 
	private Long pacijent;
	@Column
	private StanjePregleda statusPregleda;
	private String izvestaj;

	public Pregled(){
	}
}
