package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;
import models.valueobjects.Type;

public class NotebookBuilder {
    private Ram ram;
    private int rom = 256;
    private Company company;
    private String model = "Galaxy S20";
    private Type type;

    public NotebookBuilder(Ram ram, Company company, Type type) {
        this.ram = ram;
        this.company = company;
        this.type = type;
    }

    public NotebookBuilder setRom(int rom){
        this.rom = rom;
        return this;
    }

    public NotebookBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public Notebook build(){
        Notebook notebook = new Notebook();
        notebook.setRam(this.ram);
        notebook.setRom(this.rom);
        notebook.setModel(this.model);
        notebook.setCompany(this.company);
        notebook.setType(this.type);
        return notebook;
    }
}
