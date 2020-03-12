package IntroLinkedList;

public class Single_LinkedList implements ILinkedList {
    Node head;



    public void add(Object element) {
        Node new_node = new Node(element);
        Node temp;
        if (this.head == null) {
            head = new_node;
        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next=new_node;
        }
    }




    public void add(int index1, Object element){
        int index=index1+1;
        Node new_node=new Node(element);
        Node temp=head;
        if(index>0) {
            if (index != 1) {
                for (int i = 0; i < index - 2; i++) {
                    if (temp.next != null) {
                        temp = temp.next;
                    } else {
                        throw new NullPointerException("index not found");
                    }
                }
                new_node.next = temp.next;
                temp.next = new_node;
            }
            else {new_node.next=temp;
            head=new_node;}
        }
        else {throw new NullPointerException("index not found");}
    }


    public Object get(int index1){
        int index=index1+1;
        if(index!=0) {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    throw new NullPointerException("Index not found");
                }
            }

            return temp.val;
        }
        else{throw new NullPointerException("index must be bigger than '0'");}
    }




    public void set(int index1, Object element){
        int index=index1+1;
        Node temp=head;
        if(index>0){
        for(int i=0;i<index-1;i++){
            if(temp.next==null){throw new NullPointerException("Index Not found");}
            temp=temp.next;

        }
        temp.val=element;}
        else {throw new NullPointerException("invalid index");}
    }




    public void clear(){head=null;}


    public boolean isEmpty(){
    if(head!=null){return false;}
    else {return true;}}


    public void remove(int index1){
        int index=index1+1;
        Node temp=head;
        if(index>0){
            if(index==1){head=head.next;}
            else{
            for(int i=0;i<index-2;i++){
                if(temp.next==null){
                    throw new NullPointerException("index not found");
                }
                else {temp=temp.next;}
            }
            temp.next=temp.next.next;
            }
        }
        else {throw new NullPointerException("Index Not found");}
    }



    public int size(){
        int x=0;
        Node temp=head;
        while(temp!=null){temp=temp.next;
        x++;}
        return x;
    }



    public Single_LinkedList sublist(int fromIndex, int toIndex){
        if((fromIndex>this.size())||(toIndex>this.size())||(fromIndex<0)||(toIndex<0)){throw new NullPointerException("Wrong interval");}
        Single_LinkedList x=new Single_LinkedList();
        if(fromIndex<=toIndex) {
            int y=fromIndex;
            for (int i = 0; i <= (toIndex - fromIndex); i++) {
                x.add(this.get(y));
                y++;
            }
        }
        if(fromIndex>toIndex){
            int y=fromIndex;
            for(int i=0;i<=fromIndex-toIndex;i++){
                x.add(this.get(y));
            y--;}
        }
        return x;
    }
    public boolean contains(Object o){
        boolean x=false;
        Node temp=head;
        for(int i=0;i<this.size();i++){
            if(temp.val==o){
                x=true;
                break;
            }
            else {temp=temp.next;}
        }
        return x;
    }
    public void print_LinkedList(){
        Node temp=head;
        while (temp!=null){
            System.out.println(temp.val);
            if(temp.next==null){
            break;
            }
            else { temp=temp.next;}
        }
    }


}
