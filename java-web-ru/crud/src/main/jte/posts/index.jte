@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
    content = @`
	<h1>Список постов</h1>
	<ul>
	@for (var post : page.getPosts())
		<li>
		<a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
		</li>
	@endfor
	</ul>
	<nav aria-label="Page navigation example">
  <ul class="pagination">
  	@if(page.getNumber() > 1)
    <li class="page-item"><a class="page-link" href="/posts?page=${page.getNumber() - 1}">Назад</a></li>
    	@endif
    <li class="page-item">
    <input type="button" name="page" value="${page.getNumber()}" />
    </li>
    <li class="page-item"><a class="page-link" href="/posts?page=${page.getNumber() + 1}">Вперёд</a></li>
  </ul>
</nav>
<div>
`
)
