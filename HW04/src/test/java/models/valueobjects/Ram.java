package models.valueobjects;

import java.io.Serializable;

public class Ram implements Serializable {
    private int ram;

    public Ram() {
    }

    public Ram(int ram) {
        if (ram > 0)
            this.ram = ram;
        else
            throw new IllegalArgumentException("ОП не может быть меньше 0");
    }

    public int getRam() {
        return this.ram;
    }

    public boolean equals(Ram otherRam) {
        return this.ram == otherRam.ram;
    }
}
