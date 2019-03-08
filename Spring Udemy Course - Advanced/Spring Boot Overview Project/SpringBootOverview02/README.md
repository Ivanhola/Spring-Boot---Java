# #Change Log from the [previous project](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview)

- Added a __equal(), hashCode(), and toString() __ method to our entity classes

```Java

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + ", publisher=" + publisher + ", authors=" + authors + '}';
    }
    
 ```
    
- Added [repository package](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/Spring%20Boot%20Overview%20Project/SpringBootOverview02/src/main/java/com/ivanllamas/SpringBootOverview/repository) to store our Entity Repositoy classes

Example code from one of the repositories:
```Java

public interface AuthorRepository extends CrudRepository<Author,Long> {
    
}

```
This code allows us to perform CRUD operations to our database using the Spring JPA api.
