import java.lang.StringBuffer;

public class LinkedList {

    public LLNode head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(LLNode head) {
        this.head = head;
    }

    public LinkedList(Object obj) {
        this.head = new LLNode(obj);
    }

    public void add(LLNode nd) {
        if(head == null) {
            head = nd;
            return;
        }
        LLNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = nd;
    }

    public void reverse() {
        if(head == null || head.next == null) return;
        head = reverse(head);
    }

    public LLNode reverse(LLNode nd) {
        if(nd.next == null) return nd;
        
        //reverse the linked list starting from the second node
        LLNode second = reverse(nd.next);

        //Add first node to end of reversed sub list
        LLNode tmp = second;
        while(tmp.next != null) {
            tmp = tmp.next;
        }
        nd.next = null;
        tmp.next = nd;
        return second;
    }

    public String toString() {
        LLNode cur = head;
        StringBuffer retSB = new StringBuffer();
        while(cur != null) {
            retSB.append("(" + cur.val + ")->");
            cur = cur.next;
        }
        return retSB.toString();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("List: " + list);
        list.add(new LLNode(1));
        list.add(new LLNode(2));
        list.add(new LLNode(3));
        list.add(new LLNode(4));
        System.out.println("List: " + list);
        list.reverse();
        System.out.println("List: " + list);
    }
}
