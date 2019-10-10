package com.example.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class LocationNotFoundException extends RuntimeException implements GraphQLError {
  /**
   *
   */
  private static final long serialVersionUID = 966988182973485075L;
  private Map<String, Object> extensions = new HashMap<>();

  public LocationNotFoundException(String message, Long invalidLocationId) {
    super(message);
    extensions.put("invalidLocationId", invalidLocationId);
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public Map<String, Object> getExtensions() {
    return extensions;
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.DataFetchingException;
  }
}