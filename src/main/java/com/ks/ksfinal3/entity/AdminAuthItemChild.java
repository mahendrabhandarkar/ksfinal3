package com.ks.ksfinal3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import com.ks.ksfinal3.entity.composite.AdminAuthItemChildId;

/* CREATE TABLE `tbl_admin_auth_item_child` (
  `parent` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `child` varchar(64) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "build")
//@NoArgsConstructor
@Entity
@Table(name = "tbl_admin_auth_item_child")
@IdClass(AdminAuthItemChildId.class)
public class AdminAuthItemChild {

	@Id
	@Column(name = "parent")
//	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private String parent;
	
	@Id
	@Column(name = "child")
//	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private String child;

	public AdminAuthItemChild() {
		super();
	}

}
