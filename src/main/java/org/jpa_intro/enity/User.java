package org.jpa_intro.enity;

import javax.persistence.*;

@Entity
@Table (name = "usuarios")
public class User {
  //  Indicamos el id y las columnas de la tabla
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Id generado automaticamente autoincremental

  // El nombre de la columna debe ser igual al de la BD
  @Column(name = "user_id")
  private int user_id; // Podemos darle otro nombre para el programa pero no es recomendable
  @Column(name = "login")
  private String login;
  @Column(name = "password")
  private String password;
  @Column(name = "nickname")
  private String nickname;
  @Column(name = "email")
  private String email;

  public User(){}

  public User(String email, String login, String nickname, String password, int user_id) {
    this.email = email;
    this.login = login;
    this.nickname = nickname;
    this.password = password;
    this.user_id = user_id;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "User{" +
        "email='" + email + '\'' +
        ", user_id=" + user_id +
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", nickname='" + nickname + '\'' +
        '}';
  }
}
