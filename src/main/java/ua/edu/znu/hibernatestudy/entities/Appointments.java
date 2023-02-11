package ua.edu.znu.hibernatestudy.entities;

import com.mysql.cj.util.SaslPrep;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "appointments")
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime start_time;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime end_time;

    @Column(name = "author_id", nullable = false)
    private Long author_id;

    @Column(name = "cteate_at")
    private Timestamp cteate_at;

    @Column(name = "edited_ed", nullable = false)
    private Date edited_ed;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "appointments", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Services> serviceses = new LinkedHashSet<>();

    @Column(name = "specialist_id", nullable = false)
    private Long specialist_id;

    @ElementCollection
    @Column(name = "status")
    @CollectionTable(name = "appointments_status", joinColumns = @JoinColumn(name = "owner_id"))
    private Set<char[]> status = new LinkedHashSet<>();

    @OneToMany(mappedBy = "appointments", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Orders> orderses = new LinkedHashSet<>();

    public Set<char[]> getStatus() {
        return status;
    }

    public void setStatus(Set<char[]> status) {
        this.status = status;
    }

    public Long getSpecialist_id() {
        return specialist_id;
    }

    public void setSpecialist_id(Long specialist_id) {
        this.specialist_id = specialist_id;
    }

    public Set<Services> getServiceses() {
        return serviceses;
    }

    public void setServiceses(Set<Services> serviceses) {
        this.serviceses = serviceses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getEdited_ed() {
        return edited_ed;
    }

    public void setEdited_ed(Date edited_ed) {
        this.edited_ed = edited_ed;
    }

    public Timestamp getCteate_at() {
        return cteate_at;
    }

    public void setCteate_at(Timestamp cteate_at) {
        this.cteate_at = cteate_at;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}