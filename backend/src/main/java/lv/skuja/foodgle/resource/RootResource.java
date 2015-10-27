package lv.skuja.foodgle.resource;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import lv.skuja.foodgle.dao.JsonDao;
import lv.skuja.foodgle.dao.Root;

@Path("")
public class RootResource {

    @GET
    public JsonObject root(@Context UriInfo info) {

        JsonDao root = new Root();
        return root.toJson(info);
    }
}
