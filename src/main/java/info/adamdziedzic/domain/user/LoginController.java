package info.adamdziedzic.domain.user;

import info.adamdziedzic.network.response.LoginResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public LoginResponse loginUser(@QueryParam("username") String username, @QueryParam("password") String password) {
        return new LoginResponse("ok");
    }
}
