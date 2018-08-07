package com.ltybc.xproject.server.model;

import com.ltybc.xproject.server.dao.CartDao;
import com.ltybc.xproject.server.model.validation.PhoneNumber;
import javafx.beans.DefaultProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    @NotEmpty
    @Size(min = 5, max = 12)
    private String login;

    @Column(name = "email")
    @NotEmpty
    @Email
    private String email;

    @Column(name = "password")
    @NotEmpty
    @Size(min = 8, max = 24)
    private String password;

    @Column(name = "phone")
    @PhoneNumber
    private String phone;

    @Column(name = "role")
    @NotNull
    private Role role;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cartId")
    private Cart cart = new Cart();

    public User() {
    }

    public User(String login, String email, String password, Role role) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
