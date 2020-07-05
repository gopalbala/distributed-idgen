# Distributed Id Generation

What is the need to generate a unique identifier?  

We as part of day to day operation do capture occurrences of events and persist them in data stores. Each of these entries has to be identified uniquely. This is where we use identifiers to identify them. The identifiers that are used to identify the record uniquely may be of numeric type or string type. 

The requirement is to create ids which is roughly sorted by time and can be used across products i.e the same id generator should be used across domains.  Consider a retail example the same id generator should be used for order, stock, price, payment, shipment, notification etc. The id generation should be fast and should generate unique and should not have single point of failures.

In this tutorial we are going to look in to ways to create these identifiers in different use cases.

1. Create id in database.  
2. Create id from backend and send to database.  

UUIDs

UUID - universally unique id or GUID by microsoft is a 128 bit id used to generate ids which can be generated in distributed manner and still remain unique. This uniqueness does not depend on central co-ordination between the systems creating them. So the defacto choice for many people creating unique identifiers are UUIDs. The possibility of duplication even when created in distributed manner is close to zero. Since the possible values are 2 to the power of 128 the max values is 340,​282,​366,​920,​938,​463,​463,​374,​607,​431,​768,​211,​456.  

Consider capturing of occurrences in distributed systems may be take an example of online shopping systems. Item added to cart where the cart with an id. Check out will have an id, payment will have an id and shipment will have an id and delivery notification with an id. It would be easy for someone who monitors the system to track these since the events will have identifiers which having identifiers in increasing order and gives a clear indication that payment event occurred after order event.  

One more example that we can think of is - Social networking site where user creates a post with a unique id. These posts attract likes, comments from users or people who subscribed to certain types of events. In this it would be useful to understand and trace a like or comment to a post will always have an identifier which is greater than the post itself.  