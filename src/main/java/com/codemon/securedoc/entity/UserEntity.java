package com.codemon.securedoc.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static jakarta.persistence.FetchType.EAGER;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonInclude(NON_DEFAULT)
public class UserEntity  extends Auditable {

    @Column(updatable = false, unique = true, nullable = false)
    private String userId;
    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;
    private Integer loginAttempts;
    private LocalDateTime lastLogin;
    private String phone;
    private String bio;
    private String imageUrl;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;
    private boolean mfa;
    @JsonIgnore  // Do not include this in the response
    private String qrCodeSecret;
    @Column(columnDefinition = "TEXT")
    private String qrCodeImageUrl;

    // Many user can be mapped to one role
    @ManyToOne(fetch = EAGER)
    // This join table will create a new table called user_roles to map the userEntity
    // and roleEntity tables
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"
            )
    )
    private RoleEntity role;
}