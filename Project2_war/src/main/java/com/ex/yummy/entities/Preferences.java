package com.ex.yummy.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table

public class Preferences {
    @Id
    @Column(name="preference_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
