package Stay.sure.Entitys;

import java.util.Date;

public class VisitTransition {
    private Long id;
    private Long id_visit;
    private Long id_visitState;
    private Date date;
    
    public VisitTransition(Long id, Long id_visit, Long id_visitState, Date date) {
        this.id = id;
        this.id_visit = id_visit;
        this.id_visitState = id_visitState;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_visit() {
        return id_visit;
    }

    public void setId_visit(Long id_visit) {
        this.id_visit = id_visit;
    }

    public Long getId_visitState() {
        return id_visitState;
    }

    public void setId_visitState(Long id_visitState) {
        this.id_visitState = id_visitState;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}
