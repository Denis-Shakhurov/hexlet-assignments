@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <h1>${page.getPost().getName()}</h1>
    <p>${page.getPost().getBody()}</p>
    
    <button type="button" name="popup-button">
    	<a href="${NamedRoutes.postsPath()}">К списку постов</a>
    </button>
`
)
