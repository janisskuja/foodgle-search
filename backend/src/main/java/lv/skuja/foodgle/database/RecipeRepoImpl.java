package lv.skuja.foodgle.database;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.util.List;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import lv.skuja.foodgle.dao.JsonDao;

public class RecipeRepoImpl implements RecipeRepo {

    private Node node;
    private Client client;
    
    public RecipeRepoImpl() {
        this.node = nodeBuilder().local(true).node();
        this.client = node.client();
    }

    @Override
    public List<JsonDao> getRecipes(String query, int page) {

        GetResponse response = client.prepareGet("recipes", "recipe", query)
                        .execute()
                        .actionGet();
        
        //TODO: parse response to JSON dao
        return null;
    }

    @Override
    public int rateRecipe(String id, int rating) {

        // TODO call elastic client
        return 0;
    }

    @Override
    public String addRecipe(JsonDao recipe) {

        // TODO call elastic client
        return null;
    }

    @Override
    public void shutDownNode() {

        // TODO call this method on server shutdown
        node.close();
    }

}
