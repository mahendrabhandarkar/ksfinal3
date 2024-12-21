package com.ks.ksfinal3.dto;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* CREATE TABLE `tbl_countries` (
  `id` int(11) NOT NULL,
  `sortname` varchar(3) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
import lombok.*;

import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CountriesRequest {
	public CountriesRequest(int id, String iso, String name, String sortname, String iso3, Integer numcode, Integer phonecode) {
		this.id = id;
		this.iso = iso;
		this.name = name;
		this.sortname = sortname;
		this.iso3 = iso3;
		this.numcode = numcode;
		this.phonecode = phonecode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name="iso")
	public String iso;

	@Column(name = "name")
	public String name;

	@Column(name = "sortname")
	public String sortname;

	@Column(name = "iso3")
	public String iso3;

	@Column(name="numcode", nullable = true)
	public Integer numcode;

	@Column(name="phonecode")
	public Integer phonecode;
}
