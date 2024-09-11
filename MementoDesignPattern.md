## Memento Design Pattern
The issue we are dealing with here is that we want to enable the undo option in our app. However, we face the two choices 
  1. We can make the data of our originator class public to store its data outside so that we can edit as per our wish
  2. We can keep all the data private but this will mean that we won't be able effectivly communicate with originator class.

To resolve this, we declare a memento class inside the originator class which will supply us with the current state of the originator object. This state will be stored inside another class's object -> caretaker. This object will contain the state of the originator as a stack. Whenever we need to undo the changes, we can pop the elements from this stack which will then be fed to the originator's object which will set its state according to the stack element returned.

Originator Class 
  1. All the fields that store the data
  2. Getters, Setters, Constructor
  3. setState which sets the state according to the memento object returned
  4. getState which will return the current state as a memento object

  5. Memento Class
     1. Same fields as originator
     2. Constructor that take an originator object and sets the values in I)

Caretaker Class
  1. Stack of memento 
  2. Return old state which will return the popped element from the stack in 1
  3. Add new state which will add new memento object by accessing it from originator's object
