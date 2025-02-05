# Instructions

1. Fork this git repository
2. Create new branch `exercise`
3. Only make changes in that new branch
4. Once all required changes are applied, create a PR

To maximize this spring boot exploration, I think the ideal scenario of the exercise would be:
1. You try to explore & implement each of the required changes in each section
2. Once the acceptance criteria is met, create a new PR so that I can review it
3. I'll provide continuous feedback until I think that the PR looks good

# To-do-list Application

When everything is done, the app should have:
- API to add a new to-do into the database
- API to read all existing to-dos in the database
- API to delete a to-do according to it's ID

## Section 0 - Setting up a new entity model

In creating the new entity model, you could refer to 

`Todo`:
```json
{
  "activity": "[string]",
  "id": "[randomly-generated-uuid]"
}
```

## Section 1 - Setting up a new controller to accommodate todo-related API

You could think of a controller as an API endpoint listener. For example, see `HelloWorldController`.

Acceptance criteria:
- Successfully created a new controller
- The application can be run without crashing

Stretch goal:
- Write up a comment in the code explaining what each annotation (`@RestController, @Service, @Data, @RequiredArgsController, etc`) is, and what does it do 

## Section 2 - Setting up a new service layer to handle business logic

The service layer will handle the logic for adding, reading, and deleting to-dos. The controller should only be responsible for accepting HTTP requests and forwarding them to the service layer. This separation of concerns helps with testability and maintainability.

Acceptance criteria:
- Create a `TodoService` class to handle the business logic for CRUD operations (Create, Read, Delete) on to-dos.
- As currently we don't really have database, the business logic for each method should only be just construct the todo based on the API request.
- The controller should call the service methods to perform these actions.
- The service methods should interact with the repository to persist data.

## Section 3 - Setting up a repository layer to interact with the database

In this section, you will create a `TodoRepository` to interact with the database and perform CRUD operations. The repository will use Spring Data JPA to automatically generate the necessary queries based on the method names.

Acceptance criteria:
- Create a `TodoRepository` interface extending `JpaRepository`.
- Use appropriate JPA annotations to map the `Todo` entity to the database table.
- Ensure that the repository has methods to save, find, and delete to-dos.

## Section 4 - to be added
