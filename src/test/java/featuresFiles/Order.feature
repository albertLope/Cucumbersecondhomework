Feature:  View all orders

  Scenario Outline: View all orders

    Given Navigate to website and login
    When Click on items
      | OrderButton |
      | <CardName>  |

    And HandleDropdown "<dropdownOption>"
    When Fill the order form
      | quantity     | <QuantityAmount> |
      | PricePerUnit | <pricePerUnit>   |
      | CustomerName | <CustomerName>   |
      | street       | <street>         |
      | City         | <City>           |
      | State        | <State>          |
      | Zip          | <Zip>            |
      | CardNumber   | <CardNumber>     |
      | ExpireDate   | <ExpireDate>     |

    When Click on items
      | Calculate     |
      | Process       |
      | ViewAllOrders |

    When Verify data for "<CustomerName>"
      | <dropdownOption> |
      | <street>         |
      | <City>           |
      | <State>          |
      | <Zip>            |
      | <CardName>       |
      | <CardNumber>     |
      | <ExpireDate>     |
    Examples:
      | CardName         | dropdownOption | QuantityAmount | pricePerUnit | CustomerName | street  | City    | State     | Zip   | CardNumber       | ExpireDate |
      | MasterCard       | FamilyAlbum    | 5              | 300          | AliKKL       | 123main | carlsta | newhersey | 12345 | 1234567891234567 | 11/12      |
      | Visa             | MyMoney        | 5              | 300          | ThisisNotYou | 123main | carlsta | newhersey | 12345 | 1234567891234567 | 11/12      |
      | American Express | ScreenSaver    | 5              | 300          | someone      | 123main | carlsta | newhersey | 12345 | 1234567891234567 | 11/12      |


  Scenario Outline: Order nagative

    Given Navigate to website and login
    When Click on items
      | OrderButton |
      | <CardName>  |

    And HandleDropdown "<dropdownOption>"
    When Fill the order form
      | quantity     | <QuantityAmount> |
      | PricePerUnit | <pricePerUnit>   |
      | CustomerName | <CustomerName>   |
      | street       | <street>         |
      | City         | <City>           |
      | State        | <State>          |
      | Zip          | <Zip>            |
      | CardNumber   | <CardNumber>     |
      | ExpireDate   | <ExpireDate>     |

    When Click on items
      | Calculate |
      | Process   |

    Then Verify red text is displayed

    Examples:
      | CardName   | dropdownOption | QuantityAmount | pricePerUnit | CustomerName | street  | City    | State     | Zip   | CardNumber       | ExpireDate |
      |            | FamilyAlbum    | 5              | 300          | AliKKL       | 123main | carlsta | newhersey | 12341 | 1234567891234567 | 11/12      |
      | MasterCard | FamilyAlbum    | 5              | 300          |              | 123main | carlsta | newhersey | 12343 | 1234567891234567 | 11/12      |
      | MasterCard | FamilyAlbum    | 5              | 300          | AliKKL       |         | carlsta | newhersey | 12344 | 1234567891234567 | 11/12      |
      | MasterCard | FamilyAlbum    | 5              | 300          | AliKKL       | 123main |         | newhersey | 12345 | 1234567891234567 | 11/12      |
      | MasterCard | FamilyAlbum    | 5              | 300          | AliKKL       | 123main | carlsta | newhersey | 12347 |                  | 11/12      |
      | MasterCard | FamilyAlbum    | 5              | 300          | AliKKL       | 123main | carlsta | newhersey | 12348 | 1234567891234567 |            |
      | MasterCard | FamilyAlbum    | 5              | 300          | AliKKL       | 123main | carlsta | newhersey | 12348 | 1234567891234567 | 1111       |
      | MasterCard | FamilyAlbum    | 5              | 300          | AliKKL       | 123main | carlsta | newhersey | asdasd | 1234567891234567 | 1111       |
      | MasterCard | FamilyAlbum    | 5              | 300          | AliKKL       | 123main | carlsta | newhersey | /*-/ | 1234567891234567 | 1111       |
