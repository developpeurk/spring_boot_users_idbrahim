package com.brightcoding.app.ws.meteo.app.ws.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "groups")
public class GroupEntity implements Serializable {

	private static final long serialVersionUID = -1522864136789263176L;
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "name", length = 30)
	private String name;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	                                   // clés étrangères
	@JoinTable(name = "groups_users", joinColumns = {@JoinColumn(name="groups_id")}, inverseJoinColumns = {@JoinColumn(name="users_id")} )
	// pas de doublons dans SET
	private Set<UserEntity> users = new HashSet<>();;
}
