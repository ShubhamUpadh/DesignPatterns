import org.jetbrains.annotations.*;

import java.util.Stack;

class originator{

    private int posX;
    private int posY;
    private String text;

    // Default constructor
    public originator(int posX, int posY, String text) {
        this.posX = posX;
        this.posY = posY;
        this.text = text;
    }


    public String originatorValues(){
        return "posX = " + this.posX + " posY = " + this.posY + " text = " + this.text;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public memento saveState(){
        return new memento(this);
    }

    public void setState(memento Obj){
        this.posX = Obj.getPosX();
        this.posY = Obj.getPosY();
        this.text = Obj.getText();
    }

    static class memento{

        private final int posX;
        private final int posY;
        private final String text;

        public memento(originator Obj) {
            this.posX = Obj.getPosX();
            this.posY = Obj.getPosY();
            this.text = Obj.getText();
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }

        public String getText() {
            return text;
        }
    }
}

class caretaker{
    private Stack<originator.memento> mementoStack = new Stack<>();

    // Save new memento
    public void saveNewMemento(originator.memento obj){
        mementoStack.push(obj);
    }

    // Retrieve the last state
    public originator.memento getOldState(){
        if (!mementoStack.isEmpty()) return mementoStack.pop();
        return null;
    }
}

public class MementoDesignPattern {
    public static void main(String[] args) {

        caretaker caret = new caretaker();
        originator origin8r = new originator(10,20,"This is old text");
        System.out.println(origin8r.originatorValues());

        caret.saveNewMemento(origin8r.saveState());

        origin8r.setPosX(30);
        origin8r.setPosY(300);
        origin8r.setText("THis is new text");

        System.out.println(origin8r.originatorValues());
        origin8r.setState(caret.getOldState());
        System.out.println(origin8r.originatorValues());
    }
}
