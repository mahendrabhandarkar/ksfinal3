package com.ks.ksfinal3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

/* CREATE TABLE `tbl_user_album` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `album_name` varchar(100) NOT NULL,
  `album_folder` varchar(100) NOT NULL,
  `album_create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "build")
//@NoArgsConstructor
@Entity
@Table(name = "tbl_user_album")
public class UserAlbum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "album_name")
	private String albumName;
	
	@Column(name = "album_folder")
	private String albumFolder;
	
	@CreationTimestamp
	@Column(name = "album_create_date")
	private Timestamp albumCreatedDate;
	
	public UserAlbum() {
		super();
	}
}
