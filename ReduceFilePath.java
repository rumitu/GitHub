
public class ReduceFilePath {

	public static void main(String[] args) {
		 //String filePath = "/srv/../.././mydir/rumi//../dir//";
		  String filePath = "/a/b/c/.././../d/a/c/.///..//////";
		  System.out.print(reduce_file_path(filePath));
		 	 
	}
	public static String reduce_file_path(String filePath)
	{
		 while(filePath.contains("//"))
		 {
			 filePath = filePath.replaceAll("//", "/");
		 }
		
         
         String[] fileMod = filePath.split("/");

         /* Delete ./ elements */
         for (int cnt = 0; cnt < fileMod.length; cnt++)
         {
             if (fileMod[cnt].equals("."))
             {
                 if (cnt == (fileMod.length - 1))
                 {
                     fileMod[cnt] = "";
                 }
                 else
                 {
                     while (cnt < (fileMod.length - 1))
                     {
                         fileMod[cnt] = fileMod[cnt + 1];
                         cnt++;
                     }
                     fileMod[fileMod.length - 1] = "";
                     cnt = 0;
                 }
             }
         }

         int trigger = 1;
         while (trigger == 1)
         {
             /* Delete ./ elements */
             for (int cnt = 0; cnt < fileMod.length; cnt++)
             {
                 if (fileMod[cnt].equals(".."))
                 {
                     if (cnt == 0 || cnt == (fileMod.length-1))
                     {
                         fileMod[cnt] = "";
                     }
                     else
                     {
                         while (cnt < (fileMod.length - 1))
                         {
                             fileMod[cnt - 1] = fileMod[cnt + 1];
                             cnt++;
                         }
                         fileMod[fileMod.length - 1] = "";
                         fileMod[fileMod.length - 2] = "";
                         cnt = 0;
                         continue;
                     }
                 }
             }
             trigger = 0;
         }


         String text = "";
         /* Build final string */
         for (int cnt = 0; cnt < fileMod.length; cnt++)
         {
             if (fileMod[cnt] != "")
             {
                 text += fileMod[cnt] + "/";
             }
         }

         /* Clear last / */
         if (text.charAt(text.length()-1)=='/')
         {
        	 text = text.substring(0, text.length()-1);
         }

        return text;	
	}
}
