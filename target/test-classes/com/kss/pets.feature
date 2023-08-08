Feature: Pets APIs

  @get_pets
  Scenario: Get all the PETS
    When I want to know all the pets in the clinic
    Then I should receive 13 pets
    
    @addNewPet
  Scenario: add new Pet
    When i add new Pet
    Then I should have the new Pet added
    
    @addNewPet
  Scenario Outline: add new vet for each of the specialities
When i add new vet for each of the specialities "<specialtiesId>","<specialtiesName>"
Then should be added for each of the specialities "<specialtiesId>","<specialtiesName>"



Examples: 
 |specialtiesId | specialtiesName |
 |      1       |      radiology  |   
 |      2      |         surgery  | 
 |      3      |          dentistry|  