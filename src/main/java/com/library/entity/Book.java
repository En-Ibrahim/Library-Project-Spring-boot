package com.library.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Book {

    @Id
    private Long id;
    private String title;
    private String date;
    private int version;

    @ManyToOne
    private Author author;

}
