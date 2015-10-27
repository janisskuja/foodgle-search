package lv.skuja.foodgle.dao;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.UriInfo;

import lv.skuja.foodgle.constants.Paths;

public class Root implements JsonDao {

    @Override
    public JsonObject toJson(UriInfo info) {

        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("self", info.getPath());
        builder.add("search", info.getBaseUriBuilder().path(Paths.SEARCH_RECIPES).build().toString());
        builder.add("create", info.getBaseUriBuilder().path(Paths.CREATE_RECIPE).build().toString());
        return null;
    }

}
