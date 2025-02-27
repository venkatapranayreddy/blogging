package com.as.Blog.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Authority implements Serializable {

    @Id
    @Column(length = 16)
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Authority authority1 = (Authority) o;

        return name.equals(authority1.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}