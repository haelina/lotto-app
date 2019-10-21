# lotto-app

We had this programming project while we had autumn holiday from school.

Our aim for the project was to build a lotto app with lots of  useful features using arrays, methods and everything that we had learned so far. We also got to practise documenting while creating this code for our app.

My lotto app consists of three utility classes Math, Arrays and Console which contain different methods that I use in my lotto app. The actual lotto app is in class Main.

The lotto app works like this:
-First we need to ask user 7 unique lotto numbers between 1-40
-Numbers must be real numbers and between 1-40
-After that we sort the users lotto numbers to ascending order
-Then we print the numbers, and add prefix 0 if number is smaller than 10
-We ask user if he wants to print weekly lotto results (yes = print, any other input = don't print)
-After that we need to generate new random lotto numbers every week
-The app compares user lotto and random lotto and tells how many numbers were right each time
-Round of lotto stops when user gets all the 7 numbers right
-After each round we print statistics of how long the winning took
-Lotto continues until there is a round where user has got 7 right in under a lifetime (< 120 years)
