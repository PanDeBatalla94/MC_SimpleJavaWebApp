package gradle.cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;


public class BasicStepsdefs {
    @Given("A failing scenario")
    public void a_failing_scenario() {
        Assert.assertEquals(1,1);
    }


    @When("I press start the page display an error message")
    public void i_press_start_the_page_display_an_error_message() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(1,2);
    }

    @When("I press start the page display a success message")
    public void i_press_start_the_page_display_a_success_message() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(1,1);
    }

    @Then("I go to error page")
    public void i_go_to_error_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(1,1);
    }

    @Given("A passing scenario")
    public void a_passing_scenario() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(1,1);
    }

    @When("I press start the page display a message")
    public void i_press_start_the_page_display_a_message() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(1,1);
    }

    @Then("I go to main page")
    public void i_go_to_main_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(1,1);
    }
} 