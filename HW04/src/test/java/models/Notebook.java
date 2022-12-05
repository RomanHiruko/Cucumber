package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;
import models.valueobjects.Type;

import java.io.Serializable;

public class Notebook implements Serializable {
    private Ram ram;
    private int rom;
    private Company company;
    private String model;
    private Type type;

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Notebook(Ram ram, Company company, Type type) {
        this.ram = ram;
        this.company = company;
        this.type = type;
    }

    public Notebook() {
    }
}
