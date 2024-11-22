package Stay.sure.Entitys;

public class Room {
    private Long id;
    private String lugar; 
    private Integer tamaño;
    private Long id_Lesse;

    public Room(Long id, String lugar, Integer tamaño, Long id_Lesse) {
        this.id = id;
        this.lugar = lugar;
        this.tamaño = tamaño;
        this.id_Lesse = id_Lesse;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public Integer getTamaño() {
        return tamaño;
    }
    public void setTamaño(Integer tamaño) {
        this.tamaño = tamaño;
    }
    public Long getId_Lesse() {
        return id_Lesse;
    }
    public void setId_Lesse(Long id_Lesse) {
        this.id_Lesse = id_Lesse;
    }

    
}
