package Stay.sure.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Stay.sure.Entitys.DTO.StateTransitionsDTO;
import Stay.sure.Servicies.StateTransitionsService;

@RestController
@RequestMapping("/api/stateTransition")
public class StateTransitionController {

    @Autowired
    private StateTransitionsService stateTransitionService;

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save( StateTransitionsDTO stateTransition) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        StateTransitionsDTO savedStateTransition = stateTransitionService.save(stateTransition);
        if (savedStateTransition != null) {
            result.put("stateTransition", savedStateTransition);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
        
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update( StateTransitionsDTO stateTransition) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        StateTransitionsDTO updatedStateTransition = stateTransitionService.update(stateTransition);
        if (updatedStateTransition != null) {
            result.put("stateTransition", updatedStateTransition);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
        
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HashMap<String, Object>> findById(Long id) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        StateTransitionsDTO foundStateTransition = stateTransitionService.findById(id);
        if (foundStateTransition != null) {
            result.put("stateTransition", foundStateTransition);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
        
    }
}
