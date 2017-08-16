package com.votingtrends.model;

public class Vote implements java.io.Serializable {
private int id;
private String name;
private int vote;
private String phone;
private int count;

public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getId() {
	return this.id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return this.name;
}
public void setName(String name) {
	this.name = name;
}
public int getVote() {
	return this.vote;
}
public void setVote(int vote) {
	this.vote = vote;
}


}
