@import exercise.dto.users.UserPage
@param UserPage page

<html>
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Пользователь</title>
    </head>
    <body>
        <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
        <p>${page.getUser().getEmail()}</p>
    </body>
</html>
