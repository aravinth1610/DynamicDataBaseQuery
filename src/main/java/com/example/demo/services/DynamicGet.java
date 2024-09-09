package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DynamicGet {

//	 @Value("${database.url}")
//	 private String databaseUrl;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepo per;

	public <T> List<Object[]> getTableValues(Class<T> entityType,String tableName, String whereColumnIdentifier,Object whereColumnValue, String... columnNames) {
		StringBuilder selectTableQuery = new StringBuilder("SELECT ");

		for (int i = 0; i < columnNames.length; i++) {
			selectTableQuery.append(columnNames[i]);
			if (i < columnNames.length - 1) {
				selectTableQuery.append(", ");
			}
		}

		selectTableQuery.append(" FROM ").append(tableName);

		if (whereColumnIdentifier != null && !whereColumnIdentifier.isEmpty() && whereColumnValue != null) {
			if (whereColumnValue instanceof String) {
				selectTableQuery.append(" WHERE ").append(whereColumnIdentifier).append(" = '").append(whereColumnValue.toString()).append("'");
			} else {
				selectTableQuery.append(" WHERE ").append(whereColumnIdentifier).append(" = ").append(whereColumnValue.toString());
			}
		}
//		else
//		{
//			selectTableQuery = selectTableQuery.append(";");
//		}

	
		Query query = entityManager.createNativeQuery(selectTableQuery.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> results = query.getResultList();
		
		//This is one of the way not best way 
//		  List<Map<String, Object>> mappedResults = new ArrayList<>();
//	        for (Object[] result : results) {
//	            Map<String, Object> rowMap = new HashMap<>();
//	            for (int i = 0; i < columnNames.length; i++) {
//	                rowMap.put(columnNames[i], result[i]);
//	            }
//	            mappedResults.add(rowMap);
//	        }
//	        return mappedResults;
		
		System.out.println(results);
		return results;
	}

	
	
	


}
