[![Build Status](https://travis-ci.org/emrecosar/customer-records.svg?branch=master)](https://travis-ci.org/emrecosar/customer-records)

# Customer Records #
 
We have some customer records in a text file (ex: customers.json) -- one customer per line, JSON-encoded. We want to invite any customer within 100km of our Dublin office for some food and drinks on us. Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).
You can use the first formula(law of cosines) from [this Wikipedia article](https://en.wikipedia.org/wiki/Great-circle_distance) to calculate distance. Don't forget, you'll need to convert degrees to radians.
The GPS coordinates for our Dublin office are 53.339428, -6.257664.
You can find the Customer list [here](https://gist.github.com/emrecosar/763aeb36d4ba4aa616496f674fe41b65).
 	
* Solution specifications; Spring-Boot 2.0.0, Maven and Java 8, embed-Tomcat. Just clone, build and run!
* Range parameter is optional, default value is 100. You can change the range if you prefer.
* Dublin Office location is stored in the application itself.
* KM calculation is based on, each radian on a great circle of Earth is 6371 kilometers.
 	
###Example### 

**Request**:

```
http://localhost:8081/get-invited-customers?range=100&customerUrl=https://gist.githubusercontent.com/emrecosar/763aeb36d4ba4aa616496f674fe41b65/raw/859e89c8fc3714cba8aebe3e3d72c181b73e68d6/customers.txt 
```

**Respose**:

```
[
   {
      "user_id":4,
      "name":"Ian Kehoe"
   },
   {
      "user_id":5,
      "name":"Nora Dempsey"
   },
   {
      "user_id":6,
      "name":"Theresa Enright"
   },
   {
      "user_id":8,
      "name":"Eoin Ahearn"
   },
   {
      "user_id":11,
      "name":"Richard Finnegan"
   },
   {
      "user_id":12,
      "name":"Christina McArdle"
   },
   {
      "user_id":13,
      "name":"Olive Ahearn"
   },
   {
      "user_id":15,
      "name":"Michael Ahearn"
   },
   {
      "user_id":17,
      "name":"Patricia Cahill"
   },
   {
      "user_id":23,
      "name":"Eoin Gallagher"
   },
   {
      "user_id":24,
      "name":"Rose Enright"
   },
   {
      "user_id":26,
      "name":"Stephen McArdle"
   },
   {
      "user_id":29,
      "name":"Oliver Ahearn"
   },
   {
      "user_id":30,
      "name":"Nick Enright"
   },
   {
      "user_id":31,
      "name":"Alan Behan"
   },
   {
      "user_id":39,
      "name":"Lisa Ahearn"
   }
]
```

## Copying ##

Copyright (C) 2018 Emre Cosar

All code is placed under the MIT License.
