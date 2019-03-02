//import base.ListNode;

class Operations{


	
	static void showLL(ListNode head){
		while (head!=null){
			System.out.print(head.val+ "->");
			head = head.next;
		}
		System.out.println("X");
	}
	static void insert(ListNode head, int x){

		
		for(;head.next!=null;head=head.next);
		head.next = new ListNode(x);

	}

	static ListNode insertAtBeginning(ListNode head, int x){

		ListNode newNode = new ListNode(x);
		newNode.next = head;
		return newNode;
	}

	static int loopDetection(ListNode head){

		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while(fastPtr!=null|| fastPtr.next!=null || slowPtr!=fastPtr ){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		
		if (fastPtr==slowPtr)
			return 1;
		return 0;
	}

	static ListNode getElement(ListNode head, int position){
		for(int i=0; i<position;i++){
			head = head.next;
			if (head == null)
				break;
		}
		return head;
	}
	static ListNode findMergePoint(ListNode head1, ListNode head2){

		int l1 = 0;
		int l2 = 0;

		for (ListNode temp=head1; temp!=null; temp=temp.next) {l1++;}
		for (ListNode temp=head2; temp!=null; temp=temp.next) {l2++;}

		ListNode longerlist = null;
		ListNode shorterlist = null;
		if (l1>=l2){
			longerlist = head1;
			shorterlist = head2;
		}
		else{
			longerlist = head2;
			shorterlist = head1;
		}

		for (int i=0; i<l1-l2; i++){
			longerlist = longerlist.next;
		}

		while(longerlist!=null){
			longerlist = longerlist.next;
			shorterlist = shorterlist.next;
			if (longerlist==shorterlist)
				return shorterlist;
		}
		return null;
	}

	static ListNode reverseLL(ListNode head){

		ListNode temp = null, nextNode = null, current = null;

		while(head!=null){
			nextNode = head.next;
			head.next = temp;
			temp = head;
			head = nextNode;
		}
		return temp;
	}

	static ListNode recursivelyReverseLL(ListNode head){

		if (head == null)
			return head;
		if (head.next == null)
			return head;
		ListNode secondElement, reversedLL;

		secondElement = head.next;

		head.next = null;

		reversedLL = recursivelyReverseLL(secondElement);
		secondElement.next = head;

		return reversedLL;
	}

	public static void main(String []a){
		
		ListNode head = insertAtBeginning(null, 10);
		insert(head, 11);
		insert(head, 12);
		insert(head, 15);
		showLL(head);

		System.out.println("--------------------------------");

		ListNode head1 = insertAtBeginning(null, 55);
		insert(head1, 36);
		insert(head1, 45);
		insert(head1, 47);
		insert(head1, 92);

		ListNode head2 = insertAtBeginning(null, 23);


		//creating a merge between the two LLs
		ListNode mergeNode = getElement(head1, 3);
		head2.next = mergeNode;
		head2 = insertAtBeginning(head2, 43);
		head2 = insertAtBeginning(head2, 57);

		ListNode mergePoint = findMergePoint(head1, head2);
		if ( mergePoint != null){
			System.out.println("L1: ");
			showLL(head1);
			System.out.println("L2: ");
			showLL(head2);
			System.out.println("Merge Point: "+ mergePoint.val);

		}

		System.out.println("--------------------------------");

		ListNode head3 = insertAtBeginning(null, 10);
		insert(head3, 11);
		insert(head3, 12);
		insert(head3, 15);
		showLL(head3);
		head3 = reverseLL(head3);
		showLL(head3);
		head3 = reverseLL(head3);
		showLL(head3);

	}
}