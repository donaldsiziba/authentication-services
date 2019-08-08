package za.co.awesomatic.authentication.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.awesomatic.tdd.PasswordValidator;
import za.co.awesomatic.tdd.vo.ValidationData;
import za.co.awesomatic.tdd.vo.ValidationResult;

@RestController
public class AuthenticationController {
    @Autowired
    PasswordValidator passwordValidator;

    @PostMapping("/validatepassword")
    @ResponseStatus(HttpStatus.OK)
    public ValidationResult validatePassword(@RequestBody ValidationData validationData) {
        return passwordValidator.validate(validationData);
    }
}
