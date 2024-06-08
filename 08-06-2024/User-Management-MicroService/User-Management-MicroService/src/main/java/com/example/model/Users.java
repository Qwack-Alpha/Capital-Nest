// Users.java
package com.example.model;
 
import java.time.LocalDateTime;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
 
    @NotNull
    @Size(min = 0, max = 50)
    private String first_name;
 
    @NotNull
    @Size(min = 0, max = 50)
    private String last_name;
 
    @NotNull
    @Min(value = 0, message = "Value must be greater than or equal to 0")
    @Max(value = 100, message = "Value must be less than or equal to 99")
    private int user_age;
 
    @NotNull
    @Size(min = 0, max = 50)
    private String user_email;
 
    @NotNull
    @Column(unique = true)
    @Size(min = 0, max = 11)
    private String user_phone;
 
    @NotNull
    @Size(min = 0, max = 200)
    private String user_address;
 
    @NotNull
    @Size(min = 0, max = 20)
    private String user_password;
 
    @NotNull
    private int balance = 1000;
 
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
 
    @NotNull
    private RoleEnum role;
 
}
