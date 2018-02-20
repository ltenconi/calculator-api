# calculator-api

Coding exercise:

Using Java, implement a simple calculator web service that caches the results of its computations, with endpoints in a format similar to the following:

/add/{a}/{b}/{c}
/subtract/{a}/{b}/{c}
/multiply/{a}/{b}/{c}
/divide/{a}/{b}

For the operations of addition, subtraction, and multiplication, the calculator endpoints should support an input of up to three numbers in the same call.

Each endpoint should support the GET method, and it should return the result in JSON format. If there is more than one call for the same operation on the same numbers, then the result should be returned from the cache rather than being recomputed. 
