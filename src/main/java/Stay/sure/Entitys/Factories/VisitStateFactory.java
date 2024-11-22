package Stay.sure.Entitys.Factories;

import Stay.sure.Entitys.VisitState;

public class VisitStateFactory {

    public static VisitState createVisitState(Long id, String nombre) {
        return new VisitState(id, nombre);
    }
}
