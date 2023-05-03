package com.example.mappper;

import java.sql.ResultSet;

public interface RowMapper<EntityKey> {
	EntityKey MapRow(ResultSet result);
}
