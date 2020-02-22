package examples;

class Message
{
	int container_id;
	public int getContainer_id() {
		return container_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public boolean isSuccess() {
		return success;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public int getUserId() {
		return userId;
	}

	int item_id;
	boolean success;
	long timestamp;
	int userId;
	
	Message(int container_id, int item_id, boolean success, long timestamp, int userId)
	{
		this.container_id = container_id;
		this.item_id = item_id;
		this.success = success;
		this.timestamp = timestamp;
		this.userId = userId;
	}
}

public class Messages {

	public static void main(String[] args )
	{
		Message[] msgArr = new Message[5];
		msgArr[0] = new Message(123,456,true,1499351653,789);
		msgArr[1] = new Message(111,222,false,1499351654,333);
		msgArr[2] = new Message(444,555,true,1499351654,789);
		msgArr[3] = new Message(123,456,true,1499351655,999);
		msgArr[4] = new Message(123,456,true,1499351655,789);
		
		Messages msg = new Messages();
		msg.iterateMessages(msgArr);
	}
	
	public void too_fast(int msgId, int userId)
	{
		System.out.println("Message "+msgId+" too fast for UserId " +userId);
	}
	
	public void iterateMessages(Message[] msgArr)
	{
		for(int i=0;i<5;i++)
		{
			for (int j=i+1;j<5;j++)
			{
				if(msgArr[i].getUserId() == msgArr[j].getUserId() && msgArr[j].getTimestamp()-msgArr[i].getTimestamp() <=1)
				{
					too_fast(j+1,msgArr[j].userId);
				}
			}
		}
	}
}
