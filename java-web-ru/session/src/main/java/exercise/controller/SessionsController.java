package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;
import io.javalin.http.NotFoundResponse;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = encrypt(ctx.formParam("password"));
        try {
            var user = UsersRepository.findByName(name)
                                      .orElseThrow(() -> new NotFoundResponse("not found")); 

            if (user.getPassword().equals(password)) {
                ctx.sessionAttribute("currentUser", name);
                ctx.redirect("/");
            } else {
                var page = new LoginPage(name, "Wrong username or password");
                ctx.render("build.jte", model("page", page));
            }
        } catch (NotFoundResponse e) {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }

    public static void show(Context ctx) {
        var attribute = ctx.sessionAttribute("currentUser");
        var page = new MainPage(attribute);
        ctx.render("index.jte", model("page", page));
    }
    // END
}
