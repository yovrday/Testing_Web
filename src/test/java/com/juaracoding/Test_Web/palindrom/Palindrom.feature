Feature: palidrom word

Scenario: test valid palidrom 
Given memasukan kata berupa "apa"
When cek palidrom
Then hasil harus "true"

Scenario: test invalid palidrom
Given memasukan kata berupa "kasur"
When cek palidrom
Then hasil harus "false"

