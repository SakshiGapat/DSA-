//Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

class file3 {
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

           
            first.next = second.next;
            second.next = first;
            prev.next = second;

          
            prev = first;
        }

        return dummy.next;
    }

    
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    
    public ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        file3 solution = new file3();

        // Example input: [1, 2, 3, 4]
        int[] input = {1, 2, 3, 4};
        ListNode head = solution.createList(input);

        System.out.print("Original list: ");
        solution.printList(head);

        ListNode swapped = solution.swapPairs(head);

        System.out.print("Swapped list:  ");
        solution.printList(swapped);
    }
}
