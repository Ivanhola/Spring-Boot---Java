# Documentation for Recipe project
Update 04/08/19 - Extensive Documentation found at: [http://ivanllamas.com/Documentation/RecipeProjectDocumentation](http://ivanllamas.com/Documentation/RecipeProjectDocumentation)

## Technologies

- Entities
- Spring Data JPA + Repositories
- H2 Database
- JPA Database Mappings

## Packages

- [__Controller__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/controller)
- [__Entity__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/model)
- [__Repository__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/repository)
- [__Bootstrap__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/BootStrap)
- [__CommandObjects__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/CommandObjects)
- [__Converters__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/Converters)


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
 
 Here We create Some Objects, and add them to the recipe class, and then adding the recipe object to a list, which is saved into the repository in the onApplicationEvent() method
 
```Java
 Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        
        //if there is no Description with 'Each' in our database throw exception
        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of Measure not found");
        }
        
        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        //if there is no Description with 'Tablespoon' in our database throw exception
        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of Measure not found");
        }
        
        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        //if there is no Description with 'Teaspoon' in our database throw exception
        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of Measure not found");
        }
        
        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        //if there is no Description with 'Dash' in our database throw exception
        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of Measure not found");
        }
        
        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        //if there is no Description with 'Pint' in our database throw exception
        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of Measure not found");
        }
        
        Optional<UnitOfMeasure>cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        //if there is no Description with 'Cup' in our database throw exception
        if(!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected Unit of Measure not found");
        }
        
        //get UnitOfMeasure from the optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        
        //get Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        
        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }
        
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }
        
        
        //get category object from the optionals
        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();
        
        //Guacamole Recipe
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");
        
        
        //notes for guacamole
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        
        /* *OLD needed for bidirectional, - should be a method call
        guacRecipe.setNotes(guacNotes);
        guacNotes.setRecipe(guacRecipe);
        */
        
        //NEW Version
        guacRecipe.setNotes(guacNotes);
        
        
        guacRecipe.addIngredient(new Ingredient("Ripe Avocado", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), teaSpoonUom));
        guacRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashUom));
        guacRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUom));

        //Setting our category in our Many to many relationship
        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);
        
        guacRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole");
        guacRecipe.setServings(4);
        guacRecipe.setSource("Simply Recipes");
        
        //add to our List variable.
        recipes.add(guacRecipe);
```


## Command Objects

This is a very simple class, where we simply mimic the __entities__, and turn them into __POJO__, This is useful when using Form Processing/Post Processing, in [this example](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/Spring%20Udemy%20Course/HibernateDemo/src/main/java/com/ivanllamas/HibernateDemo/StudentController.java) we have an object that is created in thymeleaf, which we then pass on to our controller. __The Difference between CommandObject and Entity__ In this example below, we are using our entity objects to bind data __which isn't good practice__, instead we should be creating __Command Objects__ to mimic the variables from our entity, and binding data to the CommandObject

```HTML
<!-- The form, creates an object from the model passed in 'studentObj' in the controller.-->
 <form action="#" th:action="@{processForm}" th:object="${studentObj}" >     
            First name: <input type="text" th:field="*{firstName}"/> 
            Last name: <input type="text" th:field="*{lastName}"/>
            Email: <input type="text" th:field="*{email}"/>
            <input type="submit"/>
```

Here the model attribute 'studentObj' is passed in, and the data is binded to a tempStudent object/entity, which is then used to upload the object to the database.
```Java
@RequestMapping("/processForm")
    public String processForm(@ModelAttribute("studentObj") Student tempStudent){
        Student student = new Student(tempStudent.getFirstName(), tempStudent.getLastName(), tempStudent.getEmail());
        System.out.println("Adding student to our database.." + student.toString());

        service.add(student);
        
        System.out.println("Uploaded to database!");
        
        return "form-processed";
```

### Command Object Example 

Here We simply create the same variables and types as it is in our entity, we then use [Converters](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/Converters) to convert the NotesCommand object into a __Notes__ entity.
```Java

public class NotesCommand {

    private Long id;
    private RecipeCommand recipeCommand;
    private String recipeNotes;

    
    /*No-Arg Constructor*/
    public NotesCommand() {
    }
    
    /*Getters and Setter*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    . . .
```

## Converters

Here We are simply taking the [NotesCommand](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/CommandObjects/NotesCommand.java) object, taking the variables, and adding those values to the __Notes__ object, and we __do the same__ for every Converter Object in this package.
```Java
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes>{

    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
    if(source == null){
        return null;
    }    
    
    final Notes notes = new Notes();
    notes.setId(source.getId());
    notes.setRecipeNotes(source.getRecipeNotes());
    return notes;
    }
}

```
