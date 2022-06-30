package com.example.lottery.enity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Winner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name ="age")
    private Integer age;

    @Column(name = "city")
    private String city;

    @Column(name = "price")
    private Integer price;
}
