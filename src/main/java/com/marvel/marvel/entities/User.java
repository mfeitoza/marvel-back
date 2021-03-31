package com.marvel.marvel.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private String id;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Document> documents;

  private String name;
  private String email;
  private String password;
  private String phone;
  private String gender;
  private Date birthday;

  protected User() {
  }

  public User(String name, String email, String password, String phone, String gender,
      Date birthday, List<Document> documents) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.gender = gender;
    this.birthday = birthday;
    this.documents = new ArrayList<Document>();
    documents.forEach(doc -> doc.setUser(this));
    this.documents.addAll(documents);
  }

  public User(String name, String email, String password, String phone, String gender,
      Date birthday) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.gender = gender;
    this.birthday = birthday;
    this.documents = new ArrayList<Document>();
  }

  public User(String id, String name, String email, String password, String phone, String gender,
      Date birthday, List<Document> documents) {
    this.id = id;
    this.documents = documents;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.gender = gender;
    this.birthday = birthday;
  }


  public String getId() {
    return this.id;
  }

  public List<Document> getDocuments() {
    return this.documents;
  }

  public void setDocuments(List<Document> documents) {
    this.documents = documents;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return this.birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }


  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(documents, user.documents)
        && Objects.equals(name, user.name) && Objects.equals(email, user.email)
        && Objects.equals(password, user.password) && Objects.equals(phone, user.phone)
        && Objects.equals(gender, user.gender) && Objects.equals(birthday, user.birthday);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }


}
