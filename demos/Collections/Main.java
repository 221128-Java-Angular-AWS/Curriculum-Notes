import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        LIST:
        Vector
        Stack
        ArrayList
        LinkedList

        MAP:
        HashMap
        TreeMap
        HashSet

        Queue
        Stack
        ArrayDeque



         */


        //List
        List<String> myList = new Vector<>();
        myList.add("Hello");
        String newString = "world!";
        myList.add(newString);

        for(String s : myList) {
            System.out.println(s);
        }



        //Maps
        Map<String, Object> myMap = new TreeMap<>();
        myMap.put("MyObject", new Object());
        myMap.put("Object2", new Object());
        Object obj = myMap.get("Object2");

        //We can't traverse a map directly
        Set<String> keySet = myMap.keySet();

        //but we can traverse a set, like this set of the maps keys.
        //This allows us to traverse the map indirectly.
        for(String s : keySet) {
            myMap.get(s);
        }

        Set<Map.Entry<String, Object>> myEntrySet = myMap.entrySet();
        for(Map.Entry<String, Object> e : myEntrySet) {
            System.out.println(e.getValue());
        }

        System.out.println("forEach: ");
        myMap.forEach((k, v)->{
            System.out.println(k + " " + v);
        });




        //queues and stacks
        Queue<String> myQueue = new LinkedList<>();
        myQueue.add("First");
        myQueue.add("Second");
        myQueue.add("Third");

        System.out.println("Queue: ");
        myQueue.forEach((str)->{
            System.out.println(str);
        });


        //Stack
        Stack<String> myStack = new Stack<>();
        myStack.add("one");
        myStack.add("two");
        myStack.add("three");
        myStack.push("four");
        myStack.push("five");
        myStack.push("six");

        System.out.println("Stack: ");
        myStack.forEach((str)->{
            System.out.println(str);
        });

        String pop = myStack.pop();



        //ArrayDeque
        ArrayDeque<String> myArrayDeque = new ArrayDeque<>();
        myArrayDeque.add("add");
        String str1 = myArrayDeque.remove();
        myArrayDeque.push("push");
        String str2 = myArrayDeque.pop();

        myArrayDeque.addFirst("Add to head of queue");//effectively push
        myArrayDeque.addLast("Add to end of queue");//effectively push_back
        myArrayDeque.getFirst();//effectively pop (pop_front)
        myArrayDeque.getLast();//effectively pop_back

        System.out.println("ArrayDeque: ");
        myArrayDeque.forEach((str)->{
            System.out.println(str);
        });








    }

}
