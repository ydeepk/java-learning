package basics.classAndObjects;

/*
* Scenario: All Shapes must have a draw() method,
* but a generic "Shape" doesn't know how to draw itself. Only Circle and Square know.

    Create an abstract class Shape.
    Define an abstract method draw().
    Create a subclass Circle that implements draw().

    Trick Question: Can you do Shape s = new Shape();?
* */
public abstract class Shape {

    public abstract void draw();

}
