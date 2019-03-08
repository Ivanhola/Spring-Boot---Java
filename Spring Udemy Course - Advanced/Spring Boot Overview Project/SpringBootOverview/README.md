## Basic Project That contains 2 JPA entity classes

- You can access the database by going to __localhost:8080/h2-console__

We annotate this variable in the entity classes with `@ManyToMany` to specify that the column in the database will be related to
a column on another table within the database, in this case it is related to the `books` column on the __`Author`__ class

__Many to many relationship on the Book.java class__
```Java

@ManyToMany
@JoinTable(name="author_books", joinColumns = @JoinColumn(name="book_id"), inverseJoinColumns= @JoinColumn(name="author_id"))
private Set<Author> authors = new HashSet<>();

```
__Many to many relationship on the Author.java class__

```Java

 @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
    
```
