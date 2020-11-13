$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/APIWorkFlow.feature");
formatter.feature({
  "name": "Syntax HRMS API Workflow",
  "description": "  Description: This feature file tests Syntax HRMS API Workflow",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.GenerateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating an employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@APIworkFlow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create an employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.a_request_is_prepared_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a POST call is made to create an employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.a_POST_call_is_made_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for creating an employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_status_code_for_creating_an_employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is created contains key \"Message\" and value \"Entry Created\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_employee_is_created_contains_key_and_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee ID \"Employee[0].employee_id\" is stored as a global variable to be used for other calls",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.GenerateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Retrieving created employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@APIworkFlow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to retrieve the created employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.a_request_is_prepared_to_retrieve_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a GET call is made to retrieve the created employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.a_GET_call_is_made_to_retrieve_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for retrieving the created employee is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_status_code_for_retrieving_the_created_employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved employee ID \"employee[0].employee_id\" matches the globally stored employee ID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_retrieved_employee_ID_matches_the_globally_stored_employee_ID(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved data at \"employee\" matches the data used to create an employee with employee ID \"employee[0].employee_id\"",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.APIFinalSteps.the_retrieved_data_at_matches_the_data_used_to_create_an_employee_with_employee_ID(java.lang.String,java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/create%20Employees.feature");
formatter.feature({
  "name": "Creating Employees",
  "description": "  Description: This feature creates employees",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@APIworkFlow"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Creating employees",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "a request is prepared to create employees",
  "keyword": "Given "
});
formatter.step({
  "name": "employee data provided is \"\u003cemployeeFirstName\u003e\", \"\u003cemployeeLastName\u003e\", \"\u003cemployeeMiddleName\u003e\",\"\u003cemployeeGender\u003e\",\"\u003cemployeeBirthday\u003e\",\"\u003cemployeeJobStatus\u003e\",\"\u003cemployeeJobTitle\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "employees are created",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "employeeFirstName",
        "employeeLastName",
        "employeeMiddleName",
        "employeeGender",
        "employeeBirthday",
        "employeeJobStatus",
        "employeeJobTitle"
      ]
    },
    {
      "cells": [
        "Bob",
        "Bob",
        "Bob",
        "M",
        "2000-07-11",
        "Employee",
        "Cloud Architect"
      ]
    },
    {
      "cells": [
        "Gozde",
        "Gozde",
        "Gozde",
        "F",
        "2000-07-11",
        "Independent contractor",
        "API Tester"
      ]
    },
    {
      "cells": [
        "Irma",
        "Irma",
        "Irma",
        "F",
        "2000-07-11",
        "Super Contractor",
        "CEO"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.GenerateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating employees",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@APIworkFlow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create employees",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.CreateEmployees.a_request_is_prepared_to_create_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee data provided is \"Bob\", \"Bob\", \"Bob\",\"M\",\"2000-07-11\",\"Employee\",\"Cloud Architect\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.CreateEmployees.employee_data_provided_is(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employees are created",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.CreateEmployees.employees_are_created()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.GenerateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating employees",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@APIworkFlow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create employees",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.CreateEmployees.a_request_is_prepared_to_create_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee data provided is \"Gozde\", \"Gozde\", \"Gozde\",\"F\",\"2000-07-11\",\"Independent contractor\",\"API Tester\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.CreateEmployees.employee_data_provided_is(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employees are created",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.CreateEmployees.employees_are_created()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.GenerateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating employees",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@APIworkFlow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create employees",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.CreateEmployees.a_request_is_prepared_to_create_employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee data provided is \"Irma\", \"Irma\", \"Irma\",\"F\",\"2000-07-11\",\"Super Contractor\",\"CEO\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.CreateEmployees.employee_data_provided_is(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employees are created",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.Final.steps.CreateEmployees.employees_are_created()"
});
formatter.result({
  "status": "passed"
});
});