/***************************************************************
Project name: findSubstring
Class file name: ReorderList.java
Created at 8:57:26 PM by chengli

Copyright (c) 2015 chengli.
All rights reserved. This program and the accompanying materials
are made available under the terms of the GNU Public License v2.0
which accompanies this distribution, and is available at
http://www.gnu.org/licenses/old-licenses/gpl-2.0.html

Contributors:
    chengli - initial API and implementation

Contact:
    To distribute or use this code requires prior specific permission.
    In this case, please contact chengli@mpi-sws.org.
 ****************************************************************/

/**
 * @author chengli
 *
 */

	 class ListNode {
	 int val;
   ListNode next;
  ListNode(int x) {
     val = x;
       next = null;
   }
 };

public class ReorderList {

public static void reorderList(ListNode head) {
        
        ListNode store_head = head;
        
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        
        int index_of_node_waiting = count/2 + 1;
        ListNode start_replaced = store_head;
        
        int index = 0;
        while(start_replaced!=null
        && start_replaced.next!=null){
            if(index + 1 == index_of_node_waiting){
                ListNode temp = start_replaced.next;
                start_replaced.next = null;
                start_replaced = temp;
                break;
            }
            start_replaced = start_replaced.next;
            index++;
        }
        
        int insert_position = 0;
        if(count % 2 == 0) {
        	insert_position = index_of_node_waiting - 3;
        }else {
        	insert_position = index_of_node_waiting - 2;
        }
        while(start_replaced!= null && insert_position >=0){
            //find the place to put
            ListNode head1 = store_head;
            int local_index = insert_position;
            while(--local_index >= 0){
                head1 = head1.next;
            }
            
            //replace
            ListNode temp = head1.next;
            ListNode temp1 = start_replaced.next;
            head1.next = start_replaced;
            start_replaced.next = temp;
            start_replaced = temp1;
            insert_position = insert_position - 1;
        }
    }

public static void main(String[] args) {
	ListNode head = new ListNode(1);
	ListNode node1 = new ListNode(2);
	ListNode node2 = new ListNode(3);
	ListNode node3 = new ListNode(4);
	head.next = node1;
	node1.next = node2;
	node2.next = node3;
	reorderList(head);
}
}
