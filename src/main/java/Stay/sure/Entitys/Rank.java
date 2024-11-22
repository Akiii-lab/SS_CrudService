package Stay.sure.Entitys;

public class Rank {
    private Long id;
    private String name;
    private Float assessment;
    
    public Rank(Long id, String name, Float assessment) {
        this.id = id;
        this.name = name;
        this.assessment = assessment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAssessment() {
        return assessment;
    }

    public void setAssessment(Float assessment) {
        this.assessment = assessment;
    }

    
}
