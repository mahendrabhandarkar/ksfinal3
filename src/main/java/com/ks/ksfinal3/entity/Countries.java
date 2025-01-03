package com.ks.ksfinal3.entity;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@Entity
@Table(name = "tbl_countries")
public class Countries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public Integer getNumcode() {
		return numcode;
	}

	public void setNumcode(Integer numcode) {
		this.numcode = numcode;
	}

	public Integer getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(Integer phonecode) {
		this.phonecode = phonecode;
	}

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
	
	public Countries() {
		super();
	}
}
