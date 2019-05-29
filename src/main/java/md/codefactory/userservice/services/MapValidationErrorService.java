package md.codefactory.userservice.services;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
public class MapValidationErrorService {

    public Map<String, String> mapValidationService(BindingResult result) {

        if (!result.hasErrors()) {
            return null;
        }

        return result.getFieldErrors().stream()
                .collect(toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));

    }
}
