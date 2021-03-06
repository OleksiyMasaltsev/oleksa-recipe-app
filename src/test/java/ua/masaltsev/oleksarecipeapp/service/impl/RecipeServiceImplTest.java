package ua.masaltsev.oleksarecipeapp.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.masaltsev.oleksarecipeapp.domain.Recipe;
import ua.masaltsev.oleksarecipeapp.repositories.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    private RecipeServiceImpl recipeServiceImpl;

    @Mock
    private RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void findAll() {

        Recipe recipe = new Recipe();
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        when(recipeServiceImpl.findAll()).thenReturn(recipeList);

        List<Recipe> recipes = recipeServiceImpl.findAll();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }


    @Test
    void findByDescription() {
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
        Recipe recipe = new Recipe();
        long id = 3L;
        recipe.setId(id);

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));
        Optional<Recipe> optionalRecipe = recipeServiceImpl.findById(id);

        optionalRecipe.ifPresent(value -> assertEquals(id, value.getId()));
        verify(recipeRepository, times(1)).findById(anyLong());
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }
}