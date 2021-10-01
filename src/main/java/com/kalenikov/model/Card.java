package com.kalenikov.model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id"})
@EqualsAndHashCode(of = {"id"})
public class Card {
    private int id;
    private String name;
    private Timestamp lastSeen;
}
