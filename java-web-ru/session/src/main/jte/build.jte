@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
content = @`
	 @if(page != null)
        <div>
            <a>${page.getError()}</a>
        </div>

    @endif
    <form action="${NamedRoutes.loginPath()}" method="post">
        <input type="text" placeholder="NickName" name="name">
        <input type="password" placeholder="Password" name="password">
        <input type="submit">
    </form>
`
)
