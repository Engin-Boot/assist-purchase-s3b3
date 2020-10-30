Feature: Assist Purchase karate test script

  Background:
    * url 'http://localhost:8080'

  Scenario: get all monitors
    Given path 'monitor'
    When method get
    Then status 200
    And print 'Response is: ', response
	And match response == '#notnull'
	
  Scenario: get total number of monitors
    Given path 'monitor/count'
    When method get
    Then status 200  
    And print 'Response is: ', response
	And match response == '#notnull'
   
  Scenario: get monitor by id (Path param)
    Given path 'monitor/1'
    When method get
    Then status 200  
    And print 'Response is: ', response
	And match response == '#notnull'
   
  Scenario: add new monitor
    Given path 'monitor'
    When request { "name":"name", "price":"123","wireless":"true","touchscreen":"false","connectivitywithemr":"false","interoperable":"true","description":"Description","image":"image"}
    And method post
    Then status 200  
    And print 'Response is: ', response
	And match response == '#notnull'
	
	Scenario: add monitor specifications
    Given path 'monitor/specs'
    When request { "wireless":"true","touchscreen":"false","connectivitywithemr":"false","interoperable":"true"}
    And method post
    Then status 200  
    And print 'Response is: ', response
	And match response == '#notnull'
   
   	Scenario: get monitor by name
    Given path 'monitor/name'
    When request 'IntelliVue MX750'
    And method post
    Then status 200  
    And print 'Response is: ', response
	And match response == '#notnull'
   
   