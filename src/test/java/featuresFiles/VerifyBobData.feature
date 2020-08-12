Feature:  Verify Data from table

  Scenario: Verify specific data

    Given Navigate to website and login
    And Verify 8 items are in the page
    When Verify data for "Bob Feather"
      |FamilyAlbum|
      |14, North av.	|
      |Milltown, WI	|
      |US |
      |81734|
      |VISA|
      |111222111222	 |
      |06/08	|

