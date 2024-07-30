package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javelin.create(config -> {
        config.bundleadPlugins.enableDevLogging();
        });
        app.get("/phones", ctx -> ctx.writeJsonStream(Data.getPhones());
        app.get("/domains", ctx -> ctx.writeJsonStream(Data.getDomains());
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
