package za.co.awesomatic.authentication.stories;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import za.co.awesomatic.tdd.vo.ValidationData;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatePassword {
    @Given("the following password <password>")
    public void givenTheFollowingPassword(final String password) {
        Serenity.getCurrentSession().put("password", password);
    }

    @When("the password is validated against a defined rule set")
    public void whenThePasswordIsValidated() {
        final ValidationData validationData = new ValidationData(Serenity.getCurrentSession().get("password").toString());
        SerenityRest.given()
                .contentType("application/json")
                .body(validationData)
                .when()
                .post("http://localhost:8780/authenticationservices/validatepassword");
    }

    @Then("the result should be <valid>")
    public void thenTheResultShouldBe(final boolean valid) {
        assertThat(SerenityRest.then()
                .extract().statusCode()).
                isEqualTo(HttpStatus.SC_OK);
        assertThat(valid ? Boolean.TRUE : Boolean.FALSE).
                isEqualTo(Boolean.valueOf(SerenityRest.then()
                        .extract().body().jsonPath().getString("valid")));
    }

    @Then("the following message should be returned to the user <messages>")
    public void thenTheFollowingMessageShouldBeReturnedToTheUser(List<String> messages) {
        assertThat(SerenityRest.then()
                .extract().response().body().jsonPath().getList("messages")
                .stream()
                .map(message -> (String) message)
                .collect(Collectors.toList())).
            isEqualTo(messages);
    }
}
