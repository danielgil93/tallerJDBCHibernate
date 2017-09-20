package org.springframework.samples.petclinic.owner;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.visit.Visit;

@Entity
@Table(name="facturas")
public class Bill extends BaseEntity{
	
	@Digits(integer=10, fraction=0)
	private long idNumber;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern=("yyyy/MM/dd"))
	private Date paymentDate;
	
	@Digits(integer=5, fraction=2)
	private double money;
	
	/*@ManyToOne
	@JoinColumn(name="owner")
	private Owner owner;*/
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="Bill", cascade=CascadeType.ALL)
	private Visit visit;
	
	public Bill () {}
	
}