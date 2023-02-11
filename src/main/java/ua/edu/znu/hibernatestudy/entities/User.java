package ua.edu.znu.hibernatestudy.entities;

import org.hibernate.annotations.Type;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @Column(name = "surname", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String surname;

    @Column(name = "comment", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String comment;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ElementCollection
    @Column(name = "sex", length = 25)
    @CollectionTable(name = "users_sex", joinColumns = @JoinColumn(name = "owner_id"))
    private List<char[]> sex = new ArrayList<>();

    @Column(name = "bio_info", nullable = false, length = 2000)
    @Type(type = "org.hibernate.type.TextType")
    private String bio_info;

    @Column(name = "is_active", nullable = false)
    private Boolean active = false;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "author_id", nullable = false)
    private Long author_id;

    @Column(name = "create_at")
    private Timestamp create_at;

    @Column(name = "edited_ed", nullable = false)
    private Date edited_ed;

    @ManyToMany(mappedBy = "users", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Services> specialist_id = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Roles> roleses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Appointments> appointmentses = new LinkedHashSet<>();

    public Date getEdited_ed() {
        return edited_ed;
    }

    public void setEdited_ed(Date edited_ed) {
        this.edited_ed = edited_ed;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getBio_info() {
        return bio_info;
    }

    public void setBio_info(String bio_info) {
        this.bio_info = bio_info;
    }

    public List<char[]> getSex() {
        return sex;
    }

    public void setSex(List<char[]> sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
