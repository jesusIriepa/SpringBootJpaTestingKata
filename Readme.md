# Demo for Testing a Springboot Application

## business explanation
We need create a CRUD application that be able of manage the timetable of a Subject in a School.

### Subjects
Every Course have a number of subjects that every Student must pass.
A subject have a name and a description of the content and a timetable of Classes where the 
class will be presented.

### Class
Every Subject have a number of Class with a Location (Building, Floor and Class Number), start time, 
end time and a Teacher. A Class has a Status: Active / Completed / Cancelled

### Teacher
A Class will be done by a Teacher. A Teacher must not have two Classes at the same time.
And need at least an Hour between two Classes.

### Use Cases
+ Teachers
  + Create a new Teacher 
    + name (mandatory char 2-200)
    + surname (mandatory char 2-200)
    + birthdate (mandatory at least 18 years old from the creation day)
  + Update a Teacher
    + name, surname or birthdate
    + status => activate
  + Delete a Teacher (logic delete / disabled) and cancel all Classes associated to this Teacher
  + Get a Teacher detail
  + Get a List of Teachers. In Pages of n elements (query param) and order by any field (query param)
+ Subjects
  + Create a new Subject
  + Update a Subject
  + Delete a Subject (logic delete/ disabled) and cancel all Classes associated to this Subject
+ Class
  + Create a new Class for a Teacher and Subject
  + Update a Class: timetable, Teacher or Status
  + Delete a Class: Cancel a Class

## Technical explanation
This application is an example of CRUD and how to test every layer from controller to domain and persistence.
The most important objective of this "kata" is the organization of the code, validation and of course 
testing all the functionality and maintainability of the code.

