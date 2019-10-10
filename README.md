1. Notes

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
