import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class AuthenticationTest {

    //***** comments are in the method names *****

    @Test
    void itShouldRegisterSuccessfully() {
        Authentication authentication = new Authentication();
        String email = "test@test.com";
        String password = "123";

        // should return this string containing the email and the pass
        assertThat(authentication.register(email, password)).contains("registered, Email: "+ email+" password: "+password);
    }

    @Test
    void itShouldFailToRegisterBecauseEmailIsTaken() {
        Authentication authentication = new Authentication();
        String email = "taken@email.com";
        String password = "123";

        // should return this string containing the email and the pass
        assertThat(authentication.register(email, password)).contains("email is taken");
    }

    @Test
    void itShouldLoginSuccessfully() {
        Authentication authentication = new Authentication();
        User user = new User("test@test.com", "123");

        // given
        String email = "test@test.com";
        String password = "123";

        assertThat(authentication.login(user, email, password)).contains("login successfully");
    }

    @Test
    void itShouldFailLoginOnEmailAuth() {
        Authentication authentication = new Authentication();
        User user = new User("test@test.com", "123");

        // given
        String email = "test@failed.com";
        String password = "123";

        assertThat(authentication.login(user, email, password)).contains("email is wrong");
    }

    @Test
    void itShouldFailLoginOnPassAuth() {
        Authentication authentication = new Authentication();
        User user = new User("test@test.com", "123");

        // given
        String email = "test@test.com";
        String password = "123456";

        assertThat(authentication.login(user, email, password)).contains("password is wrong");
    }
}