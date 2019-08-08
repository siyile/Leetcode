public class Problem707 {
    /** Initialize your data structure here. */
    class MyLinkedList {
        ListNode head;
        ListNode tail;
        int len;

        public MyLinkedList() {
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index > len) return -1;
            ListNode p;
            if (index < len / 2) {
                p = head;
                for (int i = 0; i < index + 1; i++) {
                    p = p.next;
                }
            } else {
                p = tail;
                for (int i = 0; i < len - index; i++) {
                    p = p.prev;
                }
            }
            return p.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode p = new ListNode(val);
            head.next.prev = p;
            p.next = head.next;
            p.prev = head;
            head.next = p;
            len++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode p = new ListNode(val);
            tail.prev.next = p;
            p.prev = tail.prev;
            tail.prev = p;
            p.next = tail;
            len++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > len) return;
            if (index < 0) {
                addAtHead(val);
                return;
            }
            ListNode p;
            ListNode q = new ListNode(val);
            if (index < len / 2) {
                p = head;
                for (int i = 0; i < index + 1; i++) {
                    p = p.next;
                }

            } else {
                p = tail;
                for (int i = 0; i < len - index; i++) {
                    p = p.prev;
                }
            }
            p.prev.next = q;
            q.prev = p.prev;
            p.prev = q;
            q.next = p;
            len++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= len || index < 0) return;
            ListNode p;
            if (index < len / 2) {
                p = head;
                for (int i = 0; i < index + 1; i++) {
                    p = p.next;
                }
            } else {
                p = tail;
                for (int i = 0; i < len - index; i++) {
                    p = p.prev;
                }
            }
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }

        class ListNode {
            ListNode prev;
            ListNode next;
            int val;

            ListNode(int v) {
                val = v;
            }
        }
    }

}
