Implement REST APIs to perform filter and sort operations on a collection of Txn.

Each event is a JSON entry with the following keys:
txnId: the Transaction id of the transaction (String) 
amount: the amount of transaction (Float)
gst: the gst of commission (Float)
commission: the Commission of transaction

 
You are provided with the implementation of the models required for all the APIs. The task is to implement a set of REST services that exposes the endpoints and 
allows for filtering and sorting the collection of txn records in the following ways:

POST request to /txn/add
withn the above request body
which stores the data and return 200 response code.
do all validation for amount fields as it must not be less than 0.

GET request to /txn/amount/{initial_range}/{final_range}:
returns a collection of all txns whose ampunt is between the initial and the final range supplied
The response code is 200, and the response body is an array of txns in the amount range provided.
In case there are no txns txns return status code 400.
 
GET request to /sort/amount:
returns a collection of all txns sorted by their amount
The response code is 200 and the response body is an array of the txns sorted in ascending order of amount.

use db to store data like h2 database
 
