
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import za.ac.wits.snake.DevelopmentAgent;

public class MyAgent extends DevelopmentAgent {

	static boolean existence(ArrayList<String> a, String b) {
		
		boolean result = false;
		
		for(int i = 0; i < a.size(); i++) {
			
			if(b.equals(a.get(i))) {
				
				result = true;
				break;
			}
		}
		
		return result;
		
	}
    public static void main(String args[]) throws IOException {
        MyAgent agent = new MyAgent();
        MyAgent.start(agent, args);
        
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String initString = br.readLine();
            String[] temp = initString.split(" ");
            int nSnakes = Integer.parseInt(temp[0]);
            Random rand = new Random();

            while (true) {
                String line = br.readLine();
                if (line.contains("Game Over")) {
                    break;
                }
                String apple = line;
                //do stuff with apple
                String[] s = apple.split(" ");

                int xapple = Integer.parseInt(s[0]);
                int yapple = Integer.parseInt(s[1]);
                ArrayList<String> snakesCoords = new ArrayList<>();
                
                /*for(int i = -1; i < 51; i++) {
                	
                	snakesCoords.add("-1" + "," + String.valueOf(i));
                }
                for(int i = 0; i < 50; i++) {
                	
                	snakesCoords.add( String.valueOf(i) + "," + "-1");
                }
                for(int i = 0; i < 51; i++) {
                	
                	snakesCoords.add("50" + "," + String.valueOf(i));
                }
                for(int i = 0; i < 50; i++) {
                	
                	snakesCoords.add( String.valueOf(i) + "," + "50");
                }*/

                for (int i = 0; i < 3; i++) {
                    String zombieLine = br.readLine();
                    String[] zombiesub = zombieLine.split(" ");
                	
                    
                    for(int j = 0; j < zombiesub.length; j++) {
                 	                  	
                     	snakesCoords.add(zombiesub[j]);
                     	
                    }
                 }
                	   


                int direction;

                int mySnakeNum = Integer.parseInt(br.readLine());
                for (int i = 0; i < nSnakes; i++) {
                    String snakeLine = br.readLine();
                    
                    	if(i!=mySnakeNum) {
                    		
                    		String[] percy = snakeLine.split(" ");
                    		for(int j = 0; j < percy.length; j++) {
                    			
                    			snakesCoords.add(percy[j]);
                    		}
                    		
                    	}
                    	
                    

                    if (i == mySnakeNum) {
                    	
                    	
                        //hey! That's me :)
                    	String[] a = snakeLine.split(" ");
                    	for(int j = 4; j < a.length; j++) {
                    		
                    		snakesCoords.add(a[j]);
                    	}
                    	String[] head = a[3].split(",");
                    	 
                    	String[] tail = a[a.length-1].split(",");

                    	int xhead = Integer.parseInt(head[0]);
                    	int yhead = Integer.parseInt(head[1]);
                    	int xtail = Integer.parseInt(tail[0]);
                    	int ytail = Integer.parseInt(tail[1]);
                        //do stuff with snakes
                    	

                        String snakeDir = "";

                        //System.out.println(2);
                        
                        //finding snake direction
                        if(yhead < ytail && xhead < xtail) {

                        	snakeDir = "left";
                        }
                        if(yhead < ytail && xhead > xtail){

                        	snakeDir = "right";
                        }
                        if(yhead < ytail && xhead == xtail) {
                        	snakeDir = "up";
                        }
                        if(yhead > ytail && xhead < xtail) {

                        	snakeDir = "left";
                        }
                        if(yhead > ytail && xhead > xtail){

                        	snakeDir = "right";
                        }
                        if(yhead > ytail && xhead == xtail) {
                        	snakeDir = "down";
                        }
                        if(yhead==ytail && xhead < xtail) {
                        	snakeDir = "left";
                        }
                        if(yhead==ytail && xhead>xtail) {
                        	snakeDir = "right";
                        }

                        //calculating moves
                        
                        if(snakeDir == "left") {
                        	
                        	if(xhead < xapple && yhead == yapple && snakeDir=="left") {
    	                    	
                        		if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
                        			
                        			direction = 1;
        	                    	System.out.println(direction);
                        		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead -1))) {
                        			
                        			direction = 0;
                        			System.out.println(direction);
                        		}
                        		else {
                        			
                        			direction = 2;
                        			System.out.println(direction);
                        		}
    	                    	
    	                    }
                        	
                        	if(xhead > xapple && yhead==yapple && snakeDir=="left") {
                        		if(!existence(snakesCoords, String.valueOf(xhead - 1)+ "," + String.valueOf(yhead))) {
                        			
                        			direction = 2;
        	                    	System.out.println(direction);
                        			
                        		}
                        		if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead + 1))) {
                        			
                        			direction = 1;
                        			System.out.println(direction);
                        		}
                        		else {
                        			
                        			direction = 0;
                        			System.out.println(direction);
                        		}
    	                    	
    	                    }
                        	
                        	if(xhead < xapple && yhead > yapple && snakeDir=="left") {

                        		if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead - 1))) {
    	                    	direction = 0;
    	                    	System.out.println(direction);
    	                    	//System.out.println(3);
    	                    	
                        		}
                        		if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead + 1))) {
                        			
                        			direction = 1;
                        			System.out.println(direction);
                        		}
                        		
                        		else {
                        			
                        			direction = 2;
                        			System.out.println(direction);
                        		}

    	                    }
                        	
                        	if(xhead < xapple && yhead < yapple && snakeDir=="left") {

                        		if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead + 1))) {
    	                    	direction = 1;
    	                    	System.out.println(direction);
                        		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead - 1))) {
                        			
                        			direction = 0;
                        			System.out.println(direction);
                        		}else {
                        			
                        			direction = 2;
                        			System.out.println(direction);
                        		}

    	                    }
                        	
                        	if(xhead > xapple && yhead > yapple && snakeDir=="left") {

                        		if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
    	                    	direction = 2;
    	                    	System.out.println(direction);
                        		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead)+ "," + String.valueOf(yhead-1))) {
                        			
                        			direction = 0;
                        			System.out.println(direction);
                        		}
                        		else {
                        			direction = 1;
                        			System.out.println(direction);
                        		}
    	                    }
                        	
                        	if(xhead > xapple && yhead < yapple && snakeDir=="left") {
                        		
                        		if(!existence(snakesCoords, String.valueOf(xhead -1) + "," + String.valueOf(yhead))) {
        	                    	direction = 2;
        	                    	System.out.println(direction);
                            		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
        	                    	direction = 1;
        	                    	System.out.println(direction);
                            		}
                        		else {
                        			direction = 0;
                        			System.out.println(direction);
                        		}
    	                    	
    	                    }
                        	if(xhead == xapple && yhead < yapple && snakeDir=="left") {
                        		
                        		if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
         	                    	direction = 1;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead-1) + "," + String.valueOf(yhead))) {
         	                    	direction = 2;
         	                    	System.out.println(direction);
                             		}
     	                    	else {
     	                    		direction = 0;
     	                    		System.out.println(direction);
     	                    	}
                        	}
                        	if(xhead == xapple && yhead > yapple &&  snakeDir=="left") {
                        		
                        		if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
         	                    	direction = 0;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead-1) + "," + String.valueOf(yhead))) {
         	                    	direction = 2;
         	                    	System.out.println(direction);
                             		}
     	                    	else {
     	                    		direction = 1;
     	                    		System.out.println(direction);
     	                    	}
                        	}
                        	//avoiding left side walls
    	                    if(xhead - 1 < 0 && yhead -1 <0 && snakeDir == "left" ) {
    	                    	
    	                    	direction = 1;
    	                    	System.out.println(direction);
    	                    }
    	                    if(xhead - 1 < 0 && yhead + 1 >49 && snakeDir == "left") {
    	                    	
    	                    	direction = 0;
    	                    	System.out.println(direction);
    	                    }
    	                    if(xhead - 1 < 0 && (yhead - 1>0 && yhead + 1< 49) && snakeDir == "left" ){
    	                    	
    	                    	
    	                    	if(!existence(snakesCoords, (String.valueOf(xhead) + "," + String.valueOf(yhead - 1))) && yhead > yapple) {
    	                    		
    	                    		direction = 0;
    	                    	}
    	                    	else if(!existence(snakesCoords, (String.valueOf(xhead) + "," + String.valueOf(yhead + 1)))){
    	                    		
    	                    		direction = 1;
    	                    		System.out.println(direction);
    	                    	}
    	                    }
    	                    
    	                    
                        }
                        else if(snakeDir == "right") {
                        	
                        	if(xhead < xapple && yhead == yapple && snakeDir=="right") {

                        		if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
        	                    	direction = 3;
        	                    	System.out.println(direction);
                            		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
        	                    	direction = 1;
        	                    	System.out.println(direction);
                            		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
        	                    	direction = 0;
        	                    	System.out.println(direction);
                            		}
    	                    }
    	                    
    	                    
    	                    if(xhead > xapple && yhead==yapple && snakeDir=="right" ) {

    	                    	if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
        	                    	direction = 1;
        	                    	System.out.println(direction);
                            		}
    	                    	if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
        	                    	direction = 0;
        	                    	System.out.println(direction);
                            		}
    	                    	else {
    	                    		direction = 3;
    	                    		System.out.println(direction);
    	                    	}
    	                    }

    	                    if(xhead < xapple && yhead > yapple && snakeDir=="right") {

    	                    	if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
        	                    	direction = 3;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
        	                    	direction = 0;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
    	                    		
    	                    		direction = 1;
    	                    		System.out.println(direction);
    	                    	}
    	                    	
    	                    }
    	                    
    	                    if(xhead < xapple && yhead < yapple && snakeDir=="right") {

    	                    	if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
        	                    	direction = 3;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
        	                    	direction = 1;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead - 1))) {
    	                    		direction = 0;
    	                    		System.out.println(direction);
    	                    	}
                        	}
    	                    
    	                    if(xhead > xapple && yhead > yapple && snakeDir=="right") {

    	                    	if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
        	                    	direction = 0;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
        	                    	direction = 3;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
    	                    		direction = 1;
    	                    		System.out.println(direction);
    	                    	}
    	                    	
    	                    }
    	                    
    	                    if(xhead > xapple && yhead < yapple && snakeDir=="right") {

    	                    	if(!existence(snakesCoords, String.valueOf(xhead ) + "," + String.valueOf(yhead + 1))) {
        	                    	direction = 1;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead+1) + "," + String.valueOf(yhead))) {
        	                    	direction = 3;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead - 1))) {
    	                    		direction = 0;
    	                    		System.out.println(direction);
    	                    	}
                        	}
    	                    if(xhead == xapple && yhead < yapple && snakeDir=="right") {
    	                    	
    	                    	if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
         	                    	direction = 1;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead+1) + "," + String.valueOf(yhead))) {
         	                    	direction = 3;
         	                    	System.out.println(direction);
                             		}
     	                    	else {
     	                    		direction = 0;
     	                    		System.out.println(direction);
     	                    	}
    	                    }
    	                    if(xhead == xapple && yhead > yapple && snakeDir=="right") {
    	                    	
    	                    	if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
         	                    	direction = 0;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead+1) + "," + String.valueOf(yhead))) {
         	                    	direction = 3;
         	                    	System.out.println(direction);
                             		}
     	                    	else {
     	                    		direction = 1;
     	                    		System.out.println(direction);
     	                    	}
    	                    }
    	                    //avoiding right side walls
    	                    if(xhead + 1 > 49 && yhead -1 <0 && snakeDir == "right" ) {
    	                    	
    	                    	direction = 1;
    	                    	System.out.println(direction);
    	                    }
    	                    if(xhead + 1 > 49 && yhead + 1 >49 && snakeDir == "right") {
    	                    	
    	                    	direction = 0;
    	                    	System.out.println(direction);
    	                    }
    	                    if(xhead + 1 > 49 && (yhead - 1>0 && yhead + 1 < 49) && snakeDir == "right" ){
    	                    	
    	                    	
    	                    	if(!existence(snakesCoords, (String.valueOf(xhead)+ "," + String.valueOf(yhead - 1))) && yhead > yapple){
    	                    		direction = 0;
    	                    		
    	                    	}
    	                    	else if(!existence(snakesCoords, (String.valueOf(xhead) + "," + String.valueOf(yhead) + 1))) {
    	                    		
    	                    		direction = 1;
    	                    		System.out.println(direction);
    	                    	}
    	                    }
    	                    
    	                    
                        	
                        }
                        
                        else if(snakeDir == "up") {
                        	
                        	if(xhead < xapple && yhead > yapple && snakeDir=="up") {

                        		if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
        	                    	direction = 3;
        	                    	System.out.println(direction);
                            		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
        	                    	direction = 0;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
    	                    		direction = 2;
    	                    		System.out.println(direction);
    	                    	}
    	                    }
                        	
                        	if(xhead < xapple && yhead < yapple && snakeDir=="up") {

                        		if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
        	                    	direction = 3;
        	                    	System.out.println(direction);
                            		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
        	                    	direction = 2;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead - 1))) {
    	                    		direction = 0;
    	                    		System.out.println(direction);
    	                    	}
        	                    
                            	}
                        	if(xhead > xapple && yhead > yapple && snakeDir=="up") {

                        		if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
        	                    	direction = 2;
        	                    	System.out.println(direction);
                            		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
        	                    	direction = 0;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
    	                    		direction = 3;
    	                    		System.out.println(direction);
    	                    	}
    	                    }
                        	
                        	if(xhead > xapple && yhead < yapple && snakeDir=="up") {

                        		if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
        	                    	direction = 2;
        	                    	System.out.println(direction);
                            		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead - 1))) {
        	                    	direction = 0;
        	                    	System.out.println(direction);
                            		}
    	                    	else if(!existence(snakesCoords, String.valueOf(xhead+1) + "," + String.valueOf(yhead))){
    	                    		direction = 0;
    	                    		System.out.println(direction);
    	                    	}
                            	}
                        	
                        	 if(xhead < xapple && yhead == yapple && snakeDir=="up" ) {

                        		if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 3;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
         	                    	direction = 0;
         	                    	System.out.println(direction);
                             		}
     	                    	else if(!existence(snakesCoords, String.valueOf(xhead-1) + "," + String.valueOf(yhead))) {
     	                    		direction = 2;
     	                    		System.out.println(direction);
     	                    	}
     	                    }
                        	 
                        	 if(xhead > xapple && yhead == yapple && snakeDir=="up") {

                        		if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 2;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
         	                    	direction = 0;
         	                    	System.out.println(direction);
                             		}
     	                    	else if(!existence(snakesCoords, String.valueOf(xhead+1) + "," + String.valueOf(yhead))){
     	                    		direction = 3;
     	                    		System.out.println(direction);
     	                    	}
     	                    }
                        	 
                        	 if(xhead == xapple && yhead<yapple && snakeDir=="up") {
     	                    	
                        		 if(!existence(snakesCoords, String.valueOf(xhead-1) + "," + String.valueOf(yhead))) {
         	                    	direction = 2;
         	                    	System.out.println(direction);
                             		}
                        		 else if(!existence(snakesCoords, String.valueOf(xhead+1) + "," + String.valueOf(yhead))) {
         	                    	direction = 3;
         	                    	System.out.println(direction);
                             		}
     	                    	 else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))){
     	                    		direction = 0;
     	                    		System.out.println(direction);
     	                    	}
                        	 }
                        	if(xhead == xapple && yhead>yapple && snakeDir=="up") {
          	                    	
                           		 if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead-1))) {
             	                   	direction = 0;
             	                   	System.out.println(direction);
                               		}
                           		 else if(!existence(snakesCoords, String.valueOf(xhead-1) + "," + String.valueOf(yhead))) {
             	                   	direction = 2;
             	                   	System.out.println(direction);
                               		}
         	                   	 else if(!existence(snakesCoords, String.valueOf(xhead+1) + "," + String.valueOf(yhead))){
         	                   		direction = 3;
         	                   		System.out.println(direction);
         	                   	}
                        		 
                        		 

     	                    }
                        	 
                        	//avoiding top wall
     	                    if(yhead - 1 < 0 && xhead-1 < 0 && snakeDir == "up" ) {
     	                    	
     	                    	direction = 3;
     	                    	System.out.println(direction);
     	                    }
     	                    if(yhead -1 < 0 && xhead + 1 > 49 && snakeDir == "up") {
     	                    	
     	                    	direction = 2;
     	                    	System.out.println(direction);
     	                    }
     	                    if(yhead -1 < 0 && (xhead -1!=-1 && xhead + 1!=50) && snakeDir == "up" ){
     	                    	
     	                    	
     	                    	if(!existence(snakesCoords, (String.valueOf(xhead -1) + "," + String.valueOf(yhead)))&& xhead > xapple){
     	                    		
     	                    		direction = 2;
     	                    		System.out.println(direction);
     	                    	}
     	                    	else if(!existence(snakesCoords, (String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) && xhead < xapple) {
     	                    		
     	                    		direction = 3;
     	                    		System.out.println(direction);
     	                    	}
     	                    	else if(!existence(snakesCoords, (String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) && xhead == xapple) {
     	                    		
     	                    		direction = 2;
     	                    		System.out.println(direction);
     	                    	}
     	                    }
     	                    
     	                   
                        }
                        
                        
                        else if(snakeDir == "down") {
                        	
                        	if(xhead < xapple && yhead > yapple && snakeDir=="down") {

                        		if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 3;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead-1) + "," + String.valueOf(yhead))) {
         	                    	direction = 2;
         	                    	System.out.println(direction);
                             		}
     	                    	else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead + 1))){
     	                    		direction = 1;
     	                    		System.out.println(direction);
     	                    	}
    	                    }
    	                    
    	                    if(xhead < xapple && yhead < yapple && snakeDir=="down") {

    	                    	if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 3;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
         	                    	direction = 1;
         	                    	System.out.println(direction);
                             		}
     	                    	else if(!existence(snakesCoords, String.valueOf(xhead -1) + "," + String.valueOf(yhead))){
     	                    		direction = 2;
     	                    		System.out.println(direction);
     	                    	}

    	                    }
    	                    
    	                    if(xhead > xapple && yhead > yapple && snakeDir=="down") {

    	                    	if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 2;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead+1) + "," + String.valueOf(yhead))) {
         	                    	direction = 3;
         	                    	System.out.println(direction);
                             		}
     	                    	else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead + 1))){
     	                    		direction = 1;
     	                    		System.out.println(direction);
     	                    	}
    	                    }
    	                    
    	                    if(xhead > xapple && yhead < yapple && snakeDir=="down") {

    	                    	
    	                    	if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 2;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
         	                    	direction = 1;
         	                    	System.out.println(direction);
                             		}
     	                    	else if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
     	                    		direction = 3;
     	                    		System.out.println(direction);
     	                    	}

    	                    }
    	                   
    	                    if(xhead < xapple && yhead == yapple && snakeDir=="down") {

    	                    	if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 3;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
         	                    	direction = 1;
         	                    	System.out.println(direction);
                             		}
     	                    	else if(!existence(snakesCoords, String.valueOf(xhead -1) + "," + String.valueOf(yhead))){
     	                    		direction = 2;
     	                    		System.out.println(direction);
     	                    	}
    	                    }
    	                    
    	                    if(xhead > xapple && yhead == yapple && snakeDir == "down") {

    	                    	if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 2;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead+1))) {
         	                    	direction = 1;
         	                    	System.out.println(direction);
                             		}
     	                    	else if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))){
     	                    		direction = 3;
     	                    		System.out.println(direction);
     	                    	}
    	                    }
    	                    
    	                    if(xhead == xapple && yhead > yapple && snakeDir=="down") {
    	                    	if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 2;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 3;
         	                    	System.out.println(direction);
                             		}
     	                    	else if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead + 1))){
     	                    		direction = 1;
     	                    		System.out.println(direction);
     	                    	}    	                    }
    	                    if(xhead == xapple && yhead < yapple && snakeDir == "down") {
    	                    	
    	                    	if(!existence(snakesCoords, String.valueOf(xhead) + "," + String.valueOf(yhead + 1))) {
         	                    	direction = 1;
         	                    	System.out.println(direction);
                             		}
                        		else if(!existence(snakesCoords, String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) {
         	                    	direction = 2;
         	                    	System.out.println(direction);
                             		}
     	                    	else if(!existence(snakesCoords, String.valueOf(xhead + 1) + "," + String.valueOf(yhead))){
     	                    		direction = 3;
     	                    		System.out.println(direction);
     	                    	}
    	                    }
    	                  //avoiding bottom wall
    	                    if(yhead + 1 > 49 && xhead-1 < 0 && snakeDir == "down" ) {
    	                    	
    	                    	direction = 3;
    	                    	System.out.println(direction);
    	                    }
    	                    if(yhead +1 > 49 && xhead + 1 > 49 && snakeDir == "down") {
    	                    	
    	                    	direction = 2;
    	                    	System.out.println(direction);
    	                    }
    	                    if(yhead +1 > 49 && (xhead -1 > 0 && xhead + 1 < 49) && snakeDir == "down" ){
    	                    	
    	                    	
    	                    	if(!existence(snakesCoords, (String.valueOf(xhead - 1) + "," + String.valueOf(yhead))) && xhead > xapple) {
    	                    		
    	                    		direction = 2;
    	                    		System.out.println(direction);
    	                    	}
    	                    	else if(!existence(snakesCoords, (String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) && xhead < xapple) {
    	                    		
    	                    		direction = 3;
    	                    		System.out.println(direction);
    	                    	}
    	                    	else if(!existence(snakesCoords, (String.valueOf(xhead + 1) + "," + String.valueOf(yhead))) && xhead == xapple) {
    	                    		
    	                    		direction = 3;
    	                    		System.out.println(direction);
    	                    	}
    	                    }
    	                    
    	                    
                        	
                        }
	      
	                    //avoiding snakes
                    
	               }

                }
                // finished reading, calculate move:
                System.out.println("log calculating...");
               // int move = new Random().nextInt(4);
                //int x = 5;
                //System.out.println(direction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
