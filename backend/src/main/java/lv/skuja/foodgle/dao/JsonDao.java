package lv.skuja.foodgle.dao;

import javax.json.JsonObject;
import javax.ws.rs.core.UriInfo;

public interface JsonDao {
    
    JsonObject toJson(UriInfo info);
}
