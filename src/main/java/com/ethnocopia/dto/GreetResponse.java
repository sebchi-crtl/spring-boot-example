package com.ethnocopia.dto;


import com.ethnocopia.entity.Person;

import java.util.List;

public record GreetResponse(String greet, List<String> favProgrammingLanguages, Person person) {}