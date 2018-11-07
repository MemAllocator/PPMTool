package io.nocompany.ppmtool.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "project Name is required")
    private String projectName;
    @NotBlank(message = "project Identifier is required")
    @Size(min=4,max = 5, message = "please use 4 to 5 characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message = "project description is required")
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end_date;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    public Project() {
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
