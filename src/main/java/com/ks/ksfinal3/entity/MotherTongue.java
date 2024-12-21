package com.ks.ksfinal3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* CREATE TABLE `tbl_mother_tongue` (
  `id` int(11) NOT NULL,
  `mtongue` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "build")
//@NoArgsConstructor
@Entity
@Table(name = "tbl_mother_tongue")
public class MotherTongue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "mtongue")
	private String mtongue;
	
	public MotherTongue() {
		super();
	}
}
