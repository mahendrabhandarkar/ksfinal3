package com.ks.ksfinal3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* CREATE TABLE `tbl_migration` (
  `version` varchar(180) NOT NULL,
  `apply_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "build")
//@NoArgsConstructor
@Entity
@Table(name = "tbl_migration")
public class Migration {

	@Id
	@Column(name = "version")
	private String version;

	@Column(name = "apply_time")
	private int applyTime;
	
	public Migration() {
		super();
	}
}
