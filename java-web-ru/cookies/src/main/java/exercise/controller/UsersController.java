package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;
import java.util.Objects;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
     public static void create(Context ctx) {
        var token = Security.generateToken();
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var password = ctx.formParam("password");
        var email = ctx.formParam("email");

        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);

        var id = user.getId();
        ctx.cookie("token", user.getToken());
        ctx.redirect(NamedRoutes.userPath(id));
    }

    public static void show(Context ctx) {
        var token = ctx.cookie("token");
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User nod found"));
        if (Objects.requireNonNull(token).equals(user.getToken())) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
