# Documentation for Recipe project

## Technologies

- Entities
- Spring Data JPA + Repositories
- H2 Database
- JPA Database Mappings

## Packages

- [__Controller__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/controller)
- [__Entity__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/model)
- [__Repository__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/repository)
- [__Bootstrap__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/BootStrap);

## Controller Package
As We've covered in other examples, the Controller takes care of the GET requests and HTTP protocols depending on URL.

# Entity Package
This project makes heavy emphasis on spring data JPA Entities and annotations associated with it like __@OneToOne, @OneToMany, @ManyToOne, @ManyToMany__ and others. We will break down the use of each annotation in the following code snippets from our entity classes and the Structure of the database.

Our _'main'_ Table in our database is __Recipe__

```Java
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
    private Set<Ingredient> ingredients;
    
    @Lob
    private Byte[] image;
    
    

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty; 

   
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    
    

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"), 
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
```

You'll notice the different annotations with __@OneToXXXX__ on it, lets break down what each annotation does, and how the database is mapped.

## @OneToOne
This specifies that there is a relationship in the database tables with a __Single__ relationship, in this case, recipe is related to the __Notes__ entity  and in the Notes entity it is related back to recipe
```Java

    //Recipe Class -> Notes 
    @OneToOne
    private Notes notes;
    
/*They both relate to each other v^*/
    
    //Notes class -> Recipe
    @OneToOne
    private Recipe recipe;
```

Gives us a result of having the Recipe_ID object in one of the columns (One Notes Corresponds to One Recipe)

## @OneToMany / @ManyToOne
Refers to the relationship between 2 entities, where __A__ might be linked to many elements of __B__ but __B__ is only linked to one element of __A__ example: ___One__ area can be the habitat of __many__ readers(OneToMany)._  but ___Many__ readers live in __one__ area._ Usually the Variables with __@ManyToOne__ are the 'owning' column in the database, meaning that the table _Recipe_ will __NOT__ have a column for _ingredients_ but _ingredients_ will have a column for _Recipe_

```Java
    public class Recipe{
    
    //One recipe can have many ingredients
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
    private Set<Ingredient> ingredients;
    }
    
    /*********************************/
    
    public class Ingredient{
    
    //Many Ingredients have one recipe
    @ManyToOne
    private Recipe recipe;
    
    }
    
```

## @ManyToMany
This refers to the relationship where 2 entitie, A and B, in which A may contain a parent instance for which there are many children in B and vice versa. for example: _think of A as Authors, and B as Books. An Author can write several Books, and a Book can be written by several Authors._ In this case, there will be a seperate table that integrates both of these entities and their respective ID values, as annotated by _categories_ there will be a table called __recipe_category__ with columns __recipe_id__ and __category_id__ pointing to the recipe and category objects in their respective columns.

```Java
public class Recipe{
    //There can be many recipes in different categories
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"), 
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
    }
    
    public class Category{
    //there can be many catagories of recipes
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
    }
```

## Cascade 

You may have noticed the Cascade, this means that anything done to the 'Notes' object will cascade down into the __Notes__ entity itself, and the respective columns of that entity. For example, in this program we do not have a __NotesRepository__ to add the Notes objects to our database, __instead we create a Notes object__ in our bootstrap class, and add the _Notes_ object to our Recipe, which then cascades down to the 'Notes' Entity and creates the values as well as adding to our database when we add the _Recipe_ object.
```Java
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    
    /* FROM BOOTSTRAP CLASS*/
            Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("this is a descripting");
        
        Recipe testRecipe = new Recipe();
        //setting Notes to our recipe using setter
        testRecipe.setNotes(guacNotes);
        
 ```

## Bootstrap

This package contains __starter__ data that is injected onto our database, so that we have something to reference and look at before having our own methods and implementations for performing CRUD operations with our own data.

Calling our Repository to upload data into the database
```Java

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    
    @Autowired
    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    recipeRepository.saveAll(getRecipes());    
    }
    
    
 ```
 
 
 Example of creating a recipe object and pushing it the the database
 

