ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    ListNode<Integer> root = l;
    ListNode<Integer> prev = new ListNode(99);
    ListNode<Integer> next = prev;
    while (root != null && root.value != null) {
        if (root.value.equals(k)) {
            if (root.next == null) {
                next.next = null;
            }
        } else {
            next.next = root;
            next = next.next;
        }
        root = root.next;
    }
    return prev.next;
}

// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
