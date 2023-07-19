public class Animal {
    private String name;
    private String regnum;
    private String clas;
    private String infraclass;
    private String branch;
    private String ordo;
    private String familia;
    private String information;

    public Animal(String name, String regnum, String clas, String infraclass, String branch, String ordo, String familia, String information) {
        this.name = name;
        this.regnum = regnum;
        this.clas = clas;
        this.infraclass = infraclass;
        this.branch = branch;
        this.ordo = ordo;
        this.familia = familia;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegnum() {
        return regnum;
    }

    public void setRegnum(String regnum) {
        this.regnum = regnum;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getInfraclass() {
        return infraclass;
    }

    public void setInfraclass(String infraclass) {
        this.infraclass = infraclass;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getOrdo() {
        return ordo;
    }

    public void setOrdo(String ordo) {
        this.ordo = ordo;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", regnum='" + regnum + '\'' +
                ", clas='" + clas + '\'' +
                ", infraclass='" + infraclass + '\'' +
                ", branch='" + branch + '\'' +
                ", ordo='" + ordo + '\'' +
                ", familia='" + familia + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}
