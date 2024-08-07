@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

@template.layout.page(
content = @`
    <main>
        @if(page.getName() != null)
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
    		<div class="collapse navbar-collapse" id="navbarNavDropdown">
    		<h2>${page.getName().toString()}</h2>
                <form action="${NamedRoutes.logoutPath()}" method="post">
                    <button type="submit">Выйти</button>
                </form>
    		</div>
		</nav>
	@else
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
    		<div class="collapse navbar-collapse" id="navbarNavDropdown">
        		<ul class="navbar-nav">
           			<li class="nav-item">
                		<form action="/sessions/build" method="post">
                    <button type="submit">Войти</button>
                </form>
            			</li>
        		</ul>
    		</div>
		</nav>
        @endif
    </main>
`
)
