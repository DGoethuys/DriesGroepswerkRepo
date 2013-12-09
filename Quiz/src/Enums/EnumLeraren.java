package Enums;

public class EnumLeraren {
	public enum Leraren{
		Jan,Nicolas,Dries,Glenn,Sofie
	}

	public static Object enumsToStringArray() {
		// TODO Auto-generated method stub
		
		String[] results = new String[Leraren.values().length];  
        int count = 0;  
        for (Leraren each  : Leraren.values()) {  
            results[count] = each.toString();  
            count++;  
        }  
        return results;
		
	}
	

}
