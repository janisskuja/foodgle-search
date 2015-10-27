package lv.skuja.foodgle.resource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lv.skuja.foodgle.constants.Paths;
import lv.skuja.foodgle.dao.JsonDao;
import lv.skuja.foodgle.dao.Recipe;

@Path("recipes")
public class RecipesResource {

    @GET
    public JsonArray recipes(@Context UriInfo info) {

        // TODO add elastic search query
        JsonArrayBuilder builder = Json.createArrayBuilder();
        JsonDao recipe = new Recipe();
        builder.add(recipe.toJson(info));
        return builder.build();
    }

    @GET
    @Path("{id}")
    public JsonObject recipe(@PathParam("id") String id, @Context UriInfo info) {

        JsonDao recipe = new Recipe();
        return recipe.toJson(info);
    }

    @POST
    @Path(Paths.CREATE_RECIPE)
    public Response recipe(JsonDao recipe, @Context UriInfo info) {

        // TODO: create object in elastic search and return created objects URI
        return Response.created(info.getBaseUri()).build();
    }
}
