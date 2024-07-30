package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
        config.bundledPlugins.enableDevLogging();
        });
        app.get("/phones", ctx -> ctx.writeJsonStream(Data.getPhones().stream()));
        app.get("/domains", ctx -> ctx.writeJsonStream(Data.getDomains().stream()));
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
