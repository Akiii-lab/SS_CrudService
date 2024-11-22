package Stay.sure.Entitys.DTO;

public class RankDTO {
    public Long id;
    public String name;
    public Float assessment;
    
    public RankDTO(Long id, String name, Float assessment) {
        this.id = id;
        this.name = name;
        this.assessment = assessment;
    }
}
