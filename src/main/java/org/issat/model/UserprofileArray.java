package org.issat.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserprofileArray {
	private List<Userprofile> users=new ArrayList<Userprofile>();

	public List<Userprofile> getUsers() {
		return users;
	}

	public void setUsers(List<Userprofile> users) {
		this.users = users;
	}
	
	
}
