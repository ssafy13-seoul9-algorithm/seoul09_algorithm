import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<N; i++){
            DoubleLinkedList edit = new DoubleLinkedList();
            String word = sc.nextLine();

            for(int a = 0; a<word.length(); a++){
                char charac = word.charAt(a);
                if (charac == '<') {
                    edit.moveLeft();
                } else if (charac == '>') {
                    edit.moveRight();
                } else if (charac == '-') {
                    edit.delete();
                } else {
                    edit.add(charac);
                }
            }

            edit.print();
            System.out.println();
        }
    }

    static class Node{
        char data;
        Node prev;
        Node next;

        public Node(char data){
            this.data = data;
        }
    }

    static class DoubleLinkedList{
        private Node head;
        private Node tail;
        private Node cursor;

        public DoubleLinkedList(){
            head = new Node('\0');
            tail = new Node('\0');
            head.next = tail;
            tail.prev = head;
            cursor = head;
        }

        public void add(char data){
            Node newN = new Node(data);
            newN.prev = cursor;
            newN.next = cursor.next;

            // 이 부분 고려 X
            if(cursor.next != tail){
                cursor.next.prev = newN;
            }
            cursor.next = newN;
            ///////////////////
            
            cursor = newN;
        }

        public void moveLeft(){
            if (cursor != head) {
                cursor = cursor.prev;
            }
        }

        public void moveRight(){
            if(cursor.next != tail){
                cursor = cursor.next;
    
            }
        }

        public void delete(){
            if(cursor == head) return;

            Node deleteN = cursor;
            cursor = cursor.prev;
            cursor.next = deleteN.next;

            // 이 부분 빠졌었음
            if(deleteN.next != null){
                deleteN.next.prev = cursor;
            }
            //////////////////////////////
        }

        public void print(){
            Node cur = head.next;
            while(cur != tail){
                System.out.print(cur.data);
                cur = cur.next;
            }
        }




    }

}
