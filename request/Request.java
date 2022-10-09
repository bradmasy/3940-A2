package request;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Request {
  
    private InputStream inputStream = null;
    private String reqType = null;
    private String reqUserAgent = null;



    public Request(InputStream inStream) {
        System.out.println("INPUT STREAM");
        
        inputStream = inStream;


        // Create a method to parse incoming request payload.a

        System.out.println("SCANNER");
        // Scanner a = new Scanner(inputStream);
        Scanner a = new Scanner(inStream);
        String header = "";
        String temp;
        while(a.hasNext()){
            temp = a.nextLine();
            // System.out.println(temp);
            header += temp;
            header += "\n";
        }

        System.out.println(header);
        System.out.println("END OF HEADER");
    
        System.out.println("input stream:" + inStream.toString());

        // parsePayload(inputStream);
    
    }



    

    public void parsePayload(InputStream inStream){
        Scanner scanner = new Scanner(inStream);

        // Need to know Request type: GET or POST
        reqType = scanner.next();
        System.out.println("The Request Type is: " + reqType);
        // Need to know User-Agent type: Find where the connection is comming from, CLI or Browser.
        // If User agent exists - browser, else - command line

        // ArrayList<String,String> FormData = new ArrayList<String,String>(); - Consider using hashmap instead..
        HashMap<String, String> FormData = new HashMap<String, String>(); 

        // Parse First Line
        // String FirstLine = scanner.next();

        // // Check First Line
        // switch(reqType){
        //     case "GET":
        //         // We will know to execute GET Request
        //         FormData.put("GET", reqType);
        //         break;
        //     case "POST":
        //         // We will know to execute POST request
        //         FormData.put("POST",reqType);
        //         break;
        // } 

        // String currentLine;

        
        // while (scanner.hasNextLine()) {
        
        //     currentLine = scanner.nextLine();
        //     System.out.println(currentLine);
        //     // Parse each line after the first..
        //     if (currentLine.startsWith("User-Agent")) {
        //         reqUserAgent = "browser";
        //     } else {
        //         reqUserAgent = "cli";
        //     }
        //     //FormData.add(currentLine); //do this after we see a boundary
        // }



        System.out.println("Made it here");
        scanner.close();

    }

    // private static String convertInputStreamToString(InputStream inputStream)
    //     throws IOException {
    //     return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    // }

    public void setReqType(final String reqType){
        this.reqType = reqType;
    }
    public String getReqMethod(){
        return reqType;
    }

    public String getUserAgent() {
        return reqUserAgent;
    }
    public void setUserAgent(String userAgent) {
        reqUserAgent = userAgent;
    }
    
    public InputStream getInputStream() {
        return inputStream;
    }
}

