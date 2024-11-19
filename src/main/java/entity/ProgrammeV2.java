//LimShiLei
package entity;

public class ProgrammeV2 {
    private String programmeCode;
    private String programmeName;
    private String programmeDescription;

    public ProgrammeV2() {
    }

    public ProgrammeV2(String code, String name, String description) {
        this.programmeCode = code;
        this.programmeName = name;
        this.programmeDescription = description;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public String getProgrammeDescription() {
        return programmeDescription;
    }

    public void setProgrammeDescription(String programmeDescription) {
        this.programmeDescription = programmeDescription;
    }
}