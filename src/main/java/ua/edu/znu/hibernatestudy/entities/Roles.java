package ua.edu.znu.hibernatestudy.entities;

import org.hibernate.annotations.Type;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description", nullable = false, length = 2000)
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @Column(name = "created_at")
    private Instant created_at = Instant.now();

    @Column(name = "edited_ed")
    private Instant edited_ed;

    @Column(name = "author_id")
    private Long author_id;

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Instant getEdited_ed() {
        return edited_ed;
    }

    public void setEdited_ed(Instant edited_ed) {
        this.edited_ed = edited_ed;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}