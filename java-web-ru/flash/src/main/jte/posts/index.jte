@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <h1>Публикация постов</h1>
	@if(page.getFlash() != null)
		<p class="text-success">${page.getFlash()}</p>
	@endif
	<form action="${NamedRoutes.postsPath()}" method="get">
	</form>
	@if(page.getPosts().isEmpty())
		<p>Пока не добавлено ни одного поста</p>
		<a href="${NamedRoutes.buildPostPath()}">Создать пост</a>
	@else
        	<table class="table table-sm table-striped">
  			<thead class="thead-dark">
    				<tr>
      					<th scope="col">#</th>
      					<th scope="col">Name</th>
      					<th scope="col">Description</th>
    				</tr>
  			</thead>
            		@for(var post : page.getPosts())
            		 <tbody class="table-striped">
    					<tr>
      					<th scope="row">${page.getPosts().indexOf(post) + 1}</th>
      					<td><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></td>
      					<td>${post.getBody()}</td>
    					</tr>
    				</tbody>
            @endfor
			</table>
	@endif
`
)
