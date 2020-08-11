# JMCh03Ex11_Book
Create a class Book with two private `int` fields, `numPages` and `currentPage`.
Supply a constructor that takes one parameter and sets `numPages` to that value and `currentPage` to 1.
Provide accessor methods for both fields. Also provide a method `nextPage` that increments
`currentPage` by 1, but only if `currentPage` is less than `numPages`.

Hint:
```
if (currentPage < numPages) {
  currentPage++;
}
```

Create a `Main` class with a `main` method. Let `main` create a `Book` object with 3 pages,
call its `getNumPages` method and print out the value, then print out the value of `currentPage`,
and finally call its `nextPage` method three times, printing out the value of `currentPage` after each call.

### Instructions to run
`make` - will compile the java files  
`make run` - will compile and run the main()  
`make test` - will run the unit test  
