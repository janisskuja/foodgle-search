package lv.skuja.foodgle.dao;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.UriInfo;

import lv.skuja.foodgle.constants.Paths;

public class Recipe implements JsonDao {

    private String name;
    private String author;
    private String description;
    private int    rating;
    private String id;

    public Recipe() {
        this.id = "dummyId";
        this.name = "dummyName";
        this.author = "dummyAuthor";
        this.description = "dummyDescription";
        this.rating = 4;
    }

    public Recipe(String id, String name, String author, String description, int rating) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.rating = rating;
    }

    @Override
    public JsonObject toJson(UriInfo info) {

        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id", this.id);
        builder.add("name", this.name);
        builder.add("author", this.author);
        builder.add("description", this.description);
        builder.add("rating", this.rating);

        if (info != null) {

            JsonObjectBuilder linkBuilder = Json.createObjectBuilder();
            linkBuilder.add("self", info.getBaseUriBuilder().path(Paths.RECIPES + this.id).build().toString());
            linkBuilder.add("rate", info.getBaseUriBuilder().path(Paths.RATE_RECIPE + this.id).build().toString());
            builder.add("links", linkBuilder.build());
        }
        return builder.build();
    }

}
