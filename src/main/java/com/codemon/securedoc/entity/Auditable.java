package com.codemon.securedoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
/*
    * This is an abstract class that will be extended by all entities that need to be audited.
    * Like the super class, it has an id, referenceId, createdBy, updatedBy, createdAt, and updatedAt fields.
 */
public abstract class Auditable {
    @Id
    @SequenceGenerator(name = "primary_key_seq", sequenceName = "primary_key_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_seq")
    @Column(name = "id", updatable = false)
    private Long id;
    private String referenceId = new AlternativeJdkIdGenerator().generateId().toString();
    @NotNull
    private Long createdBy; // Who created this record
    @NotNull
    private Long updatedBy; // Who last updated this record
    @NotNull
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; // When this record was created
    @CreatedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt; // When this record was last updated



    /*
       @PrePersist
       This will be called before saving anything in the database
     */

    @PrePersist
    public void beforePersist() {
        var userId = 1L; // Get the current user from the security context

        // If we don't know the user, we cannot save the entity throw an exception
        if(userId == null) {
           throw new ApiException("Cannot persist entity without a user ID in Request Context for this thread");
        }

        // Otherwise, set the createdBy and updatedBy fields to the current user
        setCreatedAt(now());
        setCreatedBy(userId);
        setUpdatedBy(userId);
        setUpdatedAt(now());
    }


    /*
       @PreUpdate
       This will be called before updating anything in the database
     */

    @PreUpdate
    public void beforeUpdate() {
        var userId = 1L; // Get the current user from the security context

        // If we don't know the user, we cannot save the entity throw an exception
        if(userId == null) {
            throw new ApiException("Cannot update entity without a user ID in Request Context for this thread");
        }

        // Otherwise, set the createdBy and updatedBy fields to the current user
        setUpdatedAt(now());
        setUpdatedBy(userId);
    }
}
