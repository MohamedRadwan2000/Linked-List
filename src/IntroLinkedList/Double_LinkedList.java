package IntroLinkedList;

public class Double_LinkedList implements ILinkedList {
    Double_Node head;

    public void add(Object element) {
        Double_Node new_node = new Double_Node(element);
        Double_Node temp;
        if (this.head == null) {
            head = new_node;
        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.prev = temp;
        }
    }

    public void add(int index1, Object element) {
        int index=index1+1;
        Double_Node new_node = new Double_Node(element);
        Double_Node temp = head;
        if (index > 0) {
            if (index != 1) {
                for (int i = 0; i < index - 2; i++) {
                    if (temp.next != null) {
                        temp = temp.next;
                    } else {
                        throw new NullPointerException("index not found");
                    }
                }
                new_node.next = temp.next;
                new_node.prev = temp;
                temp.next = new_node;
            } else {
                new_node.next = temp;
                new_node.prev = null;
                head = new_node;
            }
        } else {
            throw new NullPointerException("index not found");
        }
    }

    public Object get(int index1){
        int index=index1+1;
        if(index!=0) {
            Double_Node temp = head;
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
        Double_Node temp=head;
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
        Double_Node temp=head;
        if(index>0){
            if(index==1){head=head.next;}
            else{
                for(int i=0;i<index-2;i++){
                    if(temp.next==null){
                        throw new NullPointerException("index not found");
                    }
                    else {temp=temp.next;}
                }
                temp.next.next.prev=temp.next;
                temp.next=temp.next.next;

            }
        }
        else {throw new NullPointerException("Index Not found");}
    }

    public int size(){
        int x=0;
        Double_Node temp=head;
        while(temp!=null){temp=temp.next;
            x++;}
        return x;
    }


    public Double_LinkedList sublist(int fromIndex, int toIndex){
        if((fromIndex>this.size())||(toIndex>this.size())||(fromIndex<0)||(toIndex<0)){throw new NullPointerException("Wrong interval");}
        Double_LinkedList x=new Double_LinkedList();
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
        Double_Node temp=head;
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
        Double_Node temp=head;
        while (temp!=null){
            System.out.println(temp.val);
            if(temp.next==null){
                break;
            }
            else { temp=temp.next;}
        }
    }

}
