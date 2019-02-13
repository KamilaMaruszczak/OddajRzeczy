package pl.maruszczak.validator;

import org.springframework.beans.factory.annotation.Autowired;
import pl.maruszczak.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        try {
            List<String> emailList = userRepository.queryFindAllEmails();
            return !emailList.contains(email);
        } catch (NullPointerException e) {
            return true;
        }

    }
}
