package learning_1.week_1;

// 两数相加
public class _2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node_1 = new ListNode(3);
        ListNode node_12 = new ListNode(4);
        node_12.next = node_1;
        ListNode node_13 = new ListNode(2);
        node_13.next = node_12;

        ListNode node_2 = new ListNode(3);
        ListNode node_22 = new ListNode(4);
        node_22.next = node_2;
        ListNode node_23 = new ListNode(2);
        node_23.next = node_22;

        ListNode result = new _2_AddTwoNumbers().addTwoNumbers(node_13, node_23);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        // l1,l2都为空
        if (l1 == null && l2 == null) {
            return result;
        }
        // l1为空
        if (l1 == null) {
            return l2;
        }
        // l2 为空
        while (l2 == null) {
            return l1;
        }
        // l1,l2都不为空
        return sum(l1, l2);
    }

    // 两个非空ListNode求和
    private ListNode sum(ListNode l1, ListNode l2) {
        // 参数1
        String param1 = getStrValue(l1);
        // 参数2
        String param2 = getStrValue(l2);
        // 求和
        String sumStr = addTwoStr(param1, param2);
        // 转换
        ListNode node = new ListNode(0);
        convert2ListNode(sumStr, node);
        // 返回
        return node;
    }

    // 提取字符数值
    private String getStrValue(ListNode node) {
        String result = String.valueOf(node.val);
        ListNode next = node.next;
        while (next != null) {
            result = result + String.valueOf(next.val);
            next = next.next;
        }
        return result;
    }

    // 字符串数字相加
    private String addTwoStr(String param1, String param2) {
        String result = ""; int carry = 0, index = 0;
        int length = param1.length() > param2.length() ? param1.length() : param2.length();
        while ((index < length) || carry > 0) {
            int digit1 = index + 1 <= param1.length() ? Integer.valueOf(param1.substring(index, index + 1)) : 0;
            int digit2 = index + 1 <= param2.length() ? Integer.valueOf(param2.substring(index, index + 1)) : 0;
            int value = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) / 10;
            result = result + value;
            index ++;
        }
        return result;
    }

    // 数字转ListNode
    private ListNode convert2ListNode(String value, ListNode node) {
        if (value == null || value == "") {
            return node;
        }
        node.val = Integer.valueOf(value.substring(0, 1));
        if (value.length() == 1) {
            return node;
        }
        node.next = new ListNode(0); // 初始化下个node
        return convert2ListNode(value.substring(1, value.length()), node.next);
    }
}
