package Stay.sure.Entitys.Factories;

import java.util.Date;

import Stay.sure.Entitys.VisitTransition;

public class VisitTransitionFactory {

    public static VisitTransition createVisitTransition(Long id, Long id_visit, Long id_visitState, Date date) {
        return new VisitTransition(id, id_visit, id_visitState, date);
    }
}
