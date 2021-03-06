package com.ISA2020.back.model;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

import java.security.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ISA2020.back.enumerations.UsersEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy=TABLE_PER_CLASS)
@Data
public abstract class User implements UserDetails {


	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected Long id;

	private String email;
	
	@JsonIgnore
	private String password;
	
	@Enumerated
	private UsersEnum tipKorisnika;

	private Boolean enabled;
	
	private Date lastPasswordResetDate;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "radnici_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private java.util.List<Authority> authorities;
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
	

}
