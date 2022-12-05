package models.valueobjects;

import java.io.Serializable;

public class Type implements Serializable {
    private String type;

    public Type(String type) {
        if (!type.isBlank() || !type.isEmpty())
            this.type = type;
        else
            throw new IllegalArgumentException("Сортировка не может быть пустым!");
    }

    public String getType() {
        return this.type;
    }

    public Type() {
    }

    public boolean equals(Type otherType) {
        return this.type.equals(otherType.type);
    }
}
