# card-verification
A web service for checking ATM card details. A client should be able to see details of his/her card like:
- valid/not valid
- the scheme (i.e VISA, MASTERCARD or AMEX)
- the bank when is available

In order to do this, a simple Spring REST API service that understands the following call and response structure was built

```
GET /card-scheme/verify/234564562....
 {
   "success": true
   "payload" : {
        "scheme": "visa",
        "type" : "debit",
        "bank" : "UBS"
 }    
}
# Number of hits
GET /card-scheme/stats?start=1&limit=3
{
  "success": true
  "start": 1,
  "limit": 3,
  "size": 133,
  "payload": {
    "545423": 5,
    "679234": 4,
    "329802": 1
  }
}

```
To gather this data, a 3rd party API, such as (https://binlist.net/) was used
