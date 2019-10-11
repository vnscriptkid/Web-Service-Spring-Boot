1. Notes

- Test

  - C:\Users\vnscr\AppData\Roaming\Code\User\workspaceStorage

- Security

  - deps: see pom.xml
  - custom config
    > extends WebSecurityConfigurerAdapter
  - annotations
    > @Configuration
    > @EnableWebSecurity
  - Auth Types:
    > Basic Auth: username + password -> base64, sent along with requests
    > JWT token
  - status
    > 401: Unauthorized

- Layers of Web Service
  - Entity (Model)
    - Map between DB table and an object
  - Repository
    - extends CrudOperations -> reduce boilerplate code
      > interface, implementation is created on the fly
      > JPA repository
    - DAO layer
  - Service: contains business logic
    - interface
    - implementation
  - Web Controller
    - @RestController
    - @GetMapping
      - @RequestMapping (method = RequestMethod.GET)
    - return new ResponseEntity (entire Http response)

2. Observations

- One class can have multiple constructors
- @Autowired
  - Above properties: inject dependencies
  - Above setters: looks like same as above but more code needed
  - Above others: ...
    > https://www.baeldung.com/spring-autowire
