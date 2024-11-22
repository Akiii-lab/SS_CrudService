package Stay.sure.Entitys.DTO;

public class RoomDTO {
    public Long id;
    public String lugar; 
    public Integer tamaño;
    public Long id_Lesse;

    public RoomDTO(Long id, String lugar, Integer tamaño, Long id_Lesse) {
        this.id = id;
        this.lugar = lugar;
        this.tamaño = tamaño;
        this.id_Lesse = id_Lesse;
    }
}
