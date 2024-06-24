package com.example.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Objects;

@Data
@Embeddable
public class EmployeeID implements java.io.Serializable {
    private int division;
    private int id;

    public EmployeeID() {
    }

    public EmployeeID(int division, int id) {
        this.division = division;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeID that = (EmployeeID) o;
        return division == that.division && id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(division, id);
    }
}
