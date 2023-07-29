package learning_1.week_1;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("val: " + val);
        ListNode nextTmp = next;
        while (nextTmp != null) {
            sb.append(" -> " + "val: " + nextTmp.val);
            nextTmp = nextTmp.next;
        }
        return sb.toString();
    }
}
