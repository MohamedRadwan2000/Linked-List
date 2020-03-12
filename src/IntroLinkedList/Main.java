package IntroLinkedList;

public class Main {

    public static void main(String[] args) {
      Single_LinkedList l=new Single_LinkedList();
       l.add(5);
       l.add(8);
       l.add(4);
       l.add(3);
       l.add(34);
       l.add(7);
      l= l.sublist(1,5);
      l.contains(8);
       l.print_LinkedList();
       System.out.println(l.contains(34));



    }
}
