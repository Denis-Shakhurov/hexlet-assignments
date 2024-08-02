@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Пользователи</h1>
	@if(page.getTerm() == null)
	<form action="/users" method="get">
		<input type="search" required name="term">
		<input type="submit" value="Искать">
	</form>
	<table class="table table-sm table-striped">
  			<thead class="thead-dark">
    				<tr>
      					<th scope="col">#</th>
      					<th scope="col">Name</th>
      					<th scope="col">Email</th>
    				</tr>
  			</thead>
            		@for(var user : page.getUsers())
            		 <tbody class="table-striped">
    					<tr>
      					<th scope="row">${page.getUsers().indexOf(user) + 1}</th>
      					<td><a href="/users/${user.getId()}">${user.getFirstName()}</a></td>
      					<td>${user.getEmail()}</td>
    					</tr>
    				</tbody>
            @endfor
	@else
	<form action="/users" method="get">
		<input type="search" required name="term" value="${page.getTerm()}">
		<input type="submit" value="Искать">
	</form>
        	<table class="table table-sm table-striped">
  			<thead class="thead-dark">
    				<tr>
      					<th scope="col">#</th>
      					<th scope="col">Name</th>
      					<th scope="col">Email</th>
    				</tr>
  			</thead>
            		@for(var user : page.getUsers())
            		 <tbody class="table-striped">
    					<tr>
      					<th scope="row">${page.getUsers().indexOf(user) + 1}</th>
      					<td><a href="/users/${user.getId()}">${user.getFirstName()}</a></td>
      					<td>${user.getEmail()}</td>
    					</tr>
    				</tbody>
            @endfor
	@endif
`
)
