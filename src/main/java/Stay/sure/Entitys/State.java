package Stay.sure.Entitys;

public class State {

    private Long id;
    private String state;

    
    public State(Long id, String state) {
        this.id = id;
        this.state = state;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    
}
