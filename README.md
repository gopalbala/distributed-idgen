# Distributed Id Generation

What is the need to generate a unique identifier?  

We as part of day to day operation do capture occurrences of events and persist them in data stores. Each of these entries has to be identified uniquely. This is where we use identifiers to identify them. The identifiers that are used to identify the record uniquely may be of numeric type or string type. 

The requirement is to create ids which is roughly sorted by time and can be used across products i.e the same id generator should be used across domains.  Consider a retail example the same id generator should be used for order, stock, price, payment, shipment, notification etc. The id generation should be fast and should generate unique and should not have single point of failures.

In this tutorial we are going to look in to ways to create these identifiers in different use cases.

1. Create id in database.  
2. Create id from backend and send to database.  

## UUIDs

UUID - universally unique id or GUID by microsoft is a 128 bit id used to generate ids which can be generated in distributed manner and still remain unique. This uniqueness does not depend on central co-ordination between the systems creating them. So the defacto choice for many people creating unique identifiers are UUIDs. The possibility of duplication even when created in distributed manner is close to zero. Since the possible values are 2 to the power of 128 the max values is 340,​282,​366,​920,​938,​463,​463,​374,​607,​431,​768,​211,​456.  

Sample UUID - xxxxxxxx-xxxx-Mxxx-Nxxx-xxxxxxxxxxxx  
              907f39b0-6778-**4**c47-b173-e6348efa1641  
              M is the UUID version here we are using type 4 UUIDs  
              N is the UUID variant  
              
The default UUIDs that we create out of syntax.   
    ```
    UUID.randomUUID() is version 4 UUID
    ```
    
What are the pros and cons of UUIDs to uniquely identify records?

Easy to generate.  
Fast.   
Uniquness.  
Random i.e. we cannot predict next id with the current id.  

UUIDs are 128 bits long which is 32 chars in length.  
Sorting UUIDs would not result in ordering of actual records since they are random and not generated in any sequence.  

## Auto incrementing Ids - Identity columns

We can use identity columns as key to generate ids for records and this will work for most of the use cases where the uniqueness is for a particular type but when we move across types or entities this approach cannot be used as it is restricted to a table. 

## Understanding the requirements again with examples

Consider capturing of occurrences in distributed systems may be take an example of online shopping systems. Item added to cart where the cart with an id. Check out will have an id, payment will have an id and shipment will have an id and delivery notification with an id. It would be easy for someone who monitors the system to track these since the events will have identifiers which having identifiers in increasing order and gives a clear indication that payment event occurred after order event.  

One more example that we can think of is - Social networking site where user creates a post with a unique id. These posts attract likes, comments from users or people who subscribed to certain types of events. In this it would be useful to understand and trace a like or comment to a post will always have an identifier which is greater than the post itself.  

## Centralized Id generation 

We can have a service that can generate identifiers and distribute them to services. We need to handle concurrency and synchoronization. Consider the scale at which requests come for Twitter, Flickr, sale day in Amazon or Flipkart. We expect on an average of 10000 requests per second and having a centralized service to handle requests at this scale is not easy and any failure will have impact on the platform.

## Id generation based on Twitter snowflake algorithm will help here.

https://blog.twitter.com/engineering/en_us/a/2010/announcing-snowflake.html 

Other references  
https://github.com/sony/sonyflake  
https://instagram-engineering.com/sharding-ids-at-instagram-1cf5a71e5a5c  
https://docs.mongodb.com/manual/reference/method/ObjectId/  

