package com.ks.ksfinal3.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/* CREATE TABLE `tbl_admin_auth_item` (
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `type` smallint(6) NOT NULL,
  `description` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `rule_name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `data` blob DEFAULT NULL,
  `created_at` int(11) DEFAULT NULL,
  `updated_at` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "build")
//@NoArgsConstructor
@Entity
@Table(name = "tbl_admin_auth_item")
public class AdminAuthItem {

	@Id
	@Column(name = "name")
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinTable(name = "tbl_admin_auth_assignment", 
	joinColumns = {
			@JoinColumn(name="item_name"),
		}, 
	inverseJoinColumns = {
			@JoinColumn(name="name"),
		})
	private String name;
	
	@Column(name = "type")
	private int type;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "rule_name")
	private String ruleName;
	
	@Column(name = "data")
	@Lob
	private byte[] data;
	
	@CreatedDate
	@Column(name = "created_at")
	private int createdAt;
	
	@LastModifiedDate 
	@Column(name = "updated_at")
	private int updatedAt;

	public AdminAuthItem() {
		super();
	}

}
