# Tech Test-Currency Converter App

## Introduction
Tech test for a software developer interview.  The brief was:

> ### Development Test - Currency Converter
> Build a data structure that can contain currency conversion ratios based with example/dummy data for:
> - GBP to USD
> - GBP to AUD
> - GBP to EUR
>
> Create a front end application using the technology and language of your choice that:
> - Allows the user to specify an amount to convert between any of the currencies in the above list
> - Provides sensible validation on user inputs
>
> Next, create a data structure that allows currency conversions made by the user to be logged for audit purposes.
> 
> Create an interface that allows the currency conversion audit to be queried within a user-specified date range.
>
> Time Allowed: 1hr (it is not expected that all requirements will be fully implemented)

My solution presents the user with a web page where they can select a predefined currency from a dropdown and enter an amount to convert.  When the user clicks the Calculate button the form is submitted and the back end code calculates the currency conversion.  The html page is updated to show the exchange rate of the selected currency and the converted amount.  

The conversions are logged in the backend but unfortunately I ran out of time to display the audit trail and to allow it to be queried (1 hour goes quick when you are having fun 😉)

## Run the Code
To run, execute the following at the command line from the repository root folder
````
mvnw spring-boot:run
````

## Design Choices
I decided to develop the solution in Java and Spring.  At this point I had no working knowledge of Spring (I had followed a few starter tutorials prior to applying for this role) but as it was used by the company I was interviewing for it seemed like a good choice.  They already knew I had no experience with it but were happy to interview me anyway so I thought it would be a good opportunity to show how quickly I pick up new things.

The WebController.java class handles the requests.  It contains a method to return the initial html where the user can select a currency and enter an amount, and also handles the calculation of the conversion amount and returning the result to the end user.

The html is built using [Thymeleaf](https://www.thymeleaf.org/) to parse the html template.  The html uses the [Bootstrap](https://getbootstrap.com/) framework with no javascript.

The data is stored in an in-memory repository (MemoryDataRepository.java).  The repository inherits from a Repository interface so it can easily be modified to use a persistent database if required.

## End Result
I am happy with the choices I made when building this solution.  By storing the data in memory I didn't have to worry about implementing a database which would have taken up valuable time.  While there was a small learning curve with Spring I believe it saved me time in the long run.

If I'd had more time I would have added a second page which showed a table of audit trail records.  The screen would have 2 date entry fields to allow the user to enter a from and to date range to filter on.  A new controller class would have been added to handle these calls.

I didn't get the job 🙁