package com.example.s3cur1ty.model.entites;

import com.example.s3cur1ty.model.enums.ActionType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "permission", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"subject", "action"})
})
public class Permission {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    @Enumerated(EnumType.STRING)
    private ActionType action;
}
