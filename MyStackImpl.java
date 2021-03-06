public class MyStackImpl {
 
    private int stackSize;
    private Object[] stackArr;
    private int top;
 
    /**
     * constructor to create stack with size
     * @param size
     */
    public MyStackImpl(int size) {
        this.stackSize = size;
        this.stackArr = new Object[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top 
     * of the stack
     * @param entry
     * @throws Exception 
     */
    public void push(Object entry) throws Exception {
        if(this.isStackFull()){
            throw new Exception("Stack is already full. Can not add element.");
        }
       // System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the 
     * top of the stack.
     * @return
     * @throws Exception 
     */
    public Object pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        Object entry = this.stackArr[top--];
       // System.out.println("Removed entry: "+entry);
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public Object peek() {
        return stackArr[top];
    }
 
    /**
     * This method returns true if the stack is 
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
 
  }