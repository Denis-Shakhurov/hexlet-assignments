@import gg.jte.Content
@param Content content
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    <title>Hexlet Javalin Example</title>
  </head>
  <body>
    <ul class="nav nav-pills">
      <li class="nav-item">
        <a class="nav-link active" href="/">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/users">Users</a>
      </li>
    </ul>
    ${content}
    <footer class="fixed-bottom">
      <a href="https://github.com/Denis-Shakhurov">Denis Shakhurov</a>
    </footer>
  </body>
</html>
