package com.boris.tyutin.chat.model.entity;

import com.boris.tyutin.chat.security.entity.Role;
import lombok.*;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import static com.boris.tyutin.chat.security.entity.Role.USER;

@Setter
@Getter
@Entity
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private List<Message> messages;

    public Role getRole() {
        return USER;
    }
}
