package examples;

import java.util.*;
import java.util.Scanner;

public class EmpInMeetingRoom
{        
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
      EmpInMeetingRoom sol = new EmpInMeetingRoom();
        sol.startStop();
    }
    
    
    public int startStop(){
		Map<String,List<Integer>> employee = new HashMap<String,List<Integer>>();
		employee.put("A", Arrays.asList(1,4));
		employee.put("B", Arrays.asList(3,5));
		employee.put("C", Arrays.asList(2,7));
		employee.put("D", Arrays.asList(5,10));

		int startIndex = 0;
		int stopIndex = 1;
		int currentTime =24;
		int maxCount=0;
		List<String> meetingRoom = new ArrayList<String>();

		for(int i=0; i<currentTime; i++){
			for(Map.Entry<String, List<Integer>> emp : employee.entrySet()){
				if(emp.getValue().get(startIndex)==i){
					meetingRoom.add(emp.getKey());
				} if(emp.getValue().get(stopIndex)==i){
					meetingRoom.remove(emp.getKey());
				}
			}
			if(maxCount < meetingRoom.size()){
				maxCount = meetingRoom.size();
			}
			System.out.println("At time " + i + " employees " +meetingRoom.toString()+ " are present. Max members " +maxCount);
		}

		return maxCount;
	}
    
    
}