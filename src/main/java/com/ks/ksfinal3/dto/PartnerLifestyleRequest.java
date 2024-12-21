package com.ks.ksfinal3.dto;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* CREATE TABLE `tbl_partner_lifestyle` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `pdiet` varchar(100) NOT NULL,
  `psmoke` varchar(100) NOT NULL,
  `pdrink` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class PartnerLifestyleRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "pdiet")
	private String pdiet;

	@Column(name = "psmoke")
	private String psmoke;
	
	@Column(name = "pdrink")
	private String pdrink;
}
