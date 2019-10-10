# GraphQL

### Dependencies needed:

- graphql-spring-boot-starter
- graphiql-spring-boot-starter
- graphql-java-tools

### Schema

- Where: /resources/graphql/location.graphqls
- 1 root Query & 1 root Mutation for a given type
- Complex type like Location maps Location class in /entity

### Java Side

- Query class
  > implements GraphQLQueryResolver
  > handle all queries that are defined in schema
- Mutation class
  > implements GraphQLMutationResolver
  > handle all mutation operations in schema

### Operations

- Queries: retrieve data
- Mutations: create, update, delete data

### Exception Handling

- Custom ones
  > extends RuntimeException
  > implements GraphQLError

### Tools

- GraphiQL: GUI tool to test query to graphql server
- Postman
