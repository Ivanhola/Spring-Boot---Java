# Test Package Used for testing with JUnit & Mockito


## Unit Testing
Lets have a look at a simple JUnit test example from out IndexController Test

```Java
    @Mock
    RecipeService recipeService;
     
    @Mock
    Model model;
    
    IndexController controller;
    
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        
        controller = new IndexController(recipeService);
    }

    @Test
    public void testMainPage() throws Exception{
      Set<Recipe> recipes= new HashSet<>();
      recipes.add(new Recipe());
      

      Recipe recipe = new Recipe();
      recipe.setId(1L);     
      recipes.add(recipe);
        
        
      Mockito.when(recipeService.getRecipes()).thenReturn(recipes);
      
      ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
       
       
      String viewName = controller.mainPage(model);
      
      

      assertEquals("index",viewName);     
      verify(recipeService, times(1)).getRecipes();
      

      verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
      
      

      Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
```
# 

Here We create a 'Mock Up' of a `RecipeService` object, that the Spring container would use to inject into the IndexController.java class
as well as a `Model` type object.
```Java
    @Mock
    RecipeService recipeService;
     
    @Mock
    Model model;
```

So `@Before` the test is run, we want to mimic what spring would do, which is the use of Dependency injection of our `recipeService` into the constructor of our IndexController, it is important
to __note that the recipeService here will be empty since we don't actually get a database and what the Spring container has in the real program__
```Java
    @Before
    public void setUp() throws Exception{
         //create the mocks
        MockitoAnnotations.initMocks(this);
        //dependency injection of recipeService
        controller = new IndexController(recipeService);
    }
```

Our Actual Test occurs here 

```Java
 @Test
    public void testMainPage() throws Exception{
    . . . 
    
    }
```

Looking at our __Actual__ RecipeService class/interface, we see that the method `.getRecipes()` returns a Set<>. Therefore since we have no actual data from the Spring context, we must mimic/create some sample data
by creating a `Set<Recipe>` and adding Recipe Objects to it.

```Java
      Set<Recipe> recipes= new HashSet<>();
      recipes.add(new Recipe());
      

      Recipe recipe = new Recipe();
      recipe.setId(1L);     
      recipes.add(recipe);
      
      Mockito.when(recipeService.getRecipes()).thenReturn(recipes);
```

When the __.getRecipes()__ method is called, we want to return a Set<> as that is what the real method returns,  so we use `Mockito.when(recipeService.getRecipes()).thenReturn(recipes);` to return the set we created, as the data it returns as it would return a Set if that method was called in our real program.

# 
The `ArgumentCaptor` is simply an object that makes sure you are returning/using the Type that you specify in the arguments, in this case `Set<Recipe>` is a Set type with Recipe objects in it.
```Java
 ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
       
       //the mainPage() method returns a string value, and we set viewName==the value it returns
      String viewName = controller.mainPage(model);
      
      
      //making sure the value it returns is the same as the one we are looking for
      assertEquals("index",viewName);   
      
      //make sure that the .getRecipes() method is called (1) times
      verify(recipeService, times(1)).getRecipes();
      
      //make sure that the .addAttribute("recipes",Set<>) is run 1 time
      verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
      
      
      //this is used to make sure we are using a Set with Recipe objects, since we can use a Set of String objects, and it wouldn't know.
      Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
```

