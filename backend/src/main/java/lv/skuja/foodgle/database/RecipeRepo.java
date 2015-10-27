package lv.skuja.foodgle.database;

import java.util.List;

import lv.skuja.foodgle.dao.JsonDao;

public interface RecipeRepo {

    List<JsonDao> getRecipes(String query, int page);
    
    int rateRecipe(String id, int rating);
    
    String addRecipe(JsonDao recipe);
    
    void shutDownNode();
}
